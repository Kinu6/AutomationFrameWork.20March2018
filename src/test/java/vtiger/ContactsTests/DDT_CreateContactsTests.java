package vtiger.ContactsTests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.NewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class DDT_CreateContactsTests extends BaseClass{	
	@Test 
	public void TC_01() throws IOException{
		
		String LASTNAME=eUtil.readDataFromExcel("contacts", 1, 2); 
			
		HomePage hp= new HomePage(driver);
		hp.getContactstab().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getCreateContactIcon().click();
		wUtil.takesScreenShot(driver, "TC_01");
		
		NewContactPage cncp= new NewContactPage(driver);
		cncp.getLastName().sendKeys(LASTNAME);
		cncp.getSaveBtn().click();
		
		ContactInformationPage cip= new ContactInformationPage(driver);
		
		// Verification -
		String orginfo= cip.getHeaderTxt().getText();
		
		Assert.assertEquals(orginfo.contains(LASTNAME), true);
		
	}
}
