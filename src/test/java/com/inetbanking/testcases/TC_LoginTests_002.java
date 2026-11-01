package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtils;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTests_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	   public void LoginDDT(String user,String pwd) throws InterruptedException 
	   {
		   LoginPage lp=new LoginPage(driver);
		   lp.setusername(user);
		   lp.setpassword(pwd);
		   lp.clicksubmit();
		   Thread.sleep(3000);
		 
		   if(isAlertPresent()==true)
		   {

		    logger.info("login failed");
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		   }
			else {
				//Assert.assertTrue(true);
				lp.Logout();
				Thread.sleep(90000);
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				logger.info("login passed");
			}
		  
	   }
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	
	 @DataProvider(name="LoginData")
	   String[][] getData() throws IOException
	   {
		   String path=System.getProperty("user.dir")+ "/src/test/java/com/inet/testData/LoginData.xlsx";
		   System.out.println(path);
		   int rownum=XLUtils.getRowCount(path,"Sheet1");
		   int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		   String LoginData[][]= new String[rownum][colcount];
		   for(int i=1;i<=rownum;i++)
		   {
			   for(int j=0;j<colcount;j++)
			   {
				 LoginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			   }
		   }
		   return LoginData;
	   }
}
