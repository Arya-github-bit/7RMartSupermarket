package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.RandomUtility;
import utilities.WaitUtility;

public class SubCategoryPage 
{
	public WebDriver driver;
	public SubCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")WebElement subCategoryTile;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")WebElement selectCategoryDropDown;
	@FindBy(xpath = "//input[@id='subcategory']")WebElement subCategoryTextBox;
	@FindBy(xpath = "//input[@type='file']")WebElement chooseFileButton;
	@FindBy(xpath = "//button[text()='Save']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertBox;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")WebElement selectCategory;
	@FindBy(xpath ="//input[@placeholder='Sub Category']" )WebElement selectSubCategory;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchONSubCAtegoryPage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")WebElement table;
	
	
	
	public void clickOnSubCategoryTile()
	{
		subCategoryTile.click();
	}
	public void clickOnNewButton()
	{
		 WaitUtility waitUtility= new WaitUtility();
		 waitUtility.waitUntilElementToBeClickable(driver, newButton);
		newButton.click();
	}
	public void selectCategory()
	{
	 PageUtility pageUtility = new PageUtility();
	 pageUtility.selectFromDropDownUsingIndex(selectCategoryDropDown, 1);
	}
	public void selectSubCategory(String subcategory)
	{
	 
		subCategoryTextBox.sendKeys(subcategory);
	}
	public void uploadFile()
	{
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(chooseFileButton,Constant.TOYIMG);
		saveButton.click();
		
	}
	public String getAlertText()
	{
		String alertMessage =alertBox.getText();
		return alertMessage;
	}
	public void clickOnSearchButton()
	{
		WaitUtility waitUtility= new WaitUtility();
		waitUtility.waitUntillelementToBeClickableUsingFluentWait(driver, searchButton);
		searchButton.click();
	}
	public void selectCategory1()
	{
		PageUtility pageUtility= new PageUtility();
		pageUtility.selectFromDropDownUsingIndex(selectCategory, 2);
	}
	public void selectSubCategory1(String searchText)
	{
		
		selectSubCategory.sendKeys(searchText);
	}
	public void searchOnSubCategoryPage()
	{
		searchONSubCAtegoryPage.click();
	}
	public String getSearchResult()
	{
		String searchSubCategory =table.getText();
		return searchSubCategory;
	}
}
