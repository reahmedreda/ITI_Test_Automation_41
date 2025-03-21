package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class WebUIActions1_BasicImp_GetDriverInConstructor {
    WebDriver driver;
    public WebUIActions1_BasicImp_GetDriverInConstructor(WebDriver driver){
        this.driver= driver;
    }

    public void setText(By b, String text,boolean clear) {
        WebElement element = waitUntil(b, "presenceOfElement");
        //System.out.println(element);
        try {
            if(clear){
                element.clear();}
            element.sendKeys(text);

            String actualValue = (
                    element.getAttribute("value")==null) ?
                    (element.getAttribute("innerHTML")==null ? element.getText() : element.getAttribute("innerHTML"))
                    : element.getAttribute("value");

            assertEquals(actualValue,text );
        } catch (Exception e) {
            Assert.fail("Couldn't set text because of " + e.getMessage());
        }
    }

    public void clickOn(By b,boolean assertion) {
        waitUntil(b, "presenceOfElement");
        WebElement element = driver.findElement(b);
        try {

            /*Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();*/
            if(assertion==true){waitUntil(b, "elementToBeClickable");}
            element.click();
        } catch (Exception e) {
            try{
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", element);
            }
            catch(Exception c) {
                Assert.fail("Couldn't click because of" + c.getMessage());
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

    public void clickOn(By b,boolean assertion,By expectedElement) {
        //waitUntil(b, "presenceOfElement");
        WebElement element = null;// = driver.findElement(b);
        try {

            /*Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();*/
            if(assertion==true){
                element= waitUntil(b, "elementToBeClickable");}
            else{
                element = waitUntil(b, "presenceOfElement");
            }
            element.click();
            
            
            
            
            
        } catch (Exception e) {
            try{
                if(element !=null) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", element);
                }
            }
            catch(Exception c) {
                Assert.fail("Couldn't click because of" + c.getMessage());
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        if(expectedElement !=null)
        assertNotNull(waitUntil(expectedElement,"presenceOfElement"));
    }

    public WebElement waitUntil(By b, String condition) {
        try {
            WebElement element = null;
            switch (condition) {

                case "presenceOfElement":
                    element = (new WebDriverWait(driver,Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfElementLocated(b));
                    return element;

                case "elementToBeClickable":
                    element = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(b));
                    return element;


                default:
                    element = null;
                    Assert.fail("Wrong condition");
            }
            return element ;
        } catch (Exception e) {
            //Assert.fail("Couldn't find the element because of " + e.getMessage());
            return null;
        }
    }

    public boolean IsElementDisplayed(By b){
        return driver.findElement(b).isDisplayed();
    }

    public void navigateToPage(String url, By b) {
        driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement element = waitUntil(b, "presenceOfElement");
        assertNotNull(element, "Navigation Failed to this Website "+url);
    }

    public String getText(By b){
        try{
            return waitUntil(b,"presenceOfElement").getText();
        }
        catch (Exception e){
            return null;
        }
    }


}
