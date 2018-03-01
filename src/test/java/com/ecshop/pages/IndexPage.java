package com.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	/**
	 *免费注册链接
	 */
	@FindBy(linkText="免费注册")
	private WebElement register_link;
	/**
	 * 登录链接
	 */
	@FindBy(xpath="//a[@href='user.php']")
	private WebElement login_link;
	
	public void goRegist() {
		register_link.click();		
	}
	
	public void goLogin() {
		login_link.click();

	}
	
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
		
	}
	
	
	
	
}
