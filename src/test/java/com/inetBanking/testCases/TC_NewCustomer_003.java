package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomerPage;

public class TC_NewCustomer_003 extends BaseClass{

	@Test
	public void NewCustomerEntry() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseurl);
		LoginPage lg=new LoginPage(driver);
		lg.userName(username);
		lg.passWord(userpassword);
		lg.clickLogin();
		Thread.sleep(3000);
		
		NewCustomerPage nc=new NewCustomerPage(driver);
		nc.linkAddNewCustomer();
		nc.addNewCustomer(customername);
		nc.selectCustomerGender();
		Thread.sleep(3000);
		nc.selectCustomerDOB("1993", "02", "02");
		nc.addCustomerAddress("388 E 49th Avenue, Victoria");
		nc.addCustomerCity("Victoria");
		nc.addCustomerState("British Columbia");
		nc.addCustomerpinno("888452");
		nc.addCustomerTelNo("65654565165");
		String cemail= randomString()+"@gmail.com";
		nc.addCustomerEmail(cemail);
		nc.addCustomerPwd("abcdefg");
		nc.submitBtn();
		Thread.sleep(10000);
		
	}
	
}
