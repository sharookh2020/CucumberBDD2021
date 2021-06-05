
@tag
Feature: Acceptance testing to validate Pagination is working.
  In order to validate pagination from first page to last page
  
	Background:
		Given I navigate to WebTable Page "https://datatables.net/examples/advanced_init/dt_events.html" of CloudTable Website
    When I move to WebTable with Next button
  
  @GB
  Scenario: Validate web table pagination    
    When User click on next button until it no longer exists 
    
	@GB
	Scenario: Validate webtable sorting
	 When User click on Sorting Name column
	 Then I shoud choose "Rhona Davidson" employee from sorted table and expected salary "$327,900"
	
	@GB
	Scenario: Validate search filtering
		Then User enter "Brenden Wagner" in Search filter field
		And Result should match "Brenden Wagner" with in the Web table contained data
	
	@GB1	
	Scenario: List all valid links in the page
		Then list all valid links 