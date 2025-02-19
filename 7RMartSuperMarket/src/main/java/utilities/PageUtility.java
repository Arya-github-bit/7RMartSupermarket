package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	public void selectFromDropDownUsingValue(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectFromDropDownUsingIndex(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectFdromDropDownUsingVisibleText(WebElement element,String visibleText)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void toMoveanElement( WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		
	}
	public void toDoubleClickanelement(WebElement element)
	{
		Actions actions = new Actions(null);
		actions.doubleClick(element).perform();
	}
	public void toRightClickanelement(WebElement element)
	{
		Actions actions = new Actions(null);
		actions.contextClick(element).perform();
	}
	public void toDragandDropanelement(WebElement element1,WebElement element2)
	{
		Actions actions = new Actions(null);
		actions.dragAndDrop(element1, element2);
		
	}
	public void getTextFromAlert(WebDriver driver) 
	{
		String alertText = driver.switchTo().alert().getText();
	}
	public void scrollDown(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	public void scrollUp(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(x,-y)", "");
	}
	public void navigateToPage(WebDriver driver,String url)
	{
		driver.navigate().to(url);
	}



}
