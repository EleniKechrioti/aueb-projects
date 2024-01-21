

public class Point {

    private int x, y; 
    Point(int x, int y) {this.x = x;this.y = y;}

    public int x(){ return this.x;} // return the x-coordinate

    public int y() { return this.y;} // return the y-coordinate

    public double distanceTo(Point z) {
        double dx = x - z.x(), dy = y - z.y(); 
        return Math.sqrt(dx*dx + dy*dy); 
    }// Euclidean distance between two points
    
    public int squareDistanceTo(Point z){
        int dx = x - z.x(), dy = y - z.y(); 
        return dx*dx + dy*dy;
    } // square of the Euclidean distance
    // between two points
    
    public String toString(){
        return "(" + x + "," + y + ")"; 
    } // string representation: (x, y)
    
}