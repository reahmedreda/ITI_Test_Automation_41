import org.testng.Assert;
import org.testng.annotations.Test;

public class retryAnalyzerTest {
    int x =0 ;

    @Test(retryAnalyzer =  Wrappers.RetryAnalyzer.class)
    void retryFailed(){
        x++;
        Assert.assertEquals(x,3);
        // Assert.assertFalse(true);
    }
}
