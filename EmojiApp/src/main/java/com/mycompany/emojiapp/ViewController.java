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
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
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
    @FXML
    private Button randomButton;
    @FXML
    private Button upButton;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private Button downButton;
    @FXML
    private Button xButton;

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
        
    private void visibleButtons(){
         upButton.setVisible(true);
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        downButton.setVisible(true);
    }
    
    @FXML
    private void cargarImagenes(MouseEvent event) throws FileNotFoundException, IOException{    

        FaceButton.setOnMouseClicked((MouseEvent e) ->{ 
            visibleButtons();// AL PRESIONAR EL BOTON DE UN GRUPO DE ELEMENTOS
                    imagenes.clear();       // ELIMINO TODAS LAS IMAGENES DE CADA BOTON
        File eyesFiles = new File("src\\main\\resources\\com\\mycompany\\images\\faces");
         File[] listFaces = eyesFiles.listFiles();
         for(File file : listFaces){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
         }
            try {
                colocarImagenBotones(); //INVOCO AL METODO PARA COLOCAR IMAGEN A CADA BOTON 
            } catch (IOException ex) {
                ex.printStackTrace();
            }
});
         
         EyeButton.setOnMouseClicked((MouseEvent e)->{
               imagenes.clear();
               visibleButtons();
        File eyesFiles = new File("src\\main\\resources\\com\\mycompany\\images\\eyes");
         File[] listEyes = eyesFiles.listFiles();
         for(File file : listEyes){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
         }
         try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         });
        
         MouthButton.setOnMouseClicked((MouseEvent e) ->{
               imagenes.clear();
               visibleButtons();
        File mouthFiles = new File("src\\main\\resources\\com\\mycompany\\images\\mouth");
         File[] listMouths = mouthFiles.listFiles();
         for(File file : listMouths){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
         }
         try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }});
         
          AccessoriesButton.setOnMouseClicked((MouseEvent e) ->{
                imagenes.clear();
                visibleButtons();
        File accessoriesFiles = new File("src\\main\\resources\\com\\mycompany\\images\\accessories");
         File[] listAccessories = accessoriesFiles.listFiles();
         for(File file : listAccessories){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
         }
         
         try {
                colocarImagenBotones();
            } catch (IOException ex) {
                ex.printStackTrace();
            }});
          
          EyeBrowsButton.setOnMouseClicked((MouseEvent e) ->{
//               imagenes.clear();
//        DirectoryStream<Path> stream = null;
//            try {
//                stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\eyebrows"));
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        for(Path file: stream ){
//            try {
//                imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\eyebrows\\" + file.getFileName()),50,50,true,false));
//                //System.out.println(file.getFileName());
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            }
//        }
                visibleButtons();
               imagenes.clear();
        File eyeBrowsFiles = new File("src\\main\\resources\\com\\mycompany\\images\\eyebrows");
         File[] listEyeBrows = eyeBrowsFiles.listFiles();
         for(File file : listEyeBrows){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
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
//        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\faces"));
//        for(Path file: stream ){
//            imagenes.addLast(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\faces\\" + file.getFileName()),50,50,true,false));
//      
//        }
         File faceFiles = new File("src\\main\\resources\\com\\mycompany\\images\\faces");
         File[] listFaces = faceFiles.listFiles();
         for(File file : listFaces){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
             
         }
         
        }else if(EyeGroup){
            File eyesFiles = new File("src\\main\\resources\\com\\mycompany\\images\\eyes");
         File[] listEyes = eyesFiles.listFiles();
         for(File file : listEyes){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
         }
            
        }else if(EyeBrowsGroup){
         File eyeBrowsFiles = new File("src\\main\\resources\\com\\mycompany\\images\\eyebrows");
         File[] listEyeBrows = eyeBrowsFiles.listFiles();
         for(File file : listEyeBrows){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
             
         }
        }else if(mouthGroup){
        File mouthFiles = new File("src\\main\\resources\\com\\mycompany\\images\\mouth");
        File[] listMouths = mouthFiles.listFiles();
        for(File file : listMouths){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
         }
        }else if(accesoriesGroup){
         File accessoriesFiles = new File("src\\main\\resources\\com\\mycompany\\images\\accessories");
         File[] listAccessories = accessoriesFiles.listFiles();
         for(File file : listAccessories){
             String path = file.toURI().toString();
             Image image = new Image(path);
             imagenes.addLast(image);
             
         }
        }
        
     }
    
    private void colocarImagenBotones() throws FileNotFoundException, IOException{
        
         Iterator<Button> it = listaBotones().iterator();  
         Iterator<Image> it2 = imagenes.iterator();
        while(it.hasNext()){  //ITERO SOBRE LA LISTA DE BOTONES
            ImageView imageview = new ImageView(it2.next());
            imageview.setFitHeight(50);
            imageview.setFitWidth(50);
           it.next().setGraphic(imageview); // SETEO UNA IMAGEN A CADA BOTON
           
        }
          
    }
    
    @FXML
    private void prevElement(MouseEvent event){
        
        prevButton.setOnMouseClicked((MouseEvent e) ->{
        imagenes.prevNode(); // INVOCO A LA FUNCION QUE DESPLAZA LOS ELEMENTOS A LA DERECHA
        Iterator<Button> listaBotones = listaBotones().iterator();  
        Iterator<Image> images = imagenes.iterator();
         while(listaBotones.hasNext()){   //ITERO SOBRE LA LISTA DE BOTONES
             ImageView imageview = new ImageView(images.next());
            imageview.setFitHeight(50);
            imageview.setFitWidth(50);
             listaBotones.next().setGraphic(imageview); // CARGO UNA IMAGEN PARA CADA BOTON             
         }
      
       });
    }
    
    @FXML
    private void nextElement(MouseEvent event){
        
        nextButton.setOnMouseClicked((MouseEvent e) ->{
        imagenes.nextNode();     // INVOCO EL METODO PARA "DESPLAZAR" LOS ELEMENTOS A LA IZQUIERDA                      
        Iterator<Button> listaBotones = listaBotones().iterator(); //ITEROSOBRE LA LISTA DE BOTONES
        Iterator<Image> images = imagenes.iterator();//PARA SETEAR NUEVAMENTE LAS IMAGENES
         while(listaBotones.hasNext()){ 
             ImageView imageview = new ImageView(images.next());
            imageview.setFitHeight(50);
            imageview.setFitWidth(50);
             listaBotones.next().setGraphic(imageview);
             
         }
                  
       });
    }
    
    @FXML
    private void cargarBotones() throws FileNotFoundException{
        // AGREGAMOS ICONOS A LOS BOTONES DE BACK , NEXT Y SUBIR IMAGEN
        prevButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\Larrow.png" ),45,45,true,false)));
        nextButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\Rarrow.png" ),45,45,true,false)));
        loadImg.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\upload.png" ),20,20,true,false)));  
        randomButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\random.png" ),25,25,true,false))); 
        upButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\up.png" ),13,13,true,false)));
        leftButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\left.png" ),20,17,true,false)));
        rightButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\right.png" ),20,17,true,false)));
        downButton.setGraphic(new ImageView(new Image(new FileInputStream("src\\main\\resources\\com\\mycompany\\images\\buttons\\down.png" ),13,13,true,false)));
        upButton.setVisible(false);
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        downButton.setVisible(false);
    }
    
    @FXML
    private void mostrarImagen(MouseEvent event){
                          
        option1.setOnMouseClicked((MouseEvent e) ->{
              showFace(option1);
              showEyes(option1);
              showEyeBrows(option1);
              showMouth(option1);
              showAccessories(option1);
              if(e.getButton()== MouseButton.SECONDARY){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmacion");
                alert.setContentText("¿Deseas realmente eliminar el componente?");
                Optional<ButtonType> action= alert.showAndWait();
                if(action.get()== ButtonType.OK){
                    //se pone la opcion nueva
                    Alert al= new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Se elimino correctamente");
                    al.show();
                }
              }
            });
        option2.setOnMouseClicked((MouseEvent e) ->{
              showFace(option2);
              showEyes(option2);
              showEyeBrows(option2);
              showMouth(option2);
              showAccessories(option2);
              if(e.getButton()== MouseButton.SECONDARY){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmacion");
                alert.setContentText("¿Deseas realmente eliminar el componente?");
                Optional<ButtonType> action= alert.showAndWait();
                if(action.get()== ButtonType.OK){
                    //se pone la opcion nueva
                    Alert al= new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Se elimino correctamente");
                    al.show();
                }
              }
            });
        option3.setOnMouseClicked((MouseEvent e) ->{
              showFace(option3);
              showEyes(option3);
              showEyeBrows(option3);
              showMouth(option3);
              showAccessories(option3);
              if(e.getButton()== MouseButton.SECONDARY){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmacion");
                alert.setContentText("¿Deseas realmente eliminar el componente?");
                Optional<ButtonType> action= alert.showAndWait();
                if(action.get()== ButtonType.OK){
                    //se pone la opcion nueva
                    Alert al= new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Se elimino correctamente");
                    al.show();
                }
              }
            });
        option4.setOnMouseClicked((MouseEvent e) ->{
              showFace(option4);
              showEyes(option4);
              showEyeBrows(option4);
              showMouth(option4);
              showAccessories(option4);
              if(e.getButton()== MouseButton.SECONDARY){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmacion");
                alert.setContentText("¿Deseas realmente eliminar el componente?");
                Optional<ButtonType> action= alert.showAndWait();
                if(action.get()== ButtonType.OK){
                    //se pone la opcion nueva
                    Alert al= new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Se elimino correctamente");
                    al.show();
                }
              }
            });
        option5.setOnMouseClicked((MouseEvent e) ->{
              showFace(option5);
              showEyes(option5);
              showEyeBrows(option5);
              showMouth(option5);
              showAccessories(option5);
              if(e.getButton()== MouseButton.SECONDARY){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmacion");
                alert.setContentText("¿Deseas realmente eliminar el componente?");
                Optional<ButtonType> action= alert.showAndWait();
                if(action.get()== ButtonType.OK){
                    //se pone la opcion nueva
                    Alert al= new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Se elimino correctamente");
                    al.show();
                }
              }
            });
        option6.setOnMouseClicked((MouseEvent e) ->{
              showFace(option6);
              showEyes(option6);
              showEyeBrows(option6);
              showMouth(option6);
              showAccessories(option6);
              if(e.getButton()== MouseButton.SECONDARY){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmacion");
                alert.setContentText("¿Deseas realmente eliminar el componente?");
                Optional<ButtonType> action= alert.showAndWait();
                if(action.get()== ButtonType.OK){
                    //se pone la opcion nueva
                    Alert al= new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Se elimino correctamente");
                    al.show();
                }
              }
            });
        option7.setOnMouseClicked((MouseEvent e) ->{
              showFace(option7);
              showEyes(option7);
              showEyeBrows(option7);
              showMouth(option7);
              showAccessories(option7);
              if(e.getButton()== MouseButton.SECONDARY){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmacion");
                alert.setContentText("¿Deseas realmente eliminar el componente?");
                Optional<ButtonType> action= alert.showAndWait();
                if(action.get()== ButtonType.OK){
                    //se pone la opcion nueva
                    Alert al= new Alert(Alert.AlertType.INFORMATION);
                    al.setContentText("Se elimino correctamente");
                    al.show();
                }
              }
            });
    }
    
    private void showFace(Button face){
        if(faceGroup){// SI ESTA ACTIVADO EL CONTROL DE GRUPOS
        ImageView img = (ImageView) face.getGraphic(); // OBTENER EL GRAFICO DEL BOTON
            Image imagen = img.getImage(); // OBTENER IMAGEN DEL NODO IMAGEVIEW
        
            facePanel.getChildren().clear(); // ELIMINAMOS EL ELEMENTO DEL PANEL PARA REEMPLAZARLO
            Iterator<Image> it = imagenes.iterator(); 
            //ITERAR LOS ARCHIVOS DE IMAGENES          
            while(it.hasNext()){
               Image image = it.next(); // OBTENEMOS EL ELEMENTO PARA COMPARAR
               if (imagen.equals(image) ){  // SI LA IMAGEN OBTENIDA DEL BOTON ES IGUAL AL ARHIVO IMAGEN DE LA CARPETA
                   ImageView pic = new ImageView();  // CREO UN IMAGEVIEW PARA AGREGARLA AL PANEL
                   pic.setFitHeight(150); // AJUSTAR TAMANIO 
                   pic.setFitWidth(150);
                   pic.setImage(image); // AGREGO LA IMAGEN OBTENIDA AL IMAGEVIEW
                   facePanel.getChildren().add(pic);// AGREGO EL IMAGEVIEW AL PANEL DEL ROSTRO
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
        //AJUSTAR POSICION 
        facePanel.setMaxHeight(150);
        facePanel.setMaxWidth(150);
        facePanel.setLayoutY(6);
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
                                                               // SI EL BOTON DE ABRIR ES PRESIONADO Y EL 
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
        mouthGroup=false;});
        
        EyeButton.setOnAction(e ->{ faceGroup =false; EyeGroup=true; EyeBrowsGroup=false; accesoriesGroup=false;
        mouthGroup=false;});
        
        EyeBrowsButton.setOnAction(e ->{ faceGroup =false; EyeGroup=false; EyeBrowsGroup=true; accesoriesGroup=false;
        mouthGroup=false; });
        
        AccessoriesButton.setOnAction(e ->{ faceGroup = false; EyeGroup=false; EyeBrowsGroup=false; accesoriesGroup=true;
        mouthGroup=false;});
        
        MouthButton.setOnAction(e ->{ faceGroup = false; EyeGroup=false; EyeBrowsGroup=false; accesoriesGroup=false;
        mouthGroup=true; });
                                       
    }
    
    @FXML
    private void logout(MouseEvent event ) throws IOException{
        // LOGOUT  PARA REGRESAR A LA VISTA DE INICIO DE SESION
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Login.fxml"));
            Parent root = loader.load();
            App.getScene().setRoot(root);
    }
    
    @FXML  
    private void colorButton(){  
    // FUNCION DE EVENTO PARA CAMBIAR EL FONO DEL BOTON CUANDO EL PUNTERO DEL MOUSE INGRESA Y SALE DEL BOTON
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
        
        randomButton.setOnMouseEntered((MouseEvent e) -> { randomButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        randomButton.setOnMouseExited((MouseEvent e) -> { randomButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        upButton.setOnMouseEntered((MouseEvent e) -> { upButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        upButton.setOnMouseExited((MouseEvent e) -> { upButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        leftButton.setOnMouseEntered((MouseEvent e) -> { leftButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        leftButton.setOnMouseExited((MouseEvent e) -> { leftButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        rightButton.setOnMouseEntered((MouseEvent e) -> { rightButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        rightButton.setOnMouseExited((MouseEvent e) -> { rightButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        downButton.setOnMouseEntered((MouseEvent e) -> { downButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        downButton.setOnMouseExited((MouseEvent e) -> { downButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        loadImg.setOnMouseEntered((MouseEvent e) -> { loadImg.setStyle("-fx-background-color: rgb(91,91,91)");});
        loadImg.setOnMouseExited((MouseEvent e) -> { loadImg.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        nextButton.setOnMouseEntered((MouseEvent e) -> { nextButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        nextButton.setOnMouseExited((MouseEvent e) -> { nextButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        prevButton.setOnMouseEntered((MouseEvent e) -> { prevButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        prevButton.setOnMouseExited((MouseEvent e) -> { prevButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        xButton.setOnMouseEntered((MouseEvent e) -> { xButton.setStyle("-fx-background-color: rgb(91,91,91)");});
        xButton.setOnMouseExited((MouseEvent e) -> { xButton.setStyle("-fx-background-color: rgb(0,0,0)");});
        
        
    }
////    
////    private void removeImage(Button button) throws IOException{
////        if(faceGroup){// SI ESTA ACTIVADO EL CONTROL DE GRUPOS
////       
////           
////                ImageView img = (ImageView) button.getGraphic(); // OBTENER EL GRAFICO DEL BOTON
////                Image imagen = img.getImage();
////                imagen.
////                // OBTENER IMAGEN DEL NODO IMAGEVIEW
////                DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src\\main\\resources\\com\\mycompany\\images\\faces"));
////                for(Path file: stream ){
////                    if(imagen.){
////                        
////                    }
////                }
////              }    
////            }
    
    @FXML
    private void randomEmoji(){
        facePanel.getChildren().clear();
        eyePanel.getChildren().clear();
        eyebrowsPanel.getChildren().clear();
        mouthPanel.getChildren().clear();
         accessoriesPanel.getChildren().clear();
         
        File faceFiles = new File("src\\main\\resources\\com\\mycompany\\images\\faces");
        File eyesFiles = new File("src\\main\\resources\\com\\mycompany\\images\\eyes");
        File eyebrowsFiles = new File("src\\main\\resources\\com\\mycompany\\images\\eyebrows");
        File mouthFiles = new File("src\\main\\resources\\com\\mycompany\\images\\mouth");
        File accessoriesFiles = new File("src\\main\\resources\\com\\mycompany\\images\\accessories");
        
        File[] faces = faceFiles.listFiles();
        Random random = new Random();
        int Index = random.nextInt(faces.length);
        File randomFace = faces[Index];
        String ruta = randomFace.toURI().toString();
        Image imagen = new Image(ruta);
        ImageView img = new ImageView(imagen);
        img.setFitHeight(150); // AJUSTAR TAMANIO 
        img.setFitWidth(150);
        facePanel.getChildren().add(img);
        
        File[] eyes = eyesFiles.listFiles();
        Index = random.nextInt(eyes.length);
        File randomEyes = eyes[Index];
        ruta = randomEyes.toURI().toString();
        imagen = new Image(ruta);
        img = new ImageView(imagen);
        img.setFitHeight(95);
        img.setFitWidth(95);
        eyePanel.getChildren().add(img);
        
        File[] eyebrows = eyebrowsFiles.listFiles();
        Index = random.nextInt(eyebrows.length);
        File randomEyeBrows = eyebrows[Index];
        ruta = randomEyeBrows.toURI().toString();
        imagen = new Image(ruta);
        img = new ImageView(imagen);
        img.setFitHeight(95);
        img.setFitWidth(95);
        eyebrowsPanel.getChildren().add(img);
        
        File[] mouth = mouthFiles.listFiles();
        Index = random.nextInt(mouth.length);
        File randomMouth = mouth[Index];
        ruta = randomMouth.toURI().toString();
        imagen = new Image(ruta);
        img = new ImageView(imagen);
        img.setFitHeight(65);
        img.setFitWidth(65);
        mouthPanel.getChildren().add(img);
        
        File[] accessories = accessoriesFiles.listFiles();
        Index = random.nextInt(accessories.length);
        File randomAccessories = accessories[Index];
        ruta = randomAccessories.toURI().toString();
        imagen = new Image(ruta);
        img = new ImageView(imagen);
        img.setFitHeight(105); 
        img.setFitWidth(105); 
        accessoriesPanel.getChildren().add(img);
    }
    
    @FXML
    private void movePositionUp(MouseEvent event){
        if(EyeGroup){
            double position = eyePanel.getLayoutY();
            eyePanel.setLayoutY(position - 1);
        }
        
        if(faceGroup){
            double position = facePanel.getLayoutY();
            facePanel.setLayoutY(position - 1);
        }    
        
        if(EyeBrowsGroup){
            double position = eyebrowsPanel.getLayoutY();
            eyebrowsPanel.setLayoutY(position - 1);
        } 
        
        if(mouthGroup){
            double position = mouthPanel.getLayoutY();
            mouthPanel.setLayoutY(position - 1);
        } 
        
        if(accesoriesGroup){
            double position = accessoriesPanel.getLayoutY();
            accessoriesPanel.setLayoutY(position - 1);
        } 
   }
    
    @FXML
    private void movePositionLeft(MouseEvent event){
        if(EyeGroup){
            double position = eyePanel.getLayoutX();
            eyePanel.setLayoutX(position - 1);
        }
        
        if(faceGroup){
            double position = facePanel.getLayoutX();
            facePanel.setLayoutX(position - 1);
        }    
        
        if(EyeBrowsGroup){
            double position = eyebrowsPanel.getLayoutX();
            eyebrowsPanel.setLayoutX(position - 1);
        } 
        
        if(mouthGroup){
            double position = mouthPanel.getLayoutX();
            mouthPanel.setLayoutX(position - 1);
        } 
        
        if(accesoriesGroup){
            double position = accessoriesPanel.getLayoutX();
            accessoriesPanel.setLayoutX(position - 1);
        } 
   }
    
    @FXML
    private void movePositionRight(MouseEvent event){
        if(EyeGroup){
            double position = eyePanel.getLayoutX();
            eyePanel.setLayoutX(position + 1);
        }
        
        if(faceGroup){
            double position = facePanel.getLayoutX();
            facePanel.setLayoutX(position + 1);
        }    
        
        if(EyeBrowsGroup){
            double position = eyebrowsPanel.getLayoutX();
            eyebrowsPanel.setLayoutX(position + 1);
        } 
        
        if(mouthGroup){
            double position = mouthPanel.getLayoutX();
            mouthPanel.setLayoutX(position + 1);
        } 
        
        if(accesoriesGroup){
            double position = accessoriesPanel.getLayoutX();
            accessoriesPanel.setLayoutX(position + 1);
        } 
   }
    
    @FXML
    private void movePositionDown(MouseEvent event){
        if(EyeGroup){
            double position = eyePanel.getLayoutY();
            eyePanel.setLayoutY(position + 1);
        }
        
        if(faceGroup){
            double position = facePanel.getLayoutY();
            facePanel.setLayoutY(position + 1);
        }    
        
        if(EyeBrowsGroup){
            double position = eyebrowsPanel.getLayoutY();
            eyebrowsPanel.setLayoutY(position + 1);
        } 
        
        if(mouthGroup){
            double position = mouthPanel.getLayoutY();
            mouthPanel.setLayoutY(position + 1);
        } 
        
        if(accesoriesGroup){
            double position = accessoriesPanel.getLayoutY();
            accessoriesPanel.setLayoutY(position + 1);
        } 
   }
    @FXML
    void eliminarComponente(MouseEvent event) {
        if(EyeGroup){
            eyePanel.getChildren().clear();
        }
        if(faceGroup){
            facePanel.getChildren().clear();
        }
        if(EyeBrowsGroup){
            eyebrowsPanel.getChildren().clear();
        }
        if(mouthGroup){
            mouthPanel.getChildren().clear();
        }
        if(accesoriesGroup){
            accessoriesPanel.getChildren().clear();
        }
    }
       
       
 }
 
