import POM.Home2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

    WebDriver driver1, driver2;
    Home2 home, home2;
    @Parameters({"browser","DB"})



    @BeforeTest
    void setup(String browser,String db) throws Exception {
        if(browser.equals("Chrome")) {
            driver1 = new ChromeDriver();
        }
        else if (browser.equals("FireFox")){
            driver1 = new FirefoxDriver();
        }
        else{
            Assert.fail("No such browser, actual browser is : "+browser);
        }

    }

    @AfterTest
    void teardown() {
        try {
            driver1.close();
        }
        catch (Exception e){}
    }

    @Test
    void test1() {
        home = new Home2(driver1);
        home.navigateToHome();

    }

}
