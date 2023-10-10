package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class NewOrganizationPage extends WebDriverUtility{
    @FindBy(name ="accountname") private WebElement OrgNameEdt;
    @FindBy (name="industry") private WebElement IndustryDD;
    @FindBy(name="accounttype") private WebElement TypeDD;
    @FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement SaveBtn;
    
    
    public NewOrganizationPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	/**
	 * This Mehod will create OrgName with Industry
	 * @param INDUSTRY
	 * @param ORGNAME
	 */
	public void createOrgWithIndustry(String VALUE, String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDD, VALUE);
		SaveBtn.click();
	}
	/**
	 * This Method will create OrgName with Industry and TypeDD
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param Type
	 */
	public void createOrgWithIndustry_type(String ORGNAME, String INDUSTRY, String Type) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(INDUSTRY, IndustryDD);
		handleDropdown(Type, TypeDD);
		SaveBtn.click();
	}
	
}
