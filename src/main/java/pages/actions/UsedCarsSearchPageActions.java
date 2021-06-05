package pages.actions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import factory.DriverFactory;
import pages.locators.UsedCarSearchPageLocators;

public class UsedCarsSearchPageActions {
	
	//WebDriver driver=null;
		UsedCarSearchPageLocators usedCarSearchPageLocators=null;
		public  UsedCarsSearchPageActions()
		{
			//this.driver=driver;
			this.usedCarSearchPageLocators= new UsedCarSearchPageLocators();
			PageFactory.initElements(DriverFactory.getDriver(), usedCarSearchPageLocators);
		}

		public void selectCarMaker(String carBrand)
		{
			
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='makes']")).click();
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form")).click();
			usedCarSearchPageLocators.carMakerDropDown.click();
			Select selectCarMaker=new Select(usedCarSearchPageLocators.carMakerDropDown);
			selectCarMaker.selectByVisibleText(carBrand);
			
		}
		
		public void selectCarModel(String carModel)
		{
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='models']")).click();			
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form")).click();
			usedCarSearchPageLocators.selectModelDropDown.click();
			Select selectCarModel=new Select(usedCarSearchPageLocators.selectModelDropDown);
			
			selectCarModel.selectByVisibleText(carModel);
			
			
		}
		public void selectLocation(String location)
		{
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='locations']")).click();			
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form")).click();
			usedCarSearchPageLocators.selectLocation.click();
			Select selectLocation=new Select(usedCarSearchPageLocators.selectLocation);
			
			selectLocation.selectByVisibleText(location);
		}		
		public void selectPrice(String price)
		{
			
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='price-max']")).click();
			//DriverFactory.getDriver().findElement(By.xpath(".//*[@id='priceTo']")).click();
			usedCarSearchPageLocators.priceList.click();
			Select selectPrice=new Select(usedCarSearchPageLocators.priceList);
			List<WebElement> list=selectPrice.getOptions();
			for(WebElement s:list)
			{
				System.out.println("--->"+s.getText());
			}
			selectPrice.selectByVisibleText(price);
		}
		
		public void clickOnFindMyNextCarButton()
		{
			DriverFactory.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form")).click();
			usedCarSearchPageLocators.findMyNextCarButton.click();
			
		}

}
