package POM;

import Actions.WebUIActions3_UseSingleStaticDriver;


public class Home3 {
    String homepageURL = "https://www.levelset.com/";
    String getPaid = "//a[contains(text(),'Get paid')]";
    WebUIActions3_UseSingleStaticDriver uiActions= new WebUIActions3_UseSingleStaticDriver();
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']";



    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, labelPaymentHereSelector, WebUIActions3_UseSingleStaticDriver.Locators.XPath);
    }

    public void pressCreateDocument(){
        uiActions.clickOn(createDocument, WebUIActions3_UseSingleStaticDriver.Locators.XPath,true, new SelectingDocument2().documentSearchSelector, WebUIActions3_UseSingleStaticDriver.Locators.CSS);
    }


    /* Fluent POM */
    /* Fluent POM */
    public Home3 navigateToHome_FluentPOM(){
        uiActions.navigateToPage(homepageURL, getPaid, WebUIActions3_UseSingleStaticDriver.Locators.XPath );
        return this;
    }


    public SelectingDocument2 clickOnGetPaid_FluentPOM(){
        String expectedLocator = String.format(new SelectingDocument2().doc,"Exchange a Waiver");
        uiActions.clickOn(getPaid, WebUIActions3_UseSingleStaticDriver.Locators.XPath,true, expectedLocator, WebUIActions3_UseSingleStaticDriver.Locators.XPath);
        return new SelectingDocument2();
    }

}
