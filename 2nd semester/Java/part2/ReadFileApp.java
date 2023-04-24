/**
* Ari8mos omadas: 078
 Ari8moi mhtrwou foithtwn: 3210078, 3210044, 3210056
*/


import java.util.*;
import java.io.*;

class ReadFileApp {

	public ArrayList <Products> availableProducts = new ArrayList<Products>();
    public ArrayList<Sold> SoldProduct = new ArrayList<Sold>();
    public ArrayList<Ordered> OrderedProduct = new ArrayList<Ordered>();



	public void ReadAvailableFile(){
		
		BufferedReader reader = null;
        BufferedReader reader2 = null;
		Products product = null;
        String line, l1;
        try {
			reader = new BufferedReader(new FileReader(new File("availableProducts.txt"))); // Basikos reader tou arxeiou twn dia8esimwn proiontwn
            reader2 = new BufferedReader(new FileReader(new File("availableProducts.txt")));// Secondary reader tou arxeiou twn dia8esimwn proiontwn
            line = reader.readLine();                                                                 // Diabazei to "Products_list"
            line = reader.readLine();                                                                 //Diabazei to "{"
            line = reader.readLine();                                                                 //Diabazei to "Product"
            l1 = reader2.readLine();
            l1 = reader2.readLine();                                                          //O secondary reader akolou8ei arxika to basiko
            l1 = reader2.readLine();      
            ReadFile2 rf2 = new ReadFile2();                                       // antikeimeno ths tajhs ReadFile2 gia diabasma orismenwn xarakthristikwn town arxeiwn
            while (line != null) {
                if (line.trim().equals("Product")) {
                    line = reader.readLine();                     
                    l1 = reader2.readLine();
                    if (line.trim().equals("{")) {
                        int j =0;                                                  // Metrhths 
                        l1 = reader2.readLine();                                  // O secondary reader diabazei thn epomenh grammh
                        while(l1.trim().equals("}")== false ){          //Epanalambanetai mexri na diabastei olo to proion stis agkyles "{" kai "}"
                            if (l1.trim().startsWith("ITEM_TYPE "))
                                j++;                                             //Se ka8e epanalhpsh elegxetai an periexetai ena apo ta parakatw tags
                            if (l1.trim().startsWith("MODEL "))          //An yparxei o metrhths ayjanetai kata 1
                                j++;                                            //Diabazetai h epomenh grammh mexri na emfanistei h agkylh "}"
                            if (l1.trim().startsWith("PRICE "))
                                j++;
                            l1 = reader2.readLine();
                        }
                        if (j==3){                                      //An to j = 3 tote yparxoun kai ta 3 basika tags, opote synexizoume me thn anagnwsh tou proiontos
                            line = reader.readLine();
                                if (line.trim().startsWith("ITEM_TYPE ")) {
                                    if (line.trim().substring(10).trim().equals("motherboard")) {
                                        product = new motherboards();   
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){     //Epanalambanetai mexri na diabastoun ola ta xarakthristika
                                            rf2.read(line, reader,product);                   // stelnoyme th grammh, ton basiko reader kai to proion gia na diabastoyn ta basika xarakthristika tou
                                            rf2.readMotherboard(line, reader, product);       // na diabastoyn ta eidika xarakthristika tous
                                            line = reader.readLine();                        //diabazetai h epomenh grammh | Ta tags mporoun na exoun opoiadhpote seira giauto mpainoyn se epanalhpsh 
                                        }
                                    }else if (line.trim().substring(10).trim().equals("CPU")) {
                                        product = new CPU();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readCPU(line, reader, product); 
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("HardDrive")) {
                                        product = new HardDrive();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readHD(line, reader, product);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("RAM")) {
                                        product = new RAM();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readRAM(line, reader, product);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("graphicsCard")) {
                                        product = new graphicsCard();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readGC(line, reader, product);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("screen")) {
                                        product = new screen();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readScreen(line, reader, product);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Keyboard")) {
                                        product = new Keyboard();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            if (line.trim().startsWith("CONNECTION "))
                                            ((Keyboard) product).setConnection(line.substring(11).trim());
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Mouse")) {
                                        product = new Mouse();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readMouse(line, reader, product);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Printer")) {
                                        product = new Printer();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readPrinter(line, reader, product);
                                            line = reader.readLine();
                                        }
                                    }
                                    availableProducts.add(product); //afou diabastoun ola ta tags to proion pou dhmioyrgh8hke apo8hkeuetai sth lista
                                } //Item
                        }else{                                      //An to j != 3 tote leipei kapoio apo ta basika tags kai to proion agnoeitai
                            while (line.trim().equals("}") == false){
                                line = reader.readLine();               // diabazoume tis grammes tou proion poy agnoeitai gia na synexisoume me to epomeno
                            }
                            System.out.println("Error: Missing characteristics (Price/Model/Item type) in Available File");
                        }
                    }//if
                } //Product
				line = reader.readLine();  //Diabazetai h epomenh grammmh tou basikoy reader
                l1 = reader2.readLine();   // Akolou8ei o seconadery reader
			}//while
			reader.close();
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}
	
	} // ReadFile

    public void ReadOrderedFile(){
		
		BufferedReader reader = null;
        BufferedReader reader2 = null;
        Ordered ordered = null;
		Products product = null;
        String line, l1;
        try {
			reader = new BufferedReader(new FileReader(new File("OrderedProducts.txt"))); // Basikos reader tou arxeiou twn paraggeliwn
            reader2 = new BufferedReader(new FileReader(new File("OrderedProducts.txt")));// Secondary reader tou arxeiou twn parageliwn
            line = reader.readLine();                                                                 // Diabazei to "Order_list"
            line = reader.readLine();                                                                 //Diabazei to "{"
            line = reader.readLine();                                                                 //Diabazei to "Order"
            l1 = reader2.readLine();
            l1 = reader2.readLine();                                                          //O secondary reader akolou8ei arxika to basiko
            l1 = reader2.readLine();      
            ReadFile2 rf2 = new ReadFile2();                                   // antikeimeno ths tajhs ReadFile2 gia diabasma orismenwn xarakthristikwn town arxeiwn
            while (line != null) {
                if (line.trim().equals("Order")) {
                    line = reader.readLine();                
                    l1 = reader2.readLine();
                    if (line.trim().equals("{")) {
                        int j =0;                                                  // Metrhths 
                        l1 = reader2.readLine();                                  // O secondary reader diabazei thn epomenh grammh
                        while(l1.trim().equals("}")== false ){          //Epanalambanetai mexri na diabastei olh h paraggelia stis agkyles "{" kai "}"
                            if (l1.trim().startsWith("ITEM_TYPE "))
                                j++;                                             //Se ka8e epanalhpsh elegxetai an periexetai ena apo ta parakatw tags
                            if (l1.trim().startsWith("MODEL "))          //An yparxei o metrhths au3anetai kata 1
                                j++;                                            //Diabazetai h epomenh grammh mexri na emfanistei h agkylh "}"
                            if (l1.trim().startsWith("PRICE "))
                                j++;
                            l1 = reader2.readLine();
                        }
                        if (j==3){                                      //An to j = 3 tote yparxoun kai ta 3 basika tags, opote synexizoume me thn anagnwsh tou proiontos
                            line = reader.readLine();
                            if ( line.trim().startsWith("NUMBER ")){   
                                ordered = new Ordered();
                                rf2.readO(line, reader, ordered);
                                line = reader.readLine();
                                if (line.trim().startsWith("ITEM_TYPE ")) {
                                    if (line.trim().substring(10).trim().equals("motherboard")) {
                                        product = new motherboards();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){     //Epanalambanetai mexri na diabastoun ola ta xarakthristika
                                            rf2.read(line, reader,product);                   // stelnoyme th grammh, ton basiko reader kai to proion gia na diabastoyn ta basika xarakthristika tou
                                            rf2.readMotherboard(line, reader, product);       // na diabastoyn ta eidika xarakthristika tous
                                            rf2.readO(line, reader, ordered);                // stelnoyme th grammh, ton basiko reader kai to antikeimeno ta3hs ordered gia na diabastoyn ta basika xarakthristika tou
                                            line = reader.readLine();                        //diabazetai h epomenh grammh | Ta tags mporoun na exoun opoiadhpote seira giauto mpainoyn se epanalhpsh 
                                        }
                                    }else if (line.trim().substring(10).trim().equals("CPU")) {
                                        product = new CPU();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readCPU(line, reader, product);
                                            rf2.readO(line, reader, ordered); 
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("HardDrive")) {
                                        product = new HardDrive();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readHD(line, reader, product);
                                            rf2.readO(line, reader, ordered);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("RAM")) {
                                        product = new RAM();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readRAM(line, reader, product);
                                            rf2.readO(line, reader, ordered);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("graphicsCard")) {
                                        product = new graphicsCard();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readGC(line, reader, product);
                                            rf2.readO(line, reader, ordered);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("screen")) {
                                        product = new screen();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readScreen(line, reader, product);
                                            rf2.readO(line, reader, ordered);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Keyboard")) {
                                        product = new Keyboard();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            if (line.trim().startsWith("CONNECTION "))
                                            ((Keyboard) product).setConnection(line.substring(11).trim());
                                            rf2.readO(line, reader, ordered);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Mouse")) {
                                        product = new Mouse();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readMouse(line, reader, product);
                                            rf2.readO(line, reader, ordered);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Printer")) {
                                        product = new Printer();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readPrinter(line, reader, product);
                                            rf2.readO(line, reader, ordered);
                                            line = reader.readLine();
                                        }
                                        
                                    }
                                        int i = 0;
                                        boolean flag = false;
                                        while(i < availableProducts.size()){
                                            if((availableProducts.get(i).toString()).equals(product.toString())){
                                                ordered.setProduct(product);
                                                OrderedProduct.add(ordered);
                                                flag = true;
                                            }
                                            i++;
                                        }
                                        if(!flag){
                                            
                                            System.out.println("The product with code: "+ ordered.getCode()+" you ordered is not available.");
                                        }
                                        
                                        
                                    //afou diabastoun ola ta tags h paraggelia pou dhmioyrgh8hke apo8hkeuetai sth lista
                                } //Item
                            }
                        }else{                                      //An to j != 3 tote leipei kapoio apo ta basika tags kai h paraggelia agnoeitai
                            while (line.trim().equals("}") == false){
                                line = reader.readLine();               // diabazoume tis grammes ths paraggelias poy agnoeitai gia na synexisoume me thn epomenh
                            }
                            System.out.println("Error: Missing characteristics (Price/Model/Item type)in Ordered File");
                        }
                    }//if
                } //Order
				line = reader.readLine();  //Diabazetai h epomenh grammmh tou basikoy reader
                l1 = reader2.readLine();   // Akolou8ei o seconadery reader
			}//while
			reader.close();
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}
	
	} // ReadFile

    public void ReadSoldFile(){
		
        BufferedReader reader = null;
        BufferedReader reader2 = null;
        Sold sold = null;
        Products product = null;
        String line, l1;
        try {
            reader = new BufferedReader(new FileReader(new File("SoldProducts.txt"))); // Basikos reader tou arxeiou twn pwlhsewn
            reader2 = new BufferedReader(new FileReader(new File("SoldProducts.txt")));// Secondary reader tou arxeiou twn pwlhsewn
            line = reader.readLine();                                                                 // Diabazei to "SALES_LIST"
            line = reader.readLine();                                                                 //Diabazei to "{"
            line = reader.readLine();                                                                 //Diabazei to "SALE"
            l1 = reader2.readLine();
            l1 = reader2.readLine();                                                          //O secondary reader akolou8ei arxika to basiko
            l1 = reader2.readLine();      
            ReadFile2 rf2 = new ReadFile2();                                   // antikeimeno ths tajhs ReadFile2 gia diabasma orismenwn xarakthristikwn twn arxeiwn
            while (line != null) {
                if (line.trim().equals("Sale")) {
                    line = reader.readLine();                
                    l1 = reader2.readLine();
                    if (line.trim().equals("{")) {
                        int j =0;                                                  // Metrhths 
                        l1 = reader2.readLine();                                  // O secondary reader diabazei thn epomenh grammh
                        while(l1.trim().equals("}")== false ){          //Epanalambanetai mexri na diabastei olo to proion stis agkyles "{" kai "}"
                            if (l1.trim().startsWith("ITEM_TYPE "))
                                j++;                                             //Se ka8e epanalhpsh elegxetai an periexetai ena apo ta parakatw tags
                            if (l1.trim().startsWith("MODEL "))          //An yparxei o metrhths ayjanetai kata 1
                                j++;                                            //Diabazetai h epomenh grammh mexri na emfanistei h agkylh "}"
                            if (l1.trim().startsWith("NUMBER "))
                                j++;
                            l1 = reader2.readLine();
                        }
                        if (j==3){                                      //An to j = 3 tote yparxoun kai ta 3 basika tags, opote synexizoume me thn anagnwsh ths pwlhshs
                            line = reader.readLine();
                            if ( line.trim().startsWith("NUMBER ")){   
                                sold = new Sold();
                                rf2.readSold(line, reader, sold);
                                line = reader.readLine();
                                if (line.trim().startsWith("ITEM_TYPE ")) {
                                    if (line.trim().substring(10).trim().equals("motherboard")) {
                                        product = new motherboards();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){     //Epanalambanetai mexri na diabastoun ola ta xarakthristika
                                            rf2.read(line, reader,product);                   // stelnoyme th grammh, ton basiko reader kai th pwlhsh gia na diabastoyn ta basika xarakthristika tou
                                            rf2.readMotherboard(line, reader, product);       // na diabastoyn ta eidika xarakthristika tous
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();                        //diabazetai h epomenh grammh | Ta tags mporoun na exoun opoiadhpote seira giauto mpainoyn se epanalhpsh 
                                        }
                                    }else if (line.trim().substring(10).trim().equals("CPU")) {
                                        product = new CPU();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readCPU(line, reader, product);
                                            rf2.readSold(line, reader, sold); 
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("HardDrive")) {
                                        product = new HardDrive();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readHD(line, reader, product);
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("RAM")) {
                                        product = new RAM();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readRAM(line, reader, product);
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("graphicsCard")) {
                                        product = new graphicsCard();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readGC(line, reader, product);
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();
                                        }
                                    }else if (line.trim().substring(10).trim().equals("screen")) {
                                        product = new screen();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readScreen(line, reader, product);
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Keyboard")) {
                                        product = new Keyboard();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            if (line.trim().startsWith("CONNECTION "))
                                            ((Keyboard) product).setConnection(line.substring(11).trim());
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Mouse")) {
                                        product = new Mouse();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readMouse(line, reader, product);
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();
                                        }
                                    } else if (line.trim().substring(10).trim().equals("Printer")) {
                                        product = new Printer();
                                        line = reader.readLine();
                                        while(line.trim().equals("}") == false){
                                            rf2.read(line, reader,product);
                                            rf2.readPrinter(line, reader, product);
                                            rf2.readSold(line, reader, sold);
                                            line = reader.readLine();
                                        }
                                        
                                    }
                                        int i = 0;
                                        boolean flag = false;
                                        while(i < availableProducts.size()){
                                            if((availableProducts.get(i).toString()).equals(product.toString())){
                                                sold.setProduct(product);
                                                SoldProduct.add(sold);
                                                flag = true;
                                            }
                                            i++;
                                        }
                                        if(!flag){
                                            
                                            System.out.println("The sale with code: "+ sold.getScode()+" is not available.");
                                        }
                                }              
                            }
                        }
                        else{                                      //An to j != 3 tote leipei kapoio apo ta basika tags kai h pwlhsh agnoeitai
                            while (line.trim().equals("}") == false){
                                line = reader.readLine();               // diabazoume tis grammes ths pwlhshs poy agnoeitai gia na synexisoume me thn epomenh
                            }
                            System.out.println("Error: Missing characteristics (Price/Model/Item type) in Sold File");
                        }
                    }//if
                } //Order
                line = reader.readLine();  //Diabazetai h epomenh grammmh tou basikoy reader
                l1 = reader2.readLine();   // Akolou8ei o seconadery reader
            }//while
            reader.close();
            
        } //try
    
        catch (IOException e) {
            System.out.println	("Error reading line ...");
        }
    
    }
                                    
                                    
                                        

    public ArrayList<Products> getavailableList() {
        
        return availableProducts;
    }
    public ArrayList<Ordered> getOrderedList() {
        
        return OrderedProduct;
    }
    public ArrayList<Sold> getSoldList() {
        
        return SoldProduct;
    }

}


class ReadFile2 {

    //ArrayList<String> data;

    ReadFile2(){}

    public Products read(String line, BufferedReader reader, Products product){
            if (line.trim().startsWith("MODEL "))
                product.setName(line.substring(6).trim());
            if (line.trim().startsWith("MODEL_YEAR "))
                product.setYear(Integer.parseInt(line.trim().substring(11).trim()));
            if (line.trim().startsWith("MANUFACTURER "))
                product.setConstructor(line.substring(13).trim());
            if (line.trim().startsWith("PRICE "))
                product.setPrice(Double.parseDouble(line.substring(6).trim()));
            if (line.trim().startsWith("PIECES "))
                product.setapo8ema(Integer.parseInt(line.substring(7).trim()));
        return product;
    }

    public Ordered readO(String line, BufferedReader reader, Ordered ordered){
            if (line.trim().startsWith("NUMBER "))
                ordered.setOrderCode(Integer.parseInt(line.substring(7).trim()));
            if (line.trim().startsWith("NAME "))
                ordered.setName(line.trim().substring(5).trim());
            if (line.trim().startsWith("PHONE "))
                ordered.setPhone(line.substring(6).trim());
            if (line.trim().startsWith("ORDERED_DATE "))
                ordered.setDateoforder(line.substring(13).trim());
            if (line.trim().startsWith("EXPECTED_DATE "))
                ordered.setExpectedDate(line.substring(14).trim());
            if (line.trim().startsWith("KATASTASH_PARAGGELIAS "))
                ordered.setKatastash(line.substring(22).trim());
        return ordered;
    }
    public Sold readSold(String line, BufferedReader reader,Sold sold){
        if (line.trim().startsWith("NUMBER "))
            sold.setSoldCode(Integer.parseInt(line.substring(7).trim()));
        if (line.trim().startsWith("NAME "))
            sold.setName(line.trim().substring(5).trim());
        if (line.trim().startsWith("PHONE "))
            sold.setPhone(line.substring(6).trim());
        if (line.trim().startsWith("SALE_DATE "))
            sold.setDateofSale(line.substring(10).trim());
    return sold;
    }
    public Products readMotherboard(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("MEMORY "))
            ((motherboards) product).setMemory(Integer.parseInt(line.substring(7).trim()));
        if (line.trim().startsWith("NUMBER_OF_GATES "))
            ((motherboards) product).setGate(Integer.parseInt(line.substring(16).trim()));
        if (line.trim().startsWith("PROCESSOR "))
            ((motherboards) product).setProcessor(line.substring(10).trim());
        return product;
    }
    public Products readCPU(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("CORE "))
            ((CPU) product).setCore(Integer.parseInt(line.substring(5).trim()));
        if (line.trim().startsWith("BUILT_IN_GRAPHICS "))
            ((CPU) product).setBuiltInGraphics(Boolean.parseBoolean(line.substring(18).trim()));
        if (line.trim().startsWith("VELOCITY "))
            ((CPU) product).setVelocity(line.substring(9).trim());
        return product;
    }
    public Products readHD(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("TYPE "))
            ((HardDrive) product).setType(line.substring(5).trim());
        if (line.trim().startsWith("SIZE "))
            ((HardDrive) product).setSize(line.substring(5).trim());
        if (line.trim().startsWith("CAPACITY "))
            ((HardDrive) product).setCapacity(line.substring(9).trim());
        return product;
    }
    public Products readRAM(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("TYPE "))
            ((RAM) product).setType(line.substring(5).trim());
        if (line.trim().startsWith("SIZE "))
            ((RAM) product).setSize(Integer.parseInt(line.substring(5).trim()));
        if (line.trim().startsWith("FREQUENCY "))
            ((RAM) product).setFrequency(Integer.parseInt(line.substring(10).trim()));
        return product;
    }
    public Products readGC(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("CHIPSET "))
            ((graphicsCard) product).setChipset(line.substring(8).trim());
        if (line.trim().startsWith("MEMORY "))
            ((graphicsCard) product).setMemory(Integer.parseInt(line.substring(7).trim()));
        return product;
    }
    public Products readScreen(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("SIZE "))
            ((screen) product).setSize(Integer.parseInt(line.substring(5).trim()));
        if (line.trim().startsWith("PORT "))
            ((screen) product).setPort(line.substring(5).trim());
        if (line.trim().startsWith("ANALYSH "))
            ((screen) product).setAnalysh(line.substring(8).trim());
        if (line.trim().startsWith("KIND "))
            ((screen) product).setKind(line.substring(5).trim());
        return product;
    }
    public Products readMouse(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("LASER "))
            ((Mouse) product).setLaser(line.substring(6).trim());
        if (line.trim().startsWith("CONNECTION "))
        ((Mouse) product).setConnection(line.substring(11).trim());
        return product;
    }
    public Products readPrinter(String line, BufferedReader reader, Products product){
        if (line.trim().startsWith("COLOR "))
            ((Printer) product).setColor(line.substring(6).trim());
        if (line.trim().startsWith("LASER "))
            ((Printer) product).setLaser(line.substring(6).trim());
        return product;
    }
            
}