


class Sold{

    private String dateoforder, name, phone;
    private Products product;
    private double price;
    private static int code =1;
    private int SoldCode;
    Sold(){

    }
    Sold(Products product, String name, String phone, double finalprice){
        this.product = product;
        this.name = name;
        this.phone = phone;
        this.price = finalprice;
        Date d = new Date();
        this.dateoforder = d.getDate();
        this.SoldCode =code++;

        
    }
    public String getName(){
        return name;
    }
    public String getphone(){
        return phone;
    }
    public String getDateofSale(){
        return dateoforder;
    }
    public int getScode(){
        return SoldCode;
    }
    Products getProduct(){
        return product;
    }
    public void setProduct(Products product) {
        this.product = product;
    }
    
    public void setSoldCode(int SoldCode){
        this.SoldCode = SoldCode;
    }

    public void setName(String name){
        this.name= name;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setDateofSale(String date){
        this.dateoforder = date;
    }
        
    public String toString(int i){

        if (i==0){
            return product.toString();
        }
        else{
            return "\nApo8ema proiontos: "+ product.getapo8ema() +"\nKwdikos pwlhshs: "+SoldCode +"\n" + product.toString() + "\nOnoma Pelath: " + name +"\nThlephwno: " + phone ;
        }
    }
}