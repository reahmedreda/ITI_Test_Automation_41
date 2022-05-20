import POM.Home;
import POM.SelectingDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Test_1_UsePOM {

    WebDriver driver;
    Home home;
    SelectingDocument selectDoc;
    String browser = "Chrome";

    @BeforeTest
    public void setup() {
        if(browser == "Chrome") {
            driver = new ChromeDriver();
        }
        else if (browser == "firefox"){
            driver = new FirefoxDriver();
        }
        else{

        }

        driver.manage().window().maximize();
        home = new Home(driver);
        selectDoc = new SelectingDocument(driver);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }


    @Test
    void testPreliminary() {
        home.navigateToHome();
        home.clickOnGetPaid();
        Assert.assertEquals(selectDoc.getPrice("Release"),"$149");

        //selectDoc.selectDocument(doc);

      //  assertEquals(selectDoc.checkIfPriceIsFree(doc),true);

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