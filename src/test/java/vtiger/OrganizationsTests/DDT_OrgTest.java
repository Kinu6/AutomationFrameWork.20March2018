package vtiger.OrganizationsTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganisationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.NewOrganizationPage;
import vtiger.ObjectRepository.OrganisationInformationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class DDT_OrgTest extends BaseClass {

	@Test(groups = "smoke suite")
	public void TC_04() throws IOException {
		 
		String ORGNAME=eUtil.readDataFromExcel("organizations", 1, 2)+jUtil.getRandomNumber(); 
		
		HomePage hp= new HomePage(driver);
		hp.getOrgTab().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		cop.getCreateOrgIcon().click();
		Reporter.log("Create contact");
		
		NewOrganizationPage cno= new NewOrganizationPage(driver);
		cno.getOrgNameEdt().sendKeys(ORGNAME);
		cno.getSaveBtn().click();
		Reporter.log("New Organisation Page");
		
		OrganisationInformationPage oip= new OrganisationInformationPage(driver);
		Reporter.log("Organisation Info Page");
		
		// Validation
		String orginfo= oip.getHeaderTxt().getText();
		Assert.assertEquals(orginfo.contains(ORGNAME),true);
		Reporter.log("Validation");
	}
	
	@Test
	public void demo() {
		System.out.println("DEMO T.S");
	}
	
}
