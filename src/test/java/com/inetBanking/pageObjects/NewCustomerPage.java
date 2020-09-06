package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver ldriver;
	
	public NewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how= How.XPATH,using = "//a[text()='New Customer']" )
	WebElement lnkAddNewCustomer;
	
	@FindBy(how= How.XPATH,using = "//input[@name='name']" )
	WebElement NewCustomerName;
	
	@FindBy(how= How.XPATH,using = "//input[@value='m']" )
	WebElement CustomerGender;
	
	@FindBy(how= How.XPATH,using = "//input[@name='dob']" )
	WebElement CustomerDOB;
	
	@FindBy(how= How.XPATH,using = "//*[@name='addr']" )
	WebElement CustomerAddress;
	
	@FindBy(how= How.XPATH,using = "//*[@name='city']" )
	WebElement CustomerCity;
	
	@FindBy(how= How.XPATH,using = "//*[@name='state']" )
	WebElement CustomerState;
	
	@FindBy(how= How.XPATH,using = "//*[@name='pinno']" )
	WebElement CustomerPinno;
	
	@FindBy(how= How.XPATH,using = "//*[@name='telephoneno']" )
	WebElement CustomerTelno;
	
	@FindBy(how= How.XPATH,using = "//*[@name='emailid']" )
	WebElement CustomerEmail;
	
	@FindBy(how= How.XPATH,using = "//*[@name='password']" )
	WebElement CustomerPwd;
	
	@FindBy(how= How.XPATH,using = "//*[@name='sub']" )
	WebElement SubmitBtn;
	
	
	public void linkAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	public void addNewCustomer(String customername)
	{
		NewCustomerName.click();
		NewCustomerName.sendKeys(customername);
	}
	
	public void selectCustomerGender()
	{
		CustomerGender.click();
	}
	
	public void selectCustomerDOB(String mm,String dd, String yyyy)
	{
		CustomerDOB.click();
		CustomerDOB.sendKeys(mm);
		CustomerDOB.sendKeys(dd);
		CustomerDOB.sendKeys(yyyy);
	}
	
	public void addCustomerAddress(String adrs)
	{
		CustomerAddress.click();
		CustomerAddress.sendKeys(adrs);
		
	}
	public void addCustomerCity(String city)
	{
		CustomerCity.click();
		CustomerCity.sendKeys(city);
		
	}
	public void addCustomerState(String state)
	{
		CustomerState.click();
		CustomerState.sendKeys(state);
		
	}
	public void addCustomerpinno(String adrs)
	{
		CustomerPinno.click();
		CustomerPinno.sendKeys(String.valueOf(adrs));
		
	}
	public void addCustomerTelNo(String telno)
	{
		CustomerTelno.click();
		CustomerTelno.sendKeys(String.valueOf(telno));
		
	}
	public void addCustomerEmail(String email)
	{
		CustomerEmail.click();
		CustomerEmail.sendKeys(email);
		
	}
	public void addCustomerPwd(String pwd)
	{
		CustomerPwd.click();
		CustomerPwd.sendKeys(pwd);
		
	}
	public void submitBtn()
	{
		SubmitBtn.click();
		
		
	}
	
}
