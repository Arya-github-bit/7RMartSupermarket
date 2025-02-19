package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage
{
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")WebElement textbox;
	@FindBy(xpath = "//button[@name='create']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertBox;
	
	
	public ManageNewsPage clickOnManageNewsTile(String url)
	{
		
		driver.navigate().to(url);
		return this;
	}
	public ManageNewsPage clickOnNewButton()
	{
		 WaitUtility waitUtility= new WaitUtility();
		 waitUtility.waitUntilElementToBeClickable(driver, newButton);
		newButton.click();
		return this;
	}
	public ManageNewsPage updateNews( String news)
	{
		textbox.clear();
		textbox.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public String getAlertText()
	{
		String alert =alertBox.getText();
		return alert;
	}
	

}
