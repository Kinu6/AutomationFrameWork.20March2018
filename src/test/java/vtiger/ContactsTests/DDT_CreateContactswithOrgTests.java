package vtiger.ContactsTests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
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
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.NewContactPage;
import vtiger.ObjectRepository.NewOrganizationPage;
import vtiger.ObjectRepository.CreateOrganisationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationInformationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class DDT_CreateContactswithOrgTests extends BaseClass{

	@Test
	public void TC_02() throws IOException {
		
		String ORGNAME=eUtil.readDataFromExcel("contacts", 4, 2)+jUtil.getRandomNumber(); 
		String LASTNAME=eUtil.readDataFromExcel("contacts", 4, 3); 
		
		HomePage hp= new HomePage(driver);
		hp.getOrgTab().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//Create Org
		{
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage nop=new NewOrganizationPage(driver);
		nop.getOrgNameEdt().sendKeys(ORGNAME);
		nop.getSaveBtn().click();
		
		OrganisationInformationPage oip= new OrganisationInformationPage(driver);
        
		String orginfo= oip.getHeaderTxt().getText();
		Assert.assertEquals(orginfo.contains(ORGNAME), true);
		
		hp.getContactstab().click();
		
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getCreateContactIcon().click();
		
		NewContactPage ncp= new NewContactPage(driver);
		ncp.addOrgName(LASTNAME, ORGNAME);
		
		ContactInformationPage cip= new ContactInformationPage(driver);
		
		// Verification -
		String orginfo1= cip.getHeaderTxt().getText();
		Assert.assertEquals(orginfo1.contains(LASTNAME), true);
       }
	}
	}
