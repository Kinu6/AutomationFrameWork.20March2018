package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
    // Create POM Class
	// Create FindBy
	 @FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement HeaderTxt;
	// Create Constructor
	 public ContactInformationPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 public WebElement getHeaderTxt() {
		 return HeaderTxt;
	 }
}
