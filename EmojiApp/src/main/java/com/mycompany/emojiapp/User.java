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
import tda.List;

/**
 *
 * @author wayar
 */
public class User {
    private String user;
    private String password;
    
    
    public User(String user, String password){
        this.user=user;
        this.password=password;
    }
    
    
    public static ArrayList<User> cargarUsuarios() {
        ArrayList<User> usuarios = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("src\\main\\resources\\com\\mycompany\\emojiapp\\usuarios.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
                String[] p = linea.split(",");
                if (p.length == 6) {
                    User usuario = new User(p[0], p[1]);
                    usuarios.add(usuario);
                    System.out.println(usuario);
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
                
    }
    
}
