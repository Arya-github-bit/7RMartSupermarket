package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	@Test(description = " Verify whether user is able to add New on ManageNews Page")
	public void verifyWhetherUserisableUpdateNewNewsonManageNewsPage()
	{
		String expectedAlertText= ExcelUtility.getString(1, 2, "ManageNewsPage"); 
		String userName = ExcelUtility.getString(1, 0, "ManageNewsPage");
		String password = ExcelUtility.getString(1, 1, "ManageNewsPage");
		String url= ExcelUtility.getString(1, 3, "ManageNewsPage");
		String news= ExcelUtility.getString(1, 4, "ManageNewsPage");
		LoginPage loginPage =new LoginPage(driver);
		loginPage.enterUseNameonUserNameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSigninButton();
		ManageNewsPage manageNewsPage= new ManageNewsPage(driver);
		manageNewsPage.clickOnManageNewsTile(url);
		manageNewsPage.clickOnNewButton();
		manageNewsPage.updateNews(news);
		manageNewsPage.clickOnSaveButton();
	    String actualAlertText =manageNewsPage.getAlertText();
		assertEquals(expectedAlertText,actualAlertText,"Admin is not able to add new on Managenews Page ");
			
	}

}
