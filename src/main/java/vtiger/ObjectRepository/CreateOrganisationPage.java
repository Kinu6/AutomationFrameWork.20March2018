package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
     
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement CreateOrgIcon;                            
	public CreateOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOrgIcon() {
		return CreateOrgIcon;
	}
}
