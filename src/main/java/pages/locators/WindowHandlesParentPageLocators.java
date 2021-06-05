package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WindowHandlesParentPageLocators {

	// https://www.salesforce.com/in/?ir=1
	
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Start my free trial')]")
	public WebElement startMyFreeTrialButton;
	
	// https://www.salesforce.com/in/form/signup/freetrial-sales/?d=jumbo1-btn-ft
	
	@FindBy(how=How.NAME, using = "UserFirstName")
	public WebElement firstNameField;
	
	@FindBy(how=How.NAME, using = "UserLastName")
	public WebElement lastNameField;
	
	@FindBy(how=How.NAME, using = "UserEmail")
	public WebElement workEmailField;
	
	@FindBy(how=How.XPATH, using = "//*[@name='UserTitle']")
	public WebElement jobTitleDropdown;
	
	@FindBy(how=How.NAME, using = "CompanyName")
	public WebElement companyField;
	
	@FindBy(how=How.XPATH, using = "//*[@name='CompanyEmployees']")
	public WebElement employeesDropdown;
	
	@FindBy(how=How.NAME, using = "UserPhone")
	public WebElement phoneField;
	
	@FindBy(how=How.XPATH, using = "//*[@name='CompanyCountry']")
	public WebElement countryDropdown;
	
	@FindBy(how=How.XPATH, using = "//div[6]/div[1]/div[1][@class='checkbox-ui']")
	public WebElement agreementCheckBox;
	
	@FindBy(how=How.XPATH, using = "//*[@name='start my free trial']")
	public WebElement startMyFreeTrialSubmitButton;
	
	//https://ap24.lightning.force.com/lightning/page/home
	
	
}
