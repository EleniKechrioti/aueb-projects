
public class Products {
    
    private String name, constructor, category;
    private int year;
    private int apo8ema;
    private double price;
    private final double salesEj = 0.25;               // ekptwseis sta ejarthmata
    private final double salesPer = 0.1;               // ekptwseis sta perifereiaka

    Products(){}

    Products(String name, int year, String constructor, double price) {
        this.name = name;
        this.year = year;
        this.constructor = constructor;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setConstructor( String constructor){
        this.constructor = constructor;
    }

    public String toString(){
        return "Onoma montelou: "+ this.name +" | Etos kataskeuhs: " + this.year+ " | Kataskeuasths: " + this.constructor+" | Timh: " + this.price;
    }

    public double getprice(){
        return price;
    }
    public void setapo8ema(int apo8ema){
        this.apo8ema = apo8ema;
    }
    public int getapo8ema(){
        return apo8ema;
    }
    public String getModel(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public String getConstructor(){
        return constructor;
    }
    

    public void Sales(){
        
        System.out.println("Arxikh timh: "+ price);
        if(category=="P"){
            System.out.println("Pososto ekptwshs: " + salesEj*100 +"%" );
            System.out.println("Telikh timh: " + (price -price*salesEj));
            System.out.println("Poso ekptwshs: " + price*salesEj);
        }
        else{
            System.out.println("Pososto ekptwshs: " + salesPer*100 +"%" );
            System.out.println("Telikh timh: " + (price -price*salesPer));
            System.out.println("Poso ekptwshs: " + price*salesPer);
        }
    }

    
}
