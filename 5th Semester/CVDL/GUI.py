import os
import tkinter
from tkinter import *
from PIL import Image, ImageTk

import Utils


class GUI:
    def __init__(self, model, db, inference):
        self.model = model
        self.db = db
        self.inference = inference
        self.initGui()

    def initGui(self):
        self.root = Tk()
        self.root.title("ASL recognition")
        self.root.state("zoomed")

        def showimg(e):
            n = listbox.curselection()
            name = listbox.get(n)
            image_path = os.path.join(Utils.INFERENCE_IMAGES_PATH, name)
            img = Image.open(image_path)
            img = img.resize((400, 400))
            img = ImageTk.PhotoImage(img)
            label.config(image=img)
            label.image = img

            img2 = self.db.show_image_landmarks(image_path)
            img2 = img2.resize((400, 400))
            img2 = ImageTk.PhotoImage(img2)
            label2.config(image=img2)
            label2.image = img2

            mytext = "Detected sign is: "
            mytext += self.inference.interpret_landmarks(self.db.get_landmarks_for_image(image_path))
            label3.config(text=mytext, font=("Arial", 25))

        listbox = Listbox(self.root)
        listbox.pack(side=LEFT, fill=BOTH)
        scrollbar = Scrollbar(self.root)
        scrollbar.pack(side=RIGHT, fill=BOTH)

        for file in os.listdir(Utils.INFERENCE_IMAGES_PATH):
            image_path = os.path.join(Utils.INFERENCE_IMAGES_PATH, file)
            listbox.insert(END, os.path.basename(image_path))

        listbox.bind("<<ListboxSelect>>", showimg)
        img = ImageTk.PhotoImage(Image.open("D:\CVDL\Resources\placeholder.png"))
        label = Label(self.root, text="hello", image=img)
        label.pack(padx=0, fill=BOTH)
        label2 = Label(self.root, text="hello", image=img)
        label2.pack(padx=0, fill=BOTH)
        label3 = Label(self.root, text="hello")
        label3.pack(padx=0)

        self.root.mainloop()
