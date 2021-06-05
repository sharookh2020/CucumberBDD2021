package parallel;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.actions.Price_AlertPageActions;
import pages.actions.Price_HomePageActions;

public class Price_WaitSteps {
	
	Price_HomePageActions price_HomePageActions = new Price_HomePageActions();
	Price_AlertPageActions price_AlertPageActions = new Price_AlertPageActions();
	
	@Given("I navidate to {string} price home page")
	public void i_navidate_to_price_home_page(String url) {
	    DriverFactory.getDriver().get(url);
	}

	@When("user select on Set Your First Alert button from home page")
	public void user_select_on_set_your_first_alert_button_from_home_page() {
	    price_HomePageActions.clickSetYourFirstAlertbutton();	    
	}
	
	@Then("user should be able to view alert page with header {string} successfully")
	public void user_should_be_able_to_view_alert_page_with_header_successfully(String alertPageHeader) {
		String actualResult = price_AlertPageActions.alertPageHeaderName();
		System.out.println("------------actualResult:"+actualResult);
		Assert.assertEquals(actualResult, alertPageHeader);
	}



}
