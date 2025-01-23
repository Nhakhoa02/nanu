package bv.Model;

public class GameState {

    private static int numLids;
    private static int numPlayers;
    private static int numTimePerGuess;
    private static String topic;

    // Constructor (Sets Static Fields)
    public GameState(int numLids, int numPlayers, int numTimePerGuess, String topic) {
        GameState.numLids = numLids;
        GameState.numPlayers = numPlayers;
        GameState.numTimePerGuess = numTimePerGuess;
        GameState.topic = topic;
    }

    public static void setGameState(int numLids, int numPlayers, int numTimePerGuess, String topic) {
        GameState.numLids = numLids;
        GameState.numPlayers = numPlayers;
        GameState.numTimePerGuess = numTimePerGuess;
        GameState.topic = topic;
    }

    // Getters and Setters (Static)
    public static int getNumLids() {
        return numLids;
    }

    public static void setNumLids(int numLids) {
        GameState.numLids = numLids;
    }

    public static int getNumPlayers() {
        return numPlayers;
    }

    public static void setNumPlayers(int numPlayers) {
        GameState.numPlayers = numPlayers;
    }

    public static int getNumTimePerGuess() {
        return numTimePerGuess;
    }

    public static void setNumTimePerGuess(int numTimePerGuess) {
        GameState.numTimePerGuess = numTimePerGuess;
    }

    public static String getTopic() {
        return topic;
    }

    public static void setTopic(String topic) {
        GameState.topic = topic;
    }
}
