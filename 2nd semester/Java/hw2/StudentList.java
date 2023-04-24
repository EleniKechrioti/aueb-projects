/*
	Name: KECHRIOTI ELENI 
	Student Number: 3210078
*/

class StudentList {
	
	private Student [] myList = new Student[50];// Fill your code here
	
	private int length = 0;
	private String Name, RN;
	private int Grade;
	private boolean flag;
	
	void InsertStudent(Student newStudent){
		
		// Fill your code here
		myList[length] = newStudent;
		length++;
		
	}//InsertStudent
	
	
	void LookupStudent(String RN) {
		
		// Fill your code here
		int i = 0;
		flag = false;
		while (i >= 0 & myList.length > i & flag == false) {
			if (RN.equals(myList[i].getRN()) ) {
						System.out.println("O ba8mos tou ma8hth me AM " + myList[i].getRN() + " einai " + myList[i].getGrade());
						flag = true;
			}
			i++;
		}
		if (!flag){ 
			System.out.println("O ma8hths den yparxei");
		}
	}//LookupStudent
	
	
	void DisplayList() {
		
		// Fill your code here
		int j = 0;
		while ( j >= 0 & j < myList.length ) {
			if (myList[j] != null) {
				System.out.println((myList[j]).toString());
			}
			j++; 
		}
		
			
	}//DisplayList
	
}//StudentList	