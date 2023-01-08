import json
import os
import re
import cv2
import mediapipe as mp
from mediapipe.tasks import python
from mediapipe.tasks.python import vision
import numpy as np
import matplotlib.pyplot as plt

mp_drawing = mp.solutions.drawing_utils
mp_drawing_styles = mp.solutions.drawing_styles
mp_hands = mp.solutions.hands

# TEST_IMAGES_PATH = "D:\\CVDL\\Database\\asl_alphabet_test\\asl_alphabet_test"
# TRAIN_IMAGES_PATH = "D:\\CVDL\\Database\\asl_alphabet_train\\asl_alphabet_train"


# def processTestImages():
#     for file in os.listdir(TEST_IMAGES_PATH):
#         image_path = os.path.join(TEST_IMAGES_PATH, file)
#         image = cv2.imread(image_path)
#         image_name = os.path.basename(image_path)
#         with mp_hands.Hands(static_image_mode=True, max_num_hands=1, min_detection_confidence=0.5) as hands:
#             image = cv2.flip(image, 1)
#             results = hands.process(cv2.cvtColor(image, cv2.COLOR_BGR2RGB))
#             print(image_name,'  Handedness:', results.multi_handedness)
#             if not results.multi_hand_landmarks:
#                 continue
#             image_height, image_width, _ = image.shape
#             cv2.imwrite(f"D:\\CVDL\\ProcessedDB\\Test/" + image_name, cv2.flip(image, 1))
#
# def processTrainImages():
#     for dir1 in os.listdir(TRAIN_IMAGES_PATH):
#         for file in os.listdir(os.path.join(TRAIN_IMAGES_PATH, dir1)):
#             image_path = os.path.join(TRAIN_IMAGES_PATH,dir1, file)
#             image = cv2.imread(image_path)
#             image_name = os.path.basename(image_path)
#             with mp_hands.Hands(static_image_mode=True, max_num_hands=1, min_detection_confidence=0.5) as hands:
#                 image = cv2.flip(image, 1)
#                 results = hands.process(cv2.cvtColor(image, cv2.COLOR_BGR2RGB))
#                 print(image_name,'  Handedness:', results.multi_handedness)
#                 if not results.multi_hand_landmarks:
#                     continue
#                 image_height, image_width, _ = image.shape
#                 cv2.imwrite(f"D:\\CVDL\\ProcessedDB\\Train/" + image_name, cv2.flip(image, 1))

# Pictures were 200x200 and the Google MediaPipe Hands API did not manage to mark the landmarks for all of them.
# Did this step in order to filter redundant images.
#processTestImages()
#processTrainImages()


# Save landmarks and tags to csv file
IMAGES_PATH = "ProcessedDB/Train"
hand_landmarker_model_path = 'Resources/hand_landmarker.task'

def processLandmarks(landmarks):
    landmarks = str(landmarks).replace("\n","").split("landmark")[1:]
    print(landmarks)
    res = []
    for landmark in landmarks:
        landmark = landmark.replace("x"," \"x\" ")
        landmark = landmark.replace("y"," ,\"y\" ")
        landmark = landmark.replace("z"," ,\"z\" ")
        jsonValue = json.loads(landmark)
        res.append(jsonValue["x"])
        res.append(jsonValue["y"])

    return res

def saveLandmarks():
    for file in os.listdir(IMAGES_PATH):
        image_path = os.path.join(IMAGES_PATH, file)
        image = cv2.imread(image_path)
        image_tag = ord(os.path.basename(image_path)[0]) - ord('A')
        with mp_hands.Hands(static_image_mode=True, max_num_hands=1, min_detection_confidence=0.5) as hands:
            image = cv2.flip(image, 1)
            results = hands.process(cv2.cvtColor(image, cv2.COLOR_BGR2RGB))
            if results.multi_hand_landmarks is not None:
                for hand_landmarks in results.multi_hand_landmarks:
                    result = processLandmarks(hand_landmarks)
                    f = open("Resources/landmarks.csv", "a")
                    f.write(str(image_tag))
                    f.write(",")
                    f.write(str(result)[1:-1])
                    f.write("\n")
                    f.close()

saveLandmarks()



