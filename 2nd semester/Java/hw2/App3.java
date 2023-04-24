/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

class Shape { 
	void draw() {}
	void erase() {} 
}
class Circle extends Shape {
	void draw() { 
		System.out.println("Circle.draw()"); 
	}
	void erase() { 
		System.out.println("Circle.erase()"); 
	}
}
class Square extends Shape {
	void draw() { 
		System.out.println("Square.draw()"); 
	}
	void erase() { 
		System.out.println("Square.erase()"); 
	}
}
class Triangle extends Shape {
	void draw() { 
		System.out.println("Triangle.draw()"); 
	}
	void erase() { 
		System.out.println("Triangle.erase()");
	}
}
class App3 {
	static Shape randShape() {
		switch((int)(Math.random() * 3)) {
			default:
			case 0: return new Circle();
			case 1: return new Square();
			case 2: return new Triangle();
		}
	}
	public static void main(String[] args) {
		
		Shape a[] = new Shape[10];// Fill your code here
     
		for (int i = 0; i<10; i++){ /* Fill your code here*/

			a[i] = randShape(); // Fill your code here
     	}
		for (int i = 0; i <10; i++) { /* Fill your code here*/
		
			a[i].draw(); // Fill your code here
		}
  }		
} 




