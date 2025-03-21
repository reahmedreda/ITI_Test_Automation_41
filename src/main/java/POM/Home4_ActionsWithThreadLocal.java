package POM;

import Actions.WebUIActions4_UseThreadLocalOfDrivers;

public class Home4_ActionsWithThreadLocal {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions4_UseThreadLocalOfDrivers uiActions;
    String getPaid = "//a[contains(text(),'Get paid')]";

    public Home4_ActionsWithThreadLocal(){
        uiActions = new WebUIActions4_UseThreadLocalOfDrivers();
    }

    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, getPaid, WebUIActions4_UseThreadLocalOfDrivers.Locators.XPath);
    }







}
