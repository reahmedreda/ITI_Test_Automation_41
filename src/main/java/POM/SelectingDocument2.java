package POM;

import Actions.WebUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SelectingDocument2 {

    WebUIActions uiActions;
    String documentSearchSelector = "#document_search",
            documentSelector = "//div[text()='%s']",
            titleSelector="//div[@class='title']",
            priceFreeSelector = "//div[text()='%s']/..//span[text()='Free']";

    public SelectingDocument2(){}
    public SelectingDocument2(WebDriver driver){
        uiActions = new WebUIActions(driver);
    }

    public void selectDocument(String doc){
        uiActions.clickOn(new By.ByXPath(String.format(documentSelector, doc)),true);
            Assert.assertEquals(doc,uiActions.getText(new By.ByXPath(titleSelector)));
    }

    public boolean checkIfPriceIsFree(String doc){
        return uiActions.waitUntil(new By.ByXPath(String.format(priceFreeSelector,doc)),"presenceOfElement") != null;
    }



}
