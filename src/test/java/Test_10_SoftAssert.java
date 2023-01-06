import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_10_SoftAssert {

    SoftAssert softAssert = new SoftAssert();
//    @BeforeMethod
//    void after(){
//        softAssert = new SoftAssert();
//    }

    @Test
    public void test1 (){
        softAssert.assertEquals(1,2,"Test1");
        softAssert.assertAll();

    }

    @Test
    public void test2 (){
        softAssert.assertEquals(3,3,"Test2");
       softAssert.assertAll();
    }
}
