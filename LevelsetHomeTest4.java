import Actions.BrowserActions;
import static Actions.BrowserActions3.drivers;

import Actions.BrowserActions3;
import POM.Home;
import POM.Home2;
import POM.Home3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LevelsetHomeTest4 {
    WebDriver driver1, driver2;
    Home2 home, home2;

    @BeforeTest
    void setup() {

        driver1 = new ChromeDriver();
        driver2 = new ChromeDriver();
        BrowserActions3.drivers.add(new ChromeDriver());

    }

    @AfterTest
    void teardown() {
        driver1.close();
        driver2.close();
        BrowserActions3.drivers.remove(BrowserActions3.drivers.size()-1);
    }

    @Test
    void test1() {
        driver1 = new ChromeDriver();
        drivers.get(drivers.size()-1);
        home = new Home2(driver1);
        home2 = new Home2(driver2);

        home.navigateToHome();
        home2.navigateToHome();

    }




    @Test
    void test3() {

        drivers.get(drivers.size());
        home = new Home2(driver1);
        home2 = new Home2(driver2);

        home.navigateToHome();
        home2.navigateToHome();

    }

}
