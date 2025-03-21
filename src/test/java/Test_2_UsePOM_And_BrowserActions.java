import Actions.BrowserActions1_BasicImp_returnDriver;
import POM.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
/*
Moving the Browser configurations from hardcoded writing in the setup
to be in a separate Class, so it can be modular and reusable for all other
test classes
 */

public class Test_2_UsePOM_And_BrowserActions {
    WebDriver driver;
    Home1_WithBasicActionsClass home;
    SelectingDocument1_WithBasicActionsClass selectDoc;
    BrowserActions1_BasicImp_returnDriver BrowserActions;

    @BeforeMethod
    public void setup() {
        BrowserActions = new BrowserActions1_BasicImp_returnDriver();
        driver = BrowserActions.initializeTheWebDriver("Chrome");
        BrowserActions.maximizeScreen();

        home = new Home1_WithBasicActionsClass(driver);
        selectDoc = new SelectingDocument1_WithBasicActionsClass(driver);
    }


    @AfterMethod
    public void teardown() {
        BrowserActions.quitDriver();
    }


    @Test
    public void test1 (){

        home.navigateToHome();
    }


}