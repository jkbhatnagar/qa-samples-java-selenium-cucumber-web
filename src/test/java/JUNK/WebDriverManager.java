package JUNK;
//
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
public class WebDriverManager {
//
//    private WebDriver driver;
//    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
//
//    public WebDriverManager() {
//    }
//
//    public WebDriver getDriver() {
//        if(driver == null) driver = createDriver();
//        return driver;
//    }
//
//    private WebDriver createDriver() {
//
//        if(System.getProperty("exemode").equals("local")){
//            driver = createLocalDriver();
//        }
//        else if(System.getProperty("exemode").equals("remote")){
//            driver = createRemoteDriver();
//        }
//        else {
//            System.out.println("Execution mode not supported");
//            System.exit(1);
//        }
//        return driver;
//    }
//
//    private WebDriver createRemoteDriver() {
//        throw new RuntimeException("RemoteWebDriver is not yet implemented");
//    }
//
//    private WebDriver createLocalDriver() {
//        if(System.getProperty("browser").equals("chrome")){
//            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
//            driver = new ChromeDriver();
//        }
//        else if(System.getProperty("browser").equals("firefox")){
//            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
//            driver = new FirefoxDriver();
//        }
//        else {
//            System.out.println("Browser not supported");
//            System.exit(1);
//        }
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        return driver;
//    }
//
//    public void closeDriver() {
//        driver.close();
//        driver.quit();
//    }
//
}