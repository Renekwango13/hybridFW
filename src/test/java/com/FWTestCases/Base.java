package com.FWTestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.FWUtilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {

	 public ReadConfig config;
	 public static WebDriver driver;
	 public static Logger log;
	 ExtentReports ExtRepo;
	
	
	@BeforeMethod
	public void setup() {
		config=new  ReadConfig();
		String browser=config.getBrowser();
	
		if(browser.equalsIgnoreCase("chrome")){
			
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
	
			driver=new EdgeDriver();
		}
		log=LogManager.getLogger(Base.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(config.getApplicationUrl());
		 generateExtentReport();
	}
	public static String getScreenshot(String testName) {
		
		String dateName = new SimpleDateFormat("MMddyyyy").format(new Date());
		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+testName+dateName+".png";
		File finalDestination = new File(destination);
	
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  destination;
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	public  ExtentReports generateExtentReport() {
		
		config=new  ReadConfig();
		ExtentReports ExtRepo= new ExtentReports();
		File extentReportFile= new File(System.getProperty("user.dir")+"\\test-output\\extentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("practice Frame work");
		sparkReporter.config().setDocumentTitle("FW report");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		ExtRepo.attachReporter(sparkReporter);
		ExtRepo.setSystemInfo("application URL",config.getApplicationUrl() );
		ExtRepo.setSystemInfo("browser Name", config.getBrowser());
		ExtRepo.setSystemInfo("Email", config.getValidUsernam());
		ExtRepo.setSystemInfo("Password",config.getValidPassworld());
		ExtRepo.setSystemInfo("Operating System", System.getProperty("os.name"));
		ExtRepo.setSystemInfo("User Name","Rene");
		ExtRepo.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return ExtRepo;	
	}

}
	

