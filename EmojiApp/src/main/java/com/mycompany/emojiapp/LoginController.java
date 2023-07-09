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
import javafx.scene.control.TextField;
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
    
    @FXML
    private TextField txtUser;
    
    @FXML
    private TextField txtPassword;
    
    

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
    
    
    @FXML
    private void loginUser(MouseEvent event) throws IOException{
         String user = txtUser.getText();
         String password = txtPassword.getText();
         System.out.println(user);
         System.out.println(password);
         try{
         User.login(user,password);
        } catch (NullPointerException n) {
            AlertBoxes.errorAlert("Error", "No puede dejar ningún campo de texto vacío", "Inténtelo nuevamente");
        }  
         catch (IOException n) {
            AlertBoxes.errorAlert("Error", "No se pudo encontrar el usuario", "Usuario no registrado");
        }   
        
    }
    
    
}
