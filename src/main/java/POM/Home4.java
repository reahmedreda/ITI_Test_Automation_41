package POM;

import Actions.BrowserActions;
import Actions.WebUIActions3;
import Actions.WebUIActions4;

public class Home4 {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions4 uiActions;
    String getPaid = "//a[contains(text(),'Get paid')]";
    public Home4(int index){
        uiActions = new WebUIActions4(index);
    }

    public Home4(String key){
        uiActions = new WebUIActions4(key);
    }

    public void navigateToHome(){
        uiActions.navigateToPage(homepageURL, getPaid, WebUIActions4.Locators.XPath);
    }







}
