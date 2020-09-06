package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass{
	

	@Test(dataProvider="loginData")
	public void loginDDT(String usr,String pwd) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp=new LoginPage(driver);
		driver.get(baseurl);
		lp.userName(usr);
		lp.passWord(pwd);
		lp.clickLogin();
		Thread.sleep(3000);
		
		if (isAlertOn() ==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.error("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			lp.logOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			logger.info("Test Passed");
		}
		
	
	}
	public boolean isAlertOn()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
			
		}
		
	}
	
	@DataProvider(name="loginData")
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String testData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				testData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return testData;
	}
}
