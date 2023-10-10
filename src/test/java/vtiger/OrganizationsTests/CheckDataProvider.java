package vtiger.OrganizationsTests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganisationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.NewOrganizationPage;
import vtiger.ObjectRepository.OrganisationInformationPage;

public class CheckDataProvider {
public static void main(String[] args) throws IOException {
	

	    ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriver driver= null;
		WebDriverUtility wUtil= new WebDriverUtility();
		JavaUtility jUtil= new JavaUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		
		String URL= pUtil.readDataFromPropertyFile("url");
		String UN=pUtil.readDataFromPropertyFile("username");
		String PW=pUtil.readDataFromPropertyFile("password");
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		
		String ORGNAME= eUtil.readDataFromExcel("dataProviderOrg", 1, 0)+jUtil.getRandomNumber();
		String INDUSRTY= eUtil.readDataFromExcel("dataProviderOrg", 1, 1);
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		wUtil.maximizeWindow(driver);
		wUtil.implicitWaits(driver);
	    driver.get(URL);
	    
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(UN, PW);
		
		HomePage hp= new HomePage(driver);
		hp.getOrgTab().click();
		
		wUtil.implicitWaits(driver);
		
		CreateOrganisationPage cop= new CreateOrganisationPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationPage cnop= new NewOrganizationPage(driver);
		cnop.createOrgWithIndustry(INDUSRTY, ORGNAME);
		
		OrganisationInformationPage oip= new OrganisationInformationPage(driver);
		String HD_TEXT= oip.getHeaderTxt().getText();
		
		if(HD_TEXT.contains(ORGNAME)) {
			System.out.println(ORGNAME+"UPDATED");
		}else{
			System.out.println("NOT FOUND");
		}
		
		hp.signOut(driver);
		
	}
  }
