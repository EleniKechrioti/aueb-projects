/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

import java.util.concurrent.TimeUnit;

class AMPMClockApp {
	
	public static void main (String args[]) throws Exception{
		
		// Fill your code here

		AMPMClock clock = new AMPMClock();
		clock.setHour(16);
		clock.setMin(28);
		clock.setSec(58);
		System.out.println(clock.toString());
		clock.setAMPM(true);
		for (int i = 0; i<180; i++){
			TimeUnit.SECONDS.sleep(1);
			clock.tick();
			System.out.println(clock.toString()); 
		}

	}
}



