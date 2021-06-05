package parallel;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.actions.CarsGuideHomePageActions;
import pages.actions.SigninPageActions;

public class SigninSteps {

	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	SigninPageActions signinPageActions = new SigninPageActions();
	
	@When("I move to SignIn-SignUp Menu")
	public void i_move_to_sign_in_sign_up_menu() {
		carsGuideHomePageActions.moveToSigninSignupMenu();
	}

	@When("click on submenu Sign In link")
	public void click_on_submenu_sign_in_link() {
		carsGuideHomePageActions.clickOnSignInMenu();
	}

	@When("user enter valid {string} in email field")
	public void user_enter_valid_in_email_field(String email) {
		signinPageActions.enterEmail(email);
	}

	@When("user enter valid {string} in password field")
	public void user_enter_valid_in_password_field(String password) {
		signinPageActions.enterPassword(password);
	}

	@When("click on Sign In button")
	public void click_on_sign_in_button() {
	    signinPageActions.clickOnSubmitButton();
	}

	@Then("User gets login and User can view user name at top right")
	public void user_gets_login_and_user_can_view_user_name_at_top_right() {
		String expectedUserName ="Sharookh";
		String actualUserName = carsGuideHomePageActions.getUserName();
		System.out.println("----------"+ actualUserName);
		Assert.assertEquals(expectedUserName, actualUserName);
	}

}
