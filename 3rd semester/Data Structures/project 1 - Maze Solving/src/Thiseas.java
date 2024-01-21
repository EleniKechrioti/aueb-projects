
import java.util.*;
import java.io.*;


public class Thiseas{

    public static boolean solve_maze(String[][] maze , int coorX, int coorY){

        StringStack<int[]> stack = new StringStackImpl<>();                         // create new object stack of class StringStack
        int x,y,maxX,maxY;                                                          //  it can only contain int[] data 
        x = coorX; y = coorY;                                                             // in x,y we store the coordinates of our entrance
        stack.push(new int[]{coorX, coorY});                                               // push in stack the coordinates of the entrance
        maxX = maze.length -1; maxY = maze[0].length -1;                              // table limits
        int[] previous = stack.peek();                                              // store in previous the top of stack, here is the "E"
        int repeats = 0;
        while (true){
            if ((y == maxY  || y == 0  || x == maxX  || x == 0 ) && repeats > 0){// if not E
                System.out.println("\n Coordinates are x = " + x + "  y = " + y);  // Exit found, print the coordinates
                return true;
            } else {                                                               // try finding the exit
                if (x == 0 && (y == 0 || y == maxY)){                              //if E is in top right or left corner
                    if ((maze[x+1][y]).equals("0") && previous[0]!= x+1 ){   // try moving down
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x+1, y}); 
                            x++;
                    }else{
                        if (y == 0){
                            if((maze[x][y+1]).equals("0") &&  previous[1] != y+1) { // try moving right
                                if (!stack.isEmpty()) {previous = stack.peek();}
                                stack.push(new int[]{x, y+1});
                                y++;
                            }
                        }else{
                            if( (maze[x][y-1]).equals("0")&& previous[1] != y-1 ){ // try moving left
                                if (!stack.isEmpty()) {previous = stack.peek();}
                                stack.push(new int[]{x, y-1});
                                y--;    
                            } 
                        }
                    }
                }else if( x == maxX && (y == 0 || y == maxY)){                  //if E is in bottom right or left corner
                    if((maze[x-1][y]).equals("0") && previous[0]!= x-1 ){
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x-1, y});  
                            x--;
                    }else{
                        if (y == 0){
                            if((maze[x][y+1]).equals("0") &&  previous[1] != y+1) { // try moving right
                                if (!stack.isEmpty()) {previous = stack.peek();}
                                stack.push(new int[]{x, y+1});
                                y++;
                            }
                        }else{
                            if( (maze[x][y-1]).equals("0")&& previous[1] != y-1 ){ // try moving left
                                if (!stack.isEmpty()) {previous = stack.peek();}
                                stack.push(new int[]{x, y-1});
                                y--;    
                            }
                        }
                    }
                } else if (x == 0 && y< maxY && y >0){                                 // if x = 0 we cannot move up because it is out of the maze limits
                    if((maze[x][y+1]).equals("0") &&  previous[1] != y+1) { // try moving right
                        if (!stack.isEmpty()) {previous = stack.peek();}
                        stack.push(new int[]{x, y+1});
                        y++;
                    }else if( (maze[x][y-1]).equals("0")&& previous[1] != y-1 ){ // try moving left
                        if (!stack.isEmpty()) {previous = stack.peek();}
                        stack.push(new int[]{x, y-1});
                        y--;    
                    }else if ((maze[x+1][y]).equals("0") && previous[0]!= x+1 ){   // try moving down
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x+1, y}); 
                            x++;
                    }
                }else if( x == maxX && y< maxY && y>0){                                  // if x = maxX we cannot move down because it is out of the maze limits
                    if((maze[x][y+1]).equals("0") &&  previous[1] != y+1) { // try moving right
                        if (!stack.isEmpty()) {previous = stack.peek();}
                        stack.push(new int[]{x, y+1});
                        y++;
                    }else if( (maze[x][y-1]).equals("0")&& previous[1] != y-1 ){ // try moving left
                        if (!stack.isEmpty()) {previous = stack.peek();}
                        stack.push(new int[]{x, y-1});
                        y--;
                    }else if((maze[x-1][y]).equals("0") && previous[0]!= x-1 ){
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x-1, y});  
                            x--;
                    }
                }else if( y == maxY && x<maxX &&x>0){                                   // if y = maxY we cannot move right because it is out of the maze limits
                    if( (maze[x][y-1]).equals("0")&& previous[1] != y-1 ){ // try moving left
                        if (!stack.isEmpty()) {previous = stack.peek();}
                        stack.push(new int[]{x, y-1});
                        y--;
                    }else if ((maze[x+1][y]).equals("0") && previous[0]!= x+1 ){   // try moving down
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x+1, y});  
                            x++;
                    }else if((maze[x-1][y]).equals("0") && previous[0]!= x-1 ){
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x-1, y}); 
                            x--;
                    }
                }else if (y == 0 && x<maxX && x>0){                                    //// if y = 0 we cannot move left because it is out of the maze limits
                    if((maze[x][y+1]).equals("0") &&  previous[1] != y+1) { // try moving right
                        if (!stack.isEmpty()) {previous = stack.peek();}
                        stack.push(new int[]{x, y+1});
                        System.out.println("if 10" + x + " " +(y+1));
                        y++;
                    }else if ((maze[x+1][y]).equals("0") && previous[0]!= x+1 ){   // try moving down
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x+1, y});  
                            x++;
                    }else if((maze[x-1][y]).equals("0") && previous[0]!= x-1 ){  //try moving up
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x-1, y}); 
                            x--;
                    }
                } else{                                                             // if we are not in the edges then we can move in which direction we want
                    if((maze[x][y+1]).equals("0") &&  previous[1] != y+1) { // try moving right | previous is there so we dont fall into an infinite loop between left and right
                        if (!stack.isEmpty()) {previous = stack.peek();}            // set previous as the old top of the stack
                        stack.push(new int[]{x, y+1});                              // push new top in the stack
                        y++;
                    }else if( (maze[x][y-1]).equals("0")&& previous[1] != y-1 ){ // try moving left
                        if (!stack.isEmpty()) {previous = stack.peek();}
                        stack.push(new int[]{x, y-1});
                        y--;
                    }else if ((maze[x+1][y]).equals("0") && previous[0]!= x+1 ){   // try moving down
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x+1, y});  
                            x++;
                    }else if((maze[x-1][y]).equals("0") && previous[0]!= x-1 ){  //try moving up
                        if (!stack.isEmpty()) {previous = stack.peek();}
                            stack.push(new int[]{x-1, y});  
                            x--;
                    }else if(!stack.isEmpty()){     // if all the other statements if are false then we are in a deadlock| if stack is not empty then we try backtracking
                        maze[x][y] = "1";           // replace "0" with "1" in order to not fall in a deadlock again
                        previous = stack.peek();    // go to previous point
                        x = previous[0];
                        y = previous[1];
                        int[] current = stack.pop(); // pop the deadlock
                    }else {
                        return false;               // if the stack is empty and there is nowhere left to go then there is no way out 
                    }
                }
            }  
            repeats++;                    // counter| counts how many tries we did and if there is more than one then we the exit we found does not match the entrance
        }
    }
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader(args[0])); // read file from terminate using args[0]
        String line;                                                     // variable line in which we store each line we are reading
        //line = br.readLine();                                          // read first line
        String[] ints = (br.readLine()).split(" ");               // split in a table every string between the " "
        int n = Integer.parseInt(ints[0]);                              // store first string as an integer in n
        int m = Integer.parseInt(ints[1]);                              // store second string as an integer in m
        ints = (br.readLine()).split(" ");
        if (ints.length != 2){
            System.out.println("Data does not match/ Invalida Data");
            System.exit(0);
        }
        int c1 = Integer.parseInt(ints[0]);     
        int c2 = Integer.parseInt(ints[1]);                             // coordinates of E   (c1, c2)
        if ( c1 >= n || c2 >=m){                                        // coordinates of 'E' are out of table limits
            System.out.println("Data does not match/ Invalida Data");
            System.exit(0);
        }
        String[][] maze= new String [n][m];                              // create table nxm
        line = br.readLine();                                           // read third line |  start of the maze
        int i = 0;                                                      // counter i , counts how many lines we are reading
        while ( line != null ){                                         // while there is a line to read continue
            line = line.replaceAll("\\s+", "");      // replace all " " with ""
            if ( i < n){                                                // if we are reading a line within our table limits
                if (line.length() == m){                                // if we are reading a line with length equal to our table columns
                    for (int j = 0; j<m; j++ ){                         // for every j in [0, m-1] 
                        
                        maze[i][j] = line.substring(j, j+1);             // store in tab[i][j] the string that starts in the length = j ends in j+1 
                        if ((i == c1) && (j == c2) && (!(maze[c1][c2]).equals( "E"))){  // if there is not an "E" in the position (c1,c2) of the maze
                            System.out.println("Data does not match/ Invalida Data");         // print
                            System.exit(0);                                              // terminate
                        }
                    } 
                } else{                                                         // if there are more than m columns
                    System.out.println("Data does not match/ Invalida Data"); // print
                    System.exit(0);                                      // terminate
                }
            } else {                                                            // if there is more than n rows 
                System.out.println("Data does not match/ Invalida Data");    // print
                System.exit(0);                                         // terminate
            }

            line = br.readLine();                                             // read next line
            i++;                                                               // counter is up by 1 
        }
        if (i != n){                                                      // if rows are less than n| it is n because i increases one more time in loop while
            System.out.println("Data does not match/ Invalida Data");    // print
            System.exit(0);
        }
        br.close();                                                            // close file
        int a1 = 0;                                                            // a1 counter, counts the non "E" elements of our table
        for (String[] a : maze){
            for( String b : a){
                if ( !b.equals("E") ){
                    a1++;
                }
            }
        }
        if ((a1 == n*m) || (a1 < n*m -1) ){         // if ther is no "E" or there is more than one 
            System.out.println("Invalid Data. There is no 'E' in the maze/ There is more than one 'E' in the maze.");
            System.exit(0);                 // terminate
        }

        if (solve_maze(maze, c1, c2)){                           // call solve_maze method
            System.out.println("Exit found");                // if it returns true it found an exit and its coordinates were printed in the method
        } else{
            System.out.println("Exit not found");           // if it returns false there is no exit 
        }
    }
}
