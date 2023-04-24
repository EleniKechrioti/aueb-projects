
class motherboards extends Products {
    
    private String processor, category;
    private int gate, memory, apo8ema;

    motherboards(String name, int year, String constructor, double price,String processor, int memory, int gate) {
        super(name,year,constructor,price);
        this.processor = processor;
        this.memory = memory;
        this.gate = gate;
        this.category = "E";
    }


    public String toString(){
        return super.toString() +" Epejergasths: " + processor + " | Mnhmh: " + memory + " | Ari8mos 8urwn: " + gate;
    }
  
}// Motherboards

class CPU extends Products {
    
    private int core;
    private boolean builtInGraphics;
    private String velocity, category;
    
    CPU(String name, int year, String constructor, double price,String velocity,int core,boolean builtInGraphics) {
        super(name,year,constructor,price);
        this.core = core;
        this.builtInGraphics = builtInGraphics;
        this.velocity = velocity;
        this.category = "E";
    }
    public String toString(){
        return super.toString() + " Purhnas: "+ core + " | Built-in graphics: "+ builtInGraphics + " | Taxuthta: "+velocity;
    }
}// CPU

class HardDrive extends Products {
    
    private String type, size, capacity, category;

    HardDrive(String name, int year, String constructor, double price,String type, String size, String capacity) {
        super(name,year,constructor,price);
        this.type = type;
        this.size = size;
        this.capacity = capacity;
        this.category = "E";
    }
    public String toString(){
        return super.toString() + " Tupos: "+ type + " | Mege8os: "+ size + " | Xwrhtikothta: "+ capacity;
    }
    
}// Hard Drive

class RAM extends Products {
    
    private String type, category;
    private int size, frequency;

    RAM(String name, int year, String constructor, double price,String type,int size,int frequency){
        super(name,year,constructor,price);
        this.type = type;
        this.size = size;
        this.frequency = frequency;
        this.category = "E";
    }
    public String toString(){
        return super.toString() + " Tupos: "+ type + " | Mege8os: "+ size + " | Suxnothta: "+ frequency;
    }
}// RAM

class graphicsCard extends Products {
    private String chipset, category;
    private int memory;

    graphicsCard(String name, int year, String constructor, double price,String chipset,int memory){
        super(name,year,constructor,price);
        this.chipset = chipset;
        this.memory = memory;
        this.category = "E";
    }    
    public String toString(){
        return super.toString() + " Chipset: "+ chipset + " | Mnhmh: "+ memory;   //+apo8ema
    }
}// Graphics Card

class screen extends Products {
    
    private String kind, port, analysh, category; 
    private int size;

    screen(String name, int year, String constructor, double price, String kind, int size, String analysh, String port){
        super(name,year,constructor,price);
        this.size = size;
        this.port = port;
        this.analysh = analysh;
        this.kind = kind;
        this.category = "P";
    }
    public String toString(){
        return super.toString() + " Eidos: "+ kind + " | Diastash o8onhs: "+ size + " | Analush: "+ analysh +" | 8ures: "+ port;   //+apo8ema
    }



}// Screen

class Keyboard extends Products {
    
    private String connection, category;

    Keyboard(String name, int year, String constructor, double price, String connection){
        super(name,year,constructor,price);
        this.connection = connection;
        this.category = "P";
    }
    public String toString(){
        return super.toString() + " Sundesh: "+ connection;   //+apo8ema
    }

}// Keyboard

class Mouse extends Products {
    
    private String laser, connection, category;

    Mouse(String name, int year, String constructor, double price, String laser, String connection){
        super(name,year,constructor,price);
        this.connection = connection;
        this.laser = laser;
        this.category = "P";
    }
    public String toString(){
        return super.toString() + " Texnologia: "+ laser + " | Sundesh: "+ connection;   
    }
}

class Printer extends Products {
    
    private String laser, color, category;

    Printer(String name, int year, String constructor, double price, String laser, String color){
        super(name,year,constructor,price);
        this.color = color;
        this.laser = laser;
        this.category = "P";
    }
    public String toString(){
        return super.toString() + " Texnologia: "+ laser + " | Tupos ektupwth: "+ color;   
    }
}