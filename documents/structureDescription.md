- **Menu** creates a JFrame and adds **MenuGraphics** and **MenuListener**
- **MenuListener** creates a variable "name" based on user's input. 
  **MenuListener** creates a new **Start** where name is passed as a parameter
- **Start** creates a new **Game** and adds **GameGraphics**, **GameListener** and **TimerListener**. 
  Then it starts the timer.
- **TimerListener** refreshes the information of the **Game**-object and **GameGraphics** 
  every second (points, level, time and other information). When **Game**-object's 
  timeLeft-variable reaches zero, timer stops and **TimerListener** creates a new **End**. 
  **TimerListener** also saves **Game**'s player's information to a text file.

- **Game**-object holds all the information of the game and it gets new calculations created
  by **Calculation** based on ongoing level. **Calculation** gets an operator created by **Operator**, 
  which is also based on level.
- **GameListener** waits for user's answers and gets new calculations from **Game**.

- **HighScores** can be opened from **Menu** or **End**. It opens to a different window and adds
  **HighScoresGraphics** and **HighScoresListener**.
- **HighScoresGraphics** gets an organized score-list from **Scores** and presents top ten scores 
  on the screen
- **Scores** get information from the text-file where **TimerListener** was putting info. **Scores** 
  organizes the information by creating a sorted list of **Player**-objects.
- **Player** object includes player's name and points. 