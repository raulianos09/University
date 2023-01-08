import os

import cv2

import Utils
from Database import Database
from GUI import GUI
from Inference import Inference
from Model import Model

if __name__ == "__main__":
  db = Database()
  model = Model()
  inference = Inference()

  # model.train_model()

  #Load images for inference

  gui = GUI(model,db,inference)

  # for file in os.listdir(Utils.INFERENCE_IMAGES_PATH):
  #   image_path = os.path.join(Utils.INFERENCE_IMAGES_PATH, file)
  #   image = cv2.imread(image_path)
  #   landmarks = db.get_landmarks_for_image(image)
  #   if landmarks is not None:
  #     aproximation = inference.interpret_landmarks(landmarks)
  #     print("Regarding to the model your image falls into category:" ,aproximation)
  #     db.show_image_landmarks(image)
  #   else:
  #     print("Gogu could not recognize a hand")

