package JUNK;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Given;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static utils.UtilConstants.*;
//
//import java.util.concurrent.TimeUnit;
//
//import managers.TestContext;
//import org.openqa.selenium.WebDriver;
//import pages.HomePage;
//import pages.HotelBookingPage;
//import pages.HotelsDetailsPage;
//import pages.HotelsListPage;
//
//import utils.UtilConstants;
//
//import java.util.List;
//import java.util.Map;
//
public class HomePage_Steps {
//
//    // Add class level private variables here
//    WebDriver driver;
//    HomePage homePage;
//    HotelsListPage listPage;
//    HotelsDetailsPage detailsPage;
//    HotelBookingPage bookingPage;
//
//    // Add class level private constants here
//
//    //region @Given
//    // Add @Given steps here
//
//    //endregion
//
//    //region @When
//    // Add @When steps here
//
//    @When("I am on Home page")
//    public void homepage_i_am_on_home_page() {
//        homePage = new HomePage(driver);
//        homePage.check_page_title();
//    }
//
//    @When("I select Hotels tab")
//    public void homepage_select_hotels_tab() {
//        homePage.click_hotelsTabLink();
//    }
//
//    @When("I enter destination city {string}")
//    public void homepage_select_destination_city(String city) {
//        homePage.click_hotelsDestinationBoxLink();
//        homePage.enter_DestinationCity(city);
//        homePage.click_hotelsDestinationFirsItemDiv();
//    }
//
//    @When("I enter checkin date {string}")
//    public void homepage_select_checkin_date(String date) {
//        homePage.enter_CheckInDate(date);
//    }
//
//    @When("I enter checkout date {string}")
//    public void homepage_select_checkout_date(String date) {
//        homePage.enter_CheckOutDate(date);
//    }
//
//    @When("I set Adults count {int}")
//    public void homepage_set_adults_count(Integer count) {
//        homePage.set_hotelsAdultsCount(count);
//    }
//
//    @When("I set Child count {int}")
//    public void homepage_set_children_count(Integer count) {
//        homePage.set_hotelsChildrenCount(count);
//    }
//
//    @When("I click Search button")
//    public void homepage_click_search_button() {
//        homePage.click_hotelsSubmitButton();
//    }
//
//    //endregion
//
//    //region @Then
//
//    //Add @Then steps here
//
//    @Then("Home page elements are displayed")
//    public void homepage_verify_elements(){
//        homePage.check_hotelsDestinationLabel();
//        homePage.check_hotelsCheckinDateLabel();
//        homePage.check_hotelsCheckoutDateLabel();
//        homePage.check_hotelsAdultsLabel();
//        homePage.check_hotelsChildLabel();
//    }
//
//    @Then("quit browser")
//    public void quit_browser(){
//        driver.quit();
//        driver.close();
//    }
//
//    //endregion
}