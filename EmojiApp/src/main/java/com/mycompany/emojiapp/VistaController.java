/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.emojiapp;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import tda.LinkedList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jurgen
 */
public class VistaController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Button nextButton;
    
    @FXML
    private Button opt1;
    
    @FXML
    private Button opt2;
    @FXML
    private Button opt3;
    @FXML
    private Button opt4;
    @FXML
    private Button opt5;
    @FXML
    private Button opt6;
    @FXML
    private Button opt7;
    @FXML
    private Button prevButton;
    
    private LinkedList<Image> menuOptions;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            colocarImangenBotones();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }    
    
    
    private void colocarImangenBotones() throws FileNotFoundException{
   
        Image imagen1 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_1.png"),20,20,false,true);

             
        opt1.setGraphic((new ImageView(imagen1)));
        opt2.setGraphic((new ImageView(imagen1)));
        opt3.setGraphic((new ImageView(imagen1)));
        opt4.setGraphic((new ImageView(imagen1)));
        opt5.setGraphic((new ImageView(imagen1)));
        opt6.setGraphic((new ImageView(imagen1)));
        opt7.setGraphic((new ImageView(imagen1)));

        
    }
}
