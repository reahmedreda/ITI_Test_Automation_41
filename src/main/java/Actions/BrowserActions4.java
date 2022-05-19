package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Map;

public class BrowserActions4 {
    public static ArrayList<WebDriver> drivers;
    public static Map<String,WebDriver> mapper;

    public void initializeTheWebDriver2(String browser,String className) {
        try{
            if(browser=="Chrome") {
                mapper.put(className,new ChromeDriver());
                //drivers.add(new ChromeDriver());
                //return drivers.get(drivers.size());

            }
        }

        catch(Exception e){
            //Handle this exception instead of returning null

        }
    }








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
