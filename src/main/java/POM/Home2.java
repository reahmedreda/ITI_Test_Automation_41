package POM;

import Actions.WebUIActions1_BasicImp_GetDriverInConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home2 {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions1_BasicImp_GetDriverInConstructor uiActions;
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']",
            getPaid = "//a[contains(text(),'Get paid')]";

    public Home2 (WebUIActions1_BasicImp_GetDriverInConstructor actions){
        this.uiActions = actions;
    }
    public Home2(WebDriver driver){
        uiActions = new WebUIActions1_BasicImp_GetDriverInConstructor(driver);
    }

    public void navigateToHome(){
         uiActions.navigateToPage(homepageURL, new By.ByXPath(getPaid));
    }

    public void pressCreateDocument(){
        uiActions.clickOn(new By.ByXPath(createDocument),true, By.cssSelector(new SelectingDocument2().documentSearchSelector));
    }

}
