import Actions.BrowserActions;
import Actions.WebUIActions;
import POM.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

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
    BrowserActions BrowserActions;
    WebUIActions actions;

    @BeforeTest
    public void setup() {
        BrowserActions = new BrowserActions();
        driver = BrowserActions.initializeTheWebDriver("Chrome");
        BrowserActions.maximizeScreen();
        actions = new WebUIActions(driver);

        home = new Home2(driver);
        selectDoc = new SelectingDocument2(driver);
    }


    @AfterTest
    public void teardown() {
        BrowserActions.quitDriver();
    }


    @Test
    public void test1 (){

        home.navigateToHome();
    }


}