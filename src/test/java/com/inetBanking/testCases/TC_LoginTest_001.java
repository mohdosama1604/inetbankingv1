package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

@Test
public void loginTest() throws IOException
{
	driver.get(baseurl);
	logger.info("Entered URL");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	LoginPage lg= new LoginPage(driver);
	lg.userName(username);
	logger.info("Entered username");
	lg.passWord(userpassword);
	logger.info("Entered password");
	lg.clickLogin();
	logger.debug("Clicked on login button");
	
	if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		
	{
		Assert.assertTrue(true);
		logger.info("Test Passed");
	}
	else
	{
		captureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		logger.info("test failed and screenshot taken");
	}
}
	
	
}
