import java.io.PrintStream;
import java.util.NoSuchElementException;   


class StringStackImpl<T> implements StringStack<T> { 
   

    private Node<T> top;						//top of stack | pointer top
	private int stack_size;	

    public StringStackImpl() {					//constructor 
		top = null;								//stack is empty so top is null
		stack_size = 0;							//and size of stack is 0
    }

	@Override
	public boolean isEmpty() {					//if top = null then stack is empty
        return (top == null);				    //returns true or false | true if stack is empty
    }

	
	@Override
	public void push(T item){					//inserts item at the top of the stack

        if (isEmpty()) {						// if stack is empty then top is a new node with item as data and null as next
            top = new Node<>(item, null);
        } else {								//else top is a new node with item as data and previous top as next
            top = new Node<>(item, top);
        }
		stack_size++;							// stack size increases by 1 because we pushed an item in the stack

    }
	
	@Override
	public T pop() throws NoSuchElementException{	// deletes the item that is on top in the stack and returns it

        if (isEmpty()){								// if its empty then there is no element and it throws an exception
            throw new NoSuchElementException();
        } else{										// else 
        	T data = top.getData();					//in data store top's data 
			Node<T> t = top.getNext(); 				//t (temporary) store the next node of the top 
			top = t;								// top is now the next node
			stack_size--;							// stack size decreases by 1 as we deleted a Node from stack
			return data;							// returns data from previous top
		}	

    }

    @Override
	public T peek() throws NoSuchElementException{// returns without removing data from the element on top

		if (isEmpty()) {						// if is empty then we throw an exception	
			throw new NoSuchElementException();
		} else {
			return top.getData();				// else it returns top's data
		}
	}

	@Override
	public void printStack(PrintStream stream){

        if (isEmpty()) {
            stream.println( "Stack is empty ");		// if stack is empty it prints the message "Stack is empty "
        } else {
			Node<T> v = top;						   // iv v store top
			while ( v != null){						  //while there is items in the stack
				stream.println(v.getData()); 		 // print item's data
				v = v.getNext();					 // v is next node
			}
		}
        

    }

	 
	@Override
	public int size(){

       return stack_size;		//returns stack's size
    }
}  
 