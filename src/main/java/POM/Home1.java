package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Home1 {
    String homepageURL = "https://www.levelset.com/";
    WebDriver driver;
    String createDocument = "//a[text()='Create a Document ']",
            getPaid = "//a[contains(text(),'Get paid')]";


    public Home1(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHome() {
        driver.get(homepageURL);
        WebElement expectedElement = driver.findElement(new By.ByXPath(getPaid));
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf
                        (expectedElement));
    }

    public void clickOnGetPaid_Basic() {
        By element = new By.ByXPath(getPaid);
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable
                        (element));
        driver.findElement(element).click();
    }

    public void clickOnGetPaid_PostValidation() {
        By element = new By.ByXPath(getPaid);
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable
                        (element));
        driver.findElement(element).click();
        By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.presenceOfElementLocated
                            (expectedElementLocator));
        } catch (Exception e) {
            Assert.fail("Element not found");
        }

    }

    public void clickOnGetPaid_PostValidationAndExceptionHandling() {
            By element = new By.ByXPath(getPaid);
            new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.elementToBeClickable
                            (element));
            driver.findElement(element).click();
            By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
            try {
                new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElementLocator));
            } catch (Exception e) {

                Actions act = new Actions(driver);
                act.doubleClick(driver.findElement(element)).perform();
                if (new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElementLocator)) == null) {

                    Assert.fail("Element not found");
                }
            }

    }





    //============================ Further initial Optimisations ====================================
   /*
   This is the wrong place to implement such generic functions, it's just
   for demo how the generalisation and optimisation cycle evolves by time
   and then we will have to move those generic functions to a centeralised
   class so every POM class can use it
    */



   /*
   Generic Function for clicking on any element and retry 3 times to achieve this
   action and validate the action by checking the presence of an expected element
    */
    public boolean clickOnElement(By element, By expectedElement) {
        for (int i = 0; i < 3; i++) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.elementToBeClickable
                                (element));
                driver.findElement(element).click();
                if (new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.presenceOfElementLocated
                                (expectedElement)) != null) {
                    return true;
                }

            } catch (Exception e) {

                return  false;
            }
        }
        return false;
    }


    /*
    generic function to check if an element is clickable or not
     */
    public boolean validateClickabilityOfElement(By element){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.elementToBeClickable
                            (element));
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }

    /*
    check presence of element
     */
    public boolean validatePresenceOfElement(By element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.presenceOfElementLocated
                            (element));
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }


    public void clickOnGetPaid_usingBasicGenericFunctions(){

        By element = new By.ByXPath(getPaid);

        if(validateClickabilityOfElement(element)) {
            driver.findElement(element).click();
            By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
            assertTrue(validatePresenceOfElement(expectedElementLocator));
        }
    }


    //================================ Further Generic func===============================
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
                new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.visibilityOfElementLocated(element));
                break;


        }
        try {
            if(x!=null) {
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(x);
            }
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }

    public void clickOnGetPaid(){

        By element = new By.ByXPath(getPaid);

        if(validateOnElement(element,"clickable")) {
            driver.findElement(element).click();

            By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
            assertTrue(validateOnElement(expectedElementLocator,"presence"));
        }
    }


    //==================================================================

    /*
    instead of having switch case for all types we can simply send
    Expected condition object as param
     */
    public boolean validateOnElement2(By element, ExpectedCondition<WebElement> s){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(s);
            return true;
        }
        catch(Exception e){
            return  false;
        }
    }

    public void clickOnGetPaid2(){

        By element = new By.ByXPath(createDocument);

        if(validateOnElement2(element,ExpectedConditions.elementToBeClickable(element))) {
            driver.findElement(element).click();

            By expectedElementLocator = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
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


    public void clickOnGetPaid3(){
       By element = new By.ByXPath(getPaid),
            expectedElement = new By.ByXPath(String.format(new SelectingDocument(driver).doc, "Exchange a Waiver"));
        clickOnBtn(element,expectedElement);
    }

}
