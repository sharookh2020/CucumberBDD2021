package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Price_AlertPageLocators {
	
	@FindBy(how = How.XPATH,using = "//*[contains(text(),'My Active Price Drops')]")
	public WebElement pageHeaderText;

}
