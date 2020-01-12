Feature: PHPTravels Web Portal Book Hotel

	@RegressionTest
  	Scenario: Load Home page and check Home page elements
		Given I open a browser and launch the application
		When I am on Home page
		Then Home page elements are displayed

	@RegressionTest
	Scenario: Load Home page and specify hotels search criteria
		Given I open a browser and launch the application
		When I am on Home page
		And I select Hotels tab
		And I enter destination city "Sydney"
		And I enter checkin date "20/01/2020"
		And I enter checkout date "21/01/2020"
		And I set Adults count 2
		And I set Child count 2
		And I click Search button

	@RegressionTest @SmokeTest
	Scenario: Search hotels and check List page elements
		Given I open a browser and launch the application
		When I am on Home page
		And I select Hotels tab
		And I enter destination city "Sydney"
		And I enter checkin date "20/01/2020"
		And I enter checkout date "21/01/2020"
		And I set Adults count 2
		And I set Child count 2
		And I click Search button
		And Hotels List page has finished loading
		Then the hotel list has more than 5 hotels
		And the first hotel item has all required fields

