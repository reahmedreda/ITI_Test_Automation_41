import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Test_7_RetryAnalyzer extends TestListenerAdapter {
    int x =0 ;

    @Test(retryAnalyzer =  Wrappers.RetryAnalyzer.class)
    void retryFailed(){
        x++;
        Assert.assertEquals(x,4);
        // Assert.assertFalse(true);
    }

    @AfterSuite
    public void after(){
        setSkippedTests(null);
    }

//    @Override
//    public void onTestSkipped(ITestResult tr) {
//        this.m_allTestMethods.add(tr.getMethod());
//        this.m_skippedTests.add(tr);
//    }
}
