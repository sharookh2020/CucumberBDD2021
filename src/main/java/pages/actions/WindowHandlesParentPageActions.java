package pages.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import factory.DriverFactory;
import pages.locators.WindowHandlesParentPageLocators;

public class WindowHandlesParentPageActions {
	
	WindowHandlesParentPageLocators windowHandlesParentPageLocators = null;
	public WindowHandlesParentPageActions()
	{
		this.windowHandlesParentPageLocators = new WindowHandlesParentPageLocators();
		PageFactory.initElements(DriverFactory.getDriver(), windowHandlesParentPageLocators);
	}
	
	public void clickOnStartMyFreeTrialButton() throws InterruptedException
	{
		Actions action= new Actions(DriverFactory.getDriver());
		action.moveToElement(windowHandlesParentPageLocators.startMyFreeTrialButton).perform();
		windowHandlesParentPageLocators.startMyFreeTrialButton.click();
		Thread.sleep(6000);
	}
	
	public void newTabFreetrialSales(String firstName, String lastName, String workEmail, String jobTitle, String company, String employees, String phone, String country) throws InterruptedException
	{
			Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
			
			System.out.println("------WindowHandles------:"+windowHandles);
			
			Iterator<String> iterator = windowHandles.iterator();
			String parentWindow = iterator.next();
			System.out.println("------parentWindow------:"+parentWindow);
			String childWindow = iterator.next();
			System.out.println("------childWindow------:"+childWindow);
			
			DriverFactory.getDriver().switchTo().window(childWindow);
			
			System.out.println("childWindow titel :"+DriverFactory.getDriver().getTitle());
			
			windowHandlesParentPageLocators.firstNameField.sendKeys(firstName);			
			windowHandlesParentPageLocators.lastNameField.sendKeys(lastName);			
			windowHandlesParentPageLocators.workEmailField.sendKeys(workEmail);

			windowHandlesParentPageLocators.jobTitleDropdown.click();
			Select selectJobTitleDrop=new Select(windowHandlesParentPageLocators.jobTitleDropdown);
			
			List<WebElement> list=selectJobTitleDrop.getOptions();
			for(WebElement s:list)
			{
				System.out.println("--->"+s.getText());
			}	
			
			System.out.println("------------:"+jobTitle);			
			selectJobTitleDrop.selectByVisibleText(jobTitle);
			
			windowHandlesParentPageLocators.companyField.sendKeys(company);
			
			windowHandlesParentPageLocators.employeesDropdown.click();
			Select selectEmployeeDrop = new Select(windowHandlesParentPageLocators.employeesDropdown);
			selectEmployeeDrop.selectByVisibleText(employees);
			
			windowHandlesParentPageLocators.phoneField.sendKeys(phone);
			
			windowHandlesParentPageLocators.countryDropdown.click();
			Select selectCountry = new Select(windowHandlesParentPageLocators.countryDropdown);
			selectCountry.selectByVisibleText(country);
			
			Actions action= new Actions(DriverFactory.getDriver());
			action.moveToElement(windowHandlesParentPageLocators.agreementCheckBox).perform();
			windowHandlesParentPageLocators.agreementCheckBox.click();
			
			windowHandlesParentPageLocators.startMyFreeTrialSubmitButton.click();

			Thread.sleep(5000);
			
			DriverFactory.getDriver().switchTo().window(parentWindow);
			System.out.println("parentWindow titel :"+DriverFactory.getDriver().getTitle());
	}
	

	


}
