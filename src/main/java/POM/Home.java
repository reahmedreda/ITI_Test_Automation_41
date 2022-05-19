package POM;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    String homepageURL = "https://www.levelset.com/";
    WebDriver driver;
    String createDocument = "//a[text()='Create a Document ']",
            getPaid = "//a[contains(text(),'Get paid')]",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']";

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateHome() {

        driver.get(homepageURL);
        WebElement expectedElement = driver.findElement(new By.ByXPath(getPaid));
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.visibilityOf
                        (expectedElement));
    }

    public void clickOnGetPaid() {

            By element = new By.ByXPath(getPaid);
            new WebDriverWait(driver, 20).
                    until(ExpectedConditions.elementToBeClickable
                            (element));
            driver.findElement(element).click();
            By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
            try {
                new WebDriverWait(driver, 20).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElementLocator));
            } catch (Exception e) {

                Actions act = new Actions(driver);
                act.doubleClick(driver.findElement(element)).perform();
                if (new WebDriverWait(driver, 20).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElementLocator)) == null) {

                    Assert.fail("Element not found");
                }
            }

    }

    public void clickOnGetPaid(boolean useSelenium) {
        if (useSelenium) {
            By element = new By.ByXPath(getPaid);
            new WebDriverWait(driver, 20).
                    until(ExpectedConditions.elementToBeClickable
                            (element));
            driver.findElement(element).click();
            By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
            try {
                new WebDriverWait(driver, 20).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElementLocator));
            } catch (Exception e) {

                Actions act = new Actions(driver);
                act.doubleClick(driver.findElement(element)).perform();
                if (new WebDriverWait(driver, 20).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElementLocator)) == null) {

                    Assert.fail("Element not found");
                }
            }
        } else {

        }


    }

    public void clickOnGetPaid2() {
        By element = new By.ByXPath(getPaid);
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.elementToBeClickable
                        (element));
        driver.findElement(element).click();
        By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
        try {
            new WebDriverWait(driver, 20).
                    until(ExpectedConditions.presenceOfElementLocated
                            (expectedElementLocator));
        } catch (Exception e) {
            Assert.fail("Element not found");
        }


    }


    public boolean clickOnElement(By element, By expectedElement) {
        for (int i = 0; i < 3; i++) {
            try {
                new WebDriverWait(driver, 20).
                        until(ExpectedConditions.elementToBeClickable
                                (element));
                driver.findElement(element).click();
                if (new WebDriverWait(driver, 20).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElement)) != null) {
                    return true;
                }

            } catch (Exception e) {

                Assert.fail();
            }
        }
        return true;
    }






    public void navigateToHome(){
        driver.get(homepageURL);
        By element = new By.ByXPath(getPaid);
        assertTrue(validateOnElement(element,"clickable"));
        /*try {
            (new WebDriverWait(driver, 6))
                    .until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath(labelPaymentHereSelector)));
        }
        catch(Exception e){
            Assert.fail();
        }*/
    }


    public void pressCreateDocument0(){
        By element = new By.ByXPath(createDocument);

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





    //==================================================================
    public boolean validateOnBtn(By element){
        try {
            new WebDriverWait(driver, 10).
                    until(ExpectedConditions.elementToBeClickable
                            (element));
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }

    public boolean validatePresenceOfElement(By element) {
        try {
            new WebDriverWait(driver, 10).
                    until(ExpectedConditions.presenceOfElementLocated
                            (element));
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }


    public void pressCreateDocument1(){

        By element = new By.ByXPath(createDocument);

        if(validatePresenceOfElement(element)) {
            driver.findElement(element).click();
            By expectedElementLocator = new By.ByCssSelector(new SelectingDocument(driver).documentSearchSelector);
            assertTrue(validatePresenceOfElement(expectedElementLocator));
        }
    }


    //==================================================================
    public boolean validateOnElement(By element, String s){
        ExpectedCondition<WebElement> x = null;
        switch (s){
            case "presence":
                x = ExpectedConditions.presenceOfElementLocated(element);

                break;
            case "clickable":
                x= ExpectedConditions.elementToBeClickable(element);
                break;

            case "Visibility":
                new WebDriverWait(driver, 10).
                        until(ExpectedConditions.visibilityOfElementLocated(element));
                break;


        }
        try {
            if(x!=null) {
                new WebDriverWait(driver, 20).until(x);
            }
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }

    public void pressCreateDocument2(){

        By element = new By.ByXPath(createDocument);

        if(validateOnElement(element,"clickable")) {
            driver.findElement(element).click();

            By expectedElementLocator = new By.ByCssSelector(new SelectingDocument(driver).documentSearchSelector);
            assertTrue(validateOnElement(expectedElementLocator,"presence"));
        }
    }


    //==================================================================

    public boolean validateOnElement2(By element, ExpectedCondition<WebElement> s){
        try{
            new WebDriverWait(driver, 10).until(s);
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }

    public void pressCreateDocument3(){

        By element = new By.ByXPath(createDocument);

        if(validateOnElement2(element,ExpectedConditions.elementToBeClickable(element))) {
            driver.findElement(element).click();

            By expectedElementLocator = new By.ByCssSelector(new SelectingDocument(driver).documentSearchSelector);
            assertTrue(validateOnElement2(expectedElementLocator,ExpectedConditions.presenceOfElementLocated(expectedElementLocator)));
        }
    }


    //==================================================================
    public void clickOnBtn(By element,By expectedElement){
        if(validateOnElement2(element,ExpectedConditions.elementToBeClickable(element))) {
            driver.findElement(element).click();
        }
        validateOnElement2(expectedElement,ExpectedConditions.presenceOfElementLocated(expectedElement));


    }


    public void pressCreateDocument4(){
       By element = new By.ByXPath(createDocument),
            expectedElement = new By.ByCssSelector(new SelectingDocument(driver).documentSearchSelector);
        clickOnBtn(element,expectedElement);
    }



    //==================================================================











    public void pressRequestADocument(){
       validateOnBtn(new By.ByXPath(createDocument));
        driver.findElement(new By.ByXPath(createDocument)).click();
        validatePresenceOfElement(new By.ByCssSelector(
               new SelectingDocument(driver).documentSearchSelector));

    }

}
