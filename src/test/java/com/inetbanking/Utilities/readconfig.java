package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {

	Properties pro; 
	
	public readconfig()
	{
	File src= new File("./Configuration/config.properties");
	
	try 
	{
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	}
	catch(Exception e) 
	{
		System.out.println("exception is"+e.getMessage());
	     
    }
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getusername()
	{
	  String username=pro.getProperty("username");
	  return username;
	  
	}

	public String password()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromedriver");
		return chromepath;
		
	}
}
