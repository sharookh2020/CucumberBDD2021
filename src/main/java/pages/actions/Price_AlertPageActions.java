package pages.actions;

import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import pages.locators.Price_AlertPageLocators;

public class Price_AlertPageActions {
	
	Price_AlertPageLocators price_AlertPageLocators = null;
	public Price_AlertPageActions()
	{
		this.price_AlertPageLocators = new Price_AlertPageLocators();
		PageFactory.initElements(DriverFactory.getDriver(), price_AlertPageLocators);
	}
	
	public String alertPageHeaderName()
	{
		return price_AlertPageLocators.pageHeaderText.getText();
	}

}
