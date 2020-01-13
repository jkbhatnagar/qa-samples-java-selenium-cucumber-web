package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this._driver = driver;
    }

    String pageTitle = "PHPTRAVELS | Travel Technology Partner";

    @FindBy(how = How.XPATH, using = "//form[@name=\"HOTELS\"]//*[text()='Destination']")
    private WebElement hotelsTabLabel;

    @FindBy(how = How.CSS, using = "nav[class=\"menu-horizontal-02\"] a[data-name=\"hotels\"]")
    private WebElement hotelsTabLink;


    @FindBy(how = How.XPATH, using = "//form[@name=\"HOTELS\"]//*[text()='Destination']")
    private WebElement hotelsDestinationLabel;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div.locationlistTravelhopeHotels a")
    private WebElement hotelsDestinationBoxLink;

    @FindBy(how = How.CSS, using = "div#select2-drop input.select2-input")
    private WebElement hotelsDestinationInput;

    @FindBy(how = How.CSS, using = "ul.select2-result-sub li:nth-of-type(1)")
    private WebElement hotelsDestinationFirsItemDiv;


    @FindBy(how = How.XPATH, using = "//form[@name=\"HOTELS\"]//*[text()='Check in']")
    private WebElement hotelsCheckinDateLabel;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div#airDatepickerRange-hotel input#checkin")  //15/01/2020
    private WebElement hotelsCheckinDateInput;


    @FindBy(how = How.XPATH, using = "//form[@name=\"HOTELS\"]//*[text()='Check out']")
    private WebElement hotelsCheckoutDateLabel;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div#airDatepickerRange-hotel input#checkout")    //16/01/2020
    private WebElement hotelsCheckoutDateInput;


    @FindBy(how = How.XPATH, using = "//form[@name=\"HOTELS\"]//*[text()='Adults ']")
    private WebElement hotelsAdultsLabel;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"adults\"]")
    private WebElement hotelsAdultsInput;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"adults\"]+span button.bootstrap-touchspin-up")
    private WebElement hotelsAdultsSpinnerUp;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"adults\"]+span button.bootstrap-touchspin-down")
    private WebElement hotelsAdultsSpinnerDown;


    @FindBy(how = How.XPATH, using = "//form[@name=\"HOTELS\"]//*[text()='Child ']")
    private WebElement hotelsChildLabel;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"children\"]")
    private WebElement hotelsChildrenInput;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"children\"]+span button.bootstrap-touchspin-up")
    private WebElement hotelsChildrenSpinnerUp;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"children\"]+span button.bootstrap-touchspin-down")
    private WebElement hotelsChildrenSpinnerDown;


    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] button[type=\"submit\"]")
    private WebElement hotelsSubmitButton;

    public Boolean check_page_title() {
        return _driver.getTitle().equals(pageTitle);
    }

    public Boolean check_hotelsTabLink() {
        return hotelsTabLink.isDisplayed() && hotelsTabLink.getText().equals("HOTELS");
    }

    public void click_hotelsTabLink() {
        hotelsTabLink.click();
    }


    public Boolean check_hotelsDestinationLabel() {
        return hotelsDestinationLabel.isDisplayed();
    }

    public void click_hotelsDestinationBoxLink() {
        hotelsDestinationBoxLink.click();
    }

    public void enter_DestinationCity(String city) {
        hotelsDestinationInput.sendKeys(city);
        hotelsDestinationFirsItemDiv.click();
    }

    public Boolean check_hotelsCheckinDateLabel() {
        return hotelsCheckinDateLabel.isDisplayed();
    }

    public void enter_CheckInDate(String date) {
        hotelsCheckinDateInput.clear();
        hotelsCheckinDateInput.sendKeys(date);
        sleep(2);
    }


    public Boolean check_hotelsCheckoutDateLabel() {
        return hotelsCheckoutDateLabel.isDisplayed();
    }

    public void enter_CheckOutDate(String date) {
        hotelsCheckoutDateInput.clear();
        hotelsCheckoutDateInput.sendKeys(date);
    }


    public Boolean check_hotelsAdultsLabel() {
        return hotelsAdultsLabel.isDisplayed();
    }

    public void set_hotelsAdultsCount(Integer count) {
        for (int i = 0; i < 10; i++) {
            hotelsAdultsSpinnerDown.click();
        }

        for (int i = 0; i < count; i++) {
            hotelsAdultsSpinnerUp.click();
        }
        sleep(2);

    }

    public Boolean check_hotelsChildLabel() {
        return hotelsChildLabel.isDisplayed();
    }

    public void set_hotelsChildrenCount(Integer count) {
        for (int i = 0; i < 10; i++) {
            hotelsChildrenSpinnerDown.click();
        }

        for (int i = 0; i < count; i++) {
            hotelsChildrenSpinnerUp.click();
        }
        sleep(2);
    }

    public void click_hotelsSubmitButton() {
        hotelsSubmitButton.click();
        sleep(2);
    }

}
