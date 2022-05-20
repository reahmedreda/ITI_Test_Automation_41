package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BrowserActions4 {
    // The goal of this version is to have multiple drivers running on the same device without selenium grid
    // We have to link each driver with its Test class or test method or test suite ... etc
    // The linking will be done in 2 ways
    // 1- Use a mapper to add a unique driver and identify it by a unique key
    // this key was set by Test Class or test case ... etc and hence, we can retrieve this driver anytime by
    // getting it from the map using our unique key
    //
    // 2- Use an Array List and use the index as an identifier , and make sure that this index will never be changed
    // Which is not a recommended solution

    public static ArrayList<WebDriver> drivers = new ArrayList<>();
    public static Map<String,WebDriver> mapper = new HashMap<>();

    public static void addWebDriverToMapOfDrivers(String browser, String className) {
        try{
            if(browser.toLowerCase().equals(BrowserActions4.Browsers.chrome.toString())) {
                //adding a new driver to the map and link it with key = className
                mapper.put(className,new ChromeDriver());

            }
            else if(browser.toLowerCase().equals(BrowserActions4.Browsers.firefox.toString())) {
                mapper.put(className,new FirefoxDriver());
            }
        }

        catch(Exception e){
            //Handle this exception instead of returning null

        }
    }



    public static void closeDriverAndRemoveFromMap(String key){
        mapper.get(key).close();
        mapper.remove(key);
    }



    //Using Array list to store newly added drivers and return its index
    // This approach is not recommended to depend on index because if you removed a
    // driver of index (x) it will shift all indexes after x to be index-1
    // A workaround to keep that index is to not remove it from array list, just make it null or leave it as it is
    // but it will keep storing in the memory -> waste of memory

    public static int addWebDriverToListOfDrivers(String browser) {
        if(browser.toLowerCase().equals(BrowserActions4.Browsers.chrome.toString())) {
                drivers.add(new ChromeDriver());
                // returning the last index of the list which is our driver index
                // A note: if 2 TC called this function at the exact same time , there is a possibility of returning wrong index
                return drivers.size()-1;
            }

        return -1;
    }
    public static void closeDriverAndRemoveFromList(int index) {
        // We can't to the next line :
        //BrowserActions4.drivers.remove(BrowserActions4.drivers.get(index-1));
        // because it will shift all indexed by -1
        // Ex { 0,1 ,2,3, 4, 5,6 } if I deleted 4 -> index 5 will be 4 and index 6 will be 5 and in the TC when trying
        // to fetch driver in index 6 will give us index out of bound
        // the workaround it to either close only:
        BrowserActions4.drivers.get(index).close();

        //Or close and then set it with null
        BrowserActions4.drivers.set(index,null);
    }


    enum Browsers{
        chrome,
        firefox
    }


}
