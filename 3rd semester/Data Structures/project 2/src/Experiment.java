import java.io.File;

public class Experiment{
    public static void main(String[] args){

        File folder_100 = new File(".\\data\\100");         
        File folder_500 = new File(".\\data\\500");
        File folder_1000 = new File(".\\data\\1000");
        int numbers[] = {100, 500, 1000};
        File folder = null;

        int folders[];
        int Sum1[] = new int[3], Sum2[] = new int[3], i = 0;

        for (int N : numbers){      // for every case in this experiment, where N = 100, 500, 1000.
            Sum1[i]= 0; Sum2[i] = 0; // sum1 = sum of disks needed from algorithm 1, sum2 = sum of disks needed from algorithm 2.
            System.out.println("----------------For N = " + N + "----------------");
            if (N==100) folder = folder_100;
            if (N==500) folder = folder_500;
            if (N==1000) folder = folder_1000;
            for (File f : folder.listFiles()){      //for every file in the N folder. 
                System.out.println("\nFor Folder " + f.getName());
                System.out.println("\nResults from Algorithm 1 are:");

                folders = Greedy.readFile(".\\data\\" + N + "\\"+ f.getName()); // store in folders[] the data we read from each file

                Sum1[i] += Greedy.Algorithm1(folders);                        //call algorithm 1 with data folders and returns the number of disks used
                System.out.println("\nResults from Algorithm 2 are:");

                folders = Greedy.readFile(".\\data\\" + N + "\\"+ f.getName()); // store in folders[] the data we read from each file

                Sum2[i] += Greedy.Algorithm2(folders);         //call algorithm 2 with data folders and returns the number of disks used
                System.out.println("----------------------------------");

            }
            i++;
            
        }
        i = 0;
        System.out.println("---------------Comparison-------------------");
        for (int N : numbers){
            System.out.println("----------------For N = " + N + "----------------");
            System.out.println("\nAverage disks used for algorithm Greedy :            " + Sum1[i]/10.f);
            System.out.println("\nAverage disks used for algorithm Greedy-Decreasing : " + Sum2[i]/10.f);
            System.out.println("------------------------------------------");
            i++;
        }
        


    }
}