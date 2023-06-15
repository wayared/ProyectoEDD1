package tda;

class Node<Imagen> {
    private Node<Imagen> prev;
    private Imagen content;
    private Node<Imagen> next;
    
    public Node (Imagen content) {
        this.content = content;
        this.next = null;
    }
    
    public Node (Imagen content, Node<Imagen> next) {
        this(content);
        this.next = next;
    }

    public Imagen getContent() {
        return content;
    }

    public void setContent(Imagen content) {
        this.content = content;
    }

    public Node<Imagen> getNext() {
        return next;
    }

    public void setNext(Node<Imagen> next) {
        this.next = next;
    }
    
    public Node<Imagen> getPrev() {
        return prev;
    }

    public void setPrev(Node<Imagen> prev) {
        this.prev = prev;
    }
    
    
}
