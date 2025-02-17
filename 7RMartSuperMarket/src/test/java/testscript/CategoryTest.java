package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base
{
	@Test(description = " Verify whether user is able to search Category on Category Page")
	public void verifyWhetherUserisAbleToSearchCategoryOnCategoryPageSuccessfully()
	{
		String userName= ExcelUtility.getString(1, 0, "CategoryPage"); 
		String password = ExcelUtility.getString(1, 1, "CategoryPage");
		String url = ExcelUtility.getString(1, 2, "CategoryPage");
		String searchCategoryName= ExcelUtility.getString(1, 3, "CategoryPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSigninButton();
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.navigateToCategoryPage(url);
		categoryPage.clickOnSearchButton();
		categoryPage.enterText(searchCategoryName);
		categoryPage.clickOnSearchButtonInSearchPage();
		 String actualResult=categoryPage.getSearchResult();
		 assertEquals(searchCategoryName, actualResult," Correct Search Result is not displayed");
	}

	
}
