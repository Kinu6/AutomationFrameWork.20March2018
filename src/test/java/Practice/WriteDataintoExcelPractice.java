package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoExcelPractice {

	public static void main(String[] args) throws IOException {
		
		//Step 1:Open the document in java readable format
		FileInputStream fis= new FileInputStream("./src/test/resources/ExcelData.xlsx");
        
		// Step 2 : Create a WorkBook
		Workbook wb= WorkbookFactory.create(fis);
		
		//Step 3: Get control of sheet
		Sheet sh=wb.getSheet("organizations");
		
		//Step 4: Get control of row
		Row rw=sh.getRow(4);
		
		//Step 5: Create a cell in that row
		Cell ce= rw.createCell(4);
		
		//Step 6: set the value to the cell
		ce.setCellValue("Ladoo");
		
		//Step 7: Open the document in write mode
		FileOutputStream fos= new FileOutputStream("./src/test/resources/Zebra.xlsx");
		
		//Step 8: Write the data
		wb.write(fos);
		System.out.println("DATA ADDED");
		
	}

}
