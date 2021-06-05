package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WindowHandlesThirdPageLocators {

	@FindBy(how=How.XPATH, using = "//*[@title='Sales']")
	public WebElement salesMenu;
}
