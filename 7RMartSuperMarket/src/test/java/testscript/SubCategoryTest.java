package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base
{
	@Test(description = "Verify whether user is able to add new subcaegory on sub category Page",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherAdminisableToAddNewSubCategoryOnListSubcategoryPage()
	{   String expectedAlert= ExcelUtility.getString(1, 3, "SubCategoryPage");  
	String userName = ExcelUtility.getString(1, 0, "SubCategoryPage");
	String password = ExcelUtility.getString(1, 1, "SubCategoryPage");
	String subcategory= ExcelUtility.getString(1, 2, "SubCategoryPage");
	LoginPage loginPage =new LoginPage(driver);
	loginPage.enterUseNameonUserNameField(userName).enterPasswordOnPasswordField(password).clickOnSigninButton();
	SubCategoryPage subCategoryPage =  new SubCategoryPage(driver);
	subCategoryPage.clickOnSubCategoryTile().clickOnNewButton().selectCategory().selectSubCategory(subcategory).uploadFile();
	String actualalert = subCategoryPage.getAlertText();
	assertEquals(actualalert, expectedAlert,"Sub Category is not created Successfully");


	}
	@Test(description = "Verify whether user is able to search subcaegory on sub category Page",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserisAbleToSearchSubcategoryOnCategoryPageSuccessfully()
	{
		String userName = ExcelUtility.getString(1, 0, "SubCategoryPage");
		String password = ExcelUtility.getString(1, 1, "SubCategoryPage");
		String subcategory = ExcelUtility.getString(1,2 , "SubCategoryPage");
		LoginPage loginPage =new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName).enterPasswordOnPasswordField(password).clickOnSigninButton();
		SubCategoryPage subCategoryPage =  new SubCategoryPage(driver);
		subCategoryPage.clickOnSearchButton().selectCategory1().selectSubCategory1(subcategory).searchOnSubCategoryPage();
		String actualSearchResult =subCategoryPage.getSearchResult();
		assertEquals(actualSearchResult, subcategory,"Coreect Search Result is not displayed");
	}
	


}
