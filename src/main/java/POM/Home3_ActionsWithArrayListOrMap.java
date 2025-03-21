package POM;

import Actions.WebUIActions3_UseArraylistOrMapOfDrivers;

public class Home3_ActionsWithArrayListOrMap {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions3_UseArraylistOrMapOfDrivers uiActions;
    String getPaid = "//a[contains(text(),'Get paid')]";
    public Home3_ActionsWithArrayListOrMap(int index){
        uiActions = new WebUIActions3_UseArraylistOrMapOfDrivers(index);
    }

    public Home3_ActionsWithArrayListOrMap(String key){
        uiActions = new WebUIActions3_UseArraylistOrMapOfDrivers(key);
    }

    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, getPaid, WebUIActions3_UseArraylistOrMapOfDrivers.Locators.XPath);
    }







}
