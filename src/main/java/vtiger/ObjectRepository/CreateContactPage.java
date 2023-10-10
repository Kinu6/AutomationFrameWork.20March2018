package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
    //Create a POM class dear
	// Create Webelement using FindBy
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement CreateContactIcon;
	//Constructor
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//getters
	public WebElement getCreateContactIcon() {
		return CreateContactIcon;
	}
}
