import Actions.BrowserActions;
import POM.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class LevelsetHomeTest2 {

    WebDriver driver;
    Home2 home;
    SelectingDocument2 selectDoc;
    BrowserActions BrowserActions;

    @BeforeTest
    void setup() {
        BrowserActions = new BrowserActions();
        driver = BrowserActions.initializeTheWebDriver("Chrome");
        BrowserActions.maximizeScreen();


        home = new Home2(driver);
        selectDoc = new SelectingDocument2(driver);
    }

    @AfterTest
    void teardown() {
        BrowserActions.closeDriver();
    }


    @Test(dataProvider = "GetDocuments")
    void testDocumentFreePrice(String doc) {
        home.navigateToHome();
        home.pressCreateDocument();
        selectDoc.selectDocument(doc);
        assertEquals(selectDoc.checkIfPriceIsFree(doc), true);

    }

    @DataProvider(name = "GetDocuments")
    public Object[] getDocuments() {
        return new Object[]
                {
                        "20-Day Preliminary Notice",
                        "Notice of Intent to Lien",
                        "Lien / Bond Claim",
                        "Lien Waiver"
                };
    }
}