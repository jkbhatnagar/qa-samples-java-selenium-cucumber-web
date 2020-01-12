Feature: Weatherbit weather api for current weather

	@SmokeTest @RegressionTest
  	Scenario: get current weather data using correct coordinates for Sydney
		Given I have set response type to json
		And I have APIKEY
		When I request Weatherbit weather api for current weather
		Then the status code is 200