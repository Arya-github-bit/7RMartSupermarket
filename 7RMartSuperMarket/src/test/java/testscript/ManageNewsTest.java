package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	LoginPage loginPage;
	ManageNewsPage manageNewsPage;
	@Test(description = " Verify whether user is able to add New on ManageNews Page",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserisableUpdateNewNewsonManageNewsPage()
	{
		String expectedAlertText= ExcelUtility.getString(1, 2, "ManageNewsPage"); 
		String userName = ExcelUtility.getString(1, 0, "ManageNewsPage");
		String password = ExcelUtility.getString(1, 1, "ManageNewsPage");
		String url= ExcelUtility.getString(1, 3, "ManageNewsPage");
		String news= ExcelUtility.getString(1, 4, "ManageNewsPage");
		loginPage =new LoginPage(driver);
		manageNewsPage=loginPage.enterUseNameonUserNameField(userName).enterPasswordOnPasswordField(password).clickOnSigninButton().clickOnManageNewsTile(url).clickOnNewButton().updateNews(news).clickOnSaveButton();
	    String actualAlertText =manageNewsPage.getAlertText();
		assertEquals(expectedAlertText,actualAlertText,"Admin is not able to add new on Managenews Page ");
			
	}

}
