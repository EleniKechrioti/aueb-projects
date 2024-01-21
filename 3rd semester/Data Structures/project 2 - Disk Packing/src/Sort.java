
import java.io.*;
  
class Sort {


    public static void quickSort(int[] array , int start, int end)
    {
        if (start < end) {                          //if start>= end then the array is not a valid one.
  
            int piv = partition(array, start, end);// split the array in 2 and set as pivot the position the method sent.
  
            
            quickSort(array, start, piv - 1);// apply the algorithm of quicksort for the first part of the array
            quickSort(array, piv + 1, end);  // apply the algorithm of quicksort for the second part of the array
        }
    }
    private static void swap(int[] array, int i, int j) //swaps 2 elements in the array given
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  
    private static int partition(int[] array, int start, int end)    
    {
        int pivot = array[end];
        int i = (start - 1);
  
        for (int j = start; j <= end - 1; j++) {

            if (array[j] > pivot) {
  
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return (i + 1);
    }

}
 
