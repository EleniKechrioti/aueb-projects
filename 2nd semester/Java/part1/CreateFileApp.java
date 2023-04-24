import java.util.*;
import java.io.*;

class UpdateFile {
	
	public ArrayList <Products> availableProduct = new ArrayList<Products>();
    public ArrayList<Sold> SoldProduct = new ArrayList<Sold>();
    public ArrayList<Ordered> OrderedProduct = new ArrayList<Ordered>();

	UpdateFile(){}
	
	public void CreateFile () {
		
		System.out.println(" >>>>>>> Write data from ARRAYLIST to FILE...");
		
		FileWriter writer = null;
		FileWriter writerO = null;
		FileWriter writerS = null;

		try	{
			writer = new FileWriter(new File("availableProducts.txt"));
			writerO = new FileWriter(new File("OrderedProducts.txt"));
			writerS = new FileWriter(new File("SoldProducts.txt"));
			writer.write ("Products_list"+"\n"+"{"+"\n"+"\t");
			writerO.write ("Order_list"+"\n"+"{"+"\n"+"\t");
			writerS.write("Sold_list"+"\n"+"{"+"\n"+"\t");
		
			for (Products product: availableProduct) {

				if (product instanceof motherboards) {
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE motherboard "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"PROCESSOR " + ((motherboards)product).getProcessor()
                                + "\n"+"\t"+"MEMORY " + ((motherboards)product).getMemory()
                                + "\n"+"\t"+"NUMBER_OF_GATES " + ((motherboards)product).getGate()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");

                   
				}else if(product instanceof CPU) { 
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE CPU "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"CORE " + ((CPU)product).getcore()
                                + "\n"+"\t"+"BUILT-IN_GRAPHICS " + ((CPU)product).getbuiltInGraphics()
                                + "\n"+"\t"+"VELOCITY " + ((CPU)product).getvelocity()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}else if(product instanceof HardDrive){
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE HardDrive "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"TYPE " + ((HardDrive)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((HardDrive)product).getsize()
                                + "\n"+"\t"+"CAPACITY " + ((HardDrive)product).getcapacity()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}else if (product instanceof RAM){
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE RAM "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"TYPE " + ((RAM)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((RAM)product).getsize()
								+ "\n"+"\t"+"FREQUENCY " + ((RAM)product).getfrequency()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}else if(product instanceof graphicsCard){
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE graphicsCard "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"CHIPSET " + ((graphicsCard)product).getchipset()
                                + "\n"+"\t"+"MEMORY " + ((graphicsCard)product).getmemory()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}else if(product instanceof screen){
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE screen "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"SIZE " + ((screen)product).getsize()
                                + "\n"+"\t"+"PORT " + ((screen)product).getport()
								+ "\n"+"\t"+"ANALYSH " + ((screen)product).getanalysh()
                                + "\n"+"\t"+"KIND " + ((screen)product).getkind()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}else if(product instanceof Keyboard){
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE Keyboard "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"CONNECTION " + ((Keyboard)product).getconnection()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}else if(product instanceof Mouse){
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE Mouse "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
                                + "\n"+"\t"+"LASER " + ((Mouse)product).getlaser()
                                + "\n"+"\t"+"CONNECTION " + ((Mouse)product).getconnection()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}else if(product instanceof Printer){
					writer.write ("Product"+"\n"+"{"+"\n"+"\t"+"ITEM_TYPE Printer "+"\n"+"\t"+"MODEL "+ product.getModel()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"PRICE "	+ product.getprice()
								+ "\n"+"\t"+"COLOR "	+ ((Printer)product).getcolor()
                                + "\n"+"\t"+"LASER " + ((Printer)product).getlaser()
                                + "\n"+"\t"+"PIECES " + product.getapo8ema()
								+ "\n"+"}"+"\n");
				}
			}
			for (Ordered product: OrderedProduct) {

				if (product.getProduct() instanceof motherboards) {
					writerO.write ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE motherboard "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"PROCESSOR " + ((motherboards)product).getProcessor()
                                + "\n"+"\t"+"MEMORY " + ((motherboards)product).getMemory()
                                + "\n"+"\t"+"NUMBER_OF_GATES " + ((motherboards)product).getGate()
								+ "\n"+"}"+"\n");

                   
				}else if(product.getProduct() instanceof CPU) { 
					writerO.write ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE CPU "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"TYPE " + ((HardDrive)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((HardDrive)product).getsize()
                                + "\n"+"\t"+"CAPACITY " + ((HardDrive)product).getcapacity()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof HardDrive){
					writerO.write  ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE HardDrive "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"TYPE " + ((HardDrive)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((HardDrive)product).getsize()
                                + "\n"+"\t"+"CAPACITY " + ((HardDrive)product).getcapacity()
								+ "\n"+"}"+"\n");
				}else if (product.getProduct() instanceof RAM){
					writerO.write  ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE RAM "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"TYPE " + ((RAM)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((RAM)product).getsize()
								+ "\n"+"\t"+"FREQUENCY " + ((RAM)product).getfrequency()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof graphicsCard){
					writerO.write  ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE graphicsCard "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"CHIPSET " + ((graphicsCard)product).getchipset()
                                + "\n"+"\t"+"MEMORY " + ((graphicsCard)product).getmemory()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof screen){
					writerO.write  ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE screen "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"SIZE " + ((screen)product).getsize()
                                + "\n"+"\t"+"PORT " + ((screen)product).getport()
								+ "\n"+"\t"+"ANALYSH " + ((screen)product).getanalysh()
                                + "\n"+"\t"+"KIND " + ((screen)product).getkind()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof Keyboard){
					writerO.write  ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE Keyboard "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"CONNECTION " + ((Keyboard)product).getconnection()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof Mouse){
					writerO.write  ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE Mouse "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"LASER " + ((Mouse)product).getlaser()
                                + "\n"+"\t"+"CONNECTION " + ((Mouse)product).getconnection()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof Printer){
					writerO.write  ("Order"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getCode()
								+ "\n"+"\t"+"ITEM_TYPE Printer "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofOrder()
								+ "\n"+"\t"+"EXPECTED_DATE " + product.getexpectedDate()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"COLOR "	+ ((Printer)product).getcolor()
                                + "\n"+"\t"+"LASER " + ((Printer)product).getlaser()
								+ "\n"+"}"+"\n");
				}
			}
			writerS.write ("Sales_list"+"\n"+"{"+"\n"+"\t");
			for (Sold product: SoldProduct) {

				if (product.getProduct() instanceof motherboards) {
					writerS.write ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE motherboard "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"PROCESSOR " + ((motherboards)product).getProcessor()
                                + "\n"+"\t"+"MEMORY " + ((motherboards)product).getMemory()
                                + "\n"+"\t"+"NUMBER_OF_GATES " + ((motherboards)product).getGate()
								+ "\n"+"}"+"\n");

                   
				}else if(product.getProduct() instanceof CPU) { 
					writerS.write ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE CPU "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"TYPE " + ((HardDrive)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((HardDrive)product).getsize()
                                + "\n"+"\t"+"CAPACITY " + ((HardDrive)product).getcapacity()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof HardDrive){
					writerS.write  ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE HardDrive "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"TYPE " + ((HardDrive)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((HardDrive)product).getsize()
                                + "\n"+"\t"+"CAPACITY " + ((HardDrive)product).getcapacity()
								+ "\n"+"}"+"\n");
				}else if (product.getProduct() instanceof RAM){
					writerS.write  ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE RAM "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"TYPE " + ((RAM)product).gettype()
                                + "\n"+"\t"+"SIZE " + ((RAM)product).getsize()
								+ "\n"+"\t"+"FREQUENCY " + ((RAM)product).getfrequency()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof graphicsCard){
					writerS.write  ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE graphicsCard "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"CHIPSET " + ((graphicsCard)product).getchipset()
                                + "\n"+"\t"+"MEMORY " + ((graphicsCard)product).getmemory()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof screen){
					writerS.write  ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE screen "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"SIZE " + ((screen)product).getsize()
                                + "\n"+"\t"+"PORT " + ((screen)product).getport()
								+ "\n"+"\t"+"ANALYSH " + ((screen)product).getanalysh()
                                + "\n"+"\t"+"KIND " + ((screen)product).getkind()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof Keyboard){
					writerS.write  ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE Keyboard "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"CONNECTION " + ((Keyboard)product).getconnection()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof Mouse){
					writerS.write  ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE Mouse "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
                                + "\n"+"\t"+"LASER " + ((Mouse)product).getlaser()
                                + "\n"+"\t"+"CONNECTION " + ((Mouse)product).getconnection()
								+ "\n"+"}"+"\n");
				}else if(product.getProduct() instanceof Printer){
					writerS.write  ("Sale"+"\n"+"{"+"\n"+"\t"
								+"NUMBER "+ product.getScode()
								+ "\n"+"\t"+"ITEM_TYPE Printer "+"\n"+"\t"+"MODEL "+ product.getProduct().getModel()
								+ "\n"+"\t"+"NAME " + product.getName()
								+ "\n"+"\t"+"PHONE " + product.getphone()
								+ "\n"+"\t"+"ORDERED_DATE " + product.getDateofSale()
								+ "\n"+"\t"+"PIECES " + product.getProduct().getapo8ema()
								+ "\n"+"\t"+"PRICE "	+ product.getProduct().getprice()
								+ "\n"+"\t"+"MODEL_YEAR "+ product.getYear()
								+ "\n"+"\t"+"MANUFACTURER "	+ product.getConstructor()
								+ "\n"+"\t"+"COLOR "	+ ((Printer)product).getcolor()
                                + "\n"+"\t"+"LASER " + ((Printer)product).getlaser()
								+ "\n"+"}"+"\n");
			
				}
			}
			writerS.write("}");
			writer.write("}");
			writerO.write("}");
				
				writer.close();
				writerO.close();
				writerS.close();
					
			}//try
		
			catch (IOException e) {
				System.err.println("Error writing file.");
			}
	}

	
}