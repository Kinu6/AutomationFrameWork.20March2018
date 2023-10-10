package vtiger.OrganizationsTests;

import java.io.IOException;

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
import vtiger.ObjectRepository.CreateOrganisationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.NewOrganizationPage;
import vtiger.ObjectRepository.OrganisationInformationPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class DDT_OrgWithIndustryTypeTest extends BaseClass {
@Test(groups = "RegressionSuite")
	public void TC_06() throws IOException {
		
		String ORGNAME= eUtil.readDataFromExcel("organizations", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYDD= eUtil.readDataFromExcel("organizations", 4, 3);
		String TYPE=eUtil.readDataFromExcel("organizations", 7, 4);
		
		HomePage hp= new HomePage(driver);
		hp.getOrgTab().click();
		
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage cnop= new NewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(ORGNAME);
		WebElement IND_DD=cnop.getIndustryDD();
		
		wUtil.handleDropdown(INDUSTRYDD, IND_DD);
		
		WebElement TYPE_DD= cnop.getTypeDD();
		wUtil.handleDropdown(TYPE_DD, TYPE);
		
		
		cnop.getSaveBtn().click();
		
		OrganisationInformationPage oip= new OrganisationInformationPage(driver);
		String HD_TEXT= oip.getHeaderTxt().getText();
		
		Assert.assertEquals(HD_TEXT.contains(ORGNAME), true);
		
	}
}
