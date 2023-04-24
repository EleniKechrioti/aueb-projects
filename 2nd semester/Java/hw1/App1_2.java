/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

import java.util.Scanner;

class App1_2 {
	
		
    // Fill your code here (Factorial Method)
	static long factorial (int n){
		long result = 1;
		for ( int i =n; i>1; i--){
			result *=i;
		}
		return result;
	}	
  	
	public static void main(String args[]){
		
		// Fill your code here 
     	Scanner in = new Scanner(System.in);
		System.out.print("Dwse ena mh arnhtiko ari8mo: ");
		int n = in.nextInt();
		System.out.println("Factorial = " + factorial(n));
   	}

}





