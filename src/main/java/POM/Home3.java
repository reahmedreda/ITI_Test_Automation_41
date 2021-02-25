package POM;

import Actions.*;
import Actions.WebUIActions3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home3 {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions3 uiActions= new WebUIActions3();
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']";



    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, labelPaymentHereSelector, WebUIActions3.Locators.XPath);
    }

    public void pressCreateDocument(){
        uiActions.clickOn(createDocument, WebUIActions3.Locators.XPath,true, new SelectingDocument2().documentSearchSelector, WebUIActions3.Locators.CSS);
    }


    /* Fluent POM */
    public Home3 navigateToHome_FluentPOM(){
        uiActions.navigateToPage(homepageURL, createDocument, WebUIActions3.Locators.XPath);
        return this;
    }

    public Home3 pressCreateDocument_FluentPOM(){
        uiActions.clickOn(createDocument, WebUIActions3.Locators.XPath,true, new SelectingDocument2().documentSearchSelector, WebUIActions3.Locators.CSS);
        return this;
    }

}
