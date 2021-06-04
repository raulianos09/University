import os

import torch
from PIL import Image
from torchvision.transforms import transforms

from exampleCV import SimpleNet

ann = SimpleNet()
ann.load_state_dict(torch.load("model_10.model"))
ann.eval()

for file in os.listdir("UserTest"):
    path = f"UserTest/{file}"

    image = transforms.Compose([
        transforms.Resize(224),
        transforms.CenterCrop(224),
        transforms.ToTensor(),
        transforms.Normalize((0.5, 0.5, 0.5), (0.5, 0.5, 0.5))
    ])(Image.open(path).convert("RGB"))

    image = image.unsqueeze(0)

    output = ann(image)
    _, prediction = torch.max(output.data, 1)

    if 1 == prediction.numpy()[0]:
        print(f"Picture: {file} contains a face")
    else:
        print(f"Picture: {file} does not contain a face")