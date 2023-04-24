import java.util.*;
import java.io.*;

public class CreateFolders{

    public static void main(String[] args){

        try{
            Random random = new Random();
            Writer writer = null;
            for (int i = 1; i <= 10; i++){ //loop for 10 files
                File file = new File(".\\data\\"+ args[0] +"\\"+ "Folder_" + args[0] + "_" + i + ".txt"); // crate new file in data/folder N 
                writer = new FileWriter( file);
                for (int j = 0; j < Integer.parseInt(args[0]) - 1; j++){    // loop for N numbers (N folders in MB)
                    writer.write(random.nextInt(1000000) + "\n");           //random number between 0 and 1000000, that represents a folder in MB
                }
                writer.write(random.nextInt(1000000) + "");
                writer.close();
            }
            
            System.out.println("Foldes created successfully.");
        }
        catch(IOException e){
            System.out.println("Error: Cannot write file.");
        }
     }


}