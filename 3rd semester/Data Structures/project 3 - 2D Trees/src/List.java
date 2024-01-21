import java.util.NoSuchElementException;

public class List<T>{

    class Node<T> {
        protected T data;
        protected Node<T> next = null;
    
        /**
         * Constructor. Sets data
         *
         * @param data the data stored
         * @return
         */
        Node(T data) {
            this.data = data;
        }
    
        /**
         * Returns this node's data
         *
         * @return the reference to node's data
         */
        T getData() {
            // return data stored in this node
            return data;
        }
    
        /**
         * Get reference to next node
         *
         * @return the next node
         */
        Node<T> getNext() {
            // get next node
            return next;
        }
    
        /**
         * Set reference to next node
         *
         * @param next reference
         */
        void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
	private int listSize = 0;

    /**
     * Default constructor
     */
    public List() {}

    /**
     * Determine whether list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Inserts the data at the front of the list
     *
     * @param data the inserted data
     */
    public void insert(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
		listSize++;
    }

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    public void clear(){
        while(listSize>0){
            remove();
        }
    }
    private T remove() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();
		listSize--;
        return data;
    }
    /**
     * Returns list as String
     */
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node<T> current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data

        while (current != null) {
            ret.append(current.data.toString());

            if (current.getNext() != null)
                ret.append("\n");

            current = current.next;
        }


        return ret.toString();
    }
	
	public int getSize(){
		return listSize;
	}
}