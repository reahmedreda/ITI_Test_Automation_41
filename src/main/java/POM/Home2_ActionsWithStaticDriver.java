package POM;

import Actions.WebUIActions2_UseSingleStaticDriver;


public class Home2_ActionsWithStaticDriver {
    String homepageURL = "https://www.levelset.com/";
    String getPaid = "//a[contains(text(),'Get paid')]";
    WebUIActions2_UseSingleStaticDriver uiActions= new WebUIActions2_UseSingleStaticDriver();
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']";



    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, labelPaymentHereSelector, WebUIActions2_UseSingleStaticDriver.Locators.XPath);
    }

    public void pressCreateDocument(){
        uiActions.clickOn(createDocument, WebUIActions2_UseSingleStaticDriver.Locators.XPath,true, new SelectingDocument1_WithBasicActionsClass().documentSearchSelector, WebUIActions2_UseSingleStaticDriver.Locators.CSS);
    }


    /* Fluent POM */
    /* Fluent POM */
    public Home2_ActionsWithStaticDriver navigateToHome_FluentPOM(){
        uiActions.navigateToPage(homepageURL, getPaid, WebUIActions2_UseSingleStaticDriver.Locators.XPath );
        return this;
    }


    public SelectingDocument1_WithBasicActionsClass clickOnGetPaid_FluentPOM(){
        String expectedLocator = String.format(new SelectingDocument1_WithBasicActionsClass().doc,"Exchange a Waiver");
        uiActions.clickOn(getPaid, WebUIActions2_UseSingleStaticDriver.Locators.XPath,true, expectedLocator, WebUIActions2_UseSingleStaticDriver.Locators.XPath);
        return new SelectingDocument1_WithBasicActionsClass();
    }

}
