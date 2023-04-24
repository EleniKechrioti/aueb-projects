import java.util.Scanner;

class Ordered {
    private String anamenomenhdate, name,phone, kat, katastash;
    private final String situation = "ANAMENETAI";
    private Products product;
    private int  OrderCode;
    private double price;
    String dateoforder;
    private static int code = 1;


    Ordered(){}
    Ordered(Products product, String name, String phone, String anamenomenhdate, double finalprice){
        Scanner input = new Scanner(System.in);

        this.product = product;
        this.name = name;
        this.phone = phone;
        this.katastash = situation;
        this.price = finalprice;
        Date d = new Date();
        this.dateoforder = d.getDate();

        while( d.afterdate(anamenomenhdate)){
            System.out.println("Invalid date..");
            anamenomenhdate = input.nextLine();
        }
        this.anamenomenhdate = anamenomenhdate;
        this.OrderCode = code++;


    }
    public void setOrderCode(int orderCode) {
        this.OrderCode = orderCode;
    }
    public void setProduct(Products product) {
        this.product = product;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setDateoforder(String dateoforder) {
        this.dateoforder = dateoforder;
    }
    public void setExpectedDate(String anamenomenhdate) {
        this.anamenomenhdate = anamenomenhdate;
    }
    public String getphone(){
        return phone;
    }
    public String getexpectedDate(){
        return anamenomenhdate;
    }
    public String getDateofOrder(){
        return dateoforder;
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
    public int getCode(){
        return OrderCode;
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
