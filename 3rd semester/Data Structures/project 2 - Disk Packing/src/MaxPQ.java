import java.lang.Comparable;

public class MaxPQ {


    private Disk[] heap; // the heap to store data in
    private int size; // current size of the queue
    //private Comparator<T> comparator; // the comparator to use between the objects

    private static final int DEFAULT_CAPACITY = 4; // default capacity
    private static final int AUTOGROW_SIZE = 4; // default auto grow

    // Queue constructor
    public MaxPQ(){//Comparator<T> comparator) {
        this.heap = new Disk[DEFAULT_CAPACITY + 1];
        this.size = 0;
        //this.comparator = comparator;
    }

    public void insert(Disk item) {
        // Check available space
        if (size == heap.length - 1)
            grow();

        // Place item at the next available position
        heap[++size] = item;

        // Let the newly added item swim
        swim(size);
    }


    public Disk peek() {
        // Ensure not empty
        if (size == 0)
            return null;

        // return root without removing
        return heap[1];
    }


    public Disk getMax() {
        // Ensure not empty
        if (size == 0)
            return null;

        // Keep a reference to the root item
        Disk root = heap[1];

        // Replace root item with the one at rightmost leaf
        heap[1] = heap[size];
        size--;

        // Dispose the rightmost leaf
        // Sink the new root element
        sink(1);

        return root;
    }

    private void swim(int i) {
        // if i is root (i==1) return
        if (i == 1)
            return;

        // find parent
        int parent = i / 2;

        // compare parent with child i
        while (i != 1 && heap[i].compareTo(heap[parent]) > 0) {
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }

    }

    private void sink(int i) {
        // determine left, right child
        int left = 2 * i;
        int right = left + 1;

        // if 2*i > size, node i is a leaf return
        if (left > size)
            return;

        // while haven't reached the leafs
        while (left <= size) {
            // Determine the largest child of node i
            int max = left;
            if (right <= size) {
                if (heap[left].compareTo(heap[right]) < 0)
                    max = right;
            }

            // If the heap condition holds, stop. Else swap and go on.
            // child smaller than parent
            if (heap[i].compareTo(heap[max]) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }

    private void swap(int i, int j) {
        Disk tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void grow() {
        Disk[] newHeap = new Disk[heap.length + AUTOGROW_SIZE];

        // copy array
		//(notice: in the priority queue, elements are located in the array slots with positions in [1, size])
        for (int i = 0; i <= size; i++) {
            newHeap[i] = heap[i];
        }

        heap = newHeap;
    }
}
