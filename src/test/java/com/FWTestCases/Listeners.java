package com.FWTestCases;
import java.awt.Desktop;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listeners extends Base implements ITestListener{

	ExtentReports extentRepo;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext result) {
		extentRepo=generateExtentReport();
	}	
		
	@Override
	public void onTestStart(ITestResult result) {
		testName=result.getName();
		extentTest=extentRepo.createTest(testName);
		extentTest.log(Status.INFO,testName+" started executing");	
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS,testName+" got successfully  executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
			extentTest.log(Status.FAIL, testName+" got failed");
			extentTest.log(Status.INFO, result.getThrowable());	
			String path=getScreenshot(testName);
			extentTest.addScreenCaptureFromPath(path);
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+" got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentRepo.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\extentReports\\extentReport.html";
		File extentReportOne = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReportOne.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		
	}

}
