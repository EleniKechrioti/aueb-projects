import java.util.Scanner;

class Ordered {
    private String anamenomenhdate, name,phone, kat, katastash;
    private final String situation = "ANAMENETAI";
    private Products product;
    private int  OrderCode;
    private double price;
    
    private static int code = 1;

    Ordered(Products product, String name, String phone, String anamenomenhdate, double finalprice){
        Scanner input = new Scanner(System.in);

        this.product = product;
        this.name = name;
        this.phone = phone;
        this.katastash = situation;
        this.price = finalprice;
        Date d = new Date();
        String dateoforder = d.getDate();

        while( d.afterdate(anamenomenhdate)){
            System.out.println("Invalid date..");
            anamenomenhdate = input.nextLine();
        }
        this.anamenomenhdate = anamenomenhdate;
        this.OrderCode = code++;


    }

    Products getProduct(){
        return product;
    }
    String getName(){
        return name;
    }
    String getPhone(){
        return phone;
    }
    void setKatastash(String kat){
        this.katastash = kat;
    }
    
    public String getKatastash(){
        return katastash;
    }
    

    String toString(int i){
        if (i==0){
            return product.toString();
        }
        else{
            return "Kwdikos paraggelias: "+OrderCode +"\n" + product.toString() + "\nOnoma Pelath: " + name +"\nThlephono: " + phone + "\nAnamenomenh hmeromhnia afijhs: " + anamenomenhdate +"\nKatastash paraggelias: " + katastash;
        }
    }
}
