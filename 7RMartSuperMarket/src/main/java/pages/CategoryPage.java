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
	

	public void navigateToCategoryPage(String url)
	{
		driver.navigate().to(url);
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public void enterText(String searchText)
	{
		searchTextBox.sendKeys(searchText);
	}
	public void clickOnSearchButtonInSearchPage()
	{
		searchButtonInSearchPage.click();
	}
	public String getSearchResult() 
	{
		String searchCategory = table.getText();
		return searchCategory;
	}
	public void clickOnNewButton() 
	{
		newButton.click();
	}
}
