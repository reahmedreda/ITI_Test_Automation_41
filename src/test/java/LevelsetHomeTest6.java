import Actions.BrowserActions;
import POM.Home2;
import Wrappers.JsonFileParser;
import Wrappers.LoggingHandling;
import Wrappers.PropertiesFileHandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class LevelsetHomeTest6 {
    WebDriver driver1, driver2;
    Home2 home, home2;
    int x = 0;


    //@Test
    void testJson(){
        int [] x = {1,2};
        try {
            if (x[3] == 0) {
                System.out.println("Error");
            }
        }
        catch (Exception e){
            System.out.println(e.toString());

            System.out.println("===============================");

            e.printStackTrace();

        }
        LoggingHandling.logger.warning(
                new JsonFileParser(JsonFileParser.jsonFile)
                        .getValuesOf("MailContact","Email").toString());

    }



    @Test
    public void assertName(){
        Assert.assertEquals(
                PropertiesFileHandler.getProperty("sendTo"),"Ahmed");
    }

    //@Test
    void TestJson(){
        Assert.assertEquals(new JsonFileParser(JsonFileParser.jsonFile)
                        .getValueOfNode("MailContact/Password/Pass1").toString(),"Ahmed");
    }

    //@Test(retryAnalyzer =  Wrappers.RetryAnalyzer.class)
    void retryFailed(){
        x++;
        Assert.assertEquals(x,3);
        // Assert.assertFalse(true);
    }



}
