package Practice;

import java.io.IOException;
import java.sql.SQLException;

import vtiger.GenericUtilities.DatabaseUtility;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericPropertyFilePractice {

	public static void main(String[] args) throws IOException, SQLException {
		PropertyFileUtility pUtil= new PropertyFileUtility();
		String URL=pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		ExcelFileUtility efu= new ExcelFileUtility();
		String value= efu.readDataFromExcel("contacts",0,1);
		System.out.println(value);
		
		System.out.println(efu.getRowCount("contacts"));
		
		efu.writeDataIntoExcel("contacts", 4, 6, "INDIA F");
		System.out.println("-----------------------------------------------------");
		
		DatabaseUtility dUtil= new DatabaseUtility();
		//dUtil.executeQueryJDBC("insert into candidateinfo values('Pankaj11','1003009','Gumla11'),('Minakshi11','1003008','Hatma11') ;");
		dUtil.executeQueryJDBC("insert into candidateinfo values('Pankaj11','1003009','Gumla11'),('Minakshi11','1003008','Hatma11') ;", "candidateinfo");
		

	}

}
