/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.emojiapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.util.Arrays.stream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import static java.util.stream.StreamSupport.stream;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
            cargarBotones();
            cargarImagenesInicio();
            colocarImagenBotones();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
    @FXML
    private HBox hbox;
    
    @FXML
    private StackPane panel;
    
    @FXML
    private Button FaceButton;
    @FXML
    private Button EyeButton;
    @FXML
    private Button EyeBrowsButton;
    @FXML
    private Button MouthButton;
    @FXML
    private Button AccessoriesButton;
    
    @FXML
    private Button prevButton;
    
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
    
    @FXML
    private Button nextButton;
    @FXML
    private Button loadImg;
    @FXML
    private File file;

    LinkedList<Image> imagenes = new LinkedList<>();
    
    

    
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
        
    @FXML
    private void cargarImagenes(MouseEvent event) throws FileNotFoundException, IOException{    

        FaceButton.setOnMouseClicked((MouseEvent e) ->{
                    imagenes.clear();
        DirectoryStream<Path> stream = null;
            try {
                stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\faces"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        for(Path file: stream ){
            try {
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\" +file.getFileName()),50,50,true,false));
                //System.out.println(file.getFileName());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
            try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
});
         
         EyeButton.setOnMouseClicked((MouseEvent e)->{
               imagenes.clear();
        DirectoryStream<Path> stream = null;
            try {
                stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\eyes"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        for(Path file: stream ){
            try {
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\eyes\\" +file.getFileName()),50,50,true,false));
                //System.out.println(file.getFileName());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
         try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         });
        
         MouthButton.setOnMouseClicked((MouseEvent e) ->{
               imagenes.clear();
        DirectoryStream<Path> stream = null;
            try {
                stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\mouth"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        for(Path file: stream ){
            try {
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\mouth\\" +file.getFileName()),50,50,true,false));
                //System.out.println(file.getFileName());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
         
         try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }});
         
          AccessoriesButton.setOnMouseClicked((MouseEvent e) ->{
               imagenes.clear();
        DirectoryStream<Path> stream = null;
            try {
                stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\accessories"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        for(Path file: stream ){
            try {
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\accessories\\" +file.getFileName()),50,50,true,false));
                //System.out.println(file.getFileName());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
         
         try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }});
          
          EyeBrowsButton.setOnMouseClicked((MouseEvent e) ->{
               imagenes.clear();
        DirectoryStream<Path> stream = null;
            try {
                stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\eyebrows"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        for(Path file: stream ){
            try {
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\eyebrows\\" +file.getFileName()),50,50,true,false));
                //System.out.println(file.getFileName());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
         
         try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }  
          });
    }
    
     private void cargarImagenesInicio() throws FileNotFoundException, IOException{    
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\faces"));
        for(Path file: stream ){
            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\" +file.getFileName()),50,50,true,false));
            //System.out.println(file.getFileName());  
        }
     }
    
    private void colocarImagenBotones() throws FileNotFoundException, IOException{
        
         Iterator<Button> it = listaBotones().iterator();
         Iterator<Image> it2 = imagenes.iterator();
        while(it.hasNext()){  
           it.next().setGraphic(new ImageView(it2.next()));
           
        }
          
    }
    
    @FXML
    private void prevElement(MouseEvent event){
        
        prevButton.setOnMouseClicked((MouseEvent e) ->{
        imagenes.prevNode();
        Iterator<Button> listaBotones = listaBotones().iterator();
        Iterator<Image> images = imagenes.iterator();
         while(listaBotones.hasNext()){ 
             listaBotones.next().setGraphic(new ImageView(images.next()));
             
         }
           
           
       });
                }
    
    @FXML
    private void nextElement(MouseEvent event){
        
        nextButton.setOnMouseClicked((MouseEvent e) ->{
        imagenes.nextNode();
        Iterator<Button> listaBotones = listaBotones().iterator();
        Iterator<Image> images = imagenes.iterator();
         while(listaBotones.hasNext()){ 
             listaBotones.next().setGraphic(new ImageView(images.next()));
             
         }
           
           
       });
                }
    
    @FXML
    private void cargarBotones() throws FileNotFoundException{
                 
        prevButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\Larrow.png" ),45,45,true,false)));
        nextButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\Rarrow.png" ),45,45,true,false)));
        loadImg.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\upload.png" ),20,20,true,false)));
        
    }
    
    @FXML
    private void mostrarImagen(MouseEvent event){
 
                
        option1.setOnMouseClicked((MouseEvent e) ->{
            ImageView imagen = (ImageView)option1.getGraphic();
            ImageView imagen2 = new ImageView(imagen.getImage());
            ImageView img = new ImageView(imagen2.getImage());
            img.setFitHeight(120);
            img.setFitWidth(120);         
            panel.getChildren().add(img);
            
       });
    }
    
    @FXML
    private void uploadImg(MouseEvent event){
//        int resultado;
//        
//        Buscarimg buscador = new Buscarimg();
//        
//        FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG y GIF", "jpg", "png", "gif");
//        
//        buscador.JFCImg.setFileFilter(formato);
//        resultado = buscador.JFCImg.showOpenDialog(null);
//        if(JFileChooser.APPROVE_OPTION == resultado){
//            file = Buscarimg.JFCImg.getSelectedFile();
//                
//            
//        }
    String path = "";
    JFileChooser selectFile = new JFileChooser();
    FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG y GIF", "jpg", "png", "gif");
        selectFile.setFileFilter(formato);
        int respuesta = selectFile.showOpenDialog(null);
        
        if(respuesta == selectFile.APPROVE_OPTION){
            path = selectFile.getSelectedFile().getPath();
            
            
        }
        
    }
}
