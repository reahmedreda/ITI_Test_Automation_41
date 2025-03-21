package POM;

import Actions.WebUIActions_BasicImp_GetDriverInConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home1_WithBasicActionsClass {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions_BasicImp_GetDriverInConstructor uiActions;
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']",
            getPaid = "//a[contains(text(),'Get paid')]";

    public Home1_WithBasicActionsClass(WebUIActions_BasicImp_GetDriverInConstructor actions){
        this.uiActions = actions;
    }
    public Home1_WithBasicActionsClass(WebDriver driver){
        uiActions = new WebUIActions_BasicImp_GetDriverInConstructor(driver);
    }

    public void navigateToHome(){
         uiActions.navigateToPage(homepageURL, new By.ByXPath(getPaid));
    }



}
