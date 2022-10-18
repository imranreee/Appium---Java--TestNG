package settings;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by: Al Imran on 21/09/2018.
 * Email: imranreee@gmail.com
 **/

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 3;
    int retryLimit = 1;

    @Override
    public boolean retry(ITestResult result) {
        if(counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}