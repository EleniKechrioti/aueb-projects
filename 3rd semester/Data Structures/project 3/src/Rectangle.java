
public class Rectangle {

    private int xmin, xmax, ymin, ymax;
    private Point A,B,C,D;

    Rectangle(int xmin, int xmax, int ymin, int ymax){
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;

        A = new Point (xmin, ymin);             //......................
        B = new Point ( xmin, ymax);            //....A----------D......
        C = new Point(xmax, ymin);              //....|..........|......
        D = new Point( xmax, ymax);             //....B----------C......
    }                                           // ......................


    public int xmin(){ return xmin;} // minimum x-coordinate of rectangle
    
    public int ymin(){ return ymin;} // minimum y-coordinate of rectangle
    
    public int xmax() { return xmax;}// maximum x-coordinate of rectangle
    
    public int ymax(){ return ymax;} // maximum y-coordinate of rectangle
    
    public boolean contains(Point p){
       return (p.x() >= xmin && p.x() <= xmax) && (p.y() >= ymin && p.y() <= ymax);  
    } //does p belong to the rectangle?
    
    public boolean intersects(Rectangle that){
        if (that.ymax() < ymin || that.ymin() > ymax || that.xmin() > xmax || that.xmax() < xmin ){
            return false;   // it is easier to check whether the two rectangles do not intersect
        }
        return true;
    } // do the two rectangles intersect?

    public double distanceTo(Point p) {

        double minDis = 10000000;
        if((p.x() > xmax && p.y() > ymax)||(p.x()>xmax &&p.y() < ymin) || (p.x() < xmin && p.y() < ymin) || (p.x() < xmin && p.y() > ymax)){
            if ( A.distanceTo(p) < minDis){ minDis = A.distanceTo(p);}  //if the given point is outside of the rectangle then we want to check the corners
            if ( B.distanceTo(p) < minDis){ minDis = B.distanceTo(p);}
            if ( C.distanceTo(p) < minDis){ minDis = C.distanceTo(p);}
            if ( D.distanceTo(p) < minDis){ minDis = D.distanceTo(p);}
            if(p.x() - xmax < minDis && p.x() - xmax > 0){             // then we check if the given point is near the sides
                minDis =p.x() - xmax ;
            }
            if(xmin- p.x()  < minDis && xmin - p.x()  > 0){
                minDis =xmin - p.x() ;
            }
            if(xmax - p.x() < minDis && xmax- p.x()  > 0){
                minDis =xmax - p.x()  ;
            }
            if(p.x() - xmin < minDis && p.x() - xmin > 0){
                minDis =p.x() - xmin ;
            }
            if(p.y() - ymax < minDis && p.y() - ymax > 0){
                minDis =p.y() - ymax ;
            }
            if(ymin- p.y()  < minDis && ymin - p.y()  > 0){
                minDis =ymin - p.y() ;
            }
            if(ymax - p.y() < minDis && ymax- p.y()  > 0){
                minDis =ymax - p.y()  ;
            }
            if(p.y() - ymin < minDis && p.y() - ymin > 0){
                minDis =p.y() - ymin ;
            }
        }else{
            minDis = 0;
        }
        return minDis;
    }// Euclidean distance from p
    
    //to closest point in rectangle
    public int squareDistanceTo(Point p){
        return (int)(distanceTo(p)* distanceTo(p));
    } // square of Euclidean
    
    // distance from p to closest point in rectangle
    public String toString(){
        return  "[" + xmin() + ", " + xmax() + "] x [" + ymin() + ", " + ymax() + "]";
    } // string representation: [xmin, xmax] x [ymin, ymax]
}