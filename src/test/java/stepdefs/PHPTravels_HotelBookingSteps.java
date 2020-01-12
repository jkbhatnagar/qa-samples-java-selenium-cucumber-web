package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.UtilConstants.*;

import java.util.List;
import java.util.Map;

public class PHPTravels_HotelBookingSteps {

    // Add class level private variables here

    // Add class level private constants here

    //region @Given
    // Add @Given steps here

    @Given("I have set response type to json")
    public void i_have_set_response_type_to_json() {
        System.out.println("i_have_set_response_type_to_json");
        System.out.println("TEST BROWSER = " + System.getProperty("browser"));
    }

    @Given("I have APIKEY")
    public void i_have_apikey() {
        System.out.println("i_have_apikey");
    }

//    @Given("I have INVALID_APIKEY")
//    public void i_have_invalid_apikey() {
//        request.queryParam("key", INVALID_APIKEY);
//    }
//
//    @Given("I have latitude {word}")
//    public void i_have_latitude(String lat) {
//        request.queryParam("lat", lat);
//    }
//
//    @Given("I have longitude {word}")
//    public void i_have_longitude(String lon) {
//        request.queryParam("lon", lon);
//    }
//
//    @Given("I have country code {word}")
//    public void i_have_country(String country) {
//        request.queryParam("country", country);
//    }
//
//    @Given("I have post code {word}")
//    public void i_have_postcode(String postcode) {
//        request.queryParam("postal_code", postcode);
//    }

    //endregion

    //region @When
    // Add @When steps here

    @When("I request Weatherbit weather api for current weather")
    public void i_request_current_weather(){
        System.out.println("i_request_current_weather");
    }

    //endregion

    //region @Then
    // Add @Then steps here

    @Then("the status code is {int}")
    public void verify_status_code(int statusCode){
        System.out.println("verify_status_code");
    }

    @Then("response includes correct headers$")
    public void response_includes_correct_headers(Map<String,String> requiredHeaders) throws Throwable {
        String checkedHeaderValue = "";
        for (Map.Entry<String, String> field : requiredHeaders.entrySet()) {
//            assertThat(response.getHeader(field.getKey()), equalTo(field.getValue()));
        }
    }

    @Then("response includes the following integer values$")
    public void response_includes_integer(Map<String,Integer> responseFields) throws Throwable {
        for (Map.Entry<String, Integer> field : responseFields.entrySet()) {
//            json.body(field.getKey(), equalTo(field.getValue()));
        }
    }

    @Then("response includes the following string values$")
    public void response_includes_string(Map<String,String> responseFields) throws Throwable {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
//            json.body(field.getKey(), equalTo(field.getValue()));
        }
    }

    @Then("response includes the following float values$")
    public void response_includes_float(Map<String,Float> responseFields) throws Throwable {
        for (Map.Entry<String, Float> field : responseFields.entrySet()) {
//            json.body(field.getKey(), equalTo(field.getValue()));
        }
    }

    @Then("response includes other mandatory parameters$")
    public void response_includes_other_parameters(List<String> responseFields) throws Throwable {
        for (String field : responseFields) {
//            json.body(field, notNullValue());
        }
    }

    @Then("response includes error {string}")
    public void response_includes_error(String msg) throws Throwable {
//        json.body("error", containsString(msg));
    }

    //endregion
}