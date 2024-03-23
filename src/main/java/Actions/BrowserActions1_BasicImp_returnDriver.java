package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions1_BasicImp_returnDriver {
    WebDriver driver;

    //A normal Browser Actions class that is used to all actions can be done in the browser

    public BrowserActions1_BasicImp_returnDriver(){}


    // A function to initialize the webdriver and return it to the caller to be used
    public WebDriver initializeTheWebDriver(String browser) {
        try{
        if(browser.toLowerCase().equals(Browsers.chrome.toString())) {
            driver = new ChromeDriver();
            return driver;
        }
        else if(browser.toLowerCase().equals(Browsers.firefox.toString())){
            driver = new FirefoxDriver();
            return driver;
        }
        }

        catch(Exception e){
            //Handle this exception instead of returning null

        }
        return null;
    }

    public void maximizeScreen(){
        driver.manage().window().maximize();
    }

    public void closeDriver(){
        driver.close();
    }

    public void quitDriver(){
        driver.quit();
    }

    enum Browsers{
        chrome,
        firefox
    }
}
