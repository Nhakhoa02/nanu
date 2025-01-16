module bv {
    requires javafx.controls;
    requires javafx.fxml;

    opens bv to javafx.fxml;
    exports bv;
}
