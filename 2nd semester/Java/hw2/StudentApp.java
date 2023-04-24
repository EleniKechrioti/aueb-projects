/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

import java.util.Scanner;

class StudentApp {

	public static void main (String args[]) {
		
		StudentList Lesson = /* Fill your code here */ new StudentList();
		
		
		// Fill your code here
		
     	Scanner in = new Scanner(System.in);

		for (;;) {
			System.out.println ("1. Insert Student");
			System.out.println ("2. Lookup Student");
			System.out.println ("3. Display List");
			System.out.println ("0. Exit");
			
			// Fill your code here
			System.out.print("\nEnter a number: ");
			int answer = in.nextInt();
			in.nextLine();
			if (answer == 1){
				System.out.println("Give the name, RN and grade of the student");
				String name = in.nextLine();
				String rn =  in.next();
				int grade = in.nextInt();
				in.nextLine();
				Student s = new Student(name, rn, grade);
				Lesson.InsertStudent(s);
			}
			else if ( answer == 2) {
				System.out.print("\nEnter the RN: ");
				String rn = in.nextLine();
				Lesson.LookupStudent(rn);
			}
			else if ( answer == 3) {
				System.out.println("-------------------------------\n");
				Lesson.DisplayList();
				System.out.println("\n-------------------------------");
			}
			else {
				break;
			}
			
		}// for
		
	} //main
	
}//StudentApp
