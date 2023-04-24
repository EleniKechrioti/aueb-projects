/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

abstract class Akolou8ia {
    abstract double oros(int i);
}

// Fill your code here
class TetragwnikiAkolou8ia extends Akolou8ia {
	
	double oros(int i) {
		return i*i;
	}
}

class App1 {
	
    public static void main(String[] args) {
		Akolou8ia a = new TetragwnikiAkolou8ia();
		System.out.println(a8roisma(a,100));
    }

    static double a8roisma(Akolou8ia ak, int n) {
		double sum = 0;
		for ( int i = 1; i <= n; i++ )
			sum += ak.oros(i);
		return sum;
    }

}


