/**
* Ari8mos omadas: 078
 Ari8moi mhtrwou foithtwn: 3210078, 3210044, 3210056
*/

import java.util.Scanner;
import java.util.ArrayList;

class mainApp{

    public static void main(String[] args){

		ReadFileApp Store = new ReadFileApp();

        Scanner in = new Scanner(System.in);

        int goback;
        int k, answer, answer2, answer3, ans;
        int mother = 0, scr= 0, gc = 0, r = 0, cpu = 0, hd = 0, key = 0, mice = 0, print = 0;

		Store.ReadAvailableFile();
        ArrayList<Products> availableProduct = Store.getavailableList();
        Store.ReadOrderedFile();
        ArrayList<Ordered> OrderedProduct = Store.getOrderedList();
        Store.ReadSoldFile();
        ArrayList<Sold> SoldProduct = Store.getSoldList();
        Catalogues cat = new Catalogues(Store);
        Menu menu = new Menu(Store);
        int f =0;
                        
        while(f < availableProduct.size()){
            if(availableProduct.get(f) instanceof motherboards){
                mother++;
            }else if(availableProduct.get(f) instanceof CPU){
                cpu++;
            }else if(availableProduct.get(f) instanceof HardDrive){
                hd++;
            }else if(availableProduct.get(f) instanceof RAM){
                r++;
            }else if(availableProduct.get(f) instanceof graphicsCard){
                gc++;
            }else if(availableProduct.get(f) instanceof screen){
                scr++;
            }else if(availableProduct.get(f) instanceof Keyboard){
                key++;
            }else if(availableProduct.get(f) instanceof Mouse){
                mice++;
            }else if(availableProduct.get(f) instanceof Printer){
                print++;
            }
            f++;
        }
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
                                System.out.println("\n\n1.Motherboards\n2. CPU\n3. RAM\n4. Graphics Card\n5. Hard Drive ");
                                System.out.println("Paramonh h epistrofh sth prohgoumenh selida; (1.Epistrofh  2.Paramonh)");
                                goback = in.nextInt();
                                int i = 0;
                                in.nextLine();
                                if(goback==2){
                                    System.out.println("\nEpilejte mia apo tis parapano kathgories:\n");
                                    ans = in.nextInt();
                                    in.nextLine();
                                    if(ans == 1){
                                        menu.menu3(0,mother,availableProduct);
                                        k = -1;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    }else if(ans == 2){
                                        menu.menu3(mother,(mother+cpu),availableProduct);
                                        k = mother -1;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if(ans == 3){
                                        menu.menu3((mother+cpu),(mother+cpu+r),availableProduct);
                                        k = mother+cpu-1 ;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    }else if(ans == 4){
                                        menu.menu3((mother+cpu+r),(mother+cpu+r+gc),availableProduct);
                                        k = mother+cpu+r-1;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    }else if(ans == 5){
                                        menu.menu3((mother+cpu+r +gc),(mother+cpu+hd+r+gc),availableProduct);
                                        k = mother+cpu+gc+r -1;
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
                                        menu.menu3((mother+cpu+hd+r+gc),(mother+cpu+hd+r+gc+scr),availableProduct);
                                        k = mother+cpu+hd+r+gc -1;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if(ans==2) {
                                        menu.menu3((mother+cpu+hd+r+gc+scr),(mother+cpu+hd+r+gc+scr+key),availableProduct);
                                        k = mother+cpu+hd+r+gc+scr -1;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if (ans == 3){
                                        menu.menu3((mother+cpu+hd+r+gc+scr+key),(mother+cpu+hd+r+gc+scr+key+mice),availableProduct);
                                        k = mother+cpu+hd+r+gc+scr+key -1;
                                        answer3 = in.nextInt();
                                        in.nextLine();
                                        menu.menu2(answer3,k, availableProduct, SoldProduct, OrderedProduct, cat);
                                    } else if(ans == 4){
                                        menu.menu3((mother+cpu+hd+r+gc+scr+key+mice),(mother+cpu+hd+r+gc+scr+key+mice+print),availableProduct);
                                        k = mother+cpu+hd+r+gc+scr+key+mice -1;
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
                                    if( ((OrderedProduct.get(ans-1).getKatastash().trim()).equals("ANAMENETAI"))){
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
    UpdateFile up = new UpdateFile(Store);
    up.CreateFile(availableProduct, OrderedProduct, SoldProduct);                             // Enhmerwnei to arxeio me tis nees paraggelies kai pwlhseis
    System.out.println("Oi listes twn dia8esimwn proiontwn, twn paraggeliwn kai twn pvlhsewn enhmerw8hkan.");
    }//main

}//mainApp

