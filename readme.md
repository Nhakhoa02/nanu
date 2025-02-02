# Nanu - A Java Application

![Online Image](https://m.media-amazon.com/images/I/617q+qDAhRL._AC_SL1024_.jpg)

# Table of contents

- [Nanu - A Java Application](#nanu---a-java-application)
- [Table of contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Features :](#features-)
  - [Folder stucture:](#folder-stucture)
  - [How to play the game](#how-to-play-the-game)
  - [Installation](#installation)
  - [References](#references)
  - [Authors](#authors)

## Introduction

Nanu is an interactive memory game targeted for kids, inspired by the original German board game. In this game, there are 24 images hidden by 2-5 lids of different colors. In the turn, player rolls the color dice and try to guess which image below the coressponding lid. 

This is a JavaFX-based digital implementation of Nanu, with an easy-to-use graphical interface for local and online multiplayer modes.

## Features :
1. Two Game Modes: User can choose between Offline play and Online play. 
2. User-Friendly Interaface: The game is designed with JavaFX, includes animated dice roll and interactively engaging game features.
3. Customizable Settings: Players can adjust difficulty levels and themes.
4. Leaderboard: Tracks the scores and stats of players.
5. Audio & Visual Effects: Enhance the game's immersiveness.

## Folder stucture:

```
Nanu/
│── pom.xml                    # Maven build file
│── README.md                  # Project documentation
│
├── src/
│   ├── main/java/bv/
│   │   ├── App.java           # Main entry point of the application
│   │   ├── Model/             # Game logic and data models
│   │   ├── MVC/               # Controllers for UI interactions
│   │   ├── Server/            # Networking for online gameplay
│   │   ├── Middleware/        # Communication handling
│   │
│   ├── main/resources/bv/
│   │   ├── fxml/              # FXML files for UI design
│   │   ├── assets/            # Game images, sound effects, and stylesheets
│
├── target/                    # Compiled output
```



## How to play the game
1. Start the game: Run the [Nanu JAR](nanu-1.0-SNAPSHOT.jar) file.
3. Select game mode Online or Offline.
4. Roll the dice: The color rolled determined the image which need to be guessed below which lid.
5. Guess the image: If the answer was correct, the score will be update . Otherwise, Other player takes the turn.
6. Game ends when not enough images for the color lids.
7. Leaderboard: View scores after the game ends.

## Installation
Prerequisites :
1. Java 17 or later. 
2. JavaFX SDK installed
3. Maven (for building the project)

Alternative way :
1. Dowload the project folder.
2. Open the folder with your IDE (Visual Studio Code recommended)
3. Locate to the file App.java in src/main, click on "Run" .
   
## References
Instructions of how to play the game Nanu via videos :
[1](https://www.youtube.com/watch?v=A_bEx2lpkmo)
[2](https://www.youtube.com/watch?v=IaH90iDNWi4)
[3](https://www.youtube.com/watch?v=dkwNihodVnw).

Our report on the application, as a part of the course Java OOP Project, degree Computer Science, WiSe 24/25, Frankfurt University of Applied Science :
[report](https://www.overleaf.com/project/67964c78462d6b1c09955dfa).

## Authors
- Toan Tran Ngoc Anh
- Thai An Le 
- Anh Khoa Nguyen Hoang
