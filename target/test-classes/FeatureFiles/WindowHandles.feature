
@tag
Feature: Acceptance testing to validate Window Handles is working perfectly
  In order to validate start my free trial with new tab
  In order to validate registration with valid details
  Check user can be succefully register and landing on Dashboard perfectly

  @tag1
  Scenario Outline: Register free trial using Windoe Handles
    Given I navigate to the Home Page "https://www.salesforce.com/in/?ir=1" of salesforce Website
    When User click on Start My Free Trial button
    Then redirect to New tab of free sales trial Sign Up page and enters valid data "<FirstName>" and "<LastName>" and "<WorkEmail>" and "<JobTitle>" and "<Company>" and "<Employees>" and "<Phone>" and "<Country>" data
    Then user successfully redirect to Dashboard page

		Examples: 
		|FirstName | LastName | WorkEmail |JobTitle| Company | Employees | Phone | Country |
    |Ram | G | test2@gmail.com |IT Manager| TechA | 1 - 15 employees | 9998599990 | India |
