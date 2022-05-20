import Actions.BrowserActions4;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Test_9_0_UseTestBase_MultipleDrivers_Map {
    String uniqueKey;

    //This test should be run from test2.xml

    @Parameters("browser")
    @BeforeClass
    void setup(String browser,final ITestContext testContext) {
        uniqueKey = testContext.getAllTestMethods()[0].getTestClass().getName();
        BrowserActions4.addWebDriverToMapOfDrivers(browser,uniqueKey);
    }

    @AfterClass
    public void tearDown(){
        BrowserActions4.closeDriverAndRemoveFromMap(uniqueKey);

    }

}
