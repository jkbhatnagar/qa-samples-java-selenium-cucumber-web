package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelsDetailsPage {

    WebDriver _driver;

    public HotelsDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
    }

    String pageTitle = "";

    @FindBy(how = How.CSS, using = "h2#detail-content-sticky-nav-00")
    private WebElement hotelNameH2;

    @FindBy(how = How.CSS, using = "div#detail-content-sticky-nav-02 div.room-item-wrapper div.room-item")
    private List<WebElement> hotelsRoomItems;

    @FindBy(how = How.CSS, using = "div#detail-content-sticky-nav-02 div.room-item-wrapper div.room-item:nth-of-type(2) p.price span")
    private WebElement hotelsRoomItem1PriceSpan;

    @FindBy(how = How.CSS, using = "div#detail-content-sticky-nav-02 div.room-item-wrapper div.room-item:nth-of-type(2) form button[type=\"submit\"]")
    private WebElement hotelRoomItem1BookNowButton;

    public Boolean check_PageTitle() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean check_hotelsTitle() {
        return !hotelNameH2.getText().equals("");
    }

    public Integer check_hotelRoomItemsCount() {
        return hotelsRoomItems.size();
    }

    public Boolean check_hotelsItemRatingSpanIsNotEmpty() {
        return !hotelsRoomItem1PriceSpan.getText().equals("");
    }

    public void click_hotelRoomItem1BookNowButton() {
        hotelRoomItem1BookNowButton.click();
        try { Thread.sleep(2000);}
        catch (InterruptedException e) {}
    }

}
