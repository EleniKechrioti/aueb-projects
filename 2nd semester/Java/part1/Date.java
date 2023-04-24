import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;


class Date{

    private LocalDate d;
    private String dd, date1;
    
    Date(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		d = LocalDate.now();
        dd = formatter.format(d);
    }
    public String getDate(){
        return dd;
    }

    public boolean afterdate(String date1){
        
        return dd.compareTo(date1) >= 0 ;
    }
        
}//Date