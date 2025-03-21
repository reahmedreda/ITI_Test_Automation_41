import POM.Home4_ActionsWithThreadLocal;
import org.testng.annotations.Test;

public class Test_9_1_TestBaseChild2 extends Test_9_0_UseTestBase_ThreadLocal {

    //This test should be run from test2.xml
    @Test
    public void test2(){
        Home4_ActionsWithThreadLocal home = new Home4_ActionsWithThreadLocal();
        home.navigateToHome();
    }
}
