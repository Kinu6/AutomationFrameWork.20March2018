package vtiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	//rule 1: Create a POM Page for every webPage
	
	//rule 2: Identify the web Elements with @FindBy,@Findall and @FindBys
	
	@FindBy(name="user_name") private WebElement UsernameEdt;
	@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type='password']")})
    private WebElement PasswordEdt;
	@FindBy(id = "submitButton")private WebElement SubmitBtn;
	
	//Rule 3: Create a constructor to initialize these Web elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Rule 4: Provide getters to access these elements
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}
	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	/**
	 * This Method will help Logging In 
	 * @param username
	 * @param password
	 */
	// Business Libraries- Generic Methods specific to current Project
	public void loginToApp(String username, String password) {
		UsernameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}	
}
