package Practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DemoTestScript_Contacts {

	public static void main(String[] args) {
		// Step 1: Launch the browser
		
		String key= "webdriver.gecko.driver";
		String value="C:\\Users\\kravi\\Downloads\\Compressed\\geckodriver-v0.33.0-win64\\geckodriver.exe";

		System.setProperty(key,value);
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:8888");
	
        // Step 2: Login to application
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        
        // Step 3: Navigate to contacts
        driver.findElement(By.linkText("Contacts")).click();
        
        //Step4: Click on Create Contacts
        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
        
        
        // Step 5: Fill Mandatory fields
        driver.findElement(By.name("lastname")).sendKeys("Anupam Ji");
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        // Step 6: Verification for contact
          String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
          if(contactHeader.contains("Anupam Ji")) {
        	  System.out.println(contactHeader+" " +"Updated");}
          
          else
          {
        	  System.out.println("Failed");}
          
        // Step 7: LogOut Operation
          WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
          Actions act= new Actions(driver);
          act.moveToElement(ele).perform();
          
          driver.findElement(By.linkText("Sign Out")).click();
          System.out.println("Logged out");	
	}

}
