package emojiapp;

class Node<Image> {
    private Node<Image> prev;
    private Image content;
    private Node<Image> next;
    
    public Node (Image content) {
        this.content = content;
        this.next = null;
    }
    
    public Node (Image content, Node<Image> next) {
        this(content);
        this.next = next;
    }

    public Image getContent() {
        return content;
    }

    public void setContent(Image content) {
        this.content = content;
    }

    public Node<Image> getNext() {
        return next;
    }

    public void setNext(Node<Image> next) {
        this.next = next;
    }
    
    public Node<Image> getPrev() {
        return prev;
    }

    public void setPrev(Node<Image> prev) {
        this.prev = prev;
    }
    
    
}
