package JUNK;
//
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import managers.TestContext;
//import org.openqa.selenium.WebDriver;
//import pages.HotelsListPage;
//import org.junit.Assert;
//
//import java.util.Map;
//
public class HotelsListPage_Steps {
//
//    // Add class level private variables here
//    HotelsListPage listPage;
//    TestContext testContext;
//
//    // Add class level private constants here
//
//    public HotelsListPage_Steps(TestContext context) {
//        testContext = context;
//        listPage = testContext.getPageObjectManager().getListPage();
//    }
//
//    //region @Given
//    // Add @Given steps here
//
//    //endregion
//
//    //region @When
//    // Add @When steps here
//
//    @When("Hotels List page has finished loading")
//    public void listpage_i_am_on_list_page() {
//        listPage.check_page_title();
//    }
//
//    @When("I click Details button")
//    public void listpage_click_details_button() {
//        listPage.click_hotelsItemDetailsButton();
//    }
//
//    //endregion
//
//    //region @Then
//    // Add @Then steps here
//
//    @Then("the hotel list has more than {int} hotels")
//    public void verify_hotel_list_count(int count){
//        Assert.assertTrue("Hotel count less than expected", (listPage.check_hotelsListItemsCount() >= count));
//    }
//
//    @Then("the first hotel item has all required fields")
//    public void verify_hotel_has_required_fields(){
//        Assert.assertTrue("Hotel count less than expected", listPage.check_hotelItemImgIsNotEmpty());
//        Assert.assertTrue("Hotel count less than expected", listPage.check_hotelsItemRatingSpanIsNotEmpty());
//        Assert.assertTrue("Hotel count less than expected", listPage.check_hotelsItemPriceSpanIsNotEmpty());
//        Assert.assertTrue("Hotel count less than expected", listPage.check_hotelsItemHotelNameH5IsNotEmpty());
//    }
//
////    @Then("response includes correct headers$")
////    public void response_includes_correct_headers(Map<String,String> requiredHeaders) throws Throwable {
////    }
//
//    //endregion
}