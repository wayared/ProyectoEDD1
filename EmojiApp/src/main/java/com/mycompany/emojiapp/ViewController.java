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
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    
    boolean faceGroup = true;
    boolean EyeGroup;
    boolean EyeBrowsGroup;
    boolean accesoriesGroup;
    boolean mouthGroup;
    int index = 0;

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
            ActionButton();
            colorButton();
            Paneles();
            
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
    private Pane facePanel = new StackPane(); 
    @FXML
    private Pane eyePanel = new StackPane(); 
    @FXML
    private Pane mouthPanel = new StackPane(); 
    @FXML
    private Pane eyebrowsPanel = new StackPane(); 
    @FXML
    private Pane accessoriesPanel = new StackPane(); 

    
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

    LinkedList<Image> imagenes = new LinkedList<>();
    

    public LinkedList<Button>  listaBotones(){
        LinkedList<Button> lista = new LinkedList<>();  // CREO UNA LISTA CON LOS BOTONES DE CADA OPCON A ELEGIR
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

        FaceButton.setOnMouseClicked((MouseEvent e) ->{  // AL PRESIONAR EL BOTON DE UN GRUPO DE ELEMENTOS
                    imagenes.clear();       // ELIMINO TODAS LAS IMAGENES DE CADA BOTON
        DirectoryStream<Path> stream = null; 
            try {                               //CARGO UNA CARPETA PARA HACER UNA LECTURA
                stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\faces"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        for(Path file: stream ){    // POR CADA ARCHIVO EN LA CARPETA LEIDA
            try {                   // ANIADO LASIMAGENES A UNA COLECCION
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\" + file.getFileName()),50,50,true,false));
                //System.out.println(file.getFileName());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
            try {
                colocarImagenBotones(); //INVOCO AL METODO PARA COLOCAR IMAGEN A CADA BOTON 
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
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\eyes\\" + file.getFileName()),50,50,true,false));
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
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\mouth\\" + file.getFileName()),50,50,true,false));
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
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\accessories\\" + file.getFileName()),50,50,true,false));
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
                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\eyebrows\\" + file.getFileName()),50,50,true,false));
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
    
     private void cargarImagenesInicio() throws FileNotFoundException, IOException{ //CARGA IAMGENES AL INICIALIZAR EL SISTEMA
        imagenes.clear();
        if(faceGroup){
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\faces"));
        for(Path file: stream ){
            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\" + file.getFileName()),50,50,true,false));
      
        }
        }else if(EyeGroup){
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\eyes"));
        for(Path file: stream ){
            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\eyes\\" + file.getFileName()),50,50,true,false));
      
        }
            
        }else if(EyeBrowsGroup){
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\eyebrows"));
        for(Path file: stream ){
            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\eyebrows\\" + file.getFileName()),50,50,true,false));
      
        }
        }else if(mouthGroup){
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\mouth"));
        for(Path file: stream ){
            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\mouth\\" +file.getFileName()),50,50,true,false));
      
        }
        }else if(accesoriesGroup){
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\accessories"));
        for(Path file: stream ){
            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\accessories\\" + file.getFileName()),50,50,true,false));
      
        }
        }
        
     }
    
    private void colocarImagenBotones() throws FileNotFoundException, IOException{
        
         Iterator<Button> it = listaBotones().iterator();  
         Iterator<Image> it2 = imagenes.iterator();
        while(it.hasNext()){  //ITERO SOBRE LA LISTA DE BOTONES
           it.next().setGraphic(new ImageView(it2.next())); // SETEO UNA IMAGEN A CADA BOTON
           
        }
          
    }
    
    @FXML
    private void prevElement(MouseEvent event){
        
        prevButton.setOnMouseClicked((MouseEvent e) ->{
        imagenes.prevNode(); // INVOCO A LA FUNCION QUE DESPLAZA LOS ELEMENTOS A LA DERECHA
        Iterator<Button> listaBotones = listaBotones().iterator();  
        Iterator<Image> images = imagenes.iterator();
         while(listaBotones.hasNext()){   //ITERO SOBRE LA LISTA DE BOTONES
             listaBotones.next().setGraphic(new ImageView(images.next())); // CARGO UNA IMAGEN PARA CADA BOTON             
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
        // AGREGAMOS ICONOS A LOS BOTONES DE BACK , NEXT Y SUBIR IMAGEN
        prevButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\Larrow.png" ),45,45,true,false)));
        nextButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\Rarrow.png" ),45,45,true,false)));
        loadImg.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\upload.png" ),20,20,true,false)));         
    }
    
    @FXML
    private void mostrarImagen(MouseEvent event){
                          
        option1.setOnMouseClicked((MouseEvent e) ->{
              showFace(option1);
              showEyes(option1);
              showEyeBrows(option1);
              showMouth(option1);
              showAccessories(option1);
            });
        option2.setOnMouseClicked((MouseEvent e) ->{
              showFace(option2);
              showEyes(option2);
              showEyeBrows(option2);
              showMouth(option2);
              showAccessories(option2);
            });
        option3.setOnMouseClicked((MouseEvent e) ->{
              showFace(option3);
              showEyes(option3);
              showEyeBrows(option3);
              showMouth(option3);
              showAccessories(option3);
            });
        option4.setOnMouseClicked((MouseEvent e) ->{
              showFace(option4);
              showEyes(option4);
              showEyeBrows(option4);
              showMouth(option4);
              showAccessories(option4);
            });
        option5.setOnMouseClicked((MouseEvent e) ->{
              showFace(option5);
              showEyes(option5);
              showEyeBrows(option5);
              showMouth(option5);
              showAccessories(option5);
            });
        option6.setOnMouseClicked((MouseEvent e) ->{
              showFace(option6);
              showEyes(option6);
              showEyeBrows(option6);
              showMouth(option6);
              showAccessories(option6);
            });
        option7.setOnMouseClicked((MouseEvent e) ->{
              showFace(option7);
              showEyes(option7);
              showEyeBrows(option7);
              showMouth(option7);
              showAccessories(option7);
            });
    }
    
    private void showFace(Button face){
        if(faceGroup){
        ImageView img = (ImageView) face.getGraphic();
            Image imagen = img.getImage();
        
            facePanel.getChildren().clear();
            Iterator<Image> it = imagenes.iterator();
            
            while(it.hasNext()){
               Image image = it.next();
               if (imagen.equals(image) ){
                   ImageView pic = new ImageView();
                   System.out.println(pic.getFitHeight() + " " + pic.getFitWidth());
                   pic.setFitHeight(150);
                   pic.setFitWidth(150);
                   pic.setImage(image);
                   System.out.println(facePanel.getLayoutX() + " " + facePanel.getLayoutY());
                   facePanel.getChildren().add(pic);
               }
            }
        }
    }
    
    private void showEyes(Button eyes){
        if(EyeGroup){
        ImageView img = (ImageView) eyes.getGraphic();
            Image imagen = img.getImage();
        
            eyePanel.getChildren().clear();
            Iterator<Image> it = imagenes.iterator();
            
            while(it.hasNext()){
               Image image = it.next();
               if (imagen.equals(image)){
                   ImageView pic = new ImageView();
                   System.out.println(pic.getFitHeight() + " " + pic.getFitWidth());
                    pic.setFitHeight(95);
                   pic.setFitWidth(95);
                   pic.setImage(image);
                   System.out.println(eyePanel.getLayoutY());
                   
                   eyePanel.getChildren().add(pic);
               }
            }     
        }
    }
    
    
    
    private void showEyeBrows(Button eyebrows){
        if(EyeBrowsGroup){
        ImageView img = (ImageView) eyebrows.getGraphic();
            Image imagen = img.getImage();
        
            eyebrowsPanel.getChildren().clear();
            Iterator<Image> it = imagenes.iterator();
            
            while(it.hasNext()){
               Image image = it.next();
               if (imagen.equals(image) ){
                   ImageView pic = new ImageView();
                   System.out.println(pic.getFitHeight() + " " + pic.getFitWidth());
                    pic.setFitHeight(95);
                   pic.setFitWidth(95);
                   pic.setImage(image);
                   eyebrowsPanel.getChildren().add(pic);
               }
            }     
        }
    }
    
     private void showMouth(Button mouth){
        if(mouthGroup){
        ImageView img = (ImageView) mouth.getGraphic();
            Image imagen = img.getImage();
        
            mouthPanel.getChildren().clear();
            Iterator<Image> it = imagenes.iterator();
            
            while(it.hasNext()){
               Image image = it.next();
               if (imagen.equals(image) ){
                   ImageView pic = new ImageView();
                   System.out.println(pic.getFitHeight() + " " + pic.getFitWidth());
                   pic.setFitHeight(65);
                   pic.setFitWidth(65);
                   pic.setImage(image);
                   mouthPanel.getChildren().add(pic);
               }
            }     
        }
    }
     
     private void showAccessories(Button mouth){
        if(accesoriesGroup){
        ImageView img = (ImageView) mouth.getGraphic();
            Image imagen = img.getImage();
        
            accessoriesPanel.getChildren().clear();
            Iterator<Image> it = imagenes.iterator();
            
            while(it.hasNext()){
               Image image = it.next();
               if (imagen.equals(image) ){
                   ImageView pic = new ImageView();
                   System.out.println(pic.getFitHeight() + " " + pic.getFitWidth());
                   pic.setFitHeight(105);
                   pic.setFitWidth(105);
                   pic.setImage(image);
                   accessoriesPanel.getChildren().add(pic);
               }
            }     
        }
    }
    private void Paneles(){
        facePanel.setMaxHeight(150);
        facePanel.setMaxWidth(150);
        facePanel.setLayoutY(5);
        facePanel.setLayoutX(10);
        eyePanel.setMaxHeight(85);
        eyePanel.setMaxWidth(85);
        eyePanel.setLayoutY(20);
        eyePanel.setLayoutX(38);
        accessoriesPanel.setLayoutY(13);
        accessoriesPanel.setLayoutX(33);
        mouthPanel.setLayoutY(80);
        mouthPanel.setLayoutX(53);
        eyebrowsPanel.setLayoutX(37);
        eyebrowsPanel.setLayoutY(7);
        
        panel.getChildren().addAll(facePanel, eyePanel, eyebrowsPanel, mouthPanel, accessoriesPanel);
//        panel.getChildren().add(eyePanel);
//        panel.getChildren().add(eyebrowsPanel);
//        panel.getChildren().add(mouthPanel);
//        panel.getChildren().add(accessoriesPanel);
        
    }
       
    // METODO PARA SUBIR UNA AGREGAR UNA IMAGEN A LA LISTA 
    @FXML
    private void uploadImg(MouseEvent event){ 
    String path = "";
    
    JFileChooser selectFile = new JFileChooser(); //PARA ABRIR EL EXLORADOR Y BUSCAR NUESTRA IMAGEN
    FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG y GIF", "jpg", "png", "gif");
        selectFile.setFileFilter(formato); // AGREGAMOS LOS FORMATOS PERMITIDOS
        int respuesta = selectFile.showOpenDialog(null);
        
        if(respuesta == selectFile.APPROVE_OPTION &&  faceGroup){  // APPROVE_OPTION = BOTON ABRIR
                                                               // SI EL BOTON DE ABRIR ES PRECIONADO Y EL 
                                                               //GRUPO DE ELEMENTOS FUE PRESIONADO
            path = selectFile.getSelectedFile().getPath();    // OBTIENE LA RUTA DEL ARCHIVO A AGREGAR
            String fileName = selectFile.getSelectedFile().getName(); // OBTENEMOS EL NOMBRE DEL ARCHIVOSELECCIONADO
            Path origen = Path.of(path);        
            Path destino = Path.of("src\\main\\resources\\com\\mycompany\\images\\faces\\" + fileName);
            copyFile(origen,destino);
        }
        
        if(respuesta == selectFile.APPROVE_OPTION &&  EyeGroup){
            path = selectFile.getSelectedFile().getPath();
            String fileName = selectFile.getSelectedFile().getName();
            Path origen = Path.of(path);
            Path destino = Path.of("src\\main\\resources\\com\\mycompany\\images\\eyes\\" + fileName);
            copyFile(origen,destino);
        }
        
        if(respuesta == selectFile.APPROVE_OPTION &&  EyeBrowsGroup){
            path = selectFile.getSelectedFile().getPath();
            String fileName = selectFile.getSelectedFile().getName();
            Path origen = Path.of(path);
            Path destino = Path.of("src\\main\\resources\\com\\mycompany\\images\\eyebrows\\" + fileName);
            copyFile(origen,destino);
        }
        
        if(respuesta == selectFile.APPROVE_OPTION &&  mouthGroup){
            path = selectFile.getSelectedFile().getPath();
            String fileName = selectFile.getSelectedFile().getName();
            Path origen = Path.of(path);
            Path destino = Path.of("src\\main\\resources\\com\\mycompany\\images\\mouth\\" + fileName);
            copyFile(origen,destino);
        }
        
        if(respuesta == selectFile.APPROVE_OPTION &&  accesoriesGroup){
            path = selectFile.getSelectedFile().getPath();
            String fileName = selectFile.getSelectedFile().getName();
            Path origen = Path.of(path);
            Path destino = Path.of("src\\main\\resources\\com\\mycompany\\images\\accessories\\" + fileName);
            copyFile(origen,destino);
        }
    }
    
    
    private void copyFile(Path origen, Path destino){
        try{                      // DAMOS UNA RUTA DESTINO CON EL RESPECTIVO NOMBRE DEL ARCHIVO SELECCIONADO
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING); // COPIAMOS EL ARCHIVO EN LA RUTA DESTINO
            cargarImagenesInicio();  // ACTUALIZO/RECARGO LOS BOTONES CON RESPECTIVAS IMAGENES
            colocarImagenBotones(); 
                AlertBoxes.infoAlert("Exito", "Registro Exitoso", "Archivo cargado exitosamente.");
            }catch(IOException e){
                AlertBoxes.errorAlert("Error", "Error al subir archivo", "No se pudo cargar el archivo o la imagen ya existe.");
            }
    }
    
    
    private void ActionButton(){   
        //CONTROL DE GRUPO DE ELEMENTOS
        FaceButton.setOnAction(e ->{ faceGroup =true;  EyeGroup=false; EyeBrowsGroup=false; accesoriesGroup=false;
        mouthGroup=false; index = 0;});
        
        EyeButton.setOnAction(e ->{ faceGroup =false; EyeGroup=true; EyeBrowsGroup=false; accesoriesGroup=false;
        mouthGroup=false; index = 0;});
        
        EyeBrowsButton.setOnAction(e ->{ faceGroup =false; EyeGroup=false; EyeBrowsGroup=true; accesoriesGroup=false;
        mouthGroup=false; index = 2; });
        
        AccessoriesButton.setOnAction(e ->{ faceGroup = false; EyeGroup=false; EyeBrowsGroup=false; accesoriesGroup=true;
        mouthGroup=false; index = 3;});
        
        MouthButton.setOnAction(e ->{ faceGroup = false; EyeGroup=false; EyeBrowsGroup=false; accesoriesGroup=false;
        mouthGroup=true; index = 4;});
                                       
    }
    
    @FXML
    private void logout(MouseEvent event ) throws IOException{
        
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Login.fxml"));
            Parent root = loader.load();
            App.getScene().setRoot(root);
    }
    
    @FXML  
    private void colorButton(){  // Funcion para cambiar el color de fondo de cada boton 
        option1.setOnMouseEntered((MouseEvent e) -> { option1.setStyle("-fx-background-color: rgb(190,190,190)");});
        option1.setOnMouseExited((MouseEvent e) -> { option1.setStyle("-fx-background-color: rgb(91,91,91)");});
        
        option2.setOnMouseEntered((MouseEvent e) -> { option2.setStyle("-fx-background-color: rgb(190,190,190)");});
        option2.setOnMouseExited((MouseEvent e) -> { option2.setStyle("-fx-background-color: rgb(91,91,91)");});
        
        option3.setOnMouseEntered((MouseEvent e) -> { option3.setStyle("-fx-background-color: rgb(190,190,190)");});
        option3.setOnMouseExited((MouseEvent e) -> { option3.setStyle("-fx-background-color: rgb(91,91,91)");});
        
        option4.setOnMouseEntered((MouseEvent e) -> { option4.setStyle("-fx-background-color: rgb(190,190,190)");});
        option4.setOnMouseExited((MouseEvent e) -> { option4.setStyle("-fx-background-color: rgb(91,91,91)");});
        
        option5.setOnMouseEntered((MouseEvent e) -> { option5.setStyle("-fx-background-color: rgb(190,190,190)");});
        option5.setOnMouseExited((MouseEvent e) -> { option5.setStyle("-fx-background-color: rgb(91,91,91)");});
        
        option6.setOnMouseEntered((MouseEvent e) -> { option6.setStyle("-fx-background-color: rgb(190,190,190)");});
        option6.setOnMouseExited((MouseEvent e) -> { option6.setStyle("-fx-background-color: rgb(91,91,91)");});
        
        option7.setOnMouseEntered((MouseEvent e) -> { option7.setStyle("-fx-background-color: rgb(190,190,190)");});
        option7.setOnMouseExited((MouseEvent e) -> { option7.setStyle("-fx-background-color: rgb(91,91,91)");});
    }
    
}
