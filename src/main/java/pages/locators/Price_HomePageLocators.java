package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Price_HomePageLocators {
	
	@FindBy(how = How.XPATH,using = "//h4[contains(text(),'Brooks')]")
	public WebElement cardContent;
	
	@FindBy(how = How.XPATH,using ="//*[contains(text(),'Set Your First Alert')]")
	public WebElement setYourFirstAlertButton;
	

}
