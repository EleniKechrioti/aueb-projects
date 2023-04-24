/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

import java.util.Scanner;

class App3 {
	
	public static void main(String args[]){
	
		// Fill your code here
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		float a = in.nextFloat();
		System.out.print("Enter the second number: ");
		float b = in.nextFloat();
		System.out.print("Enter the third number: ");
		float c = in.nextFloat();
		float s;
		s = b * b - 4*a*c;
		if (s >= 0) {
			float s1 =(float) (-b + Math.sqrt(s))/(2*a);
			float s2 = (float) (-b - Math.sqrt(s))/(2*a);
			System.out.printf("The first solution is : %11.3f\n" , s1);
			System.out.printf("The second solution is: %11.3f\n" , s2);
		}
		else {
			System.out.println("There are no real values for the quadratic equation.");
		}
	}
		
}


