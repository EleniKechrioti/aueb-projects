
class motherboards extends Products {
    
    private String processor, category;
    private int gate, memory, apo8ema;

    motherboards(){}

    motherboards(String name, int year, String constructor, double price,String processor, int memory, int gate) {
        super(name,year,constructor,price);
        this.processor = processor;
        this.memory = memory;
        this.gate = gate;
        this.category = "E";
    }
    public void setProcessor(String processor){
        this.processor = processor;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }
    public void setGate(int gate) {
        this.gate = gate;
    }
    public String getProcessor(){
        return processor;
    }
    public int getMemory(){
        return memory;
    }
    public int getGate(){
        return gate;
    }


    public String toString(){
        return super.toString() +" Epejergasths: " + processor + " | Mnhmh: " + memory + " | Ari8mos 8urwn: " + gate;
    }
  
}// Motherboards

class CPU extends Products {
    
    private int core;
    private boolean builtInGraphics;
    private String velocity, category;

    CPU(){}
    
    CPU(String name, int year, String constructor, double price,String velocity,int core,boolean builtInGraphics) {
        super(name,year,constructor,price);
        this.core = core;
        this.builtInGraphics = builtInGraphics;
        this.velocity = velocity;
        this.category = "E";
    }

    public void setVelocity(String velocity){ this.velocity = velocity;}

    public void setCore(int core) {
        this.core = core;
    }
    public void setBuiltInGraphics(boolean builtInGraphics) {
        this.builtInGraphics = builtInGraphics;
    }
    public int getcore(){
        return core;
    }
    public String getvelocity(){
        return velocity;
    }
    public boolean getbuiltInGraphics(){
        return builtInGraphics;
    }

    public String toString(){
        return super.toString() + " Purhnas: "+ core + " | Built-in graphics: "+ builtInGraphics + " | Taxuthta: "+velocity;
    }
}// CPU

class HardDrive extends Products {
    
    private String type, size, capacity, category;

    HardDrive(){}

    HardDrive(String name, int year, String constructor, double price,String type, String size, String capacity) {
        super(name,year,constructor,price);
        this.type = type;
        this.size = size;
        this.capacity = capacity;
        this.category = "E";
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public String gettype(){
        return type;
    }
    public String getsize(){
        return size;
    }
    public String getcapacity(){
        return capacity;
    }
    public String toString(){
        return super.toString() + " Typos: "+ type + " | Mege8os: "+ size + " | Xwrhtikothta: "+ capacity;
    }
    
}// Hard Drive

class RAM extends Products {
    
    private String type, category;
    private int size, frequency;

    RAM(){}

    RAM(String name, int year, String constructor, double price,String type,int size,int frequency){
        super(name,year,constructor,price);
        this.type = type;
        this.size = size;
        this.frequency = frequency;
        this.category = "E";
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String gettype(){
        return type;
    }
    public int getsize(){
        return size;
    }
    public int getfrequency(){
        return frequency;
    }

    public String toString(){
        return super.toString() + " Typos: "+ type + " | Mege8os: "+ size + " | Suxnothta: "+ frequency;
    }
}// RAM

class graphicsCard extends Products {
    private String chipset, category;
    private int memory;

    graphicsCard(){}

    graphicsCard(String name, int year, String constructor, double price,String chipset,int memory){
        super(name,year,constructor,price);
        this.chipset = chipset;
        this.memory = memory;
        this.category = "E";
    }    

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }
    public String getchipset(){
        return chipset;
    }
    public int getmemory(){
        return memory;
    }

    public String toString(){
        return super.toString() + " Chipset: "+ chipset + " | Mnhmh: "+ memory;   //+apo8ema
    }
}// Graphics Card

class screen extends Products {
    
    private String kind, port, analysh, category; 
    private int size;

    screen(){}
    screen(String name, int year, String constructor, double price, String kind, int size, String analysh, String port){
        super(name,year,constructor,price);
        this.size = size;
        this.port = port;
        this.analysh = analysh;
        this.kind = kind;
        this.category = "P";
    }
    public void setAnalysh(String analysh) {
        this.analysh = analysh;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getsize(){
        return size;
    }
    public String getport(){
        return port;
    }
    public String getanalysh(){
        return analysh;
    }
    public String getkind(){
        return kind;
    }
    public String toString(){
        return super.toString() + " Eidos: "+ kind + " | Diastash o8onhs: "+ size + " | Analush: "+ analysh +" | 8ures: "+ port;   //+apo8ema
    }



}// Screen

class Keyboard extends Products {
    
    private String connection, category;

    Keyboard(){}
    Keyboard(String name, int year, String constructor, double price, String connection){
        super(name,year,constructor,price);
        this.connection = connection;
        this.category = "P";
    }
    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getconnection(){
        return connection;
    }

    public String toString(){
        return super.toString() + " Syndesh: "+ connection;   //+apo8ema
    }

}// Keyboard

class Mouse extends Products {
    
    private String laser, connection, category;

    Mouse(){}
    Mouse(String name, int year, String constructor, double price, String laser, String connection){
        super(name,year,constructor,price);
        this.connection = connection;
        this.laser = laser;
        this.category = "P";
    }
    public void setLaser(String laser) {
        this.laser = laser;
    }
    public void setConnection(String connection) {
        this.connection = connection;
    }
    public String getconnection(){
        return connection;
    }
    public String getlaser(){
        return laser;
    }
    public String toString(){
        return super.toString() + " Texnologia: "+ laser + " | Sundesh: "+ connection;   
    }
}

class Printer extends Products {
    
    private String laser, color, category;

    Printer(){}
    Printer(String name, int year, String constructor, double price, String laser, String color){
        super(name,year,constructor,price);
        this.color = color;
        this.laser = laser;
        this.category = "P";
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setLaser(String laser) {
        this.laser = laser;
    }
    public String getcolor(){
        return color;
    }
    public String getlaser(){
        return laser;
    }

    public String toString(){
        return super.toString() + " Texnologia: "+ laser + " | Tupos ektupwth: "+ color;   
    }
}