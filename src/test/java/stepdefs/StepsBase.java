package stepdefs;

import cucumber.api.PendingException;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

import pages.HomePage;
import pages.HotelBookingPage;
import pages.HotelsDetailsPage;
import pages.HotelsListPage;
import utils.UtilConstants;

import java.util.concurrent.TimeUnit;

import static utils.UtilConstants.ENDPOINT_PHPTRAVELS;

public class StepsBase {

    WebDriver driver;
    HomePage homePage;
    HotelsListPage listPage;
    HotelsDetailsPage detailsPage;
    HotelBookingPage bookingPage;
//    static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    // region StepsBase

    @Given("I open a browser and launch the application")
    public void open_a_browser_and_launch_the_application() throws MalformedURLException
    {
        try {
            if(System.getProperty("exemode").equals("remote")) {
                if(System.getProperty("browser").equals("firefox")){
                    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                    DesiredCapabilities dc = DesiredCapabilities.firefox();
                    dc.setBrowserName("firefox");
                    dc.setPlatform(Platform.LINUX);
                    driver = new RemoteWebDriver(new URL(UtilConstants.ENDPOINT_SELENIUM_HUB), dc);
                }
                else if(System.getProperty("browser").equals("chrome")){
                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                    DesiredCapabilities dc = DesiredCapabilities.chrome();
                    dc.setBrowserName("chrome");
                    dc.setPlatform(Platform.LINUX);
                    driver = new RemoteWebDriver(new URL(UtilConstants.ENDPOINT_SELENIUM_HUB), dc);
                }
            }
            else{
                if(System.getProperty("browser").equals("firefox")){
                    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                    driver = new FirefoxDriver();
                }
                else if(System.getProperty("browser").equals("chrome")){
                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                    driver = new ChromeDriver();
                }
            }

            if(driver!=null){
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                driver.get(ENDPOINT_PHPTRAVELS);
            }
        }
        catch(Exception e){
            e.printStackTrace();
//            System.exit(1);
        }
    }

    @When("I wait for page to finish loading")
    public void wait_for_load() throws Throwable {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @When("I wait for 3 seconds")
    public void wait_for_3_seconds() throws Throwable {
        driver.wait(3000);
    }

    // endregion



    // region HOME PAGE

    @When("I am on Home page")
    public void homepage_i_am_on_home_page() {
        homePage = new HomePage(driver);
        homePage.check_page_title();
    }

    @When("I select Hotels tab")
    public void homepage_select_hotels_tab() {
        homePage.click_hotelsTabLink();
    }

    @When("I enter destination city {string}")
    public void homepage_select_destination_city(String city) throws Exception {
        homePage.click_hotelsDestinationBoxLink();
        homePage.enter_DestinationCity(city);
    }

    @When("I enter checkin date {string}")
    public void homepage_select_checkin_date(String date) throws Exception {
        homePage.enter_CheckInDate(date);
    }

    @When("I enter checkout date {string}")
    public void homepage_select_checkout_date(String date) throws Exception {
        homePage.enter_CheckOutDate(date);
    }

    @When("I set Adults count {int}")
    public void homepage_set_adults_count(Integer count) throws Exception {
        homePage.set_hotelsAdultsCount(count);
    }

    @When("I set Child count {int}")
    public void homepage_set_children_count(Integer count) throws Exception {
        homePage.set_hotelsChildrenCount(count);
    }

    @When("I click Search button")
    public void homepage_click_search_button() {
        homePage.click_hotelsSubmitButton();
    }

    @When("I select Hotels tab and search hotels for {string} from {string} to {string} for {int} adults")
    public void homepage_i_search_for_hotels_on_home_page(String city, String checkinDate, String checkoutDate, Integer adults) {
        homePage.click_hotelsTabLink();
        homePage.click_hotelsDestinationBoxLink();
        homePage.enter_DestinationCity(city);
        homePage.enter_CheckInDate(checkinDate);
        homePage.enter_CheckOutDate(checkoutDate);
        homePage.set_hotelsAdultsCount(adults);
        homePage.click_hotelsSubmitButton();
    }

    @Then("Home page elements are displayed")
    public void homepage_verify_elements(){
        Assert.assertTrue("Home Page : Destination label not as expected", homePage.check_hotelsDestinationLabel());
        Assert.assertTrue("Home Page : Check in label not as expected", homePage.check_hotelsCheckinDateLabel());
        Assert.assertTrue("Home Page : Check out label not as expected", homePage.check_hotelsCheckoutDateLabel());
        Assert.assertTrue("Home Page : Adults label not as expected", homePage.check_hotelsAdultsLabel());
        Assert.assertTrue("Home Page : Child label not as expected", homePage.check_hotelsChildLabel());
    }

    //endregion




    // Hotels List Page

    @When("Hotels List page has finished loading")
    public void listpage_i_am_on_list_page() {
        listPage = new HotelsListPage(driver);
        listPage.check_page_title();
    }

    @When("I click Details button")
    public void listpage_click_details_button() {
        listPage.click_hotelsItemDetailsButton();
    }

    @Then("the hotel list has more than {int} hotels")
    public void verify_hotel_list_count(int count){
        Assert.assertTrue("List Page : Hotel count less than expected", (listPage.check_hotelsListItemsCount() >= count));
    }

    @Then("the first hotel item has all required fields")
    public void verify_hotel_has_required_fields(){
        Assert.assertTrue("List Page : Hotel Image not as expected", listPage.check_hotelItemImgIsNotEmpty());
        Assert.assertTrue("List Page : Hotel Rating not as expected", listPage.check_hotelsItemRatingSpanIsNotEmpty());
        Assert.assertTrue("List Page : Hotel Price not as expected", listPage.check_hotelsItemPriceSpanIsNotEmpty());
        Assert.assertTrue("List Page : Hotel Name not as expected", listPage.check_hotelsItemHotelNameH5IsNotEmpty());
    }

    //endregion



    // Hotels Details Page

    @When("Hotels Details page has finished loading")
    public void detailspage_i_am_on_details_page() {
        detailsPage = new HotelsDetailsPage(driver);
        detailsPage.check_page_title();
    }

    @When("I click Book Now button")
    public void detailspage_click_book_now_button() {
        detailsPage.click_hotelRoomItem1BookNowButton();
    }

    @Then("the Details page has more than {int} rooms")
    public void detailspage_verify_hotel_room_count(int count){
        Assert.assertTrue("Details Page : Room count less than expected", (detailsPage.get_hotelRoomItemsCount() >= count));
    }

    @Then("the Details page has all required fields")
    public void detailspage_verify_page_has_required_fields(){
        Assert.assertTrue("Details Page : Hotel Name not as expected", detailsPage.check_hotelTitle());
        Assert.assertTrue("Details Page : Hotel Rating not as expected", detailsPage.check_hotelItemRatingSpanIsNotEmpty());
    }

    //endregion




    // Booking Page

    @When("Hotels Booking page has finished loading")
    public void bookingpage_i_am_on_booking_page() {
        bookingPage = new HotelBookingPage(driver);
        bookingPage.check_page_title();
    }

    @When("I enter first name {string} and last name {string}")
    public void bookingpage_enter_name(String firstname, String lastname) {
        bookingPage.enter_FirstName(firstname);
        bookingPage.enter_LastName(lastname);
    }

    @When("I enter email {string} and phone {string}")
    public void bookingpage_enter_email_and_phone(String email, String phone) {
        bookingPage.enter_Email(email);
        bookingPage.enter_PhoneNumber(phone);
    }

    @When("I select country {string}")
    public void bookingpage_enter_email_and_phone(String country) {
        bookingPage.enter_Country(country);
    }

    @When("I click Complete Booking button")
    public void bookingpage_click_complete_booking_button() {
        bookingPage.click_completeBookingButton();
    }

    @Then("the Booking page shows correct booking details")
    public void bookingpage_verify_booking_details(){
        //THIS IS SPECIAL -> WILL DEMO SHARING STATE BETWEEN TEST AND SCENARIOS
    }

    @Then("the Booking page has all required fields")
    public void bookingpage_verify_page_has_required_fields(){
        Assert.assertTrue("Booking Page : Last Name label not as expected", bookingPage.check_LastNameLabel());
        Assert.assertTrue("Booking Page : Email label not as expected", bookingPage.check_EmailLabel());
        Assert.assertTrue("Booking Page : Phone label  not as expected", bookingPage.check_PhoneLabel());
        Assert.assertTrue("Booking Page : Country label not as expected", bookingPage.check_CountryLabel());
    }

    //endregion


    @After
    public void afterScenario()
    {
        driver.quit();
    }
}
