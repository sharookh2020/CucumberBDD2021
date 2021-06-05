package pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaginationDataTablePageLocators {
	
	/**
	 * xpath or css
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='example']/tbody/tr/td[1]")
	public List<WebElement> nameElementsXPATH;
	
	@FindBy(how = How.CSS,using = "#example>tbody>tr>td:nth-child(1)")
	public List<WebElement> nameElementsCSS;
	
	
//	@FindBy(how = How.CSS,using = "#example>tbody>tr>td:nth-child(6)")
//	public List<WebElement> salaryElements;
	
	@FindBy(how=How.ID,using= "example_next")
	public WebElement nextButton;
	
	@FindBy(how=How.ID,using = "example_info")
	public WebElement totalTableShowingEntries;
	
	@FindBy(how = How.CSS, using = "#example>thead>tr>th:nth-child(1)")
	public WebElement nameColumn;
	
	@FindBy(how=How.XPATH,using= "//input[@type='search']")
	public WebElement searchFilterField;
	
	@FindBy(how = How.TAG_NAME,using = "a")
	public List<WebElement> allLinks;

}
