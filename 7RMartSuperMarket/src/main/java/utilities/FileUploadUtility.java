package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtility 
{
	public void fileUploadUsingSendKeys(WebElement chooseFile,String filePath)
	{
		chooseFile.sendKeys(filePath);
	}
	public void fileUploadUsingRobotClass( WebDriver driver,String url,String filePath) throws AWTException
	{
		driver.navigate().to(url);
		StringSelection sS =new StringSelection(filePath);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sS,null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);//press enter key
		//releasing enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(30);
		robot.keyPress(KeyEvent.VK_CONTROL);//click on ctrl V (paste)
		robot.keyPress(KeyEvent.VK_V);//two


		robot.keyRelease(KeyEvent.VK_CONTROL);//release command
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(50);

		// r.delay(90);
		//D:\D drive\Software testing\Certificates\Manual.pdf
		robot.keyRelease(KeyEvent.VK_ENTER);


	}


	
}
