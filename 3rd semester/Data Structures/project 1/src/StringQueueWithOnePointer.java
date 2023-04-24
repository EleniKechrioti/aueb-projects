import java.io.PrintStream;
import java.util.NoSuchElementException; 

public class StringQueueWithOnePointer<T> implements StringQueue<T> {

    private Node<T> tail = null;        //tail of queue
    private int size=0;                 //size of queue

     
    StringQueueWithOnePointer() {        //Default constructor
    }

    
    @Override
    public boolean isEmpty() {          // Determine whether queue is empty 
        return tail == null;            // returns true if queue is empty
    }

    
    @Override
    public void put(T data) {           // Inserts the data at the end of the queue
        Node<T> n = new Node<>(data);
        if (isEmpty()) {
            tail = n;                   //if is empty then tail becomes node n 
            tail.setNext(n);            //and next node is itself
        } else {
            n.setNext(tail.getNext());  //else next node from tail becomes next from n| tails next node is the head so n next node as current tail must become head
            tail.setNext(n);            //current tail has as next new node n
            tail=n;                     //new tail with node n
        }
        size=size+1;                    //size increases by 1 as we inserted an item in queue
    }

 
         
    @Override
    public T get() throws NoSuchElementException {          //Returns and removes the data from the queue head
        if (isEmpty()){
            throw new NoSuchElementException();             //throws NoSuchElementException if the queue is empty
        }else{                                              //return the data contained in the queue head
            T data = (tail.getNext()).getData();            //tail's next node is head so data = head.getdata()
            if (tail.getNext() == tail){                    //if tail's next is equal with tail then head = tail and there is 1 item in queue
                tail = null;                                //tail = null there is no items left in queue
            }else{                                          //else the queue has more than 1 nodes 
                tail.setNext(tail.getNext().getNext());     //set as tail's next the node next from head, which is tail's next node
            } 
            size=size-1;                                    //decrease size by 1 as we removed an item from the queue
            return data;                                    //return head's data
        }
    }

    
    @Override
    public T peek() throws NoSuchElementException {        //Returns  the data from the queue head
         if (isEmpty()){
            throw new NoSuchElementException();            //throws NoSuchElementException if the queue is empty
        }else{
            T data = (tail.getNext()).getData();           //tail's next is head so data = head.getdata()

            return data;                                   //return the data contained in the queue head
        }
    }

    @Override
    public void printQueue(PrintStream stream){             //prints queue
        if (isEmpty()){                                     //if is empty it prints the message "Queue is empty"
            stream.println("Queue is empty");
        }else{
            Node<T> temp = tail.getNext();                 // temp node is tail's next node(head)
            boolean flag=true;                             //flag 
            while(flag){                                   //while flag is true | we have not made it yet to the end of queue
                stream.println(temp.getData());            // print current node's data
                temp=temp.getNext();                       // temp becomes next node
                if(temp==tail.getNext()){                  // if temp = head then we reached the end of queue
                    flag=false;                            // flag becomes false
                }
            }
        }

        
    }
    
    @Override
    public int size(){

        return size;        //return the size of the queue
    }

}