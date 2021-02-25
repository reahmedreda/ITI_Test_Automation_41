package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectingDocument {
    WebDriver driver ;
    String documentSearchSelector = "#document_search",
            documentSelector = "//div[text()='%s']",
            titleSelector="//div[@class='title']",
            priceFreeSelector = "//div[text()='%s']/..//span[text()='Free']";


    public SelectingDocument(WebDriver driver){
        this.driver = driver;
    }

    public void selectDocument(String doc){
        try {
            WebElement element = new WebDriverWait(driver, 10).
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
            new WebDriverWait(driver,10).
                    until(ExpectedConditions.presenceOfElementLocated
                            (new By.ByXPath(String.format(priceFreeSelector,doc))));
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }



}
