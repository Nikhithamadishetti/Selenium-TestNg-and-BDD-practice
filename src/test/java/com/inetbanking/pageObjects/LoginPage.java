package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver Ldriver;
    
	public LoginPage(WebDriver Rdriver)
	{
		Ldriver=Rdriver;
		PageFactory.initElements(Rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement textusername;
	
	@FindBy(name="password")
	WebElement textpassword;
	
	@FindBy(name="btnLogin")
	WebElement Submitbutton;
	
	@FindBy(linkText ="Log out")
	WebElement logout;
	
	public void setusername(String uid) 
	{
		textusername.sendKeys(uid);
	}
	
	public void setpassword(String pwd)
	{
		textpassword.sendKeys(pwd);
	}
	
	public void clicksubmit() {
		Submitbutton.click();
	}

	public void Logout() {
		logout.click();
	}
}
