package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	@CacheLookup
	WebElement txtUserName;
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement txtPassWord;
	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	WebElement clickLogin;
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOutBtn;
	
	
	public void userName(String usr) {
		 txtUserName.sendKeys(usr);
	}
	public void passWord(String pwd) {
		txtPassWord.sendKeys(pwd);;
	}
	public void clickLogin() {
		 clickLogin.click();
	}
//	public WebElement userName() {
//		// TODO Auto-generated method stub
//		return txtUserName;
//	}
//	public WebElement passWord() {
//		// TODO Auto-generated method stub
//		return txtPassWord;
//	}
	public void logOut() {
		logOutBtn.click();
	}
	
}
