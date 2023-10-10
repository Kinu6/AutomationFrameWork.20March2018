package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.BaseClass;

public class NewContactPage extends BaseClass{
    // create a POM class for every webPage
	
	//WebELement
	@FindBy(name = "lastname") private WebElement LastName;
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement AddOrgNameIcon;
	@FindBy(name="leadsource") private WebElement LeadSourceDD;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement SaveBtn;
	@FindBy(id="search_txt") private WebElement SearchTxt;
	@FindBy(name="search") private WebElement SearchBtn;
	
	//Constructor
	public NewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//getters
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getAddOrgNameIcon() {
		return AddOrgNameIcon;
	}
	public WebElement getLeadSourceDD() {
		return LeadSourceDD;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public WebElement getSearchTxt() {
		return SearchTxt;
	}
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	// Generic Methods
	
	/**
	 * This Method will create orgname with last name
	 * @param name
	 * @param OrgName
	 */
	public void addLastNamewithOrgName(String name, String OrgName) {
		LastName.sendKeys(name);
		AddOrgNameIcon.sendKeys(OrgName);
		SaveBtn.click();
	}
	/**
	 * This Method will create Last name with LeadSource
	 * @param name
	 * @param leadName
	 */
	public void addLastnamewithLeadSource(String name, String leadName) {
		LastName.sendKeys(name);
		LeadSourceDD.sendKeys(leadName);
		SaveBtn.click();
	}
	
	public void addOrgName(String LASTNAME, String ORGNAME ) {
		
		LastName.sendKeys(LASTNAME);
		AddOrgNameIcon.click();
		wUtil.switchToWindow(driver, "Accounts");
		SearchTxt.sendKeys(ORGNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		wUtil.switchToWindow(driver, "Contacts");
				SaveBtn.click();
		
	}
	
	
}

