package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class ParallelRun {

	@CucumberOptions(
			plugin = {"pretty",				
					//"html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
					//"junit:target/cucumber-reports/cucumber.xml",
//					"json:target/cucumber/report.json","html:target/cucumber/report.html",
//					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-output-thread/",
					"rerun:target/failedrerun.txt"
					},
			tags = "@GB or @FB", 
			monochrome = true,
			glue = { "parallel" },
			features = { "src/test/resources/FeatureFiles" }
			)
	public class PositiveTest extends AbstractTestNGCucumberTests {

		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}

	
}
