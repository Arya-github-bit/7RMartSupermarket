package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(description = "Verify Whether User is able to Login Successfully with Valid Username and Valid Password",groups = ("smoke"),retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleLoginSuccessfullywithValidUsernameandValidPassword()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String Password = ExcelUtility.getString(1, 1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseNameonUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnSigninButton();
		boolean isNavigatedToDashboard = loginpage.whetherDashboardTileIsDisplayed();
		assertTrue(isNavigatedToDashboard, "User is not able to login successfully with valid username and valid password");
	}
	@Test(description = " Verify Whether User  is not able to Login successfully  with Valid Username and Invalid  Password",groups = ("regression"),retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserisNotAbleToLoginSuccessfullywithValidUsernameAndInvalidPassword()
	{
		String userName = ExcelUtility.getString(2, 0,"LoginPage");
		String Password = ExcelUtility.getString(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseNameonUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnSigninButton();
		boolean isNavigatedToDashboard= loginpage.whetherAlertIsDisplayed();
		assertTrue(isNavigatedToDashboard, "User is able to login successfully with valid username and invalid password");
	}
	@Test(description = "Verify Whether User  is not able to Login successfully  with Invalid Username and Valid  Password",groups = ("regression"),retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserisNotAbleToLoginSuccessfullywithInvalidUsernameAndValidPassword()
	{
		String userName = ExcelUtility.getString(3, 0, "LoginPage");
		String Password = ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseNameonUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnSigninButton();
		boolean isNavigatedToDashboard= loginpage.whetherAlertIsDisplayed();
		assertTrue(isNavigatedToDashboard, "User is able to login successfully  with invalid username and valid password");
	}
	@Test(description = "Verify Whether  User is not able to Login successfully  with Invalid Username and Invalid Password",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserisNotAbleToLoginSuccessfullywithInvalidUsernameAndInvalidPassword()
	{
		String userName = ExcelUtility.getString(4, 0, "LoginPage");
		String Password = ExcelUtility.getString(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseNameonUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnSigninButton();
		boolean isNavigatedToDashboard= loginpage.whetherAlertIsDisplayed();
		assertTrue(isNavigatedToDashboard, "User is able to login successfully with invalid username and invalid password");
	}

}
