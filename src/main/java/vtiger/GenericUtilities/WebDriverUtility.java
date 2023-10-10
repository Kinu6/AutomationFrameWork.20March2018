package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class consists of generic methods related to webDriver actions
 * @author kravi
 *
 */

public class WebDriverUtility {
    /**
     * This method will maximize the window
     * @param driver
     */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This Method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This Method will wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisisble(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This Method will wait for alert to be shown 
	 * @param driver
	 */
	public void implicitWaits(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This Method will handle drop down based on Index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This Method will handle the Drop down based on value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This Method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This Method will perform Mouse Hover Action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element){
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();;
		
	}
	/**
	 * This Method will perform right click action in WebPage
	 * @param driver 
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This Mehod will perform right click action on element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element ) {
		Actions act= new Actions(driver);
		act.contextClick().moveToElement(element).perform();
	}
	/**
	 * This Method will perform double click on webPage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act= new Actions(driver);
		act.contextClick().doubleClick();
	}
	/**
	 * This Method will perform double click on element in WebPage
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element).doubleClick(element);
	}
	
	
	/**
	 * This Method will return the text in Alert Message
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
	   return driver.switchTo().alert().getText();
	}
	/**
	 * This method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		    driver.switchTo().alert().accept();
		}
	/**
	 * This Method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		    driver.switchTo().alert().dismiss();;
		}
	/**
	 * This Mehod will handle frame based on Index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This Mehod will handle frame based on name or ID
	 * @param driver
	 * @param index
	 * @param nameorId 
	 */
	public void handleFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}
    
	/**
	 * This Mehod will handle frame based on WebElement
	 * @param driver
	 * @param index
	 * @param element 
	 */
	public void handleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This Method will switch to default frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to required Window
	 * @param driver
	 * @param partialwintitle
	 */
	public void switchToWindow(WebDriver driver, String partialwintitle)
	{
		// Capture all the window IDs
		Set<String> winIDs= driver.getWindowHandles();
		
		// Navigate to each window
		for(String win:winIDs) {
			// Switch to Window and capture the title
			String winTitle=driver.switchTo().window(win).getTitle();
			
			// Compare the title with required partial title
			if(winTitle.contains(partialwintitle)) {
				break;
			}
		}	
	}
	
	/**
	 * This method is for taking screenshot
	 * @param driver
	 * @param screenshotName 
	 * @return
	 * @throws IOException
	 */
	public String takesScreenShot(WebDriver driver, String screenshotName ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File((".\\Screenshots\\")+screenshotName+".png");
		FileUtils.copyFile(src, dest); // Commons IO Dependency
		
		return dest.getAbsolutePath(); // Used for Extent Reports
	}
	
	/**
	 * This Mehod will perform scroll down action
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)",null);
	}
	
	/**
	 * This Method will perform scroll untill element is identified in POM
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,'+y+')", element);
	}
}
