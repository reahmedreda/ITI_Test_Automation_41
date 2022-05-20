import org.junit.Test;

public class Test_00_BadExampleOfTestClassesDependencies {
    Test_0_UseSeleniumDirectlyInTestClass test0UseSeleniumDirectlyInTestClass = new Test_0_UseSeleniumDirectlyInTestClass();


    @Test
    public void document(){

        test0UseSeleniumDirectlyInTestClass.
                setup();
        test0UseSeleniumDirectlyInTestClass.testExchangeAWaiver();
    }

}
