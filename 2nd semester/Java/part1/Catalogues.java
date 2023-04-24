

import java.util.ArrayList;

public class Catalogues{

    
    public ArrayList<Products> availableProduct;
    public ArrayList<Sold> SoldProduct;
    public ArrayList<Ordered> OrderedProduct;
    private double price;

    Catalogues(){
        availableProduct = new ArrayList<Products>();
        SoldProduct = new ArrayList<Sold>();
        OrderedProduct = new ArrayList<Ordered>();
    }


    public void CatalogueForSale(){
        availableProduct.add(new motherboards("INTEL H342", 2015, "Asus", 135, "intel",  32, 4));
        availableProduct.add(new motherboards("INTEL G687", 2017, "Asus", 145, "intel",  32, 6));
        availableProduct.add(new motherboards("GIGABYTE AM5 Ryzen 2000", 2019, "GIGABYTE", 268, "amd", 128, 4));
        availableProduct.add(new motherboards("GIGABYTE AM4 Ryzen 2000", 2020, "GIGABYTE", 145, "amd",  128, 6));
        availableProduct.add(new CPU("AMD RYZEN 5",2020, "AMD" ,207.8, "2.8", 6, true));
        availableProduct.add(new CPU("Intel Core i5",2020, "Intel", 280.9, "3.3", 6, true));
        availableProduct.add(new CPU("AMD RYZEN 5",2021, "AMD", 193.2 , "4.1", 6, true));
        availableProduct.add(new CPU("Intel Core i5",2020, "Intel",180.0, "4.1", 16, false));
        availableProduct.add(new RAM("Crusial",2018,"Crusial",30.3, "DDR3", 4, 1600));
        availableProduct.add(new RAM("Patriot Viper Steel",2020,"Patriot", 47.5, "DDR3", 8, 3200));
        availableProduct.add(new RAM("Crusial",2018,"Crusial",58.3, "DDR4", 16, 2666));
        availableProduct.add(new RAM("Corsair Vengeance RGB Pro",2021, "Corsair",80.5, "DDR5", 16, 3200));
        availableProduct.add(new graphicsCard("Gigabyte GeForce GTX 1660",2020,"Gigabyte",305.8, "Nvidia", 12));
        availableProduct.add(new graphicsCard("Gigabyte GeForce RTX 3070",2020,"Gigabyte",778.9, "Nvidia", 6));   
        availableProduct.add(new graphicsCard("Sapphire Radeon RX 6600", 2021, "Sapphire",371.5, "amd", 12));           
        availableProduct.add(new graphicsCard("MSI Radeon RX 6600 XT ", 2019, "MSI",620, "amd", 8)); 
        availableProduct.add(new HardDrive("Western Digital Blue",2019,"Western Digital",39.9, "HDD", "1.8", "1TB" ));
        availableProduct.add(new HardDrive("Toshiba P300", 2021, "Toshiba",30.0, "HDD", "3.5", "2TB" ));
        availableProduct.add(new HardDrive("Samsung 870 Evo",2020,"Samsung",46.5, "SSD", "1.8", "256GB" )); 
        availableProduct.add(new HardDrive("Samsung 970 Evo Plus",2021,"Samsung",56.5, "SSD", "2.5", "1TB" ));
        availableProduct.add(new HardDrive("Kingston A400",2021,"Kingston",26.9, "SSD", "3.5", "256GB" ));
        availableProduct.add(new screen("Samsung C24F390FHR VA Curved Monitor",2020,"Samsung",199.9, "Monitor", 24, "1920x1080", "Display Port" ));
        availableProduct.add(new screen("Samsung Odyssey G5",2019,"Samsung",293.0, "Monitor", 27, "1920x1080", "HDMI" ));
        availableProduct.add(new Keyboard("Logitech MK295 Silent",2020,"Logitech",32.0, "wired"));
        availableProduct.add(new Keyboard("Dell KB216",2021, "Dell",11.2, "wireless"));
        availableProduct.add(new Mouse("Xiaomi Mi Dual Mode",2020,"Xiaomi",10.3, "laser", "wired"));
        availableProduct.add(new Mouse("Logitech Pebble M350",2022,"Logitech",17.5, "laser", "wireless"));
        availableProduct.add(new Mouse("Powertech PT-806",2021,"Powertech", 5.6, "optical", "wired"));
        availableProduct.add(new Printer("HP DeskJet 2721e AiO",2021,"HP", 59.9, "laser", "color"));
        availableProduct.add(new Printer("Xerox B230V/DNI",2022,"Xerox",116.3, "laser", "black and white"));
    }


    public ArrayList<Products> getavailableList() {
        
        return availableProduct;
    }

    public ArrayList<Ordered> getOrderedList() {
        
        return OrderedProduct;
    }
    public ArrayList<Sold> getSoldList() {
        
        return SoldProduct;
    }

    
    public void CatalogueOrdered(Ordered p){
        OrderedProduct.add(p);


    }

    public void CatalogueSold(Sold p){
        SoldProduct.add(p);
    }

    
}