import random
import numpy as np
import tensorflow as tf
from sklearn.model_selection import train_test_split
import Utils


class Model(object):
    def __init__(self):
        self.RANDOM_SEED = random.randint(1,500)
        self.NUM_CLASSES = 26
        self.model = tf.keras.models.Sequential([
            tf.keras.layers.Input((21 * 2,)),
            tf.keras.layers.Dropout(0.2),
            tf.keras.layers.Dense(20, activation='relu'),
            tf.keras.layers.Dropout(0.4),
            tf.keras.layers.Dense(10, activation='relu'),
            tf.keras.layers.Dense(self.NUM_CLASSES, activation='softmax')
        ])
        # Checkpoint callback
        self.cp_callback = tf.keras.callbacks.ModelCheckpoint(Utils.model_path, verbose=1, save_weights_only=False)
        # Callback for early stopping
        self.es_callback = tf.keras.callbacks.EarlyStopping(patience=20, verbose=1)
        # define the optimizer, loss function and logged metrics for the model
        self.model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])

    def train_model(self):
        # load trainng data
        landmarks_dataset = np.loadtxt(Utils.dataset, delimiter=",", dtype='float32', usecols=list(range(1, (21 * 2) + 1)))
        tags_dataset = np.loadtxt(Utils.dataset, delimiter=",", dtype='int32', usecols=(0))
        # Split the training data into train set and test set
        landmarks_train, landmarks_test, tags_train, tags_test = train_test_split(landmarks_dataset, tags_dataset,
                                                                                  train_size=0.75,
                                                                                  random_state=self.RANDOM_SEED)
        # Start training
        self.model.fit(
            landmarks_train,
            tags_train,
            epochs=1000,
            batch_size=8392,
            validation_data=(landmarks_test, tags_test),
            callbacks=[self.cp_callback, self.es_callback]
        )
        # Save the weights of the model after training
        self.model.save(Utils.model_path, include_optimizer=False)

    def summary(self):
        self.model.summary()

    def save_inference_model(self):
        # Saves the model that is used for inference purposes. Tf.Lite model is easier to use if front-end is created
        converter = tf.lite.TFLiteConverter.from_keras_model(self.model)
        converter.optimizations = [tf.lite.Optimize.DEFAULT]
        tflite_quantized_model = converter.convert()
        open(Utils.tflite_path, 'wb').write(tflite_quantized_model)

