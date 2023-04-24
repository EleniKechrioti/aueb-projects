import java.util.*;
import java.io.*;

public class Greedy {
    
    public static int[] readFile(String file){
        int[] f = null;
        try{
            BufferedReader reader = null;
            String line;
            int size = 0;
            reader = new BufferedReader(new FileReader(new File(file))); // reads file.
            line = reader.readLine();
            while (line!=null){
                line = reader.readLine();                       // reads each line so we can now the number of folders.
                size++;                                         // each line is another folder.
            }
            int[] folders = new int[size];                      //create new table folders with size the number of folders we read
            reader = new BufferedReader(new FileReader(new File(file)));// new reader so we can read again.
            for(int i = 0; i < size; i++ ){
                line = reader.readLine();                           // read each line.
                if(Integer.parseInt(line.trim()) > 1000000 || Integer.parseInt(line.trim()) <0){ // if a number is negative or bigger than 1TB 
                    System.out.println("Error: Invalid data.");
                    return f;                                   // returns null table.
                }
                folders[i] = Integer.parseInt(line);            // else store in folders the number we read.
            }
            return folders;                                     //return table folders with all data from the file.
        }catch(IOException e){
            System.out.println("File not found.");
        }
        return f;                                               // if file not found return null table.
    }



    public static int Algorithm1(int[] folders){           //Greedy algorithm

        int folderSum = 0;                      //the sum of the sizes in MB of all folders

        for (int i = 0; i < folders.length; i++){
            folderSum += folders[i];                // counts the sum of all folders
        }
        //MaxPQ<Disk> disks = new MAXPQ<> ();
        MaxPQ disks = new MaxPQ();          // priority queue with DiskComparator as Comparator.
        
        disks.insert(new Disk());                               // if file is not empty then we'll need at least 1 disk.
        int disksUsed = 1;
        for (int i = 0; i<folders.length; i++){
            if (folders[i] <= disks.peek().getFreeSpace()){    //first disk will be with the most free space, so if the folder fits in first disk
                disks.peek().addFolder(folders[i]);            // add the folder in the first disk
                Disk d = disks.peek();                         // store first disk in d
                disks.getMax();                                //remove the first disk from the queue
                disks.insert(d);                               // insert again the disk we used so it can find its place in the queue
            }else{                                             // folder does not fit in the first disk, then it does not fit in every other disk
                Disk d = new Disk();                           // create new disk to store the folder
                d.addFolder(folders[i]);                        
                disks.insert(d);                               //insert new disk in the queue
                disksUsed++;                                   //increase number of disks needed to be used.
            }
        }
        
        System.out.println("Sum of the folders =  "+ (double)folderSum/1000000.0 + " TB.");
        System.out.println("Number of disks needed: "+ disksUsed);
        

        if (folders.length < 100){                         //if folders in the file are less than 100.
            for (int i = 0; i< disksUsed; i++){            //for every disk
                Disk diskaki = disks.getMax();             // get the fisrt folder with the most free space
                System.out.println(diskaki.toString());   //and print its elements.
            }
        }
        return disksUsed;                               //returns the number of disks need / for part D
    }

    public static int Algorithm2(int[] folders){        // Greedy-Decreasing algorithm

        Sort.quickSort(folders, 0, folders.length - 1); // sort the folders first

		int disksUsed = Algorithm1(folders);            //use algorithm 1 to store the now sorted folders in the disks
		return disksUsed;                               //returns the number of disks need / for part D
    }

    public static void main(String[] args){
        int[] folders = readFile(args[0]);              //reads the file from terminal

        if (folders == null){                           //if folders= null then file was not found or data were invalid
            System.exit(0);                             // exit from program
        }
        Algorithm1(folders);                            //apply Greedy algoritmh 
    }
}
