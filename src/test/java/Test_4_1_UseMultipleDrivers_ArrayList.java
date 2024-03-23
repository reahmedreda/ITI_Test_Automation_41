import Actions.BrowserActions4_UseArraylistOrMapOfDrivers;
import POM.Home4;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
This Test Class uses a version of Browser and UI Actions where they're capable
of using multiple drivers, and it's stored in Array List, Which isn't the best
data structure to use for this purpose, check the Browser Actions class for more information
 */
public class Test_4_1_UseMultipleDrivers_ArrayList {
    Home4 home;
    int driverNo;

    @BeforeTest
    void setup() {
        driverNo= BrowserActions4_UseArraylistOrMapOfDrivers.addWebDriverToListOfDrivers("Chrome");
    }

    @AfterTest
    void teardown() {
        BrowserActions4_UseArraylistOrMapOfDrivers.closeDriverAndRemoveFromList(driverNo);
    }

    @Test
    void test1() {
        home = new Home4(driverNo);
        home.navigateToHome();
    }


}
