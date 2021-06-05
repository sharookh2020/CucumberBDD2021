package parallel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.actions.PaginationDataTablePageActions;

public class PaginationSteps {
	
	PaginationDataTablePageActions paginationDataTablePageActions = new PaginationDataTablePageActions();
	
	@Given("I navigate to WebTable Page {string} of CloudTable Website")
	public void i_navigate_to_web_table_page_of_cloud_table_website(String url) {
		DriverFactory.getDriver().get(url);		
	}

	@When("I move to WebTable with Next button")
	public void i_move_to_web_table_with_next_button() {
		paginationDataTablePageActions.moveToNextButton();
	}

	@When("User click on next button until it no longer exists")
	public void user_click_on_next_button_until_it_no_longer_exists() {
		//paginationDataTablePageActions.handlingPagination();
		Map<String,String> results = paginationDataTablePageActions.handlingPagination();
		String expected = results.get("expected");
		String actual = results.get("actual");
		
		Assert.assertEquals(actual, expected);
	}
	
	@When("User click on Sorting Name column")
	public void user_click_on_sorting_name_column() {
		
		Map<String,List<String>> data = paginationDataTablePageActions.handlingSorting();
		System.out.println("--------------------------------------------");
		List<String> expected = new ArrayList<String>();
		List<String> actual = new ArrayList<String>();
		expected =data.get("expected");
		actual =data.get("actual");
		expected.stream().forEach(x -> System.out.println(x));
		System.out.println("--------------------------------------------");
		actual.stream().forEach(y -> System.out.println(y));
		System.out.println("--------------------------------------------");
		
//		Assert.assertTrue(actual.equals(expected));
//		Assert.assertEquals(expected, actual);
		
//		SoftAssert softAssert1 = new SoftAssert();
//		softAssert1.assertEquals(expected, actual);
//		softAssert1.assertAll();
		
	}
	
	@Then("I shoud choose {string} employee from sorted table and expected salary {string}")
	public void i_shoud_choose_employee_from_sorted_table_and_expected_salary(String employee, String expectedsalary) {
	    
		String actualSalary = paginationDataTablePageActions.salaryofemployeeFromSortedTable(employee);
		System.out.println("----------Actual Salary :"+actualSalary);
		System.out.println("----------Expected Salary :"+expectedsalary);
		Assert.assertEquals(expectedsalary, actualSalary);
		
	}
	
	@Then("User enter {string} in Search filter field")
	public void user_enter_in_search_filter_field(String employeeName) {
		paginationDataTablePageActions.enterDataInSearchFilter(employeeName);
	}


	@Then("Result should match {string} with in the Web table contained data")
	public void result_should_match_with_in_the_web_table_contained_data(String expectedEmpName) {
		Map<String,String> results = paginationDataTablePageActions.validateSearchFilterResult(expectedEmpName);
		
		String expected = results.get("expected");
		String actual = results.get("actual");
				
		Assert.assertEquals(actual, expected);
	}
	
	@Then("list all valid links")
	public void list_all_valid_links() {
		paginationDataTablePageActions.listAllLinks();
	}
	

}
