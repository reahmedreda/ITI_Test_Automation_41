import Actions.BrowserActions4_UseThreadLocalOfDrivers;
import POM.Home4_ActionsWithThreadLocal;
import org.testng.annotations.*;

/*
Same as previous class but uses ThreadLocal instead of Map which is way better
*/
public class Test_5_UseThreadLocal {
        @Parameters({"browser"})
        @BeforeMethod
        void setup(@Optional("firefox") String browser) throws Exception {

            BrowserActions4_UseThreadLocalOfDrivers.setWebDriverToThreadLocalOfDrivers(BrowserActions4_UseThreadLocalOfDrivers.Browsers.valueOf(browser.toLowerCase()));

        }

        @AfterMethod
        void teardown() {
            BrowserActions4_UseThreadLocalOfDrivers.closeDriver();
        }

        @Test
        void test1() {
            Home4_ActionsWithThreadLocal home = new Home4_ActionsWithThreadLocal();
            home.navigateToHome();

        }

    }
