package POM;

import Actions.WebUIActions4_UseArraylistOrMapOfDrivers;

public class Home4 {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions4_UseArraylistOrMapOfDrivers uiActions;
    String getPaid = "//a[contains(text(),'Get paid')]";
    public Home4(int index){
        uiActions = new WebUIActions4_UseArraylistOrMapOfDrivers(index);
    }

    public Home4(String key){
        uiActions = new WebUIActions4_UseArraylistOrMapOfDrivers(key);
    }

    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, getPaid, WebUIActions4_UseArraylistOrMapOfDrivers.Locators.XPath);
    }







}
