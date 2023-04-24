/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

abstract class Animal {
	
	String name;
	static int animals = 0;
	
	public Animal(String n) {
		this.name = n;
		animals++;
	}
	
	abstract void speak();
	
	static int numberOfAnimals() {
		return animals;
	}

}

class Dog extends Animal {
	String sound = "woof";
	static int dogs = 0;

	// Fill your code here

	Dog(String name) {
		super(name);
		dogs++;
	}

	static int numberOfDogs() {
		return dogs;
	}
	void speak() {
		System.out.println(name + ": " +  sound);
	}

}

class Cat extends Animal {
	String sound = "miaou";
	static int cats = 0;

	// Fill your code here

	Cat( String name) {
		super(name);
		cats++;
	}

	static int numberOfCats() {
		return cats;
	}

	void speak() {
		System.out.println(name + ": " +  sound);
	}
}

class App4 {

	public static void main(String[] args) {
		Animal[] animal = {	new Cat("stella"), new Cat("ziggy"), new Dog("azor")};
		System.out.println("Cats: "+Cat.numberOfCats());
		System.out.println("Dogs: "+Dog.numberOfDogs());
		System.out.println("Animals: "+Animal.numberOfAnimals());
		for ( int i = 0; i < animal.length; i++ )
			animal[i].speak();
	}
}
