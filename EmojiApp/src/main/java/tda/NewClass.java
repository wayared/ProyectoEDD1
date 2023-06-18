/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

import java.util.Iterator;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;

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
        
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
    
    

    
}
