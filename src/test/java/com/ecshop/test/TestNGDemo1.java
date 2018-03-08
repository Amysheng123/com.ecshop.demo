package com.ecshop.test;

import org.testng.annotations.Test;

import com.ecshop.pages.IndexPage;
import com.ecshop.pages.LoginPage;
import com.ecshop.testutils.TestBase;

public class TestNGDemo1 extends TestBase {
	@Test(description="简单的测试2")
	public  void loginTest2() {
		driver.get("http://localhost/ecshop/");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.goLogin();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("liudao001", "123456");
		loginPage.assertLoginResult("登录成功");
	}
	@Test(description="简单的测试3")
	public  void loginTest3() {
		driver.get("http://localhost/ecshop/");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.goLogin();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("liudao001", "234567");
		loginPage.assertLoginResult("登录失败");
	}
	
	@Test(dependsOnMethods="loginTest3")
	public  void loginTest4() {
		driver.get("http://localhost/ecshop/");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.goLogin();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("liudao001", "234567");
		loginPage.assertLoginResult("登录失败");
	}
	@Test
	public void runTest2() {
	        System.out.println("Start to throw the Exception");
	        assert false:"fail the test";
	}

}
