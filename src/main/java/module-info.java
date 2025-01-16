module bv {
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.fxml;
    requires javafx.base;

    opens bv to javafx.fxml;
    opens bv.MVC to javafx.fxml;
    
    exports bv;
    exports bv.MVC;
}
