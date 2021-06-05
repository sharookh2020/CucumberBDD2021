package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CarsGuideHomePageLocators {
	
	@FindBy(how=How.LINK_TEXT,using="buy + sell")
	public WebElement carsForSaleLink;
	
	@FindBy(how=How.LINK_TEXT,using="Sell My Car")
	public WebElement sellMyCarLink;
	
	@FindBy(how=How.LINK_TEXT,using="Car Reviews")
	public WebElement carReviewsLink;
	
	@FindBy(how=How.LINK_TEXT,using="Search Cars")
	public WebElement searchCarsLink;
	
	@FindBy(how=How.LINK_TEXT,using="Used")
	public WebElement usedSearchCarsLink;
	
	
	@FindBy(how=How.LINK_TEXT,using="Sign up / Sign in")
	public WebElement SignupSigninLink;
	
	@FindBy(how=How.LINK_TEXT,using="Sign in")
	public WebElement SigninLink;
	
	@FindBy(how=How.LINK_TEXT,using="Sharookh")
	public WebElement UserNameLink;

}
