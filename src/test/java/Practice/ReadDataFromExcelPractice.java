package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelPractice {

	public static void main(String[] args) throws IOException {
		//Open the file in Java Readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Zebra.xlsx");
        
		//Create a workbook
		Workbook wb= WorkbookFactory.create(fis);
		
		//get hold of sheet
		Sheet sh= wb.getSheet("Contacts");
		
		//get hold of row
		Row rw= sh.getRow(1);
		
		//get hold of cell
		Cell ce= rw.getCell(1);
		
		//read the data inside the cell
		String value= ce.getStringCellValue();
		System.out.println(value);
	}
}
