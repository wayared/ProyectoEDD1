/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emojiapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import tda.List;

/**
 *
 * @author wayar
 */
public class User {
    private String user;
    private String password;
   // static ArrayList<User> users = new ArrayList<>();
    
    public User(String user, String password){
        this.user=user;
        this.password=password;
    }
    
    
    public static ArrayList<User> cargarUsuarios() {
        //users.clear();                              // ELIMINO TODOS LO ELEMENTOS USUARIO DE LA LISTA DE USUARIOS PARA NO ANIADIR LOS MISMOS USUARIOS
         ArrayList<User> usuarios = new ArrayList<>();  // CREO UNA LISTA PARA RETORNARLA
        try (BufferedReader bf = new BufferedReader(new FileReader("src\\main\\resources\\com\\mycompany\\emojiapp\\usuarios.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length == 2) {
                    User usuario = new User(p[0], p[1]);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los usuarios");
            
            ex.printStackTrace();
        }
        return usuarios;
    }
    
    public static void registrarUsuario(String usuario, String contraseña) throws FileNotFoundException, IOException{
        if(usuario.isEmpty() || contraseña.isEmpty()){
            throw new NullPointerException();
        }
         
         try(BufferedWriter bf= new BufferedWriter(new FileWriter("src\\main\\resources\\com\\mycompany\\emojiapp\\usuarios.txt",true))){
             String linea= usuario+","+contraseña;
             bf.write(linea);
             bf.newLine();
             } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }    
            
         cargarUsuarios();
    }
    
    public static void login(String user, String password) throws IOException{
        ArrayList<User> usuarios = cargarUsuarios();
        boolean bool = true;
        for (User usuario : usuarios) {
            if (user.isEmpty() | password.isEmpty()) {
                throw new NullPointerException();
            }
            else if (usuario.user.equals(user) && usuario.password.equals(password)) {
                bool = false;
                App.setRoot("View");
            }          
        }
        if (bool) {
        throw new IOException();
        }
    }
    
}
