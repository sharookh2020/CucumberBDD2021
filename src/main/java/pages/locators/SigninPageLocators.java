package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SigninPageLocators {
	
	@FindBy(how=How.XPATH,using=".//*[@name='email']")
	public WebElement emailTextBox;
	
	@FindBy(how=How.XPATH,using=".//*[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy(how=How.XPATH,using=".//*[@type='submit']")
	public WebElement findSubmitButton;
	
	//Test for git
	
	//Test for git update 2

}
