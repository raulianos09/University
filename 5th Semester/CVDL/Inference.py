import json

import cv2
import tensorflow as tf
import numpy as np
import mediapipe as mp

def processLandmarks(landmarks):
    landmarks = str(landmarks).replace("\n","").split("landmark")[1:]
    res = []
    for landmark in landmarks:
        landmark = landmark.replace("x"," \"x\" ")
        landmark = landmark.replace("y"," ,\"y\" ")
        landmark = landmark.replace("z"," ,\"z\" ")
        jsonValue = json.loads(landmark)
        res.append(jsonValue["x"])
        res.append(jsonValue["y"])

    return res

model_path = "D:\\CVDL\\Resources\\model.tflite"

mp_drawing = mp.solutions.drawing_utils
mp_drawing_styles = mp.solutions.drawing_styles
mp_hands = mp.solutions.hands
NUM_CLASSES = 26

image = cv2.imread("D:\\CVDL\\Inference\\test.jpg")
hands = mp_hands.Hands(static_image_mode=True, max_num_hands=1, min_detection_confidence=0.5)
image = cv2.flip(image, 1)
results = hands.process(cv2.cvtColor(image, cv2.COLOR_BGR2RGB))
if results.multi_hand_landmarks is not None:
    for hand_landmarks in results.multi_hand_landmarks:
        result = processLandmarks(hand_landmarks)

interpreter = tf.lite.Interpreter(model_path=model_path)
interpreter.allocate_tensors()
input_details = interpreter.get_input_details()
output_details = interpreter.get_output_details()

input_details_tensor_index = input_details[0]['index']
interpreter.set_tensor(input_details_tensor_index,np.array([result], dtype=np.float32))
interpreter.invoke()

output_details_tensor_index = output_details[0]['index']

tensor_result = interpreter.get_tensor(output_details_tensor_index)

result_index = np.argmax(np.squeeze(result))

print('Result index is: ' ,result_index,' (',chr(result_index+ord('A')),')')