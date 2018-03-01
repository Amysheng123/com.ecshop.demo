package com.ecshop.test;

import org.testng.annotations.Test;

import com.ecshop.pages.IndexPage;
import com.ecshop.pages.LoginPage;
import com.ecshop.testutils.TestBase;
import com.ecshop.testutils.TestDataFactory;

public class LoginTest extends TestBase {
	
	@Test(dataProviderClass=TestDataFactory.class,dataProvider="calc_CSV_data")
	public  void loginTest1(String username, String password, String result) {
		driver.get("http://localhost/ecshop/");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.goLogin();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(username, password);
		loginPage.assertLoginResult(result);
	}
	
	
	
}
