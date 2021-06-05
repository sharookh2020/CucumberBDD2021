
@tag
Feature: Price app home page data access for new user
  As a new Price app user
  I Want access home page products
  So that I can view proper redirection and Product details

	Background:
		Given I navidate to "https://price.com/" price home page

  @tag1
  Scenario: User open Price Alert page via Set Your First Alert button from Home page slide
    When user select on Set Your First Alert button from home page
    Then user should be able to view alert page with header "My Active Price Drops" successfully
