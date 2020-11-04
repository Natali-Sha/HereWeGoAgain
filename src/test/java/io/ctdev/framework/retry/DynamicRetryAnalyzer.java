package io.ctdev.framework.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class DynamicRetryAnalyzer implements IRetryAnalyzer {

    int count = 1;
    int maxRetryCount=2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maxRetryCount){
            count++;
            return true;
        }
        return false;
    }
}