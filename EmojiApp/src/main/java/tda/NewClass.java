/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

import java.util.Iterator;

/**
 *
 * @author wayar
 */
public class NewClass {
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("A");
       list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
                
        System.out.println(list);
       list.nextNode();
        System.out.println(list);
        list.nextNode();
        System.out.println(list);
         list.prevNode();
        System.out.println(list);
         list.prevNode();
        System.out.println(list);
        
        
        
       
        
        
        Iterator<String> it = list.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
    
    

    
}
