# Nanu Game Project for Java bv

![pic697952](https://user-images.githubusercontent.com/101057915/215149706-e69b1eae-c2de-4fcc-a657-d843b3739106.jpg)

## Table of contents

- [Introduction](#introduction)
- [Folder stucture](#folder-stucture)
- [How to play the game](#how-to-play-the-game)
- [Additional documents](#additional-documents)
- [Authors](#authors)

## Introduction

Nanu is a memory game for children. There are 24 pictures, 2-5 covers in the game. At the beginnig, the covers are put on random pictures. The players will roll the dice and try to remember which picture hidden under the color rolled cover.
In this repository, we created the java game based on the original nanu game. We implemented most of the basis features and rules of the game. In our game, there are two mode: online and offline. Offline version is just a two-player game, where the players take turn to roll dice and guess the picture. While in the online version, you can play on multiple machines if you enter the secret code.

## Folder stucture:

- [FXML](https://github.com/TomNewbie/nanu/tree/main/src/main/resources/bv/fxml): Stores our fxml for UI
- [MVC](https://github.com/TomNewbie/nanu/tree/main/src/main/java/bv/Client/MVC): Stores our java file to manage the user interaction with our game
- [Model](https://github.com/TomNewbie/nanu/tree/main/src/main/java/bv/Client/Model): Defines how data is created, stored, and changed
- [Server](https://github.com/TomNewbie/nanu/tree/main/src/main/java/bv/Server) and [Middleware](https://github.com/TomNewbie/nanu/tree/main/src/main/java/bv/Middleware): Stores the code for online game
- [assets](https://github.com/TomNewbie/nanu/tree/main/src/main/resources/bv/assets): Stores the resources like images, sound ...

## How to play the game

To play the game you need to install JDK to run the Java Program. The JAR file can be found in [Here](https://github.com/TomNewbie/nanu/blob/main/nanu-1.0-SNAPSHOT.jar)

## Additional documents

The inspiration for our application is [Here](https://campuas.frankfurt-university.de/pluginfile.php/207336/mod_resource/content/1/Nanu.pdf). You can watch the original game [here-Deutsch](https://www.youtube.com/watch?v=A_bEx2lpkmo) or [here-English](https://www.youtube.com/watch?v=dkwNihodVnw).

For more information, you can read the documents about our application here [pdf](https://github.com/TomNewbie/nanu/blob/main/report/Project_report.pdf).

## Authors

- [Tho Phan Chi](https://github.com/TomNewbie)
- [Thanh Le Hoang Kim](https://github.com/Kimthanh11)
- [Ferid Gökkaya](https://github.com/ferid99)
- [Kim Tran Hoang](https://github.com/HoangKim1504)
- [Ngoc Pham Nhu](https://github.com/PhamNhuNgoc)
