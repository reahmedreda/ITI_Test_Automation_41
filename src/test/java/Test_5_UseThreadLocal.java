import Actions.BrowserActions5_UseThreadLocalOfDrivers;
import POM.Home5;
import org.testng.annotations.*;

/*
Same as previous class but uses ThreadLocal instead of Map which is way better
*/
public class Test_5_UseThreadLocal {
        @Parameters({"browser"})
        @BeforeTest
        void setup(@Optional("firefox") String browser) throws Exception {

            BrowserActions5_UseThreadLocalOfDrivers.setWebDriverToThreadLocalOfDrivers(BrowserActions5_UseThreadLocalOfDrivers.Browsers.valueOf(browser.toLowerCase()));

        }

        @AfterTest
        void teardown() {
            BrowserActions5_UseThreadLocalOfDrivers.closeDriver();
        }

        @Test
        void test1() {
            Home5 home = new Home5();
            home.navigateToHome();

        }

    }
