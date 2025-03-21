import Actions.BrowserActions3_UseArraylistOrMapOfDrivers;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class Test_9_0_UseTestBase_MultipleDrivers_Map {
    String uniqueKey;

    //This test should be run from test2.xml

    @Parameters("browser")
    @BeforeClass
    void setup(String browser,ITestContext testContext) {
        ITestContext x = testContext;
        uniqueKey = testContext.getAllTestMethods()[0].getTestClass().getTestName();
        BrowserActions3_UseArraylistOrMapOfDrivers.addWebDriverToMapOfDrivers(BrowserActions3_UseArraylistOrMapOfDrivers.Browsers.valueOf(browser),uniqueKey);
    }

    @AfterClass
    public void tearDown(){
        BrowserActions3_UseArraylistOrMapOfDrivers.closeDriverAndRemoveFromMap(uniqueKey);
    }

}
