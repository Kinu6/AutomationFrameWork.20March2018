package Practice;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class DemoTestScriptWithDDT {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver= null;
		
		//Read data from PropertyFile
		PropertyFileUtility pObj=new PropertyFileUtility();
		String URL= pObj.readDataFromPropertyFile("url");
		String BROWSER= pObj.readDataFromPropertyFile("browser");
		String USERNAME= pObj.readDataFromPropertyFile("username");
		String PASSWORD= pObj.readDataFromPropertyFile("password");
		
		//Read data from Excel Sheet
		ExcelFileUtility eUtil= new ExcelFileUtility();
		String LASTNAME=eUtil.readDataFromExcel("contacts",1,2);
		
		// Step 1: Launch the browser - Run Time Polymorphism
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
			
		// Step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		        
		// Step 3: Navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		        
		//Step4: Click on Create Contacts
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		        
		        
		// Step 5: Fill Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		        
		// Step 6: Verification for contact
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(LASTNAME)) {
		     System.out.println(contactHeader+" " +"Updated");
		    	  }
	    else {
		     System.out.println("Failed");
		      	  }
		          
      // Step 7: LogOut Operation
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act= new Actions(driver);
		 act.moveToElement(ele).perform();
		          
		 driver.findElement(By.linkText("Sign Out")).click();
		 System.out.println("Logged out");	
      }
}
