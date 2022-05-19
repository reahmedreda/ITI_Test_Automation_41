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


public class LevelsetHomeTest2 {
    Map<String,WebDriver> drivermapper = new HashMap<>();
    WebDriver driver,d2,d3,d4,d5;
    Home2 home;
    SelectingDocument2 selectDoc;
    BrowserActions BrowserActions;
    WebUIActions actions;
    @BeforeTest
    void setup() {

        BrowserActions = new BrowserActions();
        driver = BrowserActions.initializeTheWebDriver("Chrome");
        BrowserActions.maximizeScreen();
        actions = new WebUIActions(driver);

        home = new Home2(driver);
        selectDoc = new SelectingDocument2(driver);
    }

//    @BeforeTest
//    public void setup(){
//
//        drivermapper.put("Test1",new ChromeDriver());
//    }

    @AfterTest
    void teardown() {
        BrowserActions.closeDriver();
    }


    @Test
    public void parallel(){
      WebDriver driver = drivermapper.get("Test1");
      driver.get("");
    }


}