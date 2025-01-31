package bv.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import bv.Client.Model.GameState;
import javafx.application.Platform;
import bv.Client.Model.Pos;
import bv.Client.Model.Dice;
import bv.Client.Model.Lids;
import bv.Client.Model.Player;
import bv.Client.MVC.GameSceneController;
import bv.Client.MVC.EnterProfileOnlController;
import bv.Client.MVC.SceneController;
import bv.Client.MVC.SoundController;
import bv.Middleware.API;

/**
 * Class Client is responsible for maintaining the connection between the client
 * and the server.
 * 
 * The class uses socket, BufferedReader, and BufferedWriter to connect to the
 * server, read and write data to it.
 * 
 * It receives messages from the server and calls the appropriate function to
 * handle each message.
 * 
 * The class implements functions to handle different messages such as enter
 * profile, roll dice, and end game.
 * 
 * It uses GameState, GameSceneController, SceneController and other classes
 * to update the state of the game and show the appropriate scene.
 */

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    /**
     * This code is a Java constructor for a client socket that attempts to connect
     * to a server at the specified IPv4 address and port number (1809). If the
     * connection is unsuccessful, it closes any related resources and throws an
     * exception, potentially displaying an error message to the user.
     * 
     * @param ipv4
     * @throws Exception
     */
    public Client(String ipv4) throws Exception {
        try {
            this.socket = new Socket(ipv4, 1809);
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
            throw new Exception();
        }
    }

    /**
     * This method takes the data that the player inputs to generate two players
     * 
     * @param s
     * @throws IOException
     */
    private void onReceiveEnterProfile(String s) throws IOException {
        String[] data = s.split(";");
        if (data.length == 1) {
            EnterProfileOnlController epoc = EnterProfileOnlController.getInstance();
            epoc.statusSuccess();
            return;
        }
        // else this will sent the name and age of second player
        GameState.Players.PLAYER2 = new Player(data[1], Integer.parseInt(data[2]));
    }

    /**
     * This methods receive the message from the client to call the corresponding
     * methods
     * 
     * @param s
     * @throws IOException
     */
    private void handleMessage(String s) throws IOException {
        API.Type type = API.getTypeFromClient(s);
        switch (type) {
            case ENTER_PROFILE:
                onReceiveEnterProfile(s);
                break;
            case DATA:
                onReceiveData(s);
                break;
            case ROLL_DICE:
                onReceiveRollDice(s);
                break;
            case ANSWER:
                onReceiveAnswer(s);
                break;
            case POP_UP:
                onReceivePopUp(s);
                break;
            case CHOOSE_COVER:
                onReceiveChooseCover(s);
                break;
            case END_GAME:
                onReceiveEndGame(s);
                break;
            default:
                System.out.println("Unspecify type");
        }
        System.out.println("hehe handle message");
    }

    /**
     * This method is called at the end of the game. It will create
     * the leaderboard scene
     * 
     * @param s
     */
    public void onReceiveEndGame(String s) {
        updateScore(s);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                SceneController sc = SceneController.getInstance();
                try {
                    sc.loadSceneByStage(GameState.stage, "LeaderBoard");
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }
            }
        });
    }

    /**
     * This method updates the game board by setting the cover image and deleting
     * previous cover images, and also updates the message displayed to the players
     * based on whose turn it is
     * 
     * @param s
     */
    public void onReceiveChooseCover(String s) {
        String[] splStrings = s.split(";");
        int column = Integer.parseInt(splStrings[1]);
        int row = Integer.parseInt(splStrings[2]);
        GameState.gameLogic.COLOR = splStrings[3];
        System.out.println("onReceiveChooseCover");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                GameSceneController bgc = GameSceneController.getInstance();
                String coverImage = "/bv/assets/Covers/" + GameState.gameLogic.COLOR + ".png";
                try {
                    if (GameState.Players.checkIsPlayer1Turn()) {
                        bgc.message.setVisible(false);
                    } else {
                        bgc.message.setText(
                                "Waiting player " + GameState.Players.PLAYER2.getName() + " roll dice");
                    }
                    bgc.deleteCover();
                    bgc.putCover(coverImage, new Pos(column, row), GameState.gameLogic.COLOR);
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }
            }
        });
    }

    /**
     * This function is handling the answer of a player in the game and updates the
     * UI accordingly by setting the message based on whether the answer was right
     * or wrong, playing sounds, and showing pop-up scenes.
     * 
     * @param s
     * @throws IOException
     */
    public void onReceiveAnswer(String s) throws IOException {
        // suy nghĩ thêm cái này
        String[] splString = s.split(";");
        String status = splString[1];
        String answer = splString[2];
        SceneController sc = SceneController.getInstance();
        GameSceneController bgc = GameSceneController.getInstance();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    if (status.equals("right")) {
                        GameState.answer = answer;
                        if (GameState.Players.checkIsPlayer1Turn()) {
                            SoundController sound = new SoundController();
                            sound.correctAnswer();
                            sc.loadSceneByStage(bgc.popUpStage, "RightAnswer");
                        } else {
                            bgc.message.setText(
                                    "Player " + GameState.Players.PLAYER2.getName() + " guess " + answer
                                            + " on dice "
                                            + GameState.gameLogic.COLOR + " got Right answer");
                        }
                    } else {
                        GameState.answer = splString[3];
                        GameState.imageString = splString[4];
                        if (GameState.Players.checkIsPlayer1Turn()) {
                            SoundController sound = new SoundController();
                            sound.wrongAnswer();
                            sc.loadSceneByStage(bgc.popUpStage, "WrongAnswer");
                        } else {
                            bgc.message.setText(
                                    "Player " + GameState.Players.PLAYER2.getName() + " guess " + answer
                                            + " on dice "
                                            + GameState.gameLogic.COLOR + " got Wrong answer");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * This function updates the game status based on the value of the status
     * string, either by changing the turn, removing or creating buttons, or
     * updating the scores, and updating the GUI with relevant messages and changes.
     * 
     * @param s
     * @throws IOException
     */
    public void onReceivePopUp(String s) throws IOException {
        String[] splString = s.split(";");
        String status = splString[1];
        GameSceneController bgc = GameSceneController.getInstance();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    if (status.equals("wrong")) {
                        if (GameState.Players.checkIsPlayer1Turn()) {

                            bgc.removeGuessPictureBtn();
                            bgc.dice.setVisible(false);
                        } else {
                            bgc.createRollDiceBtn();
                        }
                        GameState.Players.changeTurn();
                        bgc.setTurn(GameState.Players.checkIsPlayer1Turn());
                    } else {
                        updateScore(s);
                        bgc.update();
                        if (GameState.Players.checkIsPlayer1Turn()) {
                            bgc.removeGuessPictureBtn();
                            bgc.message.setVisible(true);
                            bgc.message.setText(
                                    "Please choose picture to place " + GameState.gameLogic.COLOR + " cover");
                        } else {
                            bgc.message.setText(
                                    "Waiting for player " + GameState.Players.PLAYER2.getName()
                                            + " choose picture to cover "
                                            + GameState.gameLogic.COLOR);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }
            }
        });
    }

    /**
     * This function updates the scores of the two players based on the data
     * received from a string input.
     * 
     * @param s
     */
    public void updateScore(String s) {
        String[] splStrings = s.split(";");
        if (GameState.Players.PLAYER1.getName().equals(splStrings[2])) {
            GameState.Players.PLAYER1.addScore(Integer.parseInt(splStrings[3]));
            GameState.Players.PLAYER2.addScore(Integer.parseInt(splStrings[5]));
        } else {
            GameState.Players.PLAYER1.addScore(Integer.parseInt(splStrings[5]));
            GameState.Players.PLAYER2.addScore(Integer.parseInt(splStrings[3]));
        }
    }

    /**
     * The method updates the game state by handling the result of a dice roll and
     * updating the game display accordingly, based on the current player's turn and
     * the result of the dice roll.
     * 
     * @param s
     * @throws IOException
     */
    public void onReceiveRollDice(String s) throws IOException {
        String result = s.split(";")[1];
        // if player 2 turn print message that player 2 get
        GameSceneController bgc = GameSceneController.getInstance();
        GameState.gameLogic.COLOR = result;
        if (!GameState.Players.checkIsPlayer1Turn()) {
            bgc.message.setText("Player " + GameState.Players.PLAYER2.getName() + " get: " + result);
            return;
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    bgc.clickRollDice();
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }
            }
        });
        return;
    }

    /**
     * The method "requestDice" sends a message with type "ROLL_DICE" to the server.
     */
    public void requestDice() {
        sendMessage("", API.Type.ROLL_DICE);
    }

    /**
     * The method sendAnswer sends a message containing the answer argument and the
     * API.Type.ANSWER type to the server.
     * 
     * @param answer
     */
    public void sendAnswer(String answer) {
        sendMessage(answer, API.Type.ANSWER);
    }

    /**
     * The method "closePopUp" sends a message with the given string "s" to API with
     * type "POP_UP".
     * 
     * @param s
     */
    public void closePopUp(String s) {
        sendMessage(s, API.Type.POP_UP);
    }

    /**
     * 
     * The method sets up the game by parsing the received string, initializing the
     * number of dice, theme, countdown timer, and list of Discs, then loads the
     * game screen.
     * 
     * @param s the received string from the server
     */
    public void setUpGame(String s) {
        String splString[] = s.split(";");
        Dice.numDice = Integer.parseInt(splString[2]);
        GameState.gameLogic.theme = splString[3];
        GameState.countDownTimer = Integer.parseInt(splString[4]);
        System.out.println(splString.length);
        for (int i = 5; i < splString.length - 1; i = i + 2) {
            GameState.gameLogic.myList.add(new Lids(splString[i + 1], splString[i]));
        }
        GameState.gameLogic.pictureName = GameState.getArrayValue();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SceneController sc = SceneController.getInstance();
                    sc.enterGameOnline(GameState.stage);
                } catch (Exception e) {
                    System.out.println("can not load game");
                    e.printStackTrace();
                    // TODO: handle exception
                }
            }
        });
    }

    /**
     * This method processes data received from a network connection.
     * It splits the received data into different parts, and based on the second
     * part (type), it either sets up a game, changes the turn, or updates the cover
     * coordinates.
     * 
     * @param s the data received from the network connection
     */

    public void onReceiveData(String s) {
        String type = s.split(";")[1];
        System.out.println(s);
        if (type.equals("boardgame")) {
            setUpGame(s);
        } else if (type.equals("turn")) {
            String data = s.split(";")[2];
            if (GameState.Players.PLAYER1.getName().equals(data)) {
                GameState.Players.changeTurn(); // because default isPlayer1Turn false
            }
        } else {
            System.out.println("cover run");
            GameSceneController bgc = GameSceneController.getInstance();
            bgc.coverCoords = getCoord(s);
        }

    }

    /**
     * 
     * This method is used to get the Pos array from the given string.
     * 
     * @param s The input string that contains the Pos data separated by ";".
     * @return result The Pos array that contains the coordinates obtained
     *         from the input string.
     */
    public Pos[] getCoord(String s) {
        Pos[] result = new Pos[5];
        String[] splString = s.split(";");
        int count = 0;
        for (int i = 2; i < splString.length - 1; i = i + 2) {
            if (count >= Dice.numDice) {
                break;
            }
            result[count] = new Pos(Integer.parseInt(splString[i]), Integer.parseInt(splString[i + 1]));
            count++;
        }
        for (int i = 0; i < Dice.numDice; i++) {
            System.out.println(result[i].getRow());
        }
        return result;
    }

    /**
     * 
     * Sends a message to the server.
     * 
     * @param s    String to be sent as the message.
     * @param type The type of message being sent, as defined in the API.Type
     *             enumeration.
     */
    public void sendMessage(String s, API.Type type) {
        try {
            String sendMessage = type.toString() + ";"
                    + GameState.Players.PLAYER1.getName() + ";" + s;
            bufferedWriter.write(sendMessage);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Send to server");
        } catch (Exception e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
            System.out.println("Some thing wrong with sendMessage");
            e.printStackTrace();
        }
    }

    /**
     * 
     * The chooseColor method is used to send a message to the server, indicating
     * the color choice made by the player.
     * 
     * @param color a string representing the chosen color.
     */
    public void chooseColor(String color) {
        sendMessage(color, API.Type.SET_COLOR);
    }

    /**
     * 
     * Method to listen for incoming messages from the server.
     * The method starts a new thread that continually listens for incoming
     * messages.
     * If a message is received, it is passed to the handleMessage method for
     * processing.
     * If an exception occurs, the method closes the socket, bufferedReader, and
     * bufferedWriter.
     */
    public void listenForMessage() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromServer;
                while (socket.isConnected()) {
                    try {
                        msgFromServer = bufferedReader.readLine();
                        // System.out.println(msgFromServer);
                        if (msgFromServer != null)
                            handleMessage(msgFromServer);
                    } catch (Exception e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        // t.setDaemon(true);
        t.start();
    }

    /**
     * 
     * Closes the connection with the server by sending a "CLOSE_CONNECTION"
     * message,
     * and then closes the socket, buffered reader, and buffered writer objects.
     */
    public void close() {
        sendMessage("", API.Type.CLOSE_CONNECTION);
        ;
        closeEverything(socket, bufferedReader, bufferedWriter);
    }

    /**
     * 
     * This method closes the given socket and buffered reader/writer.
     * 
     * @param socket         The socket to be closed
     * @param bufferedReader The buffered reader to be closed
     * @param bufferedWriter The buffered writer to be closed
     */
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (socket != null) {
                socket.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
