package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPage {

    WebDriver _driver;

    public HotelBookingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        _driver = driver;
    }

    String pageTitle = "Hotels Booking Checkout";

    @FindBy(how = How.CSS, using = "label[for=\"first_name\"]")
    private WebElement guestFirstNameLabel;

    @FindBy(how = How.CSS, using = "input#first_name")
    private WebElement guestFirstNameInput;

    @FindBy(how = How.CSS, using = "label[for=\"last_name\"]")
    private WebElement guestLastNameLabel;

    @FindBy(how = How.CSS, using = "input#last_name")
    private WebElement guestLastNameInput;

    @FindBy(how = How.CSS, using = "label[for=\"email\"]")
    private WebElement guestEmailLabel;

    @FindBy(how = How.CSS, using = "input#email")
    private WebElement guestEmailInput;

    @FindBy(how = How.CSS, using = "label[for=\"phone_number\"]")
    private WebElement guestPhoneNumberLabel;

    @FindBy(how = How.CSS, using = "input#phone_number")
    private WebElement guestPhoneNumberInput;

    @FindBy(how = How.CSS, using = "label[for=\"country_code\"]")
    private WebElement guestCountryLabel;

    @FindBy(how = How.CSS, using = "select#country_code")
    private Select guestCountrySelect;

    @FindBy(how = How.CSS, using = "form[action=\"https://www.phptravels.net/thhotels/pay\"]:nth-of-type(2) button")
    private WebElement completeBookingButton;

//    public Boolean check_FirstNameLabel() {
//        return guestFirstNameLabel.getText().equals("First Name");
//    }

    public void enter_FirstName(String firstName) {
        guestFirstNameInput.sendKeys(firstName);
    }

    public Boolean check_LastNameLabel() {
        return guestLastNameLabel.getText().equals("Last Name");
    }

    public void enter_LastName(String lastName) {
        guestLastNameInput.sendKeys(lastName);
    }

    public Boolean check_EmailLabel() {
        return guestEmailLabel.getText().equals("Email");
    }

    public void enter_Email(String email) {
        guestEmailInput.sendKeys(email);
    }

    public Boolean check_PhoneLabel() {
        return guestPhoneNumberLabel.getText().equals("Phone");
    }

    public void enter_PhoneNumber(String phone) {
        guestPhoneNumberInput.sendKeys(phone);
    }

    public Boolean check_CountryLabel() {
        return guestCountryLabel.getText().equals("Country");
    }

    public void enter_Country(String country) {
        guestCountrySelect.selectByVisibleText(country);
    }

    public void click_hotelsTabLink() {
        completeBookingButton.click();
        try { Thread.sleep(3000);}
        catch (InterruptedException e) {}
    }

}
