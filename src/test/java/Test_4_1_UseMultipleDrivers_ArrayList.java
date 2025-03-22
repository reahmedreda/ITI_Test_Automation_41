import Actions.BrowserActions3_UseArraylistOrMapOfDrivers;
import POM.Home3_ActionsWithArrayListOrMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
This Test Class uses a version of Browser and UI Actions where they're capable
of using multiple drivers, and it's stored in Array List, Which isn't the best
data structure to use for this purpose, check the Browser Actions class for more information
 */
public class Test_4_1_UseMultipleDrivers_ArrayList {

    @BeforeMethod
    void setup() {
        }

    @AfterMethod
    void teardown() {

    }

    @Test
    void test1() {
        Home3_ActionsWithArrayListOrMap home;
        int driverNo;
        driverNo= BrowserActions3_UseArraylistOrMapOfDrivers.addWebDriverToListOfDrivers("Chrome");
        home = new Home3_ActionsWithArrayListOrMap(driverNo);
        home.navigateToHome();
        BrowserActions3_UseArraylistOrMapOfDrivers.closeDriverAndRemoveFromList(driverNo);
    }


}
