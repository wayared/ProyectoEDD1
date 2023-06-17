/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

import static javafx.application.Application.launch;

/**
 *
 * @author wayar
 */
public class NewClass {
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("A");
       list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        System.out.println(list);
        list.addLast("E");
        System.out.println(list);
    }

    
}
