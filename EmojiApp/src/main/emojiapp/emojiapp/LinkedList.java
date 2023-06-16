package emojiapp;

import emojiapp.Node;

public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public int size() {
        int cont = 0;
        Node<E> viajero;
        for (viajero = first; viajero != null; viajero = viajero.getNext()) {
            cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        String result = "{";
        Node<E> p;
        for (p = first; p != null; p = p.getNext()) {

            result += p.getContent() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result + "}";
    }

    @Override
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(element);
        nuevo.setNext(this.first);
        if (this.isEmpty()) {
            this.last = nuevo;
        }
        this.first = nuevo;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(element);
        if (this.isEmpty()) {
            this.first = nuevo;
        } else {
            this.last.setNext(nuevo);
        }
        this.last = nuevo;
        return true;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public E remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Implemente aquí los métodos del taller
    
    public LinkedList<E> getReversedPairs(){
        
        LinkedList<E> nuevaLista = new LinkedList<>();
        Node<E> current = first;

        while (current != null && current.getNext() != null) {
            Node<E> firstNode = current;
            Node<E> secondNode = current.getNext();

            nuevaLista.addLast(secondNode.getContent());
            nuevaLista.addLast(firstNode.getContent());

            current = current.getNext().getNext();
        }

        if (current != null) {
            nuevaLista.addLast(current.getContent());
        }
        return nuevaLista;  // retornoen una nueva lista que contiene los elementos que aparecen en las posiciones anteriores a index

    }
    
    public LinkedList<E> splitByIndex(int index){
        
        LinkedList<E> nuevaLista = new LinkedList<>();
        Node<E> nodoActual = first;
        
        for(int i = 0; i< index; i++){    // tomo el conjunto desde el primer elemento hasta el indice indicado
            nuevaLista.addLast(nodoActual.getContent());  // añado los elementos a la sublista
            nodoActual = nodoActual.getNext();              // sigo iterando la lista
        }
        return nuevaLista;  // retornoen una nueva lista que contiene los elementos que aparecen en las posiciones anteriores a index

    
    }
    
    public E getNthFromLast(int n){
        
        if (n <= 0 || n > this.size()) {
            throw new IllegalArgumentException("Invalid value for n");
        }
        
        Node<E> nodoActual = first;
        for(int i = 0; i < this.size()-n-1 ; i++){ // itero la lista desde el final hasta el indice n 
            nodoActual = nodoActual.getNext();
           
        }
        return nodoActual.getContent(); // retorno el elemento colocado en el indice n 
    }
    
    public void removeRange(int start, int end){
        
        if(start < 0 || end < 0) {
        throw new IllegalArgumentException();
    }
        
        Node<E> nodoActual = first;
        for(int i = 0; i < start-1 ; i++){
            nodoActual = nodoActual.getNext();   // toma los primeros n elementos hasta start
        }
        Node<E> primerNodo = nodoActual;   // "crea" la sublista (en realidad es un nodo) de los primeros n elementos hasta start
        
        for(int n = end - 1; n < this.size() ; n++){ // toma los elementos desde el end hasta el final de la lista 
            nodoActual = nodoActual.getNext();
        }
        
        Node<E> segundoNodo= nodoActual;  // "crea" la sublista (en realidad es un nodo) desde el elemento end hasta el final de la lista
                                                // toma el enlace del nodo creado al principio y lo coloca en este nuevo nodo credao
        
        primerNodo.setNext(segundoNodo); // junto las dos sublistas donde no incluyen los elementos entre los rangos asignados
        
    }
    // No olvide incluir sus prototipos en la interface List

}
