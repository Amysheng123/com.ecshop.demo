package com.ecshop.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class demolog {
	public Logger logger1 = LogManager.getLogger(this.getClass());
	public Logger logger3 = LogManager.getLogger(demolog.class);
	
	public static void main(String[] args) {
		demolog demolog = new demolog();
		demolog.hello();

	}
	
	public void hello() {
		logger1.error("logger1");
		logger3.error("logger3");
	}

}
