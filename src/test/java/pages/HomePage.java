package pages;

import org.openqa.selenium.By;
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

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String pageTitle = "PHPTRAVELS | Travel Technology Partner";

    @FindBy(how = How.CSS, using = "nav[class=\"menu-horizontal-02\"] a[data-name=\"hotels\"]")
    private WebElement hotelsTabLink;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div.locationlistTravelhopeHotels a")
    private WebElement hotelsDestinationBoxLink;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div[class~=\"select2-drop\"][style*=\"display: block\"] div.select2-search input")
    private WebElement hotelsDestinationInput;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div[class~=\"select2-drop\"][style*=\"display: block\"] > ul > li > ul > li:nth-of-type(1) > div")
    private WebElement hotelsDestinationFirsItemDiv;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div#airDatepickerRange-hotel input#checkin")  //15/01/2020
    private WebElement hotelsCheckinDateInput;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] div#airDatepickerRange-hotel input#checkout")    //16/01/2020
    private WebElement hotelsCheckinDateOutput;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"adults\"]")
    private WebElement hotelsAdultsInput;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"adults\"]+span button.bootstrap-touchspin-up")
    private WebElement hotelsAdultsSpinnerUp;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"adults\"]+span button.bootstrap-touchspin-down")
    private WebElement hotelsAdultsSpinnerDown;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"children\"]")
    private WebElement hotelsChildrenInput;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"children\"]+span button.bootstrap-touchspin-up")
    private WebElement hotelsChildrenSpinnerUp;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] input[name=\"children\"]+span button.bootstrap-touchspin-down")
    private WebElement hotelsChildrenSpinnerDown;

    @FindBy(how = How.CSS, using = "form[name=\"HOTELS\"] button[type=\"submit\"]")
    private WebElement hotelsSubmitButton;

    public void click_hotelsTabLink() {
        hotelsTabLink.click();
    }

    public void click_hotelsDestinationBoxLink() {
        hotelsDestinationBoxLink.click();
    }

    public void enter_DestinationCity(String city) {
        hotelsDestinationInput.sendKeys(city);
    }

    public void click_hotelsDestinationFirsItemDiv() {
        hotelsDestinationFirsItemDiv.click();
    }

    public void enter_CheckInDate(String date) {
        hotelsCheckinDateInput.sendKeys(date);
    }

    public void enter_CheckOutDate(String date) {
        hotelsCheckinDateInput.sendKeys(date);
    }

    public void set_hotelsAdultsCount(Integer count) {
        Integer currentCount = Integer.parseInt(hotelsAdultsInput.getText());

        if(!currentCount.equals(currentCount)){
            for (int i = 0; i < currentCount; i++) {
                hotelsAdultsSpinnerDown.click();
            }

            for (int i = 0; i < count; i++) {
                hotelsAdultsSpinnerUp.click();
            }
        }
    }

    public void set_hotelsChildrenCount(Integer count) {
        Integer currentCount = Integer.parseInt(hotelsChildrenInput.getText());

        if(!currentCount.equals(currentCount)){
            for (int i = 0; i < currentCount; i++) {
                hotelsChildrenSpinnerDown.click();
            }

            for (int i = 0; i < count; i++) {
                hotelsChildrenSpinnerUp.click();
            }
        }
    }

    public void click_hotelsSubmitButton() {
        hotelsSubmitButton.click();
        try { Thread.sleep(3000);}
        catch (InterruptedException e) {}
    }



}
