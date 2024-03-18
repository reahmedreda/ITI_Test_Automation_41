import POM.DocumentsPage;
import POM.Home;
import POM.HomePage;
import POM.SelectingDocument;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Test_0_UseSeleniumDirectlyInTestClass {
    String homepageURL = "https://www.levelset.com/";
    WebDriver driver;
    String doc = "//div[@class='left' and contains(text(),'%s')]",
            getPaid = "//a[contains(text(),'Get paid')]",
            priceSelector = "//div[@class='left' and contains(text(),'%s')]//..//span[@class='price-amount']";



    @BeforeTest
    public void setup() {
        driver=new ChromeDriver();

        driver.manage().window().maximize();

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }


    @Test
    public void test1(){
        WebDriver driver1 = new ChromeDriver();
        HomePage homePage = new HomePage(driver1);
        homePage.navigate();
        homePage.clickGetPAid();
        DocumentsPage doc = new DocumentsPage(driver1);
        doc.checkPrice();
    }

    @Test
    void testExchangeAWaiver() {

        driver.get(homepageURL);
        By element = new By.ByXPath(getPaid);
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable
                        (element));

        driver.findElement(element).click();

        By expectedElementLocator = new By.ByXPath(String.format(doc,"Exchange a Waiver"));
        try {
            new WebDriverWait(driver, 20).
                    until(ExpectedConditions.presenceOfElementLocated
                            (expectedElementLocator));
        }
        catch (Exception e){

            driver.get(homepageURL);
            driver.findElement(element).click();
            if(new WebDriverWait(driver, 20).
                    until(ExpectedConditions.presenceOfElementLocated
                            (expectedElementLocator))==null){

                Assert.fail("Element not found");
            }
        }

        WebElement price = driver.findElement(new By.ByXPath(String.format(priceSelector,"Exchange a Waiver")));
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOf
                        (price));
        Assert.assertEquals(price.getText(),"Free");

    }



}