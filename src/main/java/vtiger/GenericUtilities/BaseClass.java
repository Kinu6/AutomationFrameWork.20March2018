package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IBeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
   public PropertyFileUtility pUtil= new PropertyFileUtility();
   public ExcelFileUtility eUtil= new ExcelFileUtility();
   public WebDriverUtility wUtil= new WebDriverUtility();
   public JavaUtility jUtil= new JavaUtility();
   
   public WebDriver driver= null;
   public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"smoke suite","RegressionSuite"})
	public void bsconfig() {
		System.out.println("-------------Data base Connection Sucessful------------");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"smoke suite","RegressionSuite"})
	//public void bcConfig(String BROWSER ) throws IOException {
		public void bcConfig()  throws IOException {	
		
		String URL=pUtil.readDataFromPropertyFile("url");
		String BROWSER= pUtil.readDataFromPropertyFile("browser");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	} else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	} else {
		System.out.println("Invalid Browser");
	}
	
	sDriver= driver; //For Listeners
	wUtil.maximizeWindow(driver);
	wUtil.implicitWaits(driver);
	driver.get(URL);
	}
	
	@BeforeMethod(groups = {"smoke suite", "RegressionSuite"})
	public void bfConfig() throws IOException{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Sucessful");
	}
	
	@AfterMethod(groups = {"smoke suite","RegressionSuite"})
	public void amConfig() {
		HomePage hp= new HomePage(driver);
		WebElement ele= hp.getAdminIcon();
		wUtil.mouseHoverAction(driver, ele);
		hp.signOut(driver);;
	}
	
	//@Parameters("browser")
	//@AfterTest
	@AfterClass(groups ={"smoke suite","RegressionSuite"})
	//public void acConfig(String BROWSER) 
	public void acConfig(){
		
		driver.quit();
		System.out.println("--------BROWSER CLOSED SUCCESSFUL--------");
	}
	
	@AfterSuite(groups ={"smoke suite","RegressionSuite"})
	public void asConfig() {
		System.out.println("---DataBase connection Closed");
}
	
    }
