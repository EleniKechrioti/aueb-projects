


class Sold{

    private String name, phone;
    private Products product;
    private double price;
    private static int code =1;
    private int SoldCode;
    Sold(Products product, String name, String phone, double finalprice){
        this.product = product;
        this.name = name;
        this.phone = phone;
        this.price = finalprice;
        Date d = new Date();
        String dateoforder = d.getDate();
        this.SoldCode =code++;

        
    }

    
    public String toString(int i){

        if (i==0){
            return product.toString();
        }
        else{
            return "\nApo8ema proiontos: "+ product.getapo8ema() +"\nKwdikos pwlhshs: "+SoldCode +"\n" + product.toString() + "\nOnoma Pelath: " + name +"\nThlephwno: " + phone +"\nTimh: " + price +"\nApomenoun temaxia: " + product.getapo8ema() ;
        }
    }
}