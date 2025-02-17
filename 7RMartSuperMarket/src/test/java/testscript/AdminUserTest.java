package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base
{
	//@Test (description = "check the user can create a new category" , retryAnalyzer = Retry.class)
	@Test(description = " Verify Whether admin is able to add new User on AdminUser Page",retryAnalyzer = retry.Retry.class)
	public void verifyAddingNewUserOnAdminUserPage()
	{
		String userName= ExcelUtility.getString(1, 0, "AdminUserPage");
		String password =ExcelUtility.getString(1, 1, "AdminUserPage");
		String expectedAlertMessage =ExcelUtility.getString(1, 2, "AdminUserPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSigninButton();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickOnAdminUserTile();	
		adminUserPage.clickOnNewButton();
		adminUserPage.enterUserNameOfNewUser();
		adminUserPage.enterNewUserPassword();
		adminUserPage.selectUserType();
		adminUserPage.clickOnSaveButton();
		String actual= adminUserPage.isalertforCreatingNewdisplayed();
		String actualAlertMessage=actual.substring(9);
		assertEquals(expectedAlertMessage, actualAlertMessage,"Admin is not able to add New User on AdminUser page successfully");


	}
	@Test(description = "Verify Search Button on AdminUser Page ",retryAnalyzer = retry.Retry.class)
	public void verifySearchUserOnAdminUserPage()
	{
		String userName =ExcelUtility.getString(1, 0, "AdminUserPage");
		String password =ExcelUtility.getString(1, 1, "AdminUserPage");
		String searchUserName=ExcelUtility.getString(1, 3, "AdminUserPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSigninButton();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickOnAdminUserTile();	
		adminUserPage.clickOnSearchButton1();
		adminUserPage.enterUserNameInSearchField(searchUserName);
		adminUserPage.clickOnSearchButton();
		String actualResult=adminUserPage.getSearchResult();
		assertEquals(actualResult, searchUserName,"Correct Search result is not displayed");
	}
	@Test(description = "Verify whether Admin is able to change status of user successfully ",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherAdminisAbleToChangeStatusofUser()
	{String userName=ExcelUtility.getString(1, 0, "AdminUserPage");
	String password=ExcelUtility.getString(1, 1, "AdminUserPage");
	String expectedStatusAlertMessage=ExcelUtility.getString(2, 2, "AdminUserPage");
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterUseNameonUserNameField(userName);
	loginPage.enterPasswordOnPasswordField(password);
	loginPage.clickOnSigninButton();
	AdminUserPage adminUserPage = new AdminUserPage(driver);
	adminUserPage.clickOnAdminUserTile();	
	adminUserPage.clickOnStatusButton();
	String actualStatusAlertText = adminUserPage.isAlertforUserStatusChangeDisplayed();
	String actualStatusAlertMessage=actualStatusAlertText.substring(9);
	assertEquals(actualStatusAlertMessage, expectedStatusAlertMessage,"Admin is not able to change status on User");	
	}
	@Test(description = "Verify whether admin is able to Update Password of User Successfully",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherAdminisAbletoUpdatePasswordoftheUser()
	{
		String userName=ExcelUtility.getString(1, 0, "AdminUserPage");
		String password =ExcelUtility.getString(1, 1, "AdminUserPage");
		String ExpectedUpdateAlertMessage=ExcelUtility.getString(3, 2, "AdminUserPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSigninButton();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickOnAdminUserTile();
		adminUserPage.clickOnEditButton();
		//adminUserPage.editPassword();
		//adminUserPage.clickOnUpdateButton();
		//String actualUpdateAlertMessage = adminUserPage.alertForUserUpdatedSuccessfully();
		//assertEquals(actualUpdateAlertMessage, ExpectedUpdateAlertMessage,"Admin is not able to Update Password of User Successfully");
		
	}

}
