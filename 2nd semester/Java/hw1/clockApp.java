/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/


import java.util.concurrent.TimeUnit;

public class clockApp {
	
	public static void main (String args[]) throws Exception{
		
		// Fill your code here
		Clock digclock = new Clock();
		digclock.setHour(16);
		digclock.setMin(28);
		digclock.setSec(58);
		System.out.println(digclock.toString());
		for (int i = 0; i<180; i++){
			TimeUnit.SECONDS.sleep(1);
			digclock.tick();
			System.out.println(digclock.toString()); 
		}
		
	}
}



