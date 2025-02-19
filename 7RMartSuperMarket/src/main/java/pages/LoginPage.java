package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage 
{
	public WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath ="//input[@placeholder='Username']")WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']") WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']") WebElement signInButton;
	@FindBy(xpath = "//ol[@class='breadcrumb float-sm-right']//child::li[@class='breadcrumb-item active']")WebElement dashBoardText;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alert;


	public LoginPage enterUseNameonUserNameField(String userName)
	{
		userNameField.sendKeys(userName);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public LoginPage clickOnSigninButton()
	{
		 WaitUtility waitUtility= new WaitUtility();
		 waitUtility.waitUntilElementToBeClickable(driver, signInButton);
		signInButton.click();
		return this;
	}
	public boolean whetherDashboardTileIsDisplayed ()
	{
		Boolean dashBoardDisplay =dashBoardText.isDisplayed();
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBePresentInElement(driver, dashBoardText,"Dashboard");
		return dashBoardDisplay;

	}
	public boolean whetherAlertIsDisplayed()
	{
		boolean isAlertDisplayed = alert.isDisplayed();
		return isAlertDisplayed;

	}


}
