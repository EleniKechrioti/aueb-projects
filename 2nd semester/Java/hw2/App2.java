/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

class App2 { 

	public static void main (String args[]){	
		
	 	final int pin [] [] = new int [5] [3];  // Fill your code here
	 	
   		// Fill your code here

		pin[0][0] = 182; pin[1][0] = 145; pin[2][0] = 195; pin[3][0] = 110; pin[4][0] = 255;
		pin[0][1] = 41;  pin[1][1] = 85;  pin[2][1] = 15;  pin[3][1] = 24;  pin[4][1] = 11;
		pin[0][2] = 202; pin[1][2] = 325; pin[2][2] = 115; pin[3][2] = 407; pin[4][2] = 357;
		
		char[] Candidate = {'A', 'B', 'C'}; 

		System.out.println("------------------------------------------------------------");
		System.out.println("| Eklogikh    | Candidate A  | Candidate B  | Candidate C |");
		System.out.println("| Perifereia  |              |              |             |");
		for (int i= 0; i<=4; i++) {
			System.out.println("------------------------------------------------------------");
			System.out.println( "|      " + (i+1) + "      |      " + pin[i][0] + "     |      " + pin[i][1] + "      |      " + pin[i][2] + "    |");
		}
		System.out.println("------------------------------------------------------------");
		int s[] = new int[4];
		s[3] = 0;
		for (int i = 0; i<=2; i++){
			s[i] = 0;
			for (int j = 0; j<=4; j++){
				s[i] += pin[j][i];
			}
			s[3] += s[i];
		}
		float percentage[] = new float[3];
		boolean flag = false;
		int c = 0;
		for (int i = 0; i<=2; i++){
			percentage[i] = ((float) s[i] )/((float) s[3] )*100.0f;
			System.out.println("\nCandidate " + Candidate[i] + ": " + s[i] + " votes with " + String.format("%.2f", percentage[i]) + "%" );
			if (percentage[i] >50.0f){
				flag = true ;
				c = i;
			}
		}
		if (flag == true) {
			System.out.println("\nCandidate " + Candidate[c] + " is the winner");
		}
		else {
			System.out.println("\n8a diejax8ei epanalhptikos gyros metaju twn dyo prwtwn");
			if ( (s[0] > s[1])  &  (s[0] > s[2]) ){
				System.out.println("Candidate A: " + s[0] + "votes and with " + String.format("%.2f", percentage[0]) + "%"  );
				if (s[1] > s[2]){
					System.out.println("Candidate B: " + s[1] + "votes and with " + String.format("%.2f", percentage[1]) + "%");
				}
				else {
					System.out.println("Candidate C: " + s[2] + "votes and with " + String.format("%.2f", percentage[2]) + "%");
				}
			}
			else{
				System.out.println("Candidate B: " + s[1] + "votes and with " + String.format("%.2f", percentage[1]) + "%");
				System.out.println("Candidate C: " + s[2] + "votes and with " + String.format("%.2f", percentage[2]) + "%");
			}
		}

   	}	
}
