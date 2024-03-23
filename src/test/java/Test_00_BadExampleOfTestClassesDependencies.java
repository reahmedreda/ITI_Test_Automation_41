import org.junit.Test;

/*
This Class represents a bad example of depending on some functions have been written
in another test class, so it's a bad example of using another test class functions
by creating object from the other test class and use its public functions instead
of rewrite them. This issue can be solved by using design pattern like POM
 */

public class Test_00_BadExampleOfTestClassesDependencies {
    Test_0_UseSeleniumDirectlyInTestClass test0UseSeleniumDirectlyInTestClass = new Test_0_UseSeleniumDirectlyInTestClass();


    @Test
    public void document(){

        test0UseSeleniumDirectlyInTestClass.
                setup();
        test0UseSeleniumDirectlyInTestClass.testExchangeAWaiver();
        test0UseSeleniumDirectlyInTestClass.teardown();
    }

}
