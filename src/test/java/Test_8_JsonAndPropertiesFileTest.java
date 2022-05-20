import Actions.BrowserActions;
import POM.Home2;
import Wrappers.JsonFileParser;
import Wrappers.LoggingHandling;
import Wrappers.PropertiesFileHandler;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;


public class Test_8_JsonAndPropertiesFileTest {
    JsonFileParser parser;
    JSONObject jsonObject;
    @BeforeClass
    public void setup(){
       parser = new JsonFileParser("Config.json");

    }

    @Test
    public void assertNameInJson(){
        jsonObject= parser.parseJson("Config.json");
        Assert.assertEquals(
                jsonObject.get("Name"),"Ahmed");
    }


    @Test
    public void assertNameInJson1(){
        Assert.assertEquals(
                parser.getValueOfNode("Name"),"Ahmed");
    }

    @Test
    public void assertNamesInJson(){
        List<String> x = parser.getValuesOfNode("Names");
        Assert.assertEquals(x.size(),2);
        Assert.assertEquals(x
                .get(0),"A");
        Assert.assertEquals(
                x.get(1),"B");
    }

    @Test
    public void getChildValue(){
        jsonObject= parser.parseJson("Config.json");
        String parent = "MailContact";
        JSONObject parentNode = jsonObject.getJSONObject(parent);
        Assert.assertEquals(
                parentNode.get("Name"),"Ahmed");
    }

    @Test
    public void getChildValue1(){
        Assert.assertEquals(
                parser.getJsonObjectOfNode("MailContact").get("Name"),"Ahmed");
    }

    @Test
    public void getChildValue2(){
        Assert.assertEquals(
                parser.getValueOfChildByFullPath("MailContact/Name"),"Ahmed");
    }
    @Test
    public void getChildValue3(){
        Assert.assertEquals(
                parser.getValueOfChildByFullPath("MailContact/Names/Name"),"Ahmed");
    }


    //@Test
    public void getChildValue4(){
        jsonObject= parser.parseJson("Config.json");
        String parent = "MailContact";
        String node ="Age";
        String actualAge;
        JSONObject parentNode = jsonObject.getJSONObject(parent);
        Iterator<String> keys = parentNode.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            if (key == "node") {
                actualAge = parentNode.getString(key);
            } else {
                Iterator<String> childKeys = parentNode.getJSONObject(key).keys();
                //While ....
            }

        }

    }

    @Test
    void getValuesUsingParentAndOneChild(){
                Assert.assertEquals(new JsonFileParser(JsonFileParser.jsonFile)
                        .getValuesOf("MailContact","Email").get(0),"armostafa");

    }

    @Test
    void getValuesUsingFullPath(){
        Assert.assertEquals(new JsonFileParser(JsonFileParser.jsonFile)
                .getValuesOfChildByFullPath("MailContact/Password/Pass1").get(0),"Ahmed");
    }



    @Test
    public void assertName(){
        Assert.assertEquals(
                PropertiesFileHandler.getProperty("sendTo"),"Ahmed");
    }










}
