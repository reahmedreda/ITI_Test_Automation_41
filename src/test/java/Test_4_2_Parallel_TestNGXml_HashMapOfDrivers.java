import Actions.BrowserActions3_UseArraylistOrMapOfDrivers;
import POM.Home3_ActionsWithArrayListOrMap;
import org.testng.annotations.*;

/*
Same as previous class but uses Map instead of Array list which is way better
 */
public class Test_4_2_Parallel_TestNGXml_HashMapOfDrivers {

    //This test should be run from test.xml



    @Parameters({"browser"})
    @BeforeMethod
    void setup(@Optional("firefox") String browser) throws Exception {

        BrowserActions3_UseArraylistOrMapOfDrivers.addWebDriverToMapOfDrivers(BrowserActions3_UseArraylistOrMapOfDrivers.Browsers.valueOf(browser.toLowerCase()),
                String.valueOf(Thread.currentThread().getId()));

    }

    @AfterMethod
    void teardown() {
        String key = String.valueOf(Thread.currentThread().getId());
        BrowserActions3_UseArraylistOrMapOfDrivers.closeDriverAndRemoveFromMap(key);
    }

    @Test
    void test1() {
        Home3_ActionsWithArrayListOrMap home = new Home3_ActionsWithArrayListOrMap(String.valueOf(Thread.currentThread().getId()));
        home.navigateToHome();

    }

}
