/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

class Student {
	
	private String Name;
	private String RN;
	private int Grade;
	
	public Student(String Name, String RN, int Grade){
		// Fill your code here
		this.Name = Name;
		this.RN = RN;
		this.Grade = Grade;
	}
	
	// Fill your code here
	
	public int getGrade() {
		return Grade;
	}
	public String getRN() {
		return RN;
	}
	
	public String toString() {
		return "Student Name: " + Name + " Record Number: " + RN + " Grade: " + Grade;
	}
	
}// Student
