package pages.actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import pages.locators.Price_HomePageLocators;

public class Price_HomePageActions {
	
//	WebDriver driver = DriverFactory.getDriver();
	
	Price_HomePageLocators  price_HomePageLocators = null;
	public Price_HomePageActions()
	{
		this.price_HomePageLocators = new Price_HomePageLocators();
		PageFactory.initElements(DriverFactory.getDriver(), price_HomePageLocators);
	}
	
	public Price_AlertPageActions clickSetYourFirstAlertbutton()
	{
		Actions action= new Actions(DriverFactory.getDriver());
		action.moveToElement(price_HomePageLocators.setYourFirstAlertButton).perform();
		
//		clickOnExplicitWait(DriverFactory.getDriver(), price_HomePageLocators.setYourFirstAlertButton, 5);
		
		clickOnFluentWait(price_HomePageLocators.setYourFirstAlertButton);

		
		return new Price_AlertPageActions();
		
	}
	
	/**
	 * Explicit Wait:  
	•There can be instance when a particular element takes more than a minute to load.
	•In that case you definitely not like to set a huge time to Implicit wait, as if you do this your browser will going to wait for the same time for every element.
	•To avoid that situation you can simply put a separate time on the required element only.
	•By following this your browser implicit wait time would be short for every element and it would be large for specific element.
	 */
	public static void clickOnExplicitWait(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	/**
	 * FluentWait
	 * 
	 */
	private static void clickOnFluentWait(WebElement element) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(DriverFactory.getDriver())
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		element.click();		
	}
	
	

}
