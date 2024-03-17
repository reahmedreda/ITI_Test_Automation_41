import Actions.BrowserActions4;
import POM.Home2;
import POM.Home4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_5_Parallel_TestNGXml_HashMapOfDrivers {

    //This test should be run from test.xml



    @Parameters({"browser"})
    @BeforeTest
    void setup(String browser) throws Exception {

        BrowserActions4.addWebDriverToMapOfDrivers(BrowserActions4.Browsers.valueOf(browser.toLowerCase()),
                String.valueOf(Thread.currentThread().getId()));

    }

    @AfterTest
    void teardown() {
        String key = String.valueOf(Thread.currentThread().getId());
        BrowserActions4.closeDriverAndRemoveFromMap(key);
    }

    @Test
    void test1() {
        Home4 home = new Home4(String.valueOf(Thread.currentThread().getId()));
        home.navigateToHome();

    }

}
