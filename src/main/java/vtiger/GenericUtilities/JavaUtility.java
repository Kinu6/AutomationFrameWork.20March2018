package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * This class contains all the generic methods related to Java
 * @author kravi
 *
 */
public class JavaUtility {
 
	/**
	 * This method will provide the system date
	 * @return
	 */
	public String getSystemDate() {
		Date d= new Date();
		return d.toString();
	}
	/**
	 * This Method will provide the system date in specific date
	 * @return 
	 */
	public String getSystemDateInFormat() {
		Date d= new Date();
		String date[]= d.toString().split(" ");
		
		String month=date[1];
		String date1=date[2];
		String time= date[3].replace(":", "-");
		String year= date[5];
		
		String finalDate= date1+" "+month+" "+year+" "+time;
		return finalDate;
	}
	
	/**
	 * This Method will return a random number for every run
	 * @return
	 */
	public int getRandomNumber() {
		Random r= new Random();
		return r.nextInt(1000);
	}
}
