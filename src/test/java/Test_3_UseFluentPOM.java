import Actions.BrowserActions3;
import POM.*;
import org.testng.annotations.*;



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
        BrowserActions.closeDriver();
    }


    @Test
    void testFluentPOM(){
            home.navigateToHome_FluentPOM()
                    .clickOnGetPaid_FluentPOM();

        }
    }
