package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoTestScript_ContactWithOrg {

	public static void main(String[] args) {
		//Launch the Browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kravi\\Downloads\\Compressed\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		// Login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		
		/*{//Organisation Section 
			driver.findElement(By.linkText("Organizations")).click();
			
			//Click on Create Org lookup image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//Fill Accountname
			driver.findElement(By.name("accountname")).sendKeys("GADA2");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
		
		//Home Page
		driver.findElement(By.xpath("//a[@src='themes/softed/images/Home.PNG']")).click();}*/
		
	   //Click on Contacts button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Create contact lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Fill data LastName and Org
		{
		driver.findElement(By.name("lastname")).sendKeys("INDIA");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		String parentID=driver.getWindowHandle();
		
		for(String SubWindow:driver.getWindowHandles()) {
			driver.switchTo().window(SubWindow);
		}
		
		driver.findElement(By.id("search_txt")).sendKeys("GADA2");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("GADA2")).click();
		
		// driver.close();
		driver.switchTo().window(parentID);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		}
		
		// Verification
					String orginfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					if(orginfo.contains("Vedanta Limited1")) {
						System.out.println(orginfo+" "+"Updated");
					}
					else {
						System.out.println("Vedanta Limited Not found");
					}
		//Logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					
				Actions acton= new Actions(driver);
				acton.moveToElement(ele).perform();
					
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Logged Out");
	}

}
