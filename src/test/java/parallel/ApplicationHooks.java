package parallel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;



import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import factory.DriverFactory;
import utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(value = "@Skip", order = 0)
	public void skip_scenario(Scenario scenario) {
		System.out.println("SKIPPED SCENARIO is : " + scenario.getName());
		Assume.assumeTrue(false);

	}

	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

//	@Before(order = 2)
//	public void launchBrowser() {
//		String browserName = prop.getProperty("browser");
//		driverFactory = new DriverFactory();
//		driver = driverFactory.init_driver(browserName);		
//	}
	
//	@Before(value = "@GB",order = 2)
//	public void launchBrowser1() {
//		String browserName = "chrome";
//		driverFactory = new DriverFactory();
//		driver = driverFactory.init_driver(browserName);		
//	}
	
	@Before(value = "@GB",order = 2)
	public void launchBrowser1() {
		String browserName = "chrome";
		/**
		 * Run at Local Machine
		 */
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
		/**
		 * Run at Remote (AWS)
		 */
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("browserName", "chrome");
//		try {
//			driver = new RemoteWebDriver(new URL("http://13.233.157.149:4444/wd/hub"), cap);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
		
	}
	
	@Before(value = "@FB",order = 2)
	public void launchBrowser2() {
		String browserName = "firefox";
		/**
		 * Run at Local Machine
		 */
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
		/**
		 * Run at Remote (AWS)
		 */
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("browserName", "firefox");		
//		try {
//			driver = new RemoteWebDriver(new URL("http://13.233.157.149:4444/wd/hub"), cap);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
		
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
