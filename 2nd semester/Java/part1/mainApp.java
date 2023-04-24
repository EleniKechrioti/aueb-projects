// Ari8mos omadas: 078 
// Ari8moi mhtrwou: 3210078, 3210044, 3210056


import java.util.Scanner;
import java.util.ArrayList;

class mainApp {
    public static void main (String args[]) {

        Scanner in = new Scanner(System.in);

        Menu menu = new Menu();

        int goback;
        int k, answer, answer2, answer3, ans;
        Catalogues cat = new Catalogues();                             //Antikeimeno thw tajhs Catalogues  
        cat.CatalogueForSale();
        ArrayList<Ordered> OrderedProduct = cat.getOrderedList();      //Lista gia paraggelies
        ArrayList<Sold> SoldProduct = cat.getSoldList();               //Lista gia pwlhseis
        ArrayList<Products> availableProduct = cat.getavailableList(); //Lista gia Dia8esima proionta
        for(Products p: availableProduct){
            p.setapo8ema(0);                                           // 8etoume apo8ema 0 se ola ta proionta arxika
        }
//-----------------------------------------------------------------------------------------
        availableProduct.get(0).setapo8ema(2);
        availableProduct.get(3).setapo8ema(5);                         //8etoume apo8ema megalytero tou 0 se merika proionta
        availableProduct.get(23).setapo8ema(15);
        availableProduct.get(15).setapo8ema(9);
        availableProduct.get(19).setapo8ema(8);
        availableProduct.get(8).setapo8ema(20);
        availableProduct.get(26).setapo8ema(12);
        availableProduct.get(11).setapo8ema(3);
        availableProduct.get(7).setapo8ema(18);
        availableProduct.get(29).setapo8ema(5);
        availableProduct.get(24).setapo8ema(7);
//-----------------------------------------------------------------------------------------
        for (;;) {
			System.out.println ("1. Look all available products.");
			System.out.println ("2. Look all orders.");
			System.out.println ("3. Look all sales.");
			System.out.println ("0. Exit");

            System.out.print("\nEnter a number: ");
			answer = in.nextInt();
			in.nextLine();
            goback = 0;
//----------------------------------An Epilejei na dei ola ta dia8esima proionta-------------------------------------------------------            
            while( goback !=1){
                if (answer == 1){
                    System.out.println("\n1. Ejarthmata\n2. Perifereiaka");
                    System.out.println("Epistrofh h paramonh sth selida. (1. Epistrofh 2.Paramonh)\n");
                    goback = in.nextInt();
                    in.nextLine();
                    if(goback==2){
                        System.out.println("\nEpileje mia apo tis parapanw kathgories: ");
                        answer2 = in.nextInt();
                        in.nextLine();

                    //-----------------------------------An epilejei Ejarthmata-------------------------------------------------------------
                        if(answer2 == 1){
                            goback = 0;
                            while(goback !=1){
                                System.out.println("\n\n1.Motherboards\n2. CPU\n3. Hard Drive\n4. RAM\n5. Graphics Card ");
                                System.out.println("Paramonh h epistrofh sth prohgoumenh selida; (1.Epistrofh  2.Paramonh)");
                                goback = in.nextInt();
                                in.nextLine();
                                if(goback==2){
                                    System.out.println("\nEpilejte mia apo tis parapano kathgories:\n");
                                    ans = in.nextInt();
                                    in.nextLine();
                                    if(ans == 1){
                                        menu.menu3(0,4,availableProduct);
                                        k = -1;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    }else if(ans == 2){
                                        menu.menu3(4,8,availableProduct);
                                        k = 3;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if(ans == 3){
                                        menu.menu3(8,12,availableProduct);
                                        k = 7;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    }else if(ans == 4){
                                        menu.menu3(12,16,availableProduct);
                                        k = 11;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    }else if(ans == 5){
                                        menu.menu3(16,21,availableProduct);
                                        k = 15;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    }else{
                                        System.out.println("Invalid number..");
                                    }
                                }
                            }
                        }
                    
                    //---------------------------------------------An epilejei Perifereiaka------------------------------------------------------
                        else if(answer2 == 2){
                            goback = 0;
                            while(goback !=1){
                                System.out.println("\n\n1. Screens\n2. Keybords\n3. Mice\n4. Printers");
                                System.out.println("Paramonh h epistrofh sth prohgoumenh selida; (1.Epistrofh  2.Paramonh)");
                                goback = in.nextInt();
                                in.nextLine();
                                if(goback==2){
                                    System.out.println("\nEpilejte mia apo tis parapano kathgories:\n");
                                    ans = in.nextInt();
                                    in.nextLine();    
                                    if(ans == 1){
                                        menu.menu3(21,23,availableProduct);
                                        k = 20;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if(ans==2) {
                                        menu.menu3(23,25,availableProduct);
                                        k = 22;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if (ans == 3){
                                        menu.menu3(25,28,availableProduct);
                                        k = 24;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if(ans == 4){
                                        menu.menu3(28,30,availableProduct);
                                        k = 27;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else{
                                        System.out.println("Invalid number..");
                                        
                                    }
                                }
                                
                                
                            }
                        }
            }
        }
        

//-----------------------Episkophsh Paraggeliwn--------------------------------------------------
            else if (answer ==2) {
                if (OrderedProduct.isEmpty()){
                    System.out.println("\nThere are no ordered products yet.\n");
                    goback=1;
                }
                else{
                    goback = 0;
                    while (goback !=1){

                        int o = 1;

                        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------");
                        for(Ordered p: OrderedProduct){
                            System.out.println(o +". " + p.toString(0));
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                            o++ ; 
                        }
                        System.out.println("\nParamonh h epistrofh sth prohgoumenh selida; (1.Epistrofh  2.Paramonh)"); 
                        goback = in.nextInt();
                        in.nextLine();
                        if(goback==2){
                            ans = in.nextInt();
                            in.nextLine();
                            if( ans-1 <= OrderedProduct.size()) {
                                System.out.println(OrderedProduct.get(ans-1).toString(1));
                                OrderedProduct.get(ans-1).getProduct().Sales();
                                if( OrderedProduct.get(ans-1).getKatastash() == "ANAMENETAI"){
                                    System.out.println("\nAfijh paraggelias kai pwlhsh;\n1. Nai\n2. Oxi");
                                    answer2 = in.nextInt();
                                    in.nextLine();
                                    if( answer2 == 1){
                                        Sold p = new Sold(OrderedProduct.get(ans-1).getProduct(), OrderedProduct.get(ans-1).getName(), OrderedProduct.get(ans-1).getPhone(), OrderedProduct.get(ans-1).getProduct().getprice());
                                        OrderedProduct.get(ans-1).setKatastash("EKTELESTHKE");
                                        cat.CatalogueSold(p);
                                        System.out.println("\nEktelesthke h paraggelia.\n");
                                    }
                                }
                            }
                        }
                    }
                }
                
                
            }

           
//----------------------------------Episkophsh Pwlhsewn -------------------------------------------------------------------------------------------------
            else if(answer==3) {
                if (SoldProduct.isEmpty()){
                    System.out.println("\nThere are no sold products yet.\n");
                    goback = 1;
                }else{
                    goback = 0;
                    while (goback !=1){
                        int o = 1;
                        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------");
                        for(Sold p: SoldProduct){
                            System.out.println(o+". " + p.toString(0));
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                            o++ ; 
                        }
                        System.out.println("\nEpistrofh sth prohgoymenh selida h paramonh: (1.Epistrofh  2.Paramonh)");
                        goback = in.nextInt();
                        in.nextLine();
                        if (goback == 2){
                            System.out.println("\nSelect one of the above. \n");
                            ans = in.nextInt();
                            in.nextLine();
                            if (ans-1<= SoldProduct.size()){
                                System.out.println(SoldProduct.get(ans-1).toString(1));
                                System.out.println("Epistrofh sth prohgoymenh selida; \n1.Nai \n2.Oxi");
                                goback = in.nextInt();
                                in.nextLine();
                            }
                        }
                    }
                }
            
            }else {
                break;
            }//if

            }//while
            if (answer == 0){
                break;
            }
        }//for
    
    }//main

}//mainApp