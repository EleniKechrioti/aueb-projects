/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/


public class bankApp  {

	public static void main(String args[]) {

    	Account acct1 = /* Fill your code here */ new Account("100-00", "Togantzi Maria", 188.46);
    	Account acct2 = /* Fill your code here */ new Account("100-01", " Kalergis Christos", 140.21);
    	Account acct3 = /* Fill your code here */ new Account("100-02", "Maras Petros");

		System.out.println ("New accounts");
		
		System.out.println (/* Fill your code here*/ acct1.toString());
		System.out.println (/* Fill your code here*/ acct2.toString());
		System.out.println (/* Fill your code here*/ acct3.toString());
		
			
		
		//Fill your code here 
		
		acct1.deposit(-10.0);
		acct2.deposit(500.1);
		acct3.withdraw(1420.75);
		acct3.withdraw(-10.0);
		acct3.withdraw(420.75);

		
		

		System.out.println ("\nadd interest ... ");
		
   		acct1.addInterest()/* Fill your code here*/;
   		acct2.addInterest()/* Fill your code here*/;
   		acct3.addInterest()/* Fill your code here*/;

		System.out.println (/* Fill your code here*/ acct1.toString());
		System.out.println (/* Fill your code here*/ acct2.toString());
		System.out.println (/* Fill your code here*/ acct3.toString());

   }

}

