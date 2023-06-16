/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emojiapp;

/**
 *
 * @author wayar
 */

public class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E content;
        
        public Node(E content){
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
         
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> E){
            this.next = next;
        }
        
        public Node<E> getPrevious(){
            return previous;
        }
        public void setPrevious(){
            this.previous = previous;
        }
    }
