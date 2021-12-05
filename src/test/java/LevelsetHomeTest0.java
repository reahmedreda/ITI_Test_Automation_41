import POM.Home;
import POM.SelectingDocument;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LevelsetHomeTest0 {
    String homepageURL = "https://www.levelset.com/";
    WebDriver driver;
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']";

    Home home;
    SelectingDocument selectDoc;
    String broswer = "Chrome";

    @BeforeTest
    void setup() {
        driver=new ChromeDriver();

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
        driver.get(homepageURL);
        By element = new By.ByXPath(labelPaymentHereSelector);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable
                        (element));

        driver.findElement(element).click();

        By expectedElementLocator = new By.ByCssSelector(new SelectingDocument(driver).documentSearchSelector);
        try {
            new WebDriverWait(driver, 10).
                    until(ExpectedConditions.presenceOfElementLocated
                            (expectedElementLocator));
        }
        catch (Exception e){
            Assert.fail("Element not found");
        }
    }



}