package bv.Client.MVC;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import bv.Client.Model.GameState;

/**
 * SceneController is a singleton class responsible for controlling and managing
 * the scenes in the JavaFX application.
 *
 * The SceneController class contains a Stage, a Scene and a Parent object for
 * representing the current stage, scene, and root of the application.
 *
 * It also contains a private constructor to ensure only one instance of
 * the class is created.
 *
 * The class provides methods to switch between different scenes
 * in the application.
 */
public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Stage mystage;
    @FXML
    private Pane pane;
    String name;

    private static SceneController sc;

    private SceneController() {
    }

    public static SceneController getInstance() {
        if (SceneController.sc == null) {
            sc = new SceneController();
        }
        return sc;
    }

    public Stage createScene(ActionEvent event, String name) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/bv/fxml/" + name + ".fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
        return stage;
    }

    // Create scene with loader
    public void createScene(ActionEvent event, FXMLLoader loader) throws IOException {
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    public void homeScreen(ActionEvent event) throws IOException {
        createScene(event, "HomeScreen");
    }

    public void loadSceneByStage(Stage stage, String name) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/bv/fxml/" + name + ".fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    public void serverSetting(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bv/fxml/ServerSetting.fxml"));
        loader.setController(ServerSettingController.getInstance());
        createScene(event, loader);
    }

    public void chooseRole(ActionEvent event) throws IOException {
        createScene(event, "ChooseRole");
    }

    public void enterProfile1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bv/fxml/EnterProfile.fxml"));
        root = loader.load();
        if (GameState.Players.PLAYER1 != null) {
            EnterProfileController epc = loader.getController();
            epc.displayProfile(GameState.Players.PLAYER1.getName(),
                    GameState.Players.PLAYER1.getAge());
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void enterProfile2(ActionEvent event, String tho) throws IOException {
        createScene(event, "EnterProfile2");
    }

    public void enterGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bv/fxml/BoardGame.fxml"));
        loader.setController(GameSceneController.getInstance());
        createScene(event, loader);
    }

    public void enterProfileOnline(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bv/fxml/EnterProfileOnl.fxml"));
        loader.setController(EnterProfileOnlController.getInstance());
        createScene(event, loader);
    }

    public void enterGameOnline(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bv/fxml/boardgameOnl.fxml"));
        loader.setController(GameSceneController.getInstance());
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        // System.out.println("game start");
    }

    public void closeWindow() throws IOException {
        mystage = (Stage) pane.getScene().getWindow();
        mystage.close();
    }

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/Login.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void showAlertMessage(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

}
