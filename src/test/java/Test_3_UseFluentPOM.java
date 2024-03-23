import Actions.BrowserActions3;
import POM.*;
import org.testng.annotations.*;

/*
A Type of POM, called Fluent where each function return the instance "this"
so this will help creating a chain of function calls for better readability
 */

public class Test_3_UseFluentPOM {
    Home3 home;

    BrowserActions3 BrowserActions;

    @BeforeTest
    public void setup() {
        BrowserActions = new BrowserActions3();
        BrowserActions.initializeTheWebDriver("Chrome");
        BrowserActions.maximizeScreen();
        home = new Home3();

    }

    @AfterTest
    public void teardown() {
        BrowserActions.quitDriver();
    }


    @Test
    void testFluentPOM(){
            home.navigateToHome_FluentPOM()
                    .clickOnGetPaid_FluentPOM();

        }
    }
