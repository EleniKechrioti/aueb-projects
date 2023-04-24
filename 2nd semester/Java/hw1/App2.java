/*
	Name:  KECHRIOTI ELENI
	Student Number: 3210078
*/

import java.util.Scanner;

class App2 {
	
	public static void main(String args[]){
		
		// Fill your code here
		Scanner in = new Scanner(System.in);
		int x;
		System.out.print("Give a number: ");
		x = in.nextInt();
		int s = 0, items = 0, negative = 0, positive = 0, max = x, min = x;
		while (x != 0) {
			s = s + x;
			items = items + 1;
			if (x > 0) {
				positive = positive +1;
			}
			else {
				negative = negative + 1;
			}
			if (x > max) {
				max = x;
			}
			if (x < min) {
				min = x;
			}
			System.out.print("Give a number: ");
			x = in.nextInt();
		}
		float av = 0f;
		
		if (items != 0){
			float s1 = (float) s;
			float i = (float) items;
			av = s1/i;
		}
		System.out.println("----------------------------------------");
		System.out.printf("Items   : %7d\n" , items);
		System.out.printf("Average : %11.3f\n" , av);
		System.out.printf("Negative: %7d\n" , negative);
		System.out.printf("Positive: %7d\n" , positive);
		System.out.printf("Max     : %7d\n" , max);
		System.out.printf("Min     : %7d\n" , min);
		System.out.println("----------------------------------------");
   	}

}

