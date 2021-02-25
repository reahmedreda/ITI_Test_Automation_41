package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions3 {
    public static WebDriver driver;



    public void initializeTheWebDriver(String browser) {
        try{
            if(browser=="Chrome") {
                this.driver = new ChromeDriver();

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


}
