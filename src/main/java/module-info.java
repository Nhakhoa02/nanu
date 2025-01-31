module bv {
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.fxml;
    requires javafx.base;
    requires transitive javafx.media;

    opens bv;
    opens bv.Client.MVC to javafx.fxml;

    // opens bv.Client.MVC to module javafx.fxml;
    exports bv.Client.Model;
    exports bv.Client.MVC;
    exports bv;

}
