import POM.Home3_ActionsWithArrayListOrMap;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Test_9_1_TestBaseChild1 extends Test_9_0_UseTestBase_MultipleDrivers_Map {

    //This test should be run from test2.xml
    @Test
    public void test1(ITestContext context){

        Home3_ActionsWithArrayListOrMap home = new Home3_ActionsWithArrayListOrMap(uniqueKey);
        home.navigateToHome();
    }
}
