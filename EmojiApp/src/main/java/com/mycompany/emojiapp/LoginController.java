/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.emojiapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wayar
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button registerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML 
    private void registrarUsuario(MouseEvent event) throws IOException{
         FXMLLoader loader=new FXMLLoader(App.class.getResource("UserRegister.fxml"));
                        Parent root= loader.load();
                        //UserRegisterController controller = loader.getController();
                        Scene scene= new Scene(root);
                        Stage stage= new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();
        
    }
    
    
    
    private void aaa(MouseEvent event) throws IOException{
         FXMLLoader loader=new FXMLLoader(App.class.getResource("UserRegister.fxml"));
                        Parent root= loader.load();
                        //UserRegisterController controller = loader.getController();
                        Scene scene= new Scene(root);
                        Stage stage= new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();
        
    }
}
