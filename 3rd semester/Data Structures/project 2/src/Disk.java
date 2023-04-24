import java.lang.*;
import java.util.NoSuchElementException;

public class Disk<T> implements Comparable<Disk>{


    private static int currentId = 1;       //id counter | starts from 1 and increases every time new item Disk is made
	private int id;                         //id number of Disk object
	private static int max_space = 1000000; //max Space of one Disk 1 TB.
	private int free_space;                 //free space left of the Disk
	public List<Integer> folders;
    
	//Default constructor
	Disk(){
		this.id = currentId;
		this.free_space = max_space;
		this.folders = new List<Integer>();
		currentId++;
	}

    /*
     * @return int number of free space 
     * left in MB in the Disk
     */
	int getFreeSpace() {
        return this.free_space;
    }
	

    /*
     * @return int id of the Disk
     */
	int getId(){
        return this.id;
    }


    /*
     * inserts at front in list folders a folder
     * decreases the free space by the number of MB the folder is
     */
	void addFolder(int folder){
		this.folders.insertAtFront(folder); 
		this.free_space -= folder; 
	}
	
    /*
     * Determines wether a Disk has more free space than another
     * A.comareTo(B)
     * if Disk's A free space is more than Disk's B then it returns 1
     * if both Disks have equal free space it returns 0
     * else it returns -1
     */
	public int compareTo(Disk B) {
        if(this.free_space < B.getFreeSpace()){
            return -1;
        }else if(this.free_space > B.getFreeSpace()){
            return 1;
        }else{
            return 0;
        }
    }

    /*
     * @returns string 
     */
	public String toString(){
		StringBuilder formattedArray = new StringBuilder();
		int[] tempFolder = new int[folders.getSize()];
		int folderSize = folders.getSize();
		
		for (int i = 0; i < folderSize; i++){
			try{
				tempFolder[i] = folders.removeFromFront(); //Temporarily saving folders to restore later
				formattedArray.append(tempFolder[i]).append(" "); //Destroying folder list and storing in in a formatted array
			}//try
			catch(NoSuchElementException e){
				System.out.println("List is empty");
			}//catch
		}//for
		for (int i = 0; i < tempFolder.length; i++){
			folders.insertAtFront(tempFolder[i]); //Restoring folder list
		}//for
		return "id " + id + " "+ free_space + ": " + formattedArray;
	}//toString

}