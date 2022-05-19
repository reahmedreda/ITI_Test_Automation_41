import Actions.BrowserActions3;
import POM.Home2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class LevelsetHomeTest5 {

    @Test(dataProvider = "GetDocuments")
    void testDocumentName(String doc) {
        Assert.assertEquals(doc,"Lien Waiver");
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

    @Test(dataProvider = "GetDocumentsAndPrices")
    void testDocumentNameAndPrice(String docName,int price) {
        Assert.assertEquals(docName,"Lien Waiver");
        Assert.assertEquals(price,50);
    }

    @DataProvider(name = "GetDocumentsAndPrices")
    public Object[][] getDocumentsAndPrices() {
        return new Object[][]
                {
                        {"20-Day Preliminary Notice",30},
                        {"Notice of Intent to Lien",30},
                        {"Lien / Bond Claim",40},
                        {"Lien Waiver",50}
                };
    }

}
