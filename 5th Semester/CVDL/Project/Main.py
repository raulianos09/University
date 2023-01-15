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

  model.train_model()

  gui = GUI(model,db,inference)

