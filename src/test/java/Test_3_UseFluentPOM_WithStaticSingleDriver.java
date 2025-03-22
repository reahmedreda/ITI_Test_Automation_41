import Actions.BrowserActions2_StaticSingleDriver;
import POM.*;
import org.testng.annotations.*;

/*
A Type of POM, called Fluent where each function return the instance "this"
so this will help creating a chain of function calls for better readability
 */

public class Test_3_UseFluentPOM_WithStaticSingleDriver {
    Home2_ActionsWithStaticDriver home;


    @BeforeMethod
    public void setup() {
        BrowserActions2_StaticSingleDriver.initializeTheWebDriver("Chrome");
        BrowserActions2_StaticSingleDriver.maximizeScreen();
        home = new Home2_ActionsWithStaticDriver();

    }

    @AfterMethod
    public void teardown() {
        BrowserActions2_StaticSingleDriver.quitDriver();
    }


    @Test
    void testFluentPOM(){
            home.navigateToHome_FluentPOM()
                    .clickOnGetPaid_FluentPOM();

        }
    }
