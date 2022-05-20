package POM;

import Actions.WebUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home2 {
    String homepageURL = "https://www.levelset.com/";
    WebUIActions uiActions;
    String createDocument = "//a[text()='Create a Document ']",
            labelPaymentHereSelector = "//h2[text()='Payment Help is Here']",
            getPaid = "//a[contains(text(),'Get paid')]";

    public Home2 (WebUIActions actions){
        this.uiActions = actions;
    }
    public Home2(WebDriver driver){
        uiActions = new WebUIActions(driver);
    }

    public void navigateToHome(){
         uiActions.navigateToPage(homepageURL, new By.ByXPath(getPaid));
    }

    public void pressCreateDocument(){
        uiActions.clickOn(new By.ByXPath(createDocument),true, By.cssSelector(new SelectingDocument2().documentSearchSelector));
    }

}
