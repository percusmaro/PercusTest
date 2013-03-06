import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateTest {

	public static void term(){
		//long endDate = 1353236632000L;
				long endDate = 1352804632001L;
				long startDate = 1352804632000L;
				long term = endDate - startDate;
				term = 0L;
				
				Date d = new Date();
				d.setTime(term);
				
				long val = term/(60*60*24*1000);
				
				System.out.println(val);
				DateFormat df = DateFormat.getInstance();
			    System.out.println(df.format(d));
	}
	
	public long getTimestamp(){
		Calendar c = Calendar.getInstance();
		c.set(2012,10,16);
		Date d = new Date();
		//return d.getTime();
		return c.getTimeInMillis();
	}
	
	public static void dateFormat(){
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.SECOND, 0);
        Date d2 = cal.getTime();
        
        DateFormat df = DateFormat.getInstance();
        System.out.println(df.format(d2));
	}
	
	public static void main(String[] args){
		
		DateTest.term();
		
	}
}
