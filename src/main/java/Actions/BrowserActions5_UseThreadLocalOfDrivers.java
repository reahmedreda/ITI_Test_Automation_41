package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions5_UseThreadLocalOfDrivers {

    //This version uses ThreadLocal of drivers instead of Map

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void setWebDriverToThreadLocalOfDrivers(Browsers browser) {
        try{
           switch (browser){
               case chrome:
                   drivers.set(new ChromeDriver());
                break;

               case firefox:
                   drivers.set(new FirefoxDriver());
                   break;
            }
        }

        catch(Exception e){
            //Handle this exception instead of returning null

        }
    }



    public static void closeDriver(){
        drivers.get().quit();
    }

    public enum Browsers{
        chrome,
        firefox
    }


}
