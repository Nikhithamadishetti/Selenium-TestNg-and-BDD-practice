package com.inetbanking.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTests_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("url is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clicksubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			AssertJUnit.assertTrue(true);
		}
		else
		{
			captureScreenshot(driver,"loginTest");
			AssertJUnit.assertTrue(false);
			logger.info("login failed");
		}
	}
}
