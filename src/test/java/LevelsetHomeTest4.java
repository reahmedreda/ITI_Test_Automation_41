import Actions.BrowserActions;
import static Actions.BrowserActions3.driver;

import Actions.BrowserActions3;
import Actions.BrowserActions4;
import POM.Home;
import POM.Home2;
import POM.Home3;
import POM.Home4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LevelsetHomeTest4 {
    WebDriver driver1, driver2;
    Home4 home;
    int driverNo;

    @BeforeTest
    void setup() {
        driverNo= BrowserActions4.initializeTheWebDriver("Chrome");
    }

    @AfterTest
    void teardown() {
        BrowserActions4.removeDriver(driverNo);
    }

    @Test
    void test1() {
       // drivers.get();
        home = new Home4(driverNo);

    }


}
