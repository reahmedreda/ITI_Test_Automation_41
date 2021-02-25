package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions {
    WebDriver driver;

    public BrowserActions(){}


    public WebDriver initializeTheWebDriver(String browser) {
        try{
        if(browser=="Chrome") {
            driver = new ChromeDriver();
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


}
