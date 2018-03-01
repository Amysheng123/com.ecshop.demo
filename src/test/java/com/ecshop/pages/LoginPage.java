package com.ecshop.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 登录页面封装
 * by amy sheng
 */
public class LoginPage {
	/**
	 * 登录用户名输入框
	 */
	@FindBy(name="username")
	private WebElement username_input;
	/**
	 * 登录密码输入框
	 */
	@FindBy(name="password")
	private WebElement password_input;
	/**
	 * 登录提交按钮
 	 */
	@FindBy(name="submit")
	private WebElement submit_btn;
	/**
	 * 登录提交后跳转的结果显示的文本区域
	 */
	@FindBy(xpath="//div[@class='box_1']/div/div/p")
	private WebElement login_result_text;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 *执行登陆操作，自动填入用户名和密码，并点击登陆提交按钮
	 * @param name
	 * @param password
	 */
	public void doLogin(String name, String password) {
		username_input.sendKeys(name);
		password_input.sendKeys(password);
		submit_btn.click();
	}

	/**
	 * 对登录提交之后的文本进行验证，如果一致则通过，不一致则报测试不通过
	 * @param expected 期望文本内容
	 */
	public void assertLoginResult(String expected) {
		assertEquals(login_result_text.getText(), expected);
	}

}
