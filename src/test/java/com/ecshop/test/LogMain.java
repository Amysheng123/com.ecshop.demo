package com.ecshop.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogMain {
	private static Logger logger = LogManager.getLogger(LogMain.class.getName());
	
	@Test
	public void LogMaintest() {
		logger.trace("开始程序");
		Hello logTest = new Hello();
		
		for (int i = 0; i < 1000; i++) {
			if(!logTest.HelloTest())
				logger.error("hello error");			
		}

	}

}
