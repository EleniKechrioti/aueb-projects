/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/


class Clock {
	
	//Data
	
	private /*Fill your code here*/ int hour;
	private /*Fill your code here*/ int min;
	private /*Fill your code here*/ int sec;
	
	
	// Methods
	
	void setHour(/*Fill your code here*/ int h) {
		
		// Fill your code here
		this.hour = h;

	}

	void setMin(/*Fill your code here*/ int m) {
		
		// Fill your code here
		
		this.min = m;
	}
	
	void setSec(/*Fill your code here*/ int s) {
		
		// Fill your code here
		this.sec = s;
	}

	void tick() {
		
		// Fill your code here
		sec++;
		if(sec == 60){
			min ++;
			sec = 0;
			if(min == 60){
				hour ++;
				min = 0;
			}
		}

	}

	public String toString() {
		
		// Fill your code here
		return String.format("%02d",hour)+":"+String.format("%02d",min)+":"+String.format("%02d",sec);
	} 
	
}


