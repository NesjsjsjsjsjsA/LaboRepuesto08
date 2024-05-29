module fxvisual.labo08 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;

    opens fxvisual.labo08 to javafx.fxml;
    exports fxvisual.labo08;
}