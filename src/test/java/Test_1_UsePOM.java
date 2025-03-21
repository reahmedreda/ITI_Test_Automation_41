import POM.Home_BasicImp;
import POM.SelectingDocument_BasicImp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
Resolving the problems caused in the previous 2 Classes by using POM
 */

public class Test_1_UsePOM {

    WebDriver driver;
    Home_BasicImp home;
    SelectingDocument_BasicImp selectDoc;
    String browser = "Chrome";

    @BeforeMethod
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
        home = new Home_BasicImp(driver);
        selectDoc = new SelectingDocument_BasicImp(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


    @Test
    void testPreliminary() {
        home.navigateToHome();
        home.clickOnGetPaid();
        Assert.assertEquals(selectDoc.getPrice("Send a Warning"),"$59");

    }

}