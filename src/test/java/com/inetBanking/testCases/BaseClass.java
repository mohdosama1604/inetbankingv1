package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//ximport org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig rd=new ReadConfig();
	public String baseurl= rd.GetBaseURL();
	public String username=rd.GetUserName();
	public String userpassword=rd.GetUserPassWord();
	public String customername=rd.GetCustomerName();
	
	public static  WebDriver driver;
	public static Logger logger;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
		
		 logger =Logger.getLogger("BaseClass");
		 PropertyConfigurator.configure("log4j.properties");
		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rd.GetChromePath() );
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rd.GetFireFoxPath() );
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("mse"))
			{
				System.setProperty("webdriver.edge.driver",rd.GetmsePath() );
				driver=new EdgeDriver();
			}
	
	}
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString()
	{
		String randomStringpart=RandomStringUtils.randomAlphabetic(8);
		return randomStringpart;
	}
	
}
