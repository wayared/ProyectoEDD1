/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.emojiapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.util.Arrays.stream;
import java.util.Iterator;
import java.util.ResourceBundle;
import static java.util.stream.StreamSupport.stream;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import tda.LinkedList;

/**
 * FXML Controller class
 *
 * @author wayar
 */
public class ViewController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            cargarImagenes();
            colocarImangenBotones();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
    @FXML
    private HBox hbox;
    
    @FXML
    private Pane panel;
    @FXML
    private Button option1;
    @FXML
    private Button option2;
    @FXML
    private Button option3;
    @FXML
    private Button option4;
    @FXML
    private Button option5;
    @FXML
    private Button option6;
    @FXML
    private Button option7;
    
    

    
    public LinkedList<Button>  listaBotones(){
        LinkedList<Button> lista = new LinkedList<>();
        lista.addLast(option1);
        lista.addLast(option2);
        lista.addLast(option3);
        lista.addLast(option4);
        lista.addLast(option5);
        lista.addLast(option6);
        lista.addLast(option7);
        return lista;
    }
    
    private LinkedList<Image> cargarImagenes() throws FileNotFoundException, IOException{
        LinkedList<Image> imagenes = new LinkedList<>();
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\faces"));
        for(Path file: stream ){
            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\" +file.getFileName()),50,50,true,false));
        } 
        return imagenes;
    }
    
    private void colocarImangenBotones() throws FileNotFoundException, IOException{

        
        /* Image imagen1 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_1.png"),50,50,true,false);
        Image imagen2 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_4.png"),50,50,true,false);
        Image imagen3 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_5.png"),50,50,true,false);
        Image imagen4 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_6.png"),50,50,true,false);
        Image imagen5 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_7.png"),50,50,true,false);
        Image imagen6 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_8.png"),50,50,true,false);
        Image imagen7 = new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\faces_9.png"),50,50,true,false);
             
        option1.setGraphic((new ImageView(imagen1)));
        option2.setGraphic((new ImageView(imagen2)));
        option3.setGraphic((new ImageView(imagen3)));
        option4.setGraphic((new ImageView(imagen4)));
        option5.setGraphic((new ImageView(imagen5)));
        option6.setGraphic((new ImageView(imagen6)));
        option7.setGraphic((new ImageView(imagen7))); */
        Iterator<Button> it = listaBotones().iterator();
        Iterator<Image> it2 = cargarImagenes().iterator();
        
        
        while(it.hasNext()){  
            it.next().setGraphic((new ImageView(it2.next().toString())));     
        }

        
    }
}
