package parallel;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.actions.WindowHandlesParentPageActions;

public class WindowHandlesSteps {
	
	WindowHandlesParentPageActions windowHandlesParentPageActions = new WindowHandlesParentPageActions();

	@Given("I navigate to the Home Page {string} of salesforce Website")
	public void i_navigate_to_the_home_page_of_salesforce_website(String url) {
	    DriverFactory.getDriver().get(url);
	}

	@When("User click on Start My Free Trial button")
	public void user_click_on_start_my_free_trial_button() throws InterruptedException {
	   windowHandlesParentPageActions.clickOnStartMyFreeTrialButton();
	}

//	@Then("redirect to New tab of free sales trial Sign Up page and enters valid data <{string}> <{string}> <{string}> <{string}> <{string}> <{string}> <{string}> <{string}>")
//	public void redirect_to_new_tab_of_free_sales_trial_sign_up_page_and_enters_valid_data(String firstName, String lastName, String workEmail, String jobTitle, String company, String employees, String phone, String country) {
//	    windowHandlesParentPageActions.newTabFreetrialSales(firstName, lastName, workEmail, jobTitle, company, employees, phone, country);
//	}
	
//    And user enters valid data <"FirstName"> in first name field
//    And user enters valid <"LastName"> in last name field
//    And user enters valid <"WorkEmail"> in work email field
//    And select <"JobTitle"> from dropdoen
//    And user enters valid <"Company"> in Company field
//    And select <"Employees"> size from dropdoen
//    And user enters valid <"Phone"> in Phone field
//    And select <"Country"> from dropdoen

	@Then("redirect to New tab of free sales trial Sign Up page and enters valid data {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} data")
	public void redirect_to_new_tab_of_free_sales_trial_sign_up_page_and_enters_valid_data_and_and_and_and_and_and_and_data(String firstName, String lastName, String workEmail, String jobTitle, String company, String employees, String phone, String country) throws InterruptedException {
		windowHandlesParentPageActions.newTabFreetrialSales(firstName, lastName, workEmail, jobTitle, company, employees, phone, country);
	}



	@Then("user successfully redirect to Dashboard page")
	public void user_successfully_redirect_to_dashboard_page() {
	    
	}
	
}
