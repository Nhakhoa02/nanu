package bv.Client.ViewController;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

/*
 * The following class ManualPageController manages the several FXML Files. 
 *
 * The stages will have the FXML-File path which is in "main\resources\bv\fxml"
 */
public class ManualPageController {
      // private Stage stage;
      Scene scene;
      Parent root;
      Stage stage;
      SoundController soundc = new SoundController();
      SceneController sc = SceneController.getInstance();

      public void returnManual(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualOptions.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
      }

      public void switchtomanualpage1(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }

      public void switchtomanualpage2(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }

      public void switchtomanualpage3(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }

      public void switchtomanualpage4(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            // stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }

      public void switchtomanualpage5(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage5.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }

      public void switchtomanualpage6(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage6.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }

      public void switchtomanualpage7(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage7.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }

      public void switchtomanualpage8(ActionEvent event) throws IOException {
            soundc.click();
            Parent root = FXMLLoader.load(getClass().getResource("/bv/fxml/ManualPage8.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets()
                        .add(getClass().getResource("/bv/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
            // sc.gotomanualpage(event);

      }
}
