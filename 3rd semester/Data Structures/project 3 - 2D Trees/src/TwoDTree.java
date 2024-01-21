import java.util.*;
import java.io.*;

public class TwoDTree {

    private class TreeNode {
        Point point; // an object of the class Point
        Rectangle rectangle;
        TreeNode l; // pointer to left subtree
        TreeNode r; // pointer to right subtre

        TreeNode(Point p, Rectangle r){
            this.point = p;
            this.rectangle = r;
            this.r = null;
            this.l = null;
        }
    };
    private TreeNode root; //root of the tree
    private int size;      //size of the tree



    public TwoDTree(){ root = null; size = 0;} // construct an empty tree

    public boolean isEmpty() {
        return (size == 0);
    }// is the tree empty?

    public int size() {
        return size;
    }// number of points in the tree


    public void insert(Point  p) {
        /*
         * set xmin = 0, xmax = 100, ymin = 0, ymax = 100;
         * if we insert at root then the rectangle which corresponds to the root is [0,100]x[0,100] root = (50,80)
         * Say you want to insert later the point (40,60)
         *  40 < 50 so the point is going to be positioned in the left subtree (second if)
         * as xmin stays the 0 and xmax becomes the current(root) point x, ie xmax = 50
         * so to point (40,60) the correspoded rectangle is [0,50]x[0,100]
         * 
         * Another example: Insert point (100,40)
         * 100 > 50 so the point is going to be positioned in the right subtree
         * root.r = null so we reached a leef 
         * xmin = root's x = 50 and xmax stays as is 
         * so to point (100,40) the correspoded rectangle is [50,100]x[0,100]
         * It's the same logic for ymin and ymax
         */

        int xmin = 0, xmax= 100, ymin = 0, ymax = 100;
        size++;                                         //increase size each time this method is called, beacuse we might isert a point in the tree
        if (root == null){
            root = new TreeNode(p, new Rectangle(0,100,0,100)); //if the tree is empty we insert at the root
            return;                                             //the rectangle which corresponds to the root is [0,100]x[0,100]
        }
            
        TreeNode current = root;                            //else if the tree is not empty
        int i=1;                                            //counter, counts the levels in the tree
        while (true) {
            if (current.point.x() == p.x() && current.point.y() == p.y()){   //if the coordinates match then te point already exists in the tree
                size--;                                         // we decrease the size because we increased it before and we did not add any new point
                return;
            }
            if ((i % 2)==1){                   //because we started the counter from 1, if the devision remainder is 1 then we are at an even level and we check by x
                if (current.point.x() < p.x()){ // if given point's x is bigger than the current point's in tree then we are going with the right subtree
                    xmin = current.point.x();   //set as xmin the current's point x| the rest are being determined in other ifs
                    if (current.r == null) {
                        current.r = new TreeNode(p, new Rectangle(xmin, xmax, ymin, ymax));// insert the point as new TreeNode with it's corresponded rectangle
                        return;
                    } else {
                        current = current.r;// there are still more points in the tree (we did not reach a leef) and we continue to the right subtree
                    }
                } else {                    //if given point's x is less or equal to the current point's in tree then we are going with the left subtree
                    xmax = current.point.x();   // set as xmax current point's x
                    if (current.l == null) {
                        current.l = new TreeNode(p, new Rectangle(xmin, xmax, ymin, ymax));//reached a leef
                        return;
                    } else {
                        current = current.l;
                    }
                }
                i++; // increase i because there are more levels
            }
            else{                               //odd level we are cheking with y coordinate
                if (current.point.y() < p.y()){
                    ymin = current.point.y();
                    if (current.r == null) {
                        current.r = new TreeNode(p, new Rectangle(xmin, xmax, ymin, ymax));
                        return;
                    } else {
                        current = current.r;
                    }
                } else {
                    ymax = current.point.y();
                    if (current.l == null) {
                        current.l = new TreeNode(p, new Rectangle(xmin, xmax, ymin, ymax));
                        return;
                    } else {
                        current = current.l;
                    }
                }
                i++;
            }
        }
    }// inserts the point p to the tree

    public boolean search(Point p){

        int i = 0;                      //counter 
        TreeNode current;
        boolean found = false;          //assume point was not found 

        if (isEmpty()){
            System.out.println("Point cannot be found, because the tree is empty.");
            return found;
        }
        else{
            current = root;
            while(current != null){
                if (i % 2 == 0){ // even number of the loop we compare with x
                    current = (p.x() < current.point.x()) ? current.l : current.r;// if given point's x value is less than the current's then search in the left subtree, else the right subtree
                }
                else { // odd number of the loop we compare with y
                    current = (p.y() < current.point.y()) ? current.l : current.r;
                }
                if (current != null){
                    if (current.point.x() == p.x() && current.point.y() == p.y()){
                        found = true;       // the point was found
                        break;              //stop the loop
                    }
                }
                i++;// increase i because there will be other levels as well
            }
        }
        
        return found;
    } // does the tree contain p?


    public Point nearestNeighbor(Point p){
        if (root==null)                     //if root is null, then the tree is empty and there is 
            return null;                    //no point to be returned as the nearest one.
        else{
            return (nearestNeighbor_helper(root, p)).point;  //returns the point of the TreeNode with the nearest point
        }
    }
    
    

    private TreeNode nearestNeighbor_helper(TreeNode T,Point P){    //recursive method
        TreeNode x, y;
        if (T.l==null && T.r==null){    //if left and right node are null the we reached a leef and that will be the nearest neighbor 
            return T;                   // because ther are no more points to check for
        }
        else{ 
            if(T.l==null){             //if left node is null then we check to the right subtree 
                x=nearestNeighbor_helper( T.r, P);}    
            
            else if(T.r==null){ // else if the right node is null we check to the left subtree
                x=nearestNeighbor_helper( T.l, P);}    
            
            else  {         // else if none of them are null
                x=nearestNeighbor_helper( T.r, P);  //find recursively the nearest neighbor to the right
                y=nearestNeighbor_helper( T.l, P);  //find recursively the nearest neighbor to the left
                if (y.point.distanceTo(P)<x.point.distanceTo(P)){   //if the neighbor from the left is closer to the neighbor from the right then
                    x=y;                                            //set as x the closer neighbor y
                }
            }
            if (x.point.distanceTo(P) < T.point.distanceTo(P)){
                return x;}
            else {
                return T;
            }  
        }
    }


    private static  List<Point> lista=new List<Point>();
    public List<Point> rangeSearch(Rectangle rect) {
        lista.clear();                              //each time we call the method we clear the list from the points resulted in previous searches 
        if (root == null){                          // if root is null, ie tree is empty
            return null;
        }else{
            rangeSearch_helper(root,rect);          //helper method that recursively finds the points    
            return lista;
        }
    }// Returns a list
    //with the Points that are contained in the rectangle
    
    
    private void rangeSearch_helper(TreeNode T,Rectangle rect){ //Recursive method

    
        
        if(rect.intersects(T.rectangle)){ //If given rectangle intersects with current TreeNode's rectangle then there are points to add to the list
			if(rect.contains(T.point)) //If the given rectangle contains the point
				lista.insert(T.point); 
			if(T.l != null)             //If left subtree is null the we continue the search in the right subtree
                rangeSearch_helper(T.l, rect); 
			if(T.r !=null)              //If right subtree is null then we continue to the left subtree
                rangeSearch_helper(T.r, rect);
		}
    }
    

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        TwoDTree tree = new TwoDTree();
        int choice;
        try{
            BufferedReader reader = null; //file reader
            String line;
            
            reader = new BufferedReader(new FileReader(new File(args[0]))); 
            line = reader.readLine();                           // line with number of points
            int points_expected = Integer.parseInt(line.trim()); 
            int	p = 0; 
            line = reader.readLine();
            while (line !=null){ 
                line = reader.readLine();       //each line is a point to add to the tree
                p++;
            }
                
            if ( points_expected != p){
                System.out.println("Error: Invalid Data\nNumber of actual points did not match the number given at the start.");
                System.exit(0); // terminate the program
            }
        
            reader = new BufferedReader(new FileReader(new File(args[0]))); //Read file again from the beginning
            int x = 0, y = 0;
            line = reader.readLine(); // fisrt line with number of points
            line = reader.readLine();// second line with actual point
            while (line != null){
                if (line.split("\\s+").length != 2){
                    System.out.println("Error: Invalid Data\nNumber of coorrdinates are more/less than two.");
                    System.exit(0);
                }
                else{
                    if (x > 100 || x < 0){
                        System.out.println("Invalid Coordinate\nX coordinate does not belong in [0,100]");
                        System.exit(0);
                    }
                    else
                        x = Integer.parseInt(line.split("\\s+")[0]);
                    if (y > 100 || y < 0){
                        System.out.println("Invalid Coordinate\nY coordinate does not belong in [0,100]" );
                        System.exit(0);
                    }//if
                    else
                        y = Integer.parseInt(line.split("\\s+")[1]);

                    tree.insert(new Point(x, y));
                }
                line = reader.readLine();
            }		
        }
        catch(IOException e){
            System.out.println("File Not Found");
            System.exit(0);
        }

        while (true){
            System.out.println("\n--------------------- MENU ----------------------");
            System.out.println("1. Compute the size of the tree.");
            System.out.println("2. Insert a new point.");
            System.out.println("3. Search if a given point exists in the tree.");
            System.out.println("4. Provide a query rectangle.");
            System.out.println("5. Provide a query point.");
            System.out.println("0. Exit");
            System.out.print("\nGive your choice: ");
            choice = in.nextInt();


            if (choice == 0){
                break;
            }else if(choice == 1){
                System.out.println("\nThe size of the tree is " + tree.size());
            }else if(choice == 2){
                System.out.println("\nPlease enter the coordinates of the point. ");
                int x = in.nextInt(); int y = in.nextInt();
                if ( (x < 0 || x > 100) || (y< 0 || y>100)){
                    System.out.println("\nYou entered invalid coordinates (Coordinates must be [0,100]).\nPlease type the choise 2 and try inserting again.");
                }else{
                    tree.insert(new Point(x,y));
                }
            }else if(choice == 3){
                System.out.println("\nPlease enter the coordinates of the point you are trying to find.");
                int x = in.nextInt(); int y = in.nextInt();
                if ( (x < 0 || x > 100) || (y< 0 || y>100)){
                    System.out.println("\nYou entered invalid coordinates (Coordinates must be [0,100]).\nPlease type the choise 3 and try searching again.");
                }else{
                    if(tree.search(new Point(x,y))){
                        System.out.println("\nThe point you entered exists in the tree.");
                    }else{
                        System.out.println("\nThe point you entered does not exists in the tree.");
                    }
                    
                }
            }else if(choice == 4){
                int xmin, xmax, ymin, ymax;
                List<Point> pointsList;
                System.out.println("\nGive the first 2 coordinates of the rectangle [xmin,xmax]: ");

                System.out.print("X minimum: ");
                xmin = in.nextInt();
                System.out.print("X maximum: ");
                xmax = in.nextInt();
                if ( (xmin < 0 || xmin > 100) || (xmax < 0 || xmax > 100) ){
                    System.out.println("\nYou entered invalid coordinates (Coordinates must be [0,100]).\nPlease type the choise 4 try again.");
                    continue;
                }
                System.out.println("\nGive the second 2 coordinates of the rectangle [ymin,ymax]: ");
                System.out.print("Y miminum: ");
                ymin = in.nextInt();
                System.out.print("Y maximum: ");
                ymax = in.nextInt();
                if ( (ymin< 0 || ymin>100)|| (ymax< 0 || ymax>100)){
                    System.out.println("\nYou entered invalid coordinates (Coordinates must be [0,100]).\nPlease type the choise 4 try again.");
                    continue;
                }
                Rectangle rectangle = new Rectangle(xmin, xmax, ymin, ymax);
                    
                pointsList = tree.rangeSearch(rectangle);
                System.out.println(pointsList.toString());
                
            }else if(choice == 5){
                
                System.out.println("\nPlease enter the coordinates of the point you are trying to find.");
                int x = in.nextInt(); int y = in.nextInt();
                if ( (x < 0 || x > 100) || (y< 0 || y>100)){
                    System.out.println("\nYou entered invalid coordinates (Coordinates must be [0,100]).\nPlease type the choise 5 try again.");
                }else{
                    Point u = new Point(x,y);       //point the user gave
                    Point p = tree.nearestNeighbor(u); 
                    if(p != null){
                        System.out.println("The nearest point is : " +  p.toString());
                        System.out.println("Distance is : " +  p.distanceTo(u));
                    }
                }
            }
        }
    }
}