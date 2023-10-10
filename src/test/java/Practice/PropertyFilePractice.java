package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {  
	public static void main(String[] args) throws IOException {
	//Step 1:Open the file in java readable format
	FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	//Step 2: Create Object of Properties from java.util package
	 Properties pObj= new Properties();
		
    //Step 3: load the file input stream into properties
	 pObj.load(fis);
	//Step 4: access the values with keys
	 String URL= pObj.getProperty("url");
	 String USERNAME= pObj.getProperty("username");
	 
	 System.out.println(URL);
	 System.out.println(USERNAME);
	}
}
