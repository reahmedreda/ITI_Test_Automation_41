import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_7_RetryAnalyzer {
    int x =0 ;

    @Test(retryAnalyzer =  Wrappers.RetryAnalyzer.class)
    void retryFailed(){
        x++;
        Assert.assertEquals(x,4);
        // Assert.assertFalse(true);
    }
}
