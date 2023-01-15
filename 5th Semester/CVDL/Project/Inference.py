import tensorflow as tf
import numpy as np
import Utils


class Inference(object):
    def __init__(self):
        # Define model interpreter
        self.__interpreter = tf.lite.Interpreter(model_path=Utils.tflite_path)
        self.__interpreter.allocate_tensors()
        self.__input_details = self.__interpreter.get_input_details()
        self.__output_details = self.__interpreter.get_output_details()
        self.__input_details_tensor_index = self.__input_details[0]['index']

    def interpret_landmarks(self, landmarks):
        self.__interpreter.set_tensor(self.__input_details_tensor_index, np.array([landmarks], dtype=np.float32))
        self.__interpreter.invoke()
        output_details_tensor_index = self.__output_details[0]['index']
        tensor_result = self.__interpreter.get_tensor(output_details_tensor_index)
        result_index = np.argmax(np.squeeze(tensor_result))
        return Utils.INDEX_MAPPING[result_index]
