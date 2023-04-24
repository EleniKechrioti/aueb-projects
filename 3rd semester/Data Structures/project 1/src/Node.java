

public class Node<T> {
    protected T data;
    protected Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }
   
    public void setNext(Node<T> next) {
        this.next = next;
    }
}