package com.ecshop.tengListner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngRetry implements IRetryAnalyzer{
	private static Logger logger = LogManager.getLogger(TestngRetry.class);
	private static int maxRetryCount = 2;
	private int retryCount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
            String message = "Running retry for '" + result.getName()
                    + "' on class " + this.getClass().getName() + " Retrying "
                    + retryCount + " times";
            logger.info(message);
            Reporter.setCurrentTestResult(result);
            Reporter.log("RunCount=" + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
	}
	

}
