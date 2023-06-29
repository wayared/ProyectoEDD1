module com.mycompany.emojiapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires java.logging;

    opens com.mycompany.emojiapp to javafx.fxml;
    exports com.mycompany.emojiapp;
}
