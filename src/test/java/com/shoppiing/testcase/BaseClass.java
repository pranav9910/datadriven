package com.shoppiing.testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.shoppiing.utilities.ReadConfiguration;



public class BaseClass 
{
	public static WebDriver driver;
	public ReadConfiguration r=new ReadConfiguration();
	String browser=r.getBrowser();
	String url=r.getUrl();
	
	@BeforeTest
	public void setUp()
	{
		switch(browser)
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default :
			driver=null;
		}
	}
	public void screenshot() throws IOException
	{
		TakesScreenshot tc=(TakesScreenshot)driver;
		File f1=tc.getScreenshotAs(OutputType.FILE);
		File f2=new File("C:\\Users\\Hp\\eclipse-workspace\\shoppiing\\ScreenShot\\p.png");
		FileUtils.copyFile(f1, f2);
		
		
	}
}
