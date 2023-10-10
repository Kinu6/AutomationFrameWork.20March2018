package vtiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation_Random {

	public static void main(String[] args) throws IOException {
		
		Random r= new Random();
		int random= r.nextInt(1000);
		
		//Step 1: Read all the necessary data
		/* read data from property file-common Data */
		FileInputStream fisp= new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pObj= new Properties();
		pObj.load(fisp); 
		
		String URL= pObj.getProperty("url");
		System.out.println(URL);
		String BROWSER= pObj.getProperty("browser");
		System.out.println(BROWSER);
		String USERNAME= pObj.getProperty("username");
		System.out.println(USERNAME);
		String PASSWORD= pObj.getProperty("password");
		System.out.println(PASSWORD);
		
		/* Read data from excel sheet -Test data */
		FileInputStream fise= new FileInputStream("./src/test/resources/Zebra.xlsx");
		Workbook wb= WorkbookFactory.create(fise);
		Sheet sh=wb.getSheet("organizations");
		Row rw= sh.getRow(1);
		Cell ce= rw.getCell(2);  
		String VALUE= ce.getStringCellValue();
		
		//Launch the Browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kravi\\Downloads\\Compressed\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL); 
		
		// Login to app
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on Organizations button
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Create Org lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Fill Accountname
		driver.findElement(By.name("accountname")).sendKeys(VALUE+random );
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); //Click on Save Button
		
		// Verification
		String orginfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();;;;;;
		if(orginfo.contains(VALUE)) {
			System.out.println(VALUE+" "+"Updated");
		}
		else {
			System.out.println(VALUE+" "+"Limited Not found");
		}
		//Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions acton= new Actions(driver);
		acton.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logged Out");
	}
	
}
