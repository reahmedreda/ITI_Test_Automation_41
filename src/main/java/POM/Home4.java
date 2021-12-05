package POM;

import Actions.WebUIActions3;
import Actions.WebUIActions4;

public class Home4 {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions4 uiActions;
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']";

    public Home4(int index){
        uiActions = new WebUIActions4(index);
    }

    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, labelPaymentHereSelector, WebUIActions4.Locators.XPath);
    }

    public void pressCreateDocument(){
        uiActions.clickOn(createDocument, WebUIActions4.Locators.XPath,true, new SelectingDocument2().documentSearchSelector, WebUIActions4.Locators.CSS);
    }


    /* Fluent POM */
    public Home4 navigateToHome_FluentPOM(){
        uiActions.navigateToPage(homepageURL, createDocument, WebUIActions4.Locators.XPath);
        return this;
    }

    public Home4 pressCreateDocument_FluentPOM(){
        uiActions.clickOn(createDocument, WebUIActions4.Locators.XPath,true, new SelectingDocument2().documentSearchSelector, WebUIActions4.Locators.CSS);
        return this;
    }

}
