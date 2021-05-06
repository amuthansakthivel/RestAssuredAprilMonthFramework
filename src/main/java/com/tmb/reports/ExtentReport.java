package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	
	private ExtentReport() {}
	
	private static ExtentReports extent;
	private static ExtentTest test; //Threadsafe --> 3 mins
	
	public static void initReports() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Rest Assured Framework");
		extent.attachReporter(spark);
	}
	
	public static void tearDownReports() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
	
	public static void createTest(String testcasename) {
		test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}

}
