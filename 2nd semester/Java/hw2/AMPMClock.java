/*
	Name: KECHRIOTI ELENI
	Student Number: 3210078
*/

class AMPMClock extends Clock {
	
	// Fill your code here
	public boolean ampm;
	
	AMPMClock(){
		super.setHour(hour);
		super.setMin(min);
		super.setSec(sec);
	}
	void setAMPM(boolean yes) {
		this.ampm = yes;	
	}
	

	public String toString() {
		if (ampm) {
			if (super.hour < 12) {
				return super.toString() + " am";
			}
			else {
				return String.format("%02d",hour-12)+":"+String.format("%02d",min)+":"+String.format("%02d",sec) + " pm";
			}
		}
		else {
			return super.toString();
		}
	}
}