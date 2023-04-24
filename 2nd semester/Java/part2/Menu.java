

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Catalogues{

    private int answer2,ans, k;
    private double finalprice;


    Menu(ReadFileApp Store){}

    public void menu2(int ans,int k, ArrayList<Products> availableProduct, ArrayList<Sold> SoldProduct, ArrayList<Ordered> OrderedProduct, Catalogues cat){
        Scanner in = new Scanner(System.in);
        System.out.println(availableProduct.get(k+ans).toString() + "\napo8ema :" + availableProduct.get(k+ans).getapo8ema() );
    	
        if (availableProduct.get(k+ans).getapo8ema() == 0){
            System.out.println("8elete na parageilete to proion; \n1. Nai\n2. Oxi");
            int apanthsh = in.nextInt();
            in.nextLine();
            if(apanthsh == 1){
                System.out.println("Dwste to onomatepwnymo sas kai to thlefono sas: ");
                String name = in.nextLine();
                String phone = in.nextLine();
                System.out.println("Dwste anamenomenh mera afijhs ths paraggelias sas:");
                String dateanamenomeno = in.nextLine();
                Ordered oproduct = new Ordered(availableProduct.get(ans+k), name, phone, dateanamenomeno, availableProduct.get(ans+k).getprice());
                cat.CatalogueOrdered(oproduct);
                System.out.println("\nH paraggelia sas kataxwrh8hke.\n");
                
            }
        }
        else{
            System.out.println("8elete na agorasete to proion; \n1. Nai\n2. Oxi");
            int apanthsh = in.nextInt();
            in.nextLine();
            if(apanthsh == 1){
                System.out.println("Dwste to onomatepwnymo sas kai to thlefono sas: ");
                String name = in.nextLine();
                String phone = in.nextLine();
                finalprice = availableProduct.get(k+ans).getprice();
                Sold sproduct = new Sold(availableProduct.get(ans+k), name, phone, finalprice);
                int b = availableProduct.get(k+ans).getapo8ema();
                availableProduct.get(k+ans).setapo8ema(b-1);
                cat.CatalogueSold(sproduct);
                System.out.println("\nTo proion agorasthke.\n");
            }

        }
    }

    public void menu3(int a,int k, ArrayList<Products> availableProduct ){

        System.out.println("\nSelect one of the follow:\n------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        int j =1;
        for(int i = a ; i<k; i++){
            System.out.println((j) + ": " +availableProduct.get(i).toString());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            j++; 
        }
    }

}