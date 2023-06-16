module com.mycompany.emojiapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.emojiapp to javafx.fxml;
    exports com.mycompany.emojiapp;
}
