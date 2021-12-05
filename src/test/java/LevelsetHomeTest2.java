import Actions.BrowserActions;
import POM.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class LevelsetHomeTest2 {

    WebDriver driver;
    Home2 home;
    SelectingDocument2 selectDoc;
    BrowserActions BrowserActions;

    @BeforeTest
    void setup() {
        BrowserActions = new BrowserActions();
        driver = BrowserActions.initializeTheWebDriver("Chrome");
        BrowserActions.maximizeScreen();


        home = new Home2(driver);
        selectDoc = new SelectingDocument2(driver);
    }

    @AfterTest
    void teardown() {
        BrowserActions.closeDriver();
    }



}