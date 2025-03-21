import Actions.BrowserActions1_BasicImp_returnDriver;
import Actions.WebUIActions1_BasicImp_GetDriverInConstructor;
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
    Home2 home;
    SelectingDocument2 selectDoc;
    BrowserActions1_BasicImp_returnDriver BrowserActions;
    WebUIActions1_BasicImp_GetDriverInConstructor actions;

    @BeforeMethod
    public void setup() {
        BrowserActions = new BrowserActions1_BasicImp_returnDriver();
        driver = BrowserActions.initializeTheWebDriver("Chrome");
        BrowserActions.maximizeScreen();
        actions = new WebUIActions1_BasicImp_GetDriverInConstructor(driver);

        home = new Home2(driver);
        selectDoc = new SelectingDocument2(driver);
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