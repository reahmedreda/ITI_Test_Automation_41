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

    Home4 home;
    String key = "";
    @Parameters({"browser","uniqueKey"})
    @BeforeTest
    void setup(String browser,String key) throws Exception {
        this.key = key;
        BrowserActions4.addWebDriverToMapOfDrivers(browser,key);
        home =new Home4(key);
    }

    @AfterTest
    void teardown() {
        BrowserActions4.closeDriverAndRemoveFromMap(key);
    }

    @Test
    void test1() {
        home.navigateToHome();

    }

}
