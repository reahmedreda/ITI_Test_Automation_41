import POM.Home;
import POM.SelectingDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LevelsetHomeTest {

    WebDriver driver;
    Home home;
    SelectingDocument selectDoc;
    String broswer = "Chrome";

    @BeforeTest
    void setup() {
        if(broswer == "Chrome") {
            driver = new ChromeDriver();
        }
        else if (broswer == "firefox"){

        }
        else{

        }

        driver.manage().window().maximize();
        home = new Home(driver);
        selectDoc = new SelectingDocument(driver);
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }


    @Test
    void testPreliminary() {
        String doc = "20-Day Preliminary Notice";
        home.navigateToHome();
        home.pressCreateDocument0();
        selectDoc.selectDocument(doc);
        assertEquals(selectDoc.checkIfPriceIsFree(doc),true);

    }

    @Test
    void testLien() {
        //String doc = "20-Day Preliminary Notice";
        String doc= "Lien / Bond Claim";
        home.navigateToHome();
        home.pressCreateDocument2();
        selectDoc.selectDocument(doc);
        assertEquals(selectDoc.checkIfPriceIsFree(doc),true);

    }

}