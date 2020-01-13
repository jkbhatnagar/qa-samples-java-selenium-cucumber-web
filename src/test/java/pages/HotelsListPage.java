package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelsListPage extends BasePage {

    public HotelsListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
    }

    String pageTitle = "Hotels Results";

    @FindBy(how = How.CSS, using = "h3.heading-title")
    private WebElement hotelsCityH3;

    @FindBy(how = How.CSS, using = "div#listing ul#LIST li")
    private List<WebElement> hotelsListItems;

    @FindBy(how = How.CSS, using = "div#listing ul#LIST li:nth-of-type(1) div.product-long-item div.image img")
    private WebElement hotelItemImg;

    @FindBy(how = How.CSS, using = "div#listing ul#LIST li:nth-of-type(1) > div.product-long-item > div > div:nth-of-type(2) p.rating-text span")
    private WebElement hotelsItemRatingSpan;

    @FindBy(how = How.CSS, using = "div#listing ul#LIST li:nth-of-type(1) > div.product-long-item > div > div:nth-of-type(2) div.price span")
    private WebElement hotelsItemPriceSpan;

    @FindBy(how = How.CSS, using = "div#listing ul#LIST li:nth-of-type(1) > div.product-long-item > div > div:nth-of-type(2) div.rating-item+h5 a")    //16/01/2020
    private WebElement hotelsItemHotelNameH5;

    @FindBy(how = How.CSS, using = "div#listing ul#LIST li:nth-of-type(1) > div.product-long-item > div > div:nth-of-type(2) form button[type=\"submit\"]")
    private WebElement hotelsItemDetailsButton;

    @FindBy(how = How.CSS, using = "button#loadMore")
    private WebElement hotelsLoadMoreButton;

    public Boolean check_page_title() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Integer check_hotelsListItemsCount() {
        return hotelsListItems.size();
    }

    public Boolean check_hotelItemImgIsNotEmpty() {
        return !hotelItemImg.getAttribute("src").equals("");
    }

    public Boolean check_hotelsItemRatingSpanIsNotEmpty() {
        return !hotelsItemRatingSpan.getText().equals("");
    }

    public Boolean check_hotelsItemPriceSpanIsNotEmpty() {
        return !hotelsItemPriceSpan.getText().equals("");
    }

    public Boolean check_hotelsItemHotelNameH5IsNotEmpty() {
        return !hotelsItemHotelNameH5.getText().equals("");
    }

    public void click_hotelsItemDetailsButton() {
        hotelsItemDetailsButton.click();
        try { Thread.sleep(2000);}
        catch (InterruptedException e) {}
    }

    public void click_hotelsLoadMoreButton() {
        hotelsLoadMoreButton.click();
        try { Thread.sleep(3000);}
        catch (InterruptedException e) {}
    }

}
