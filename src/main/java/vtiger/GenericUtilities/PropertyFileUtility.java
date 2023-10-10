package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic Methods to read the data from property file
 * @author kravi
 */
public class PropertyFileUtility {
	/**
	 * This method will read data from property file 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fisp= new FileInputStream(IConstantsUtility.propertyFilePath);
	    Properties pObj= new Properties();
	    pObj.load(fisp);
	    String value= pObj.getProperty(key);
	    return value;	
	}
}
