package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class POMclassPractice {

	public static void main(String[] args) throws IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		
		WebDriverUtility wUtil= new WebDriverUtility();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWaits(driver);
		
		PropertyFileUtility pUtil= new PropertyFileUtility();
		String URL= pUtil.readDataFromPropertyFile("url");
		String UN= pUtil.readDataFromPropertyFile("username");
		String PW= pUtil.readDataFromPropertyFile("password");
		driver.get(URL);
		
		LoginPage lp= new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(UN);
		lp.getPasswordEdt().sendKeys(PW);
		lp.getSubmitBtn().click();
		
		HomePage hp= new HomePage(driver);
		hp.getOrgTab().click();

	}
}
