module bv {
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.fxml;
    requires javafx.base;
    requires transitive javafx.media;

    opens bv;
    opens bv.Client.ViewController to javafx.fxml;

    // opens bv.Client.ViewController to module javafx.fxml;
    exports bv.Client.Model;
    exports bv.Client.ViewController;
    exports bv;

}
