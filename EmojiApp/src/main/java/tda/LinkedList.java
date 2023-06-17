package tda;
import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private Nodo<E> first;
    
    private boolean firstIteration;

    public LinkedList() {
        this.first = null;
    }

    @Override
    public int size() {
        if(this.isEmpty()){return 0;}
        int cont = 0;
        Nodo<E> viajero;
        cont++;
        for (viajero = this.first.getNext(); viajero != this.first; viajero = viajero.getNext()) {
            cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        if(this.isEmpty()){return "[]";}
        String result = "[";
        Nodo<E> p;
        result += this.first.getContent().toString() + ", ";
        for (p = this.first.getNext(); p != this.first; p = p.getNext()) {
            result += p.getContent().toString() + ", ";
        }
        result = result.substring(0,result.length()-2);
        return result + "]";
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
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
        Nodo<E> nuevo = new Nodo<>(element);
        Nodo<E> old_nuevo = this.first;
        if (this.isEmpty()) {
            nuevo.setPrevious(nuevo);
            nuevo.setNext(nuevo);
        } else {
            nuevo.setPrevious(this.first.getPrevious());
            nuevo.setNext(this.first);
            old_nuevo.getPrevious().setNext(nuevo);
            old_nuevo.setPrevious(nuevo);
        }
        this.first = nuevo;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        Nodo<E> nuevo = new Nodo<>(element);
        Nodo<E> old_nuevo = this.first;
        if (this.isEmpty()) {
            nuevo.setPrevious(nuevo);
            nuevo.setNext(nuevo);
        } else {
            nuevo.setPrevious(this.first.getPrevious());
            nuevo.setNext(this.first);
            old_nuevo.getPrevious().setNext(nuevo);
            old_nuevo.setPrevious(nuevo);
        }
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
    public LinkedList<E> getReversedPairs() {

        LinkedList<E> nuevaLista = new LinkedList<>();
        Nodo<E> current = first;

        while (current != null && current.getNext() != null) {
            Nodo<E> firstNode = current;
            Nodo<E> secondNode = current.getNext();

            nuevaLista.addLast(secondNode.getContent());
            nuevaLista.addLast(firstNode.getContent());

            current = current.getNext().getNext();
        }

        if (current != null) {
            nuevaLista.addLast(current.getContent());
        }
        return nuevaLista;  // retornoen una nueva lista que contiene los elementos que aparecen en las posiciones anteriores a index

    }

    public LinkedList<E> splitByIndex(int index) {

        LinkedList<E> nuevaLista = new LinkedList<>();
        Nodo<E> nodoActual = first;

        for (int i = 0; i < index; i++) {    // tomo el conjunto desde el primer elemento hasta el indice indicado
            nuevaLista.addLast(nodoActual.getContent());  // añado los elementos a la sublista
            nodoActual = nodoActual.getNext();              // sigo iterando la lista
        }
        return nuevaLista;  // retornoen una nueva lista que contiene los elementos que aparecen en las posiciones anteriores a index

    }

    
    
    public E getNthFromLast(int n) {

        if (n <= 0 || n > this.size()) {
            throw new IllegalArgumentException("Invalid value for n");
        }

        Nodo<E> nodoActual = first;
        for (int i = 0; i < this.size() - n - 1; i++) { // itero la lista desde el final hasta el indice n 
            nodoActual = nodoActual.getNext();

        }
        return nodoActual.getContent(); // retorno el elemento colocado en el indice n 
    }

    public void removeRange(int start, int end) {

        if (start < 0 || end < 0) {
            throw new IllegalArgumentException();
        }

        Nodo<E> nodoActual = first;
        for (int i = 0; i < start - 1; i++) {
            nodoActual = nodoActual.getNext();   // toma los primeros n elementos hasta start
        }
        Nodo<E> primerNodo = nodoActual;   // "crea" la sublista (en realidad es un nodo) de los primeros n elementos hasta start

        for (int n = end - 1; n < this.size(); n++) { // toma los elementos desde el end hasta el final de la lista 
            nodoActual = nodoActual.getNext();
        }

        Nodo<E> segundoNodo = nodoActual;  // "crea" la sublista (en realidad es un nodo) desde el elemento end hasta el final de la lista
        // toma el enlace del nodo creado al principio y lo coloca en este nuevo nodo credao

        primerNodo.setNext(segundoNodo); // junto las dos sublistas donde no incluyen los elementos entre los rangos asignados

    }
    // No olvide incluir sus prototipos en la interface List
    

    @Override
    public Iterator<E> iterator() {
        
        Iterator<E> it;
        it = new Iterator<E>() {
            Nodo<E> old = first;
            Nodo<E> cursor = old;
            
            
          
            @Override
            public boolean hasNext() {
                return cursor != old ;
            }
            
            
            @Override
            public E next() {
                E element = cursor.getContent();
                cursor = cursor.getNext();
                return element;
            }
        };
        
        return it;
        
        
    }

}