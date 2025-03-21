package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SelectingDocument_BasicImp {
    WebDriver driver ;
    String doc = "//div[@class='left' and contains(text(),'%s')]";
    public String documentSearchSelector = "#document_search",
            documentSelector = "//div[text()='%s']",
            titleSelector="//div[@class='title']",
            priceFreeSelector = "//div[text()='%s']/..//span[text()='Free']",
            priceSelector = "\n" +
                    "//div[@class='left' and contains(text(),'%s')]//parent::Div//span[@class='price-amount']";


    public SelectingDocument_BasicImp(WebDriver driver){
        this.driver = driver;
    }

    public void selectDocument(String doc){
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.presenceOfElementLocated
                            (new By.ByXPath(String.format(documentSelector, doc))));
            element.click();
            Assert.assertEquals(element.getText(),driver.findElement(new By.ByXPath(titleSelector)).getText());

        }
        catch(Exception e){
           Assert.fail("Couldn't select Document, Exception :"+ e.getStackTrace());
        }

    }

    public boolean checkIfPriceIsFree(String doc){
        try{
            new WebDriverWait(driver,Duration.ofSeconds(10)).
                    until(ExpectedConditions.presenceOfElementLocated
                            (new By.ByXPath(String.format(priceFreeSelector,doc))));
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public String getPrice(String doc){
        WebElement price = driver.findElement(new By.ByXPath(String.format(priceSelector,doc)));
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf
                        (price));
        return price.getText();
    }





}
