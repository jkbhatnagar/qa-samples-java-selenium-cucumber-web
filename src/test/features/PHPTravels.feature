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

	@RegressionTest
	Scenario: Search hotels and check List page elements
		Given I open a browser and launch the application
		When I am on Home page
		And I select Hotels tab and search hotels for "Sydney" from "20/01/2020" to "21/01/2020" for 2 adults
		And Hotels List page has finished loading
		Then the hotel list has more than 5 hotels
		And the first hotel item has all required fields

	@RegressionTest
	Scenario: Search hotels and check List page elements
		Given I open a browser and launch the application
		When I am on Home page
		And I select Hotels tab and search hotels for "Sydney" from "20/01/2020" to "21/01/2020" for 2 adults
		And Hotels List page has finished loading
		Then I click Details button

	@RegressionTest
	Scenario: Search hotels and select first hotel and check Details page elements
		Given I open a browser and launch the application
		When I am on Home page
		And I select Hotels tab and search hotels for "Sydney" from "16/01/2020" to "17/01/2020" for 2 adults
		And Hotels List page has finished loading
		And I click Details button
		And Hotels Details page has finished loading
		Then the Details page has all required fields
		And the Details page has more than 1 rooms

	@RegressionTest
	Scenario: Search hotels and select first room of first hotel and check Booking page elements
		Given I open a browser and launch the application
		When I am on Home page
		And I select Hotels tab and search hotels for "Sydney" from "20/01/2020" to "21/01/2020" for 2 adults
		And Hotels List page has finished loading
		And I click Details button
		And Hotels Details page has finished loading
		And I click Book Now button
		And Hotels Booking page has finished loading
		Then the Booking page has all required fields