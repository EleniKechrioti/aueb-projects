/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

class Account {
	
	// Data
   	private /* Fill your code here */ final double RATE = 0.015;
	private /* Fill your code here */ String name;
   	private /* Fill your code here */ String acctNumber;
   	private /* Fill your code here */ double balance;
   	
	// Constructors
   	Account (/* Fill your code here */String acctNumber, String name, double balance) {
		// Fill your code here
		this.name = name;
		this.acctNumber = acctNumber;
		this.balance = balance;
   	}
	
	Account (/* Fill your code here */ String acctNumber, String name) {
		// Fill your code here
		this.name = name;
		this.acctNumber = acctNumber;
		this.balance = 0;
   	}
	
	// Methods
   	double deposit (/* Fill your code here */ double amount){
		// Fill your code here
		System.out.println("\nDeposit @ Account " + acctNumber);
		System.out.println("Requested: " + String.format("%.2f",amount).replace('.',','));
		if (amount < 0) {
			System.out.println("Error: Deposit amount is invalid.");
		}
		else {
			this.balance = balance + amount;
		}
		System.out.println("New Balance " + String.format("%.2f",balance).replace('.',','));
		return balance;
	}

	double withdraw (/* Fill your code here */ double amount) {
		// Fill your code here
		System.out.println("\nwithDraw @ Account " + acctNumber);
		System.out.println("Balance " + String.format("%.2f",balance).replace('.',','));
		System.out.println("Requested: " + String.format("%.2f",amount).replace('.',','));
		if  ( amount < 0) {
			System.out.println("Error: Withdraw amount is invalid.");
		}
		else if (balance < amount){
			System.out.println("Error: Insufficient funds.");
		} 
		else {
			this.balance = balance - amount;
		}
		System.out.println("New Balance " + String.format("%.2f", balance).replace('.',','));
		return balance;
   	}

   	double addInterest (){
      	// Fill your code here
		balance = balance + balance*RATE ;
		return balance;
   	}

   	double getBalance (){
      	// Fill your code here
		return balance; 
   	}

   	String getAccountNumber (){
		// Fill your code here
		return acctNumber;
   	}

   	public String toString(){
      	// Fill your code here
		String b = String.format("%.2f", balance).replace('.',',');
		return "\n\nAccount Number:" + acctNumber + "\nName:" + name + "\nBalance:" + b;
   	}
}

