package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class BrowserActions4 {
    public static ArrayList<WebDriver> drivers;



    public static int initializeTheWebDriver(String browser) {
            if(browser=="Chrome") {
                drivers.add(new ChromeDriver());
                return drivers.size();
            }


        return -1;
    }
    public static void removeDriver(int index) {

        BrowserActions4.drivers.remove(BrowserActions4.drivers.get(index-1));
    }




}
