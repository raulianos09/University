import csv
import random

import numpy as np
import tensorflow as tf
from sklearn.model_selection import train_test_split

dataset = "D:\\CVDL\\Resources\\landmarks.csv"
model_path = "D:\\CVDL\\Resources\\model.hdf5"
tflite_path= "D:\\CVDL\\Resources\\model.tflite"

NUM_CLASSES = 26
RANDOM_SEED = 50

landmarks_dataset = np.loadtxt(dataset, delimiter=",", dtype='float32', usecols=list(range(1, (21 * 2) + 1)))
tags_dataset = np.loadtxt(dataset, delimiter=",", dtype='int32', usecols=(0))

landmarks_train, landmarks_test, tags_train, tags_test = train_test_split(landmarks_dataset, tags_dataset,
                                                                          train_size=0.75, random_state=RANDOM_SEED)

model = tf.keras.models.Sequential([
    tf.keras.layers.Input((21 * 2,)),
    tf.keras.layers.Dropout(0.2),
    tf.keras.layers.Dense(20, activation='relu'),
    tf.keras.layers.Dropout(0.4),
    tf.keras.layers.Dense(10, activation='relu'),
    tf.keras.layers.Dense(NUM_CLASSES, activation='softmax')
])

model.summary()

cp_callback = tf.keras.callbacks.ModelCheckpoint(
    model_path, verbose=1, save_weights_only=False)
# Callback for early stopping
es_callback = tf.keras.callbacks.EarlyStopping(patience=20, verbose=1)

model.compile(
    optimizer='adam',
    loss='sparse_categorical_crossentropy',
    metrics=['accuracy']
)

model.fit(
    landmarks_train,
    tags_train,
    epochs=1000,
    batch_size=8192,
    validation_data=(landmarks_test, tags_test),
    callbacks=[cp_callback, es_callback]
)

val_loss, val_acc = model.evaluate(landmarks_test, tags_test, batch_size=128)

model.save(model_path, include_optimizer=False)
converter = tf.lite.TFLiteConverter.from_keras_model(model)
converter.optimizations = [tf.lite.Optimize.DEFAULT]
tflite_quantized_model = converter.convert()

open(tflite_path, 'wb').write(tflite_quantized_model)