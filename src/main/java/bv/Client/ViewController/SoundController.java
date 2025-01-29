package bv.Client.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * In this class the several sounds which are
 * at "/bv/sound/" will be associate to the methods joker, lose victory and
 * so on.
 */

public class SoundController implements Initializable {
    public static double volume = 100;

    /**
     * 
     * Initializes the SoundController class with data.
     * 
     * @param url The URL of the resource.
     * @param rb  The ResourceBundle containing the data.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * 
     * Plays a sound given a path.
     * 
     * @param path The path of the sound file.
     */
    @FXML
    public void playSound(String path) {
        Media media = new Media(this.getClass()
                .getResource(path)
                .toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(SoundController.volume);
        mediaPlayer.play();
    }

    /**
     * 
     * Plays the sound for a button click.
     */
    public void click() {
        String path = "/bv/sound/click.mp3";
        playSound(path);
    }

    /**
     * 
     * Plays the sound for a correct answer.
     */
    public void correctAnswer() {
        String path = "/bv/sound/correctanswer.mp3";
        playSound(path);
    }

    /**
     * 
     * Plays the sound for a dice roll.
     */
    public void dice() {
        String path = "/bv/sound/dice.mp3";
        playSound(path);
    }

    /**
     * 
     * Plays the sound for a joker being used.
     */
    public void joker() {
        String path = "/bv/sound/joker.mp3";
        playSound(path);
    }

    /**
     * 
     * Plays the sound for losing the game.
     */
    public void lose() {
        String path = "/bv/sound/losegame.mp3";
        playSound(path);
    }

    /**
     * 
     * Plays the sound for a wrong answer.
     */
    public void wrongAnswer() {
        String path = "/bv/sound/wronganswer.mp3";
        playSound(path);
    }

    /**
     * 
     * Plays the sound for a keyboard press.
     */
    public void presskeyboard() {
        String path = "/bv/sound/presskeyboard.mp3";
        playSound(path);
    }

    /**
     * 
     * Plays the sound for winning the game.
     */
    public void victory() {
        String path = "/bv/sound/victory.mp3";
        playSound(path);
    }

}