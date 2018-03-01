package com.ecshop.testutils;

import org.testng.annotations.AfterSuite;

import com.ecshop.WebDriverUtils.WebDriverUtils;

public class AfterEcshopTest {
	@AfterSuite
	public void stopService() {
		System.out.println("-----------AfterEcShop--------");
		WebDriverUtils.stopService();
	}
}
