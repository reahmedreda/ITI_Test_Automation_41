import Actions.BrowserActions4_UseArraylistOrMapOfDrivers;
import POM.Home4;
import org.testng.annotations.*;

/*
Same as previous class but uses Map instead of Array list which is way better
 */
public class Test_4_2_Parallel_TestNGXml_HashMapOfDrivers {

    //This test should be run from test.xml



    @Parameters({"browser"})
    @BeforeTest
    void setup(@Optional("firefox") String browser) throws Exception {

        BrowserActions4_UseArraylistOrMapOfDrivers.addWebDriverToMapOfDrivers(BrowserActions4_UseArraylistOrMapOfDrivers.Browsers.valueOf(browser.toLowerCase()),
                String.valueOf(Thread.currentThread().getId()));

    }

    @AfterTest
    void teardown() {
        String key = String.valueOf(Thread.currentThread().getId());
        BrowserActions4_UseArraylistOrMapOfDrivers.closeDriverAndRemoveFromMap(key);
    }

    @Test
    void test1() {
        Home4 home = new Home4(String.valueOf(Thread.currentThread().getId()));
        home.navigateToHome();

    }

}
