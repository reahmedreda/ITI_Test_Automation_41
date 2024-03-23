package POM;

import Actions.WebUIActions5_UseThreadLocalOfDrivers;

public class Home5 {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions5_UseThreadLocalOfDrivers uiActions;
    String getPaid = "//a[contains(text(),'Get paid')]";

    public Home5(){
        uiActions = new WebUIActions5_UseThreadLocalOfDrivers();
    }

    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, getPaid, WebUIActions5_UseThreadLocalOfDrivers.Locators.XPath);
    }







}
