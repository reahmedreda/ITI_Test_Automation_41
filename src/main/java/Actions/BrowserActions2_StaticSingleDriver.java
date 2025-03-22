package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions2_StaticSingleDriver {
    public static WebDriver driver;


    // Enhanced version from BrowserAction instead of returning everytime an instance of a webdriver and each
    // Test Class will have to pass it to each POM , this class created a static public webdriver to be seen by all classes
    // Now we don't need to return anything, and each user of the driver can access it by calling BrowserActions3_StaticSingleDriver.driver
    public static void initializeTheWebDriver(String browser) {
        try{
            if(browser.toLowerCase().equals(BrowserActions2_StaticSingleDriver.Browsers.chrome.toString())) {
                driver = new ChromeDriver();

            }
            else if(browser.toLowerCase().equals( BrowserActions2_StaticSingleDriver.Browsers.firefox.toString())){
                driver = new FirefoxDriver();

            }
        }

        catch(Exception e){
            //Handle this exception instead of returning null

        }
    }

    public static void maximizeScreen(){
        driver.manage().window().maximize();
    }

    public static void closeDriver(){
        driver.close();
    }

    public static void quitDriver(){
        driver.quit();
    }

    public enum Browsers{
        chrome,
        firefox
    }

}
