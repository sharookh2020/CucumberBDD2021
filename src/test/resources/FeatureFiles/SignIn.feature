Feature: Acceptance testing validate login page is working
  In order to validate valid and invalid user account

	@Smoke
  Scenario Outline: Sign In with valid email and password
    Given I navigate to the  Home Page "https://www.carsguide.com.au" of CarsGuide Website
    When I move to SignIn-SignUp Menu
    And click on submenu Sign In link
    When user enter valid "<Email>" in email field
    And user enter valid "<Password>" in password field
    And click on Sign In button 
    Then User gets login and User can view user name at top right

    Examples: 
      | Email  | Password |
      | sharookhtest1@gmail.com |     Car@1234 |
      
