package pages.actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.locators.CarsGuideHomePageLocators;
import factory.DriverFactory;

public class CarsGuideHomePageActions {
	
	CarsGuideHomePageLocators carsGuideHomePageLocators=null;
	public CarsGuideHomePageActions()
	{
		
		this.carsGuideHomePageLocators=new CarsGuideHomePageLocators();
		PageFactory.initElements(DriverFactory.getDriver(), carsGuideHomePageLocators);
	}
	
	public void moveToCarsForSaleMenu()
	{
		Actions action= new Actions(DriverFactory.getDriver());
		action.moveToElement(carsGuideHomePageLocators.carsForSaleLink).perform();
	}
	public void clickOnSearchCarsMenu()
	{
		//moveToCarsForSaleMenu();
		carsGuideHomePageLocators.searchCarsLink.click();
		
	}
	public void clickOnUsedSearchCarsMenu()
	{
		//moveToCarsForSaleMenu();
		carsGuideHomePageLocators.usedSearchCarsLink.click();		
	}
	public void moveToSigninSignupMenu()
	{
		Actions action= new Actions(DriverFactory.getDriver());
		action.moveToElement(carsGuideHomePageLocators.SignupSigninLink).perform();
	}
	public void clickOnSignInMenu()
	{
		carsGuideHomePageLocators.SigninLink.click();		
	}
	public String getUserName()
	{
		return carsGuideHomePageLocators.UserNameLink.getText();
	}

}
