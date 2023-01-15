## Setup
 In order to try out the project:<br>
 1. Open the 'Project' directory as a pycharm project (or whatever editor you are using)<br>
 2. A simple GUI was created for testing purposes. Add all the images that you want to detect hand signs from to the 'Inference' directory.<br>
 3. Set the paths from the "Utils.py" file so that they match the paths on your machine<br>
 4. Run  $pip install -r requirements.txt in the PyCharm terminal<br>
 
 ## Code review
 The initial model was taken from a research paper, however in that paper only 3 <br>
 signs were recognized (peace sign , OK and you  rock) so the model was not quite feasible for my needs. <br>
 I increased the number of neurons per Dense layer and lowered the dropout. <br>
 
 All the data processing code was written by me.<br>
 The GUI was also implemented by me.<br>
 
 Bassically the project idea came from the internet but the actual implementation was done by me.<br>
