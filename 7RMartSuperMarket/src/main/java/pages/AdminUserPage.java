package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.RandomUtility;
import utilities.WaitUtility;

public class AdminUserPage 
{
	public WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy( xpath ="//input[@placeholder='Username']")WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']") WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") WebElement signInButton;
	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminUsersTile;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")WebElement newUserUserNameField;
	@FindBy(xpath = "//input[@id='password']")WebElement newUserPasswordField;
	@FindBy(xpath = "//select[@id='user_type']")WebElement newUserSelectDropdown;
	@FindBy(xpath = "//button[@name='Create']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newUserAlertBox;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")WebElement aletText;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton1;
	@FindBy(xpath = "//input[@id='un']")WebElement searchUserNameField;
	@FindBy(xpath = "//select[@id='ut']")WebElement searchUserSelectDropdown;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")WebElement table;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/user/status?id=11753&st=inactive&page_ad=1']//child::i[@class='fa fa-unlock']")WebElement statusButton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement statusAlerBox;
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=11753&page_ad=1']//child::i")WebElement editButton;
@FindBy(xpath = "//input[@id='password']")WebElement passwordEditTextBox;
@FindBy(xpath = "//button[@name='Update']")WebElement updateButton;
@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement updateAlertBox;

	public void clickOnAdminUserTile()
	{
		adminUsersTile.click();
	}
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public void enterUserNameOfNewUser()
	{
		RandomUtility randomUtility = new RandomUtility();
		String newUserName =randomUtility.fakerUserName();
		newUserUserNameField.sendKeys(newUserName);
		

	}
	public void enterNewUserPassword()
	{
		RandomUtility randomUtility = new RandomUtility();
		String newUserPassword = randomUtility.fakerpassword();
		newUserPasswordField.sendKeys(newUserPassword);
	}
	public void selectUserType()
	{ 
		PageUtility pageUtility =new PageUtility();
		pageUtility.selectFromDropDownUsingIndex(newUserSelectDropdown, 1);

	}
	public void clickOnSaveButton()
	{
		 WaitUtility waitUtility= new WaitUtility();
		 waitUtility.waitUntilElementToBeClickable(driver, saveButton);
		saveButton.click();
	}
	public String isalertforCreatingNewdisplayed()
	{
		String alertmessage= newUserAlertBox.getText();
		return alertmessage;
	}


	public void clickOnSearchButton1()
	{
		WaitUtility waitUtility =new WaitUtility();
		waitUtility.waitUntillelementToBeClickableUsingFluentWait(driver, searchButton1);
		searchButton1.click();
	}
	public void enterUserNameInSearchField(String searchUserName)
	{
		searchUserNameField.sendKeys(searchUserName);
	}
	public void selectDropdownInSearch(int index)
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectFromDropDownUsingIndex(newUserSelectDropdown,index);
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public String getSearchResult()
	{
		String searchUserName = table.getText();
		return searchUserName;
	}
	public void clickOnStatusButton() 
	{
		statusButton.click();
		
	}
	public String isAlertforUserStatusChangeDisplayed()
	{
		String alerMessage = statusAlerBox.getText();
		return alerMessage;
	}
	public void clickOnEditButton() 
	{
		WaitUtility waitUtility=new WaitUtility();
		waitUtility.waitUntilElementToBeClickable(driver, editButton);
		editButton.click();
	}
	
	public void editPassword()
	{
		passwordEditTextBox.clear();
		RandomUtility randomUtility=  new RandomUtility();
		String newPassword = randomUtility.fakerpassword();
		passwordEditTextBox.sendKeys(newPassword);
		
	}
	public void clickOnUpdateButton()
	{
		updateButton.click();
	}
	public String alertForUserUpdatedSuccessfully()
	{
		String updateAlertmessage =updateAlertBox.getText();
		return updateAlertmessage;
	}

}
