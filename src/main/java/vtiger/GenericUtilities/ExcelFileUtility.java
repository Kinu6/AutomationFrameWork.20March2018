package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/** This class contains generic methods realted to excel file
 * @author kravi
 *
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet based on row and cell value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fise= new FileInputStream(IConstantsUtility.excelFilePath);
	Workbook wb= WorkbookFactory.create(fise);
    Sheet sh = wb.getSheet(sheet);
    Row rw = sh.getRow(row);
    Cell ce= rw.getCell(cell);
    String value=ce.getStringCellValue();
	return value;
	}
	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise= new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheet);
		int rowCount= sh.getLastRowNum();
		wb.close();
		return rowCount;
		
		
	}
	/**
	 * This method will write into Excel sheet
	 * @param sheet
	 * @param row
	 * @param col
	 * @param cellName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int col, String cellName) throws EncryptedDocumentException, IOException {
		FileInputStream fise= new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb= WorkbookFactory.create(fise);
		Sheet sh= wb.getSheet(sheet);
		sh.getRow(row).createCell(col).setCellValue(cellName);
		FileOutputStream fose= new FileOutputStream(IConstantsUtility.excelFilePath);
		wb.write(fose);
		wb.close();
	}
	
	public Object[][] readDataFromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis= new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		int lastRow= sh.getPhysicalNumberOfRows();
		System.out.println(lastRow);
		int lastCell= sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println(lastCell);
		
		Object[][] data= new Object[lastRow-1][lastCell];
		for(int i=1;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		wb.close();	
		return data;
	}
	
}

