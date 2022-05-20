package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions3 {
    public static WebDriver driver;


    // Enhanced version from BrowserAction instead of returning everytime an instance of a webdriver and each
    // Test Class will have to pass it to each POM , this class created a static public webdriver to be seen by all classes
    // Now we don't need to return anything, and each user of the driver can access it by calling BrowserActions3.driver
    public void initializeTheWebDriver(String browser) {
        try{
            if(browser.toLowerCase().equals(BrowserActions3.Browsers.chrome.toString())) {
                this.driver = new ChromeDriver();

            }
            else if(browser.toLowerCase().equals( BrowserActions3.Browsers.firefox.toString())){
                this.driver = new FirefoxDriver();

            }
        }

        catch(Exception e){
            //Handle this exception instead of returning null

        }
    }

    public void maximizeScreen(){
        driver.manage().window().maximize();
    }

    public void closeDriver(){
        driver.close();
    }

    enum Browsers{
        chrome,
        firefox
    }

}
