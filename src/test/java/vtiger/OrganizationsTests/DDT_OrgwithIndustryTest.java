package vtiger.OrganizationsTests;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
public class DDT_OrgwithIndustryTest extends BaseClass{
	
	ExcelFileUtility eUtil=new ExcelFileUtility();
	
@Test(dataProvider = "OrgWithIndustry")
public void TC_04(String ORGNAME, String INDUSTRY) throws IOException
      {
		HomePage hp= new HomePage(driver);
		hp.getOrgTab().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage cnop= new NewOrganizationPage(driver);
		cnop.createOrgWithIndustry(INDUSTRY, ORGNAME+jUtil.getRandomNumber());;
		
		OrganisationInformationPage oip= new OrganisationInformationPage(driver);
		String HD_TEXT= oip.getHeaderTxt().getText();
		
		Assert.assertEquals(HD_TEXT.contains(ORGNAME), true);	
	}

  @DataProvider(name="OrgWithIndustry")
  public Object[][] getData() throws EncryptedDocumentException, IOException{
	Object[][] data= eUtil.readDataFromExcelToDataProvider("dataProviderOrg");
	return data;

  }
  }
