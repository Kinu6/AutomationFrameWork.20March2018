package vtiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vtiger.GenericUtilities.IConstantsUtility;

public class EXCEL {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Object[][] data= new Object[4][4];
		for(int i=0;i<4;i++) {
			System.out.println(i);
			for(int j=0;j<4;j++) {
				
			System.out.println(data[i][j]);
			}
		}
	}
}
