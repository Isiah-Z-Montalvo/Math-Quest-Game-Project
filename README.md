# Math-Quest-Game-Project
![1](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/1.png)

## Classes and Methods
### GameApp: 
main()
### Game: 
start()
### Graphics:
getImage()
drawTitle()
drawGame()
### Audio:
playWin()
playLoss()
playMusic()
### Score:
writeScores()
readScores()
### RegexValidator:
validateText()
validateName()

## GameApp - Driver Class
The game app driver class simply runs the program using the Launch(args) method of the main function. This class also inherits methods from the Game operations class using the launch method to initiate the start method within the Game class which runs the bulk of the program.
![2](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/2.png)

## Game - Operations Class
The Game operations class imports and implements many of the javafx application library classes to create the game. It inherits the Application class from javafx and implements the start method that is launched from the driver class. 
![3](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/3.png)
This section of the Game classes defines most of the global objects that are used from other classes throughout the code such as a graphics object, scene objects, validator object, audio object, and other variables to store data used to pass to other methods. 
![4](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/4.png)
This code represents the beginning of the start function of the Game class that performs and runs the program. First, variables are initialized with random integers between the numbers 0-9. This is used later during button actions to randomize and create multiple math addition questions for the game to ask. Next, a label and textfield is created and when the enter button is pressed after a user enters into the text field, it stores their requested name into a variable which is validated to only be letters with an uppercase letter at the beginning. This name is used to store the player name in the Scores text file later on. 
![5](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/5.png)
In this section, using the getImage(String picName), the image to be used for the finished button is stored within the pic variable. Using this, a button is created that is set to invisible, as it is only supposed to appear once the game timer has been completed. Upon clicking this button, the player's name and score are written to the Scores text file and it returns the player to the title screen.
![6](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/6.png)
In this section, a tilepane is created using a label and textfield designed to consist of the core gameplay where the label will ask an addition question and the player types the answer within the textfield. A boolean variable determines if the results button is visible, which only returns true after the animation during gameplay is completed. Once this statement is satisfied, it prevents the player from entering any more answers to any more questions, requiring them to restart the game to try again. This answer is then validated using the validateText() method and parsed to an int to compare for an if statement. If the answer is correct, a win sound effect is played and the player’s score is updated, the label then updates to reflect the score increase. If the answer is incorrect, a loss sound effect is played. Two new random numbers are then generated which create the next question asked to the player through the next label. The tilepane then adds all the children. 
![7](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/7.png)
From here, the 3 buttons present on the title screen and created and their instructions initialized. The start button resets the score to 0 from a previous game, hides the results button, and passes the tilepane and results button to the game scene through the drawGame() function call. It then switches the scene to the game. Next, the highscore button is initialized and when clicked, reads and displays player name and scores from the Scores text file. Finally, the exit button is initialized and when clicked, closes the program.
![8](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/8.png)
To conclude the Game operations class, the title scene variable is given the scene from the drawTitle() function call which passes the three buttons earlier to display them in the scene. The background music for the game is then played and the game is shown. 
## Graphics - Operations Class
The Graphics operations class takes care of the GUI and color creation for the scenes as well as most of the other visuals of the program. 
![9](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/9.png)
The getImage() method is used to create an image object and use it to obtain the file locations for PNG’s that are used for the buttons throughout the game. It passes a string with the name of the requested image. The image is then returned to the Game class to create the buttons. 
![10](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/10.png)
The drawTitle() method passes the buttons created in the Game class as well as creates the main title image. The background color is also created using a rectangle object for the main menu and the bg variables as well as the passed buttons are initialized into a pane and passed through the returned scene variable to create the main menu. 
![11](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/11.png)
The drawGame() method passes the tilepane created in the Game class and the results button from the game class to draw the core gameplay background and animation. Various shape objects are created and placed to create the scene, then a rectangle is created that calls various animation methods to animate the square transitioning from the left side of the screen to the right, then back again. This is used as a timer for the player to score as high as possible by answering as many addition questions as they can, as once the animation is finished, an event handler shows the results button which stops the game and returns the player to the title screen. All of the shapes, tiles, and buttons are passed through the pane creation to return the created scene to start the game. 
## Audio - Operations Class
The Audio operations class handles the playing and creation of the audio files used throughout the game. 
![12](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/12.png)
The playWin() function creates a new file, media, and media player object that uses the imported sound effect and plays it when the method is called. This method is called every time a player answers a question correctly. The playLoss() function does the same except it imports a different sound effect that is played whenever a player answers a question incorrectly. The playMusic() function does something similar as well, importing the main background music to play throughout the game and loops 10 times to ensure the background music doesn’t stop while playing. This method is called when the program first starts. 
## Score - Operations Class
The Score operations class is responsible for writing and reading to the Scores text file to update the name and score of each player that plays the game.
![13](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/13.png)
The writeScores() method passes the name and score from the Game class to initialize the text file and write the name and score of the player into the text file.  This is called every time the results button is clicked. The readScores() method initializes the Scores text file and if data exists within the file, a while loop is started to display the name and score of each player on each line of the text file using JOptionPane, if the file isn’t found, an error message is displayed. 
## RegexValidator - Operations Class
The RegexValidator class contains many different methods to validate different types of scenarios, however, the only ones used throughout this game are the validateText() method and the validateName() method.
![14](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/14.png)
The validateText() method created a regex value that only allows for numbers 0-9 for every character which is used to ensure that only numbers are entered to answer the math questions posed by the game. Using a pattern compiler and matcher, the booleans are compared to determine whether the user submitted answer is valid, and if it is, it is returned to the Game class. The validateName() method does roughly the same, except instead of only allowing numbers to be entered, only letters Uppercase and lowercase A-Z are allowed as this is used to validate name entries in the Game class throughout the program. 
## Gameplay Images and Explanations
This is the main menu displayed to the player upon starting the program.
![1](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/1.png)
This is a screenshot of the gameplay. At the top left, a text pane is there where players will enter the math equations presented to them throughout the game. Their high score is displayed and updated in real time next to the answer box for the math questions. Next to the high score label, is the name label where upon finishing the game, the player enters their name to be stored into the high scores file. While this is happening, players are timed by the red box that moves from one side of the screen to the next. When the animation completes and the box returns to its initial position, the game is completed.
![15](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/15.png)
This is displayed upon the animation completing its cycle, clicking the finished button returns the player to the main menu.
![16](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/16.png)
Screenshot of high scores displayed to the player through the high scores button.
![17](https://github.com/Isiah-Z-Montalvo/Math-Quest-Game-Project/blob/main/17.png)
