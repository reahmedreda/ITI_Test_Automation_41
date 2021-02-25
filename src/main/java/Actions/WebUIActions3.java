package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static Actions.BrowserActions3.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class WebUIActions3 {

    public void clickOn(String selector,Locators l,boolean assertion,String expectedElementSelector,Locators l2) {
        By b = returnElementLocatorBy(selector,l);
        waitUntil(b, ExpectedConditionsEnum.presenceOfElement);
        WebElement element = driver.findElement(b);
        try {

            /*Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();*/
            if(assertion==true){waitUntil(b, ExpectedConditionsEnum.ElementToBeClickable);}
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
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        By expectedElement = returnElementLocatorBy(expectedElementSelector,l2);
        assertNotNull(waitUntil(expectedElement,ExpectedConditionsEnum.ElementToBeClickable));
    }

    public WebElement waitUntil(By b, ExpectedConditionsEnum condition) {
        try {
            WebElement element = null;
            switch (condition) {
                case presenceOfElement:

                    element = (new WebDriverWait(driver,6)).until(ExpectedConditions.presenceOfElementLocated(b));
                    return element;

                case ElementToBeClickable:
                    element = (new WebDriverWait(driver, 6)).until(ExpectedConditions.elementToBeClickable(b));
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

    public WebElement waitUntil(By element, ExpectedCondition<WebElement> s){
        try{
            return new WebDriverWait(driver, 10).until(s);

        }
        catch(Exception e){
            return null;
        }
    }

    public void navigateToPage(String url,String selector,Locators l) {
        driver.get(url);
        By b = returnElementLocatorBy(selector,l);
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement element = waitUntil(b, ExpectedConditionsEnum.presenceOfElement);
        assertNotNull(element, "Navigation Failed to this Website "+url);
    }


    public By returnElementLocatorBy(String selector,Locators l){
        switch (l){
            case XPath:
                return new By.ByXPath(selector);

            case id:
                return new By.ById(selector);


            case CSS:
                return new By.ByCssSelector(selector);


            default: return  null;
        }
    }
    public enum Locators {
        XPath,
        CSS,
        id
    }

    enum ExpectedConditionsEnum{
        presenceOfElement,
        ElementToBeClickable
    }


}
