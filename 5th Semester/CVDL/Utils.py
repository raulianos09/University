dataset = "D:\\CVDL\\Resources\\landmarks.csv"
model_path = "D:\\CVDL\\Resources\\model.hdf5"
tflite_path = "D:\\CVDL\\Resources\\model.tflite"
IMAGES_PATH = "ProcessedDB/Train"
INFERENCE_IMAGES_PATH = "D:\\CVDL\\Inference"

# Current recognized signs -
# It is possible to add more signs by adding sample images with those signs to the training set
INDEX_MAPPING = {0: "A",
                 1: "B",
                 2: "C",
                 3: "D",
                 4: "E",
                 5: "F",
                 6: "G",
                 7: "H",
                 8: "I",
                 9: "J",
                 10: "K",
                 11: "L",
                 12: "M",
                 13: "N",
                 14: "O",
                 15: "P",
                 16: "Q",
                 17: "R",
                 18: "S",
                 19: "T",
                 20: "U",
                 21: "V",
                 22: "W",
                 23: "X",
                 24: "Y",
                 25: "Z",
                 }
