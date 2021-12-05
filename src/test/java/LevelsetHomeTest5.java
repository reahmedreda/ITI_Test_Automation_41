import Actions.BrowserActions3;
import POM.Home2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class LevelsetHomeTest5 {
    WebDriver driver1, driver2;
    Home2 home, home2;
    @Parameters("browser")


    @BeforeTest
    void setup(String browser) throws Exception {
        if(browser.equals("Chrome")) {
            driver1 = new ChromeDriver();
        }
        else if (browser.equals("FireFox")){
            driver1 = new FirefoxDriver();
        }

    }

    @AfterTest
    void teardown(String browser) {
        driver1.close();

    }

    @Test
    void test1() {
        home = new Home2(driver1);
        home.navigateToHome();


    }

    @Test(dataProvider = "GetDocuments")
    void testDocumentFreePrice(String doc) {
        home.navigateToHome();
        home.pressCreateDocument();

    }

    @DataProvider(name = "GetDocuments")
    public Object[] getDocuments() {
        return new Object[]
                {
                        "20-Day Preliminary Notice",
                        "Notice of Intent to Lien",
                        "Lien / Bond Claim",
                        "Lien Waiver"
                };
    }

}
