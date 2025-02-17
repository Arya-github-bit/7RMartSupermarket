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
	@FindBy(xpath = "//div[@class='inner']//child::p[text ()='Dashboard']")WebElement dashBoardTile;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alert;


	public void enterUseNameonUserNameField(String userName)
	{
		userNameField.sendKeys(userName);
	}
	public void enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
	}
	public void clickOnSigninButton()
	{
		 WaitUtility waitUtility= new WaitUtility();
		 waitUtility.waitUntilElementToBeClickable(driver, signInButton);
		signInButton.click();
	}
	public boolean whetherDashboardTileIsDisplayed ()
	{
		boolean dashBoardTileDisplay =dashBoardTile.isDisplayed();
		return dashBoardTileDisplay;

	}
	public boolean whetherAlertIsDisplayed()
	{
		boolean isAlertDisplayed = alert.isDisplayed();
		return isAlertDisplayed;

	}


}
