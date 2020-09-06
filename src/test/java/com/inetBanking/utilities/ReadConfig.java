package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import java.util.Properties;

public class ReadConfig {
	
	
	Properties Prop;
	public ReadConfig() 
	{
		File src =new File("./configuration/config.properties");
		
		try
		{
			FileInputStream fis= new FileInputStream(src);
			Prop= new Properties();
			Prop.load(fis);
		
		}
		catch(Exception e)
		{
			System.out.println("Exception Caught"+ e.getMessage());
		}
		
	}
	
	public String GetBaseURL()
	{
		String url=Prop.getProperty("baseurl");
		return url;
	}
	public String GetUserName()
	{
		String username=Prop.getProperty("username");
		return username;
	}
	public String GetUserPassWord()
	{
		String password=Prop.getProperty("userpassword");
		return password;
	}
	public String GetCustomerName()
	{
		String customername=Prop.getProperty("customername");
		return customername;
	}
	public String GetChromePath()
	{
		String chrome=Prop.getProperty("chromepath");
		return chrome;
	}
	public String GetFireFoxPath()
	{
		String firefoxpath=Prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String GetmsePath()
	{
		String msepath=Prop.getProperty("msepath");
		return msepath;
	}
}
