package com.erail.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentManager {
	static ExtentSparkReporter htmlReporter;
	static ExtentReports reports;
	ExtentTest test;

	public static void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "erailTestReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter("erailExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine:", "Laptop");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("User Name:", "Imran");
		reports.setSystemInfo("Browser", "Chrome");

		htmlReporter.config().setReportName("This is erail_TC Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public String screenShot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = ".\\ScreenShots\\" + filename + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
		
	}

	public static void endReport() {
		reports.flush();
	}
}
