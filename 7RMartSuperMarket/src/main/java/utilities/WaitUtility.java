package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility
{
	public static final long IMPLICIT_WAIT = 5;
	public static final long EXPLICIT_WAIT = 30;
	public void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public void waitUntilAlertIsPresent(WebDriver driver,WebElement target) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitUntilElementToBeClickable(WebDriver driver,WebElement target)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
		
	}
	public void waitUntiltextToBePresentInElement(WebDriver driver,WebElement target,String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, text));
		
	}
	public void waitUntilTitileIs(WebDriver driver,String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleIs(title));
		
	}
	public void waitUntilElementToBePresentInElement(WebDriver driver,WebElement target,String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, text));
		
	}
	public void waitUntillelementToBeClickableUsingFluentWait(WebDriver driver,WebElement element) 
	{
		FluentWait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void swait(WebDriver driver,WebElement element)
	{
		FluentWait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(element));
	}
}
