package pages.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import pages.locators.PaginationDataTablePageLocators;

public class PaginationDataTablePageActions {

	PaginationDataTablePageLocators paginationDataTablePageLocators = null;
	
	public PaginationDataTablePageActions() {
		
		this. paginationDataTablePageLocators = new PaginationDataTablePageLocators();
		PageFactory.initElements(DriverFactory.getDriver(), paginationDataTablePageLocators);
	}
	
	public void moveToNextButton()
	{
		Actions action = new Actions(DriverFactory.getDriver());
		action.moveToElement(paginationDataTablePageLocators.nextButton).perform();
	}
	
	public Map<String, String> handlingPagination() 
	{
		List<WebElement> nameElements = paginationDataTablePageLocators.nameElementsCSS;
		
		List<String> names = new ArrayList<String>();
		
		for(WebElement nameElement : nameElements)
		{
			names.add(nameElement.getText());
		}
		
		String nextButtonClassName = paginationDataTablePageLocators.nextButton.getAttribute("class");
		
		while(!nextButtonClassName.contains("disabled"))
		{
			paginationDataTablePageLocators.nextButton.click();
			nameElements = paginationDataTablePageLocators.nameElementsCSS;
			
			for(WebElement nameElement : nameElements)
			{
				names.add(nameElement.getText());
			}
			
			nextButtonClassName = paginationDataTablePageLocators.nextButton.getAttribute("class");
		}
		
		for(String name : names)
		{
			System.out.println(name);
		}
		
		String totalSize = String.valueOf(names.size());
		System.out.println("Total number of names :"+ totalSize);
		
		String displayedCount = paginationDataTablePageLocators.totalTableShowingEntries.getText().split(" ")[5];
		
		Map<String, String> result = new HashMap<>();
		result.put("expected", String.valueOf(names.size()));  
        result.put("actual",displayedCount);
        
        System.out.println("Expected result: "+ String.valueOf(names.size()));
        System.out.println("Actual result: "+ displayedCount);
        
		return result;
	}
	
	public Map<String,List<String>> handlingSorting()
	{
		paginationDataTablePageLocators.nameColumn.click();
		String nameColumnClassName = paginationDataTablePageLocators.nameColumn.getAttribute("class");
//		System.out.println("--------"+nameColumnClassName+"-------------");
		
		while(!nameColumnClassName.contains("sorting_asc"))
		{
			paginationDataTablePageLocators.nameColumn.click();
			
			nameColumnClassName = paginationDataTablePageLocators.nameColumn.getAttribute("class");		
			
		}
		

		// Capture all webelements into list
		List<WebElement> nameElements = paginationDataTablePageLocators.nameElementsXPATH;
		
		// Hashmap used for return original and sorted list
//		https://stackoverflow.com/questions/12947659/how-can-i-return-2-arraylist-from-same-method
		Map<String,List<String>> map =new HashMap();
		
		System.out.println("-----------originalList--------------");
		List<String> originalList = nameElements.stream().map(s -> s.getText()).collect(Collectors.toList());
		map.put("expected",originalList);		
		originalList.forEach(System.out :: println);		
		
		System.out.println("-----------sortedList--------------");
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		map.put("actual",sortedList);		
		sortedList.forEach(System.out :: println);
  
		
//		System.out.println("*******************************************************************");
//		//scan the name with getText -> Rhona Davidson -> Salary : $327,900
//		List<String> salary;
//		do {
//			// Capture again all webelements into list 
//			List<WebElement> rows = paginationDataTablePageLocators.nameElementsXPATH;
//			
//		salary = rows.stream().filter(s -> s.getText().contains("Rhona Davidson")).map(s -> getSalart(s)).collect(Collectors.toList());
//        
//		salary.forEach(a -> System.out.println(a));
//		if(salary.size()<1)
//		{
//			paginationDataTablePageLocators.nextButton.click();
//		}
//		}while(salary.size()<1);
        return map;
	}
	
	public String salaryofemployeeFromSortedTable(String employee)
	{
		System.out.println("*******************************************************************");
		//scan the name with getText -> Rhona Davidson -> Salary : $327,900
		List<String> salaryList = new ArrayList<String>();
		String actualSalary;
		
		do {
			// Capture again all webelements into list 
			List<WebElement> rows = paginationDataTablePageLocators.nameElementsXPATH;
			rows.forEach(ag -> System.out.println(ag));
			
			salaryList = rows.stream().filter(s -> s.getText().contains(employee)).map(s -> getSalary(s)).collect(Collectors.toList());
        
			salaryList.forEach(a -> System.out.println(a));
			
			String delim = "";
			actualSalary = String.join(delim,salaryList);
	        System.out.println("^^^^^^^^actualSalary :"+actualSalary);
			
			
		if(salaryList.size()<1)
		{
			paginationDataTablePageLocators.nextButton.click();
		}
		}while(salaryList.size()<1);
		
		return actualSalary;
	}
	
	private static String getSalary(WebElement s)
	{
		String salaryValue = s.findElement(By.xpath("following-sibling::td[5]")).getText();
		return salaryValue;
	}
	
	public void enterDataInSearchFilter(String empName)
	{
		paginationDataTablePageLocators.searchFilterField.sendKeys(empName);
	}
	
	public Map<String, String> validateSearchFilterResult(String expectedEmpName)
	{
		List<WebElement> nameElementsList = paginationDataTablePageLocators.nameElementsCSS;
		nameElementsList.forEach(a -> System.out.println("^^^^^nameElementsList : "+a));
		
		List<WebElement> filteredList = nameElementsList.stream().filter(h -> h.getText().contains(expectedEmpName)).collect(Collectors.toList());
		filteredList.forEach(b -> System.out.println("^^^^^filteredList : "+b));
		
		Map<String, String> result = new HashMap<>();
		result.put("expected", String.valueOf(nameElementsList.size()));  
        result.put("actual",String.valueOf(filteredList.size()));
        
        return result;
	}
	
	public void listAllLinks()
	{
		String url = "";
		
		List<WebElement> listAllLinks = paginationDataTablePageLocators.allLinks;
		
		int sizeoflistAllLinks = listAllLinks.size();
		System.out.println("Size of all Links :"+sizeoflistAllLinks);
		
//		List<WebElement> hrefLinks = listAllLinks.stream().filter(k -> k.getAttribute("href")).collect(Collectors.toList());
		
		 Iterator<WebElement> it = listAllLinks.iterator();
	        
	        while(it.hasNext()){
	            
	            url = it.next().getAttribute("href");
	            
	            System.out.println(url);
	        
	            if(url == null || url.isEmpty()){
	System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	            }
	        }
	}
	
}
