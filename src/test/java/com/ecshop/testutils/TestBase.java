package com.ecshop.testutils;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecshop.WebDriverUtils.WebDriverUtils;

public class TestBase {
	public WebDriver driver;
	@BeforeMethod
	public void openBrowser() {
		driver = WebDriverUtils.getDriver(ConfigReader.getConfig(ConfigReader.BROWSER), this.getClass());
		String wt = ConfigReader.getConfig(ConfigReader.WAITTIME);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(wt), TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
