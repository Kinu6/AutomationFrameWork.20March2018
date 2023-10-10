package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationPage {
      
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement HeaderTxt;
	
	public  OrganisationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this); }
	
	public WebElement getHeaderTxt() {
		return HeaderTxt;
	}
}

