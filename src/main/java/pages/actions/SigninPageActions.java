package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import factory.DriverFactory;
import pages.locators.CarsGuideHomePageLocators;
import pages.locators.SigninPageLocators;
import pages.locators.UsedCarSearchPageLocators;

public class SigninPageActions {
	
	SigninPageLocators signinPageLocators=null;
	public  SigninPageActions()
	{
		//this.driver=driver;
		this.signinPageLocators= new SigninPageLocators();
		PageFactory.initElements(DriverFactory.getDriver(), signinPageLocators);
	}
	
	
	public void enterEmail(String email)
	{	
		signinPageLocators.emailTextBox.sendKeys(email);		
	}
	public void enterPassword(String password)
	{	
		signinPageLocators.passwordTextBox.sendKeys(password);		
	}
	public UsedCarsSearchPageActions clickOnSubmitButton()
	{		
		signinPageLocators.findSubmitButton.click();
		return new UsedCarsSearchPageActions();
	}


}
