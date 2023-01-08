import json
import os
import cv2
import matplotlib.pyplot as plt
import mediapipe as mp
from PIL import Image

import Utils

class Database(object):
    def __init__(self):
        self.__mp_drawing = mp.solutions.drawing_utils
        self.__mp_drawing_styles = mp.solutions.drawing_styles
        self.__mp_hands = mp.solutions.hands

    def show_image_landmarks(self,image_path):
        with self.__mp_hands.Hands(static_image_mode=True, max_num_hands=1, min_detection_confidence=0.5) as hands:
            image = cv2.imread(image_path)
            image = cv2.flip(image, 1)
            results = hands.process(cv2.cvtColor(image, cv2.COLOR_BGR2RGB))
            if results.multi_hand_landmarks is not None:
                for landmarks in results.multi_hand_landmarks:
                    self.__mp_drawing.draw_landmarks(
                        image,
                        landmarks,
                        self.__mp_hands.HAND_CONNECTIONS,
                        self.__mp_drawing_styles.get_default_hand_landmarks_style(),
                        self.__mp_drawing_styles.get_default_hand_connections_style())
                    image = cv2.flip(image, 1)
                    image = cv2.cvtColor(image,cv2.COLOR_BGR2RGB)
                    return Image.fromarray(image)

    # Google mediapipeHands API does not support serialization of the resulted landmarks,
    # This function filters out the relevant data for this project
    def process_landmarks(self,landmarks):
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

    def saveLandmarks(self):
        for file in os.listdir(Utils.IMAGES_PATH):
            image_path = os.path.join(Utils.IMAGES_PATH, file)
            image_tag = ord(os.path.basename(image_path)[0]) - ord('A')
            result = self.get_landmarks_for_image(image_path)
            f = open("Resources/landmarks.csv", "a")
            f.write(str(image_tag))
            f.write(",")
            f.write(str(result)[1:-1])
            f.write("\n")
            f.close()

    def get_landmarks_for_image(self,image_path):
        with self.__mp_hands.Hands(static_image_mode=True, max_num_hands=1, min_detection_confidence=0.5) as hands:
            image = cv2.imread(image_path)
            image = cv2.flip(image, 1)
            results = hands.process(cv2.cvtColor(image, cv2.COLOR_BGR2RGB))
            if results.multi_hand_landmarks is not None:
                for hand_landmarks in results.multi_hand_landmarks:
                    return self.process_landmarks(hand_landmarks)
