module com.mycompany.emojiapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.emojiapp to javafx.fxml;
    exports com.mycompany.emojiapp;
}
