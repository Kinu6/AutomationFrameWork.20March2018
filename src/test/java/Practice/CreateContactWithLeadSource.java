package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithLeadSource {

public static void main(String[] args) throws IOException {
	
	WebDriver driver= null;
	ExcelFileUtility eUtil= new ExcelFileUtility();
	PropertyFileUtility pUtil= new PropertyFileUtility();
	WebDriverUtility wUtil= new WebDriverUtility();
	
	String URL= pUtil.readDataFromPropertyFile("url");
	String BROWSER= pUtil.readDataFromPropertyFile("browser");
	String USERNAME= pUtil.readDataFromPropertyFile("username");
	String PASSWORD= pUtil.readDataFromPropertyFile("password");
	
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}else {
		System.out.println("Invalid Browser");
	}
	
	wUtil.maximizeWindow(driver);
	wUtil.implicitWaits(driver);
	driver.get(URL);
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	driver.findElement(By.name("lastname")).sendKeys(eUtil.readDataFromExcel("contacts", 7, 2));
	WebElement element= driver.findElement(By.name("leadsource"));
	wUtil.handleDropdown(eUtil.readDataFromExcel("contacts", 7, 3),element);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Verification
	String headerText= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerText.contains(eUtil.readDataFromExcel("contacts", 7, 2))) {
		System.out.println(eUtil.readDataFromExcel("contacts", 7, 2)+" "+ "VERIFIED");
	}
	else{
		System.out.println("Not updated");
	}
	//Logout
	WebElement ele =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverAction(driver, ele);
	
	
	driver.findElement(By.linkText("Sign Out")).click();
 }	
}
