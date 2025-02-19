package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base
{
	@Test(description = " Verify whether user is able to search Category on Category Page",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserisAbleToSearchCategoryOnCategoryPageSuccessfully()
	{
		String userName= ExcelUtility.getString(1, 0, "CategoryPage"); 
		String password = ExcelUtility.getString(1, 1, "CategoryPage");
		String url = ExcelUtility.getString(1, 2, "CategoryPage");
		String searchCategoryName= ExcelUtility.getString(1, 3, "CategoryPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName).enterPasswordOnPasswordField(password).clickOnSigninButton();
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.navigateToCategoryPage(url).clickOnSearchButton().enterText(searchCategoryName).clickOnSearchButtonInSearchPage();
		 String actualResult=categoryPage.getSearchResult();
		 assertEquals(searchCategoryName, actualResult," Correct Search Result is not displayed");
	}
	@Test(description = " Verify whether user is able to DeleteS Category on Category Page",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserisAbleToDeleteCategoryOnCategoryPageSuccessfully()
	{
		String userName= ExcelUtility.getString(1, 0, "CategoryPage"); 
		String password = ExcelUtility.getString(1, 1, "CategoryPage");
		String url = ExcelUtility.getString(1, 2, "CategoryPage");
		String expectedAlertMessage =ExcelUtility.getString(1, 4, "CategoryPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName).enterPasswordOnPasswordField(password).clickOnSigninButton();
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.navigateToCategoryPage(url).clickOnDeleteButton();
		String actualAlertMessage =categoryPage.getTextDeletedAlert();
		assertEquals(actualAlertMessage, expectedAlertMessage,"Admin is not able to Delete Category on Category page successfully");
		
	}
	

	
}
