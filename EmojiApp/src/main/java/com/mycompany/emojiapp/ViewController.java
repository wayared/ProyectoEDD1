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
import tda.*;

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
    

    Iterator<Image> it2;
    
    

    
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
            //System.out.println(file.getFileName());
        } 
        return imagenes;
    }
    
    private void colocarImangenBotones() throws FileNotFoundException, IOException{
        
         Iterator<Button> it = listaBotones().iterator();
         Iterator<Image> it2 = cargarImagenes().iterator();
        System.out.println("b");
        while(it.hasNext()){  
            System.out.println("a");
           it.next().setGraphic((new ImageView(it2.next())));   
        }
          
    }
}
