/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

/**
 *
 * @author wayar
 */

public class Nodo<E> {
        private Nodo<E> next;
        private Nodo<E> previous;
        private E content;
        
        public Nodo(E content){
            this.content = content;
            this.next = null;
            this.previous = null;
        }
        
        public E getContent(){
            return content;
        }
         public void setContent(E content){
            this.content = content;
        }
         
        public Nodo<E> getNext(){
            return next;
        }
        public void setNext(Nodo<E> nextNode){
            this.next = nextNode;
        }
        
        public Nodo<E> getPrevious(){
            return previous;
        }
        public void setPrevious(Nodo<E> prev){
            this.previous = prev;
        }
    }
