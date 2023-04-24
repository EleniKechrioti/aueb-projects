/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

class App4 {

	public static void main(String args[]){
		
		// Fill your code here
		int fib1 = 0, fib2 = 1, fib;
		boolean flag = false;
		int number = Integer.parseInt(args[0]);
		if ((number == 0) || (number == 1)) {
			flag = true;
		}
		if ( number >= 2); {
			while(true) {
				fib = fib1 + fib2;
				System.out.println("Fibonacci number = " + fib);
				if (number == fib) {
					flag = true;
				}
				fib1 = fib2;
				fib2 = fib;
				if (fib >= number) break;
			}
		}
		if (flag == true) {
			System.out.print(number + " is a fibonacci number");
		}
		else {
			System.out.print(number + " is not a fibonacci number");
		}
	}
}

