import java.io.PrintStream;
import java.util.NoSuchElementException; 


class StringQueueImpl<T> implements StringQueue<T> {

    private Node<T> head = null;            //head of queue (top)
    private Node<T> tail = null;            //tail of queuec(end)
    private int size=0;                     // size of queue
     

    StringQueueImpl() {} // Default constructor

    @Override
    public boolean isEmpty() {   // returns true if queue is empty and false if not
        return head == null;     // if head = null then queue is empty
    }

    @Override
    public void put(T data) {           //inserts data in queue
        Node<T> n = new Node<>(data);   // n is a new node with data
        if (isEmpty()) {                // if queue is empty then head = tail = n
            head = n;
            tail = n;
         } else {
            tail.setNext(n);            //else head remains as is, as current's tail's next we set n and tail becomes n
            tail = n;
        }
        size++;                         //size increases by 1 
    }

   
    @Override
    public T get() throws NoSuchElementException{      // deletes item from top of queue and returns top's data
        if (isEmpty()){                                 // if queue is empty it throws an exception
            throw new NoSuchElementException();
        }else{
            T data = head.getData();                    //else in data store current's top data
            if (head == tail){                          // if head = tail then there is only one element in queue
                head = tail = null;                     // then head = tail = null
            }else{                                      //else we set new head as the next node from previous head
                head = head.getNext();
            }
            size--;                                     //size decreases by one
            return data;                                //returns top's data
        }
    }


    @Override
    public T peek() throws NoSuchElementException { // returns data from the top of queue without removing them
         if (isEmpty()){                            // if queue is empty then we throw an exception
            throw new NoSuchElementException();
        }else{                                      
            T data = head.getData();                // else in data store top's data
            return data;                            // return data
        }
    }

    @Override
    public void printQueue(PrintStream stream){ // prints data from queue starting from top
        if(isEmpty()){                          // if queue is empty
            stream.println("Queue is empty");   // prints the message "Queue is empty"
        }else{
            Node<T> temp = head;                // else in temp store head
             while(temp!=null){                 // while there is elements in queue
                stream.println(temp.getData()); // print data
                temp = temp.getNext();          // temp is next node in queue
            }
        }
    }

    @Override
    public int size(){          //returns queue's size

        return size; 
    }

}



