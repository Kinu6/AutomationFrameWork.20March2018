package vtiger.ContactsTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class DDTCreateContactswithLeadTests extends BaseClass {

	@Test
	public void TC_03() throws IOException {
		
		String LASTNAME=eUtil.readDataFromExcel("contacts", 7, 2);
		String LEAD_DD= eUtil.readDataFromExcel("contacts", 7, 3);
		
		HomePage hp= new HomePage(driver);
		hp.getContactstab().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getCreateContactIcon().click();
		
		NewContactPage cncp= new NewContactPage(driver);
		cncp.getLastName().sendKeys(LASTNAME);
		
		WebElement leadEle = cncp.getLeadSourceDD();
		wUtil.handleDropdown(LEAD_DD, leadEle);;
		cncp.getSaveBtn().click();
		
		ContactInformationPage cip= new ContactInformationPage(driver);
		
		// Verification -
		String orginfo= cip.getHeaderTxt().getText();
		
		Assert.assertEquals(orginfo.contains(LASTNAME), true);
	}

}
