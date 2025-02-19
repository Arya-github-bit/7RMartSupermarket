package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage
{
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")WebElement searchTextBox;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchButtonInSearchPage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")WebElement table;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath = "//input[@placeholder='Enter the Category']")WebElement enterCategoryTextBox;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=1055&page_ad=1']//child::i")WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement deleteAlertBox;

	public CategoryPage navigateToCategoryPage(String url)
	{
		driver.navigate().to(url);
		return this;
	}
	public CategoryPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	public CategoryPage enterText(String searchText)
	{
		searchTextBox.sendKeys(searchText);
		return this;
	}
	public CategoryPage clickOnSearchButtonInSearchPage()
	{
		searchButtonInSearchPage.click();
		return this;
	}
	public String getSearchResult() 
	{
		String searchCategory = table.getText();
		return searchCategory;
	}
	public CategoryPage clickOnNewButton() 
	{
		newButton.click();
		return this;
	}
	public CategoryPage clickOnDeleteButton()
	{
		deleteButton.click();
		return this;
	}
	public String getTextDeletedAlert()
	{
		String alertMessage = deleteAlertBox.getText();
		return alertMessage;
	}
}
