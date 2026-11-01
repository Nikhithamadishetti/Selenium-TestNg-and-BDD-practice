package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.readconfig;

public class BaseClass {

	readconfig readconfig=new readconfig();
			
	public String baseUrl=readconfig.getApplicationUrl();
	public String username=readconfig.getusername();
	public String password=readconfig.password();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{  
	    logger= Logger.getLogger("ebanking");
	    PropertyConfigurator.configure("Log4j.properties");
	    
	    if(br.equalsIgnoreCase("chrome"))
	    {
	    	System.setProperty("Webdriver.chrome.driver",readconfig.getchromepath());
			driver = new ChromeDriver();
	    }
//		else if(br.equalsIgnoreCase("firefox"))
//		{
//			System.setProperty("Webdriver.firefox.driver",readconfig.getfirefoxpath());
//			driver = new geckoDriver();
//	    }
//		else if(br.equalsIgnoreCase("edge"))
//		{
//			System.setProperty("Webdriver.edge.driver",readconfig.getedgepath());
//			driver = new edgeDriver();
	//    }
         //driver.manage().timeouts().implicitlyWait(10);
	     driver.get(baseUrl);
} 

	@AfterClass
	public void tearDown()
	{
	driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts= ((TakesScreenshot) driver);
	    File Source = ts.getScreenshotAs(OutputType.FILE);
	    File Target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	    FileUtils.copyFile(Source,Target);
		System.out.println("Screenshot taken");
	}
}
