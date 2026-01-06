package com.shoppiing.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.shoppiing.testcase.BaseClass;

public class ExtentReportWithListeners extends BaseClass implements ITestListener
{
	ExtentSparkReporter createReport;
	ExtentReports addtest;
	ExtentTest addlog;
	
	public void reports()
	{
		createReport=new ExtentSparkReporter("myextentReport123.html");
		addtest=new ExtentReports();
		addtest.attachReporter(createReport);
		
		addtest.setSystemInfo("Operating System", "Windows");
		addtest.setSystemInfo("Browser", "Chrome");
		addtest.setSystemInfo("BrowserVersion", "191.12.21.23");
		addtest.setSystemInfo("MACAddress", "00-B0-C0-63-C2-26");
		addtest.setSystemInfo("Environment", "Testing");
		addtest.setSystemInfo("UserName", "pranav");
		
		createReport.config().setReportName("Shopping Project");
		createReport.config().setDocumentTitle("My New Report");
		createReport.config().setTheme(Theme.DARK);
	}
	 public void onStart(ITestContext Result) 
	 { 
		 reports();
	 } 
	 public void onTestSuccess(ITestResult Result) 
	 { 
		 addlog=addtest.createTest(Result.getName());
			addlog.log(Status.PASS,MarkupHelper.createLabel("My Test Case is Passed",ExtentColor.GREEN));
	 } 
	 public void onTestFailure(ITestResult Result) 
	 { 
		 try {
			 screenshot();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 String path="C:\\Users\\Hp\\eclipse-workspace\\shoppiing\\ScreenShot\\p.png";
		 addlog=addtest.createTest(Result.getName());
		 addlog.log(Status.FAIL,MarkupHelper.createLabel("My Test Case is Failed",ExtentColor.RED));
		 addlog.fail("FailedTestCaseScreenShot:"+addlog.addScreenCaptureFromPath(path));
	 } 
	 public void onTestSkipped(ITestResult Result) 
	 { 
		 addlog=addtest.createTest(Result.getName());
			addlog.log(Status.SKIP,MarkupHelper.createLabel("My Test Case is Skipped",ExtentColor.YELLOW));
	 }
	 public void onFinish(ITestContext Result) 
	 { 
		 addtest.flush();
	 } 
}
