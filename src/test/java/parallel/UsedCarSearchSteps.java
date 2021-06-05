package parallel;

import java.util.List;

import org.testng.Assert;

import factory.DriverFactory;

import io.cucumber.java.en.*;
import pages.actions.CarsGuideHomePageActions;
import pages.actions.UsedCarsSearchPageActions;

public class UsedCarSearchSteps {

	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	UsedCarsSearchPageActions usedCarsSearchPageActions= new UsedCarsSearchPageActions();
	
	@Given("I navigate to the  Home Page {string} of CarsGuide Website")
	public void i_navigate_to_the_home_page_of_cars_guide_website(String url) {
		DriverFactory.getDriver().get(url);
	}

	@When("I move to Car-For-Sale Menu")
	public void i_move_to_car_for_sale_menu() {
		carsGuideHomePageActions.moveToCarsForSaleMenu();
	}

	@When("click on submenu Used Cars Search link")
	public void click_on_submenu_used_cars_search_link() {
		carsGuideHomePageActions.clickOnUsedSearchCarsMenu();
	}

	@When("select carMaker from AnyMake dropdown")
	public void select_car_maker_from_any_make_dropdown(List<String> carMaker) {
		usedCarsSearchPageActions.selectCarMaker(carMaker.get(1));
	}

	@When("select  car model")
	public void select_car_model(List<String> list) {
		System.out.println("carModel-->"+list.get(1));
		String carModel=list.get(1);
		usedCarsSearchPageActions.selectCarModel(carModel);
	}

	@When("select location  from SelectLocation dropdown")
	public void select_location_from_select_location_dropdown(List<String> location) {
		usedCarsSearchPageActions.selectLocation(location.get(1));
	}

	@When("select price")
	public void select_price(List<String> price) {
		System.out.println("price-->"+price.get(1));
	    usedCarsSearchPageActions.selectPrice(price.get(1));
	}

	@When("click on Find_My_Car button")
	public void click_on_find_my_car_button() {
		usedCarsSearchPageActions.clickOnFindMyNextCarButton();
	}

	@Then("I should see list of Used cars")
	public void i_should_see_list_of_used_cars() {
		System.out.println("Used car list populated");
	}

	@Then("the page title should match expected title  {string}")
	public void the_page_title_should_match_expected_title(String expectedPageTitle) {
		String ActualPageTitle= DriverFactory.getDriver().getTitle();
	    System.out.println("Actual page title-->"+ActualPageTitle);
	    System.out.println("Expected page title-->"+expectedPageTitle);
	    Assert.assertEquals(expectedPageTitle, ActualPageTitle);
	}
}
