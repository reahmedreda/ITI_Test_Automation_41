import POM.Home4;
import org.testng.annotations.Test;

public class Test_9_1_TestBaseChild2 extends Test_9_0_UseTestBase_MultipleDrivers_Map {

    //This test should be run from test2.xml
    @Test
    public void test1(){
        Home4 home = new Home4(uniqueKey);
        home.navigateToHome();
    }
}
