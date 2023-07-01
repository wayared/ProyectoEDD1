/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.emojiapp;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jurgen
 */
public class UserRegisterController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private TextField txtUsuario; 
    @FXML
    private TextField txtPassword; 
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
    @FXML
    private void registrar(MouseEvent event) {        
        try {
            String usuario = txtUsuario.getText();
            String password = txtPassword.getText();
            User.registrarUsuario(usuario,password);
            AlertBoxes.infoAlert("Exito", "Registro Exitoso", "Residente registrado correctamente");
        } catch (IOException ex) {
            AlertBoxes.errorAlert("Error", "Error de Texto", "No puede dejar ningún campo de texto vacío");
        }
        User.cargarUsuarios();   
    }
    
}
