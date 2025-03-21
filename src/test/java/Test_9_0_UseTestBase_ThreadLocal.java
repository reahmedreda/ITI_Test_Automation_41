import Actions.BrowserActions4_UseThreadLocalOfDrivers;
import org.testng.annotations.*;

public class Test_9_0_UseTestBase_ThreadLocal {

    //This test should be run from test2.xml

    @Parameters("browser")
    @BeforeMethod
    void setup(String browser) {
        BrowserActions4_UseThreadLocalOfDrivers.setWebDriverToThreadLocalOfDrivers(BrowserActions4_UseThreadLocalOfDrivers.Browsers.valueOf(browser));
    }

    @AfterMethod
    public void tearDown(){
        BrowserActions4_UseThreadLocalOfDrivers.closeDriver();
    }

}
