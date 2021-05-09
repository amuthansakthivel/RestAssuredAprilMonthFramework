package com.tmb.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}
	
	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.tearDownReports();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentLogger.pass(result.getMethod().getDescription()+ " is started successfully");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ExtentLogger.pass(result.getName()+ " is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getThrowable().getMessage());
		ExtentLogger.logStackTraceInfoInExtentReport(Arrays.toString(result.getThrowable().getStackTrace()));
		ExtentLogger.fail(result.getName()+ " is failed miserably");
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getName()+ " is skipped");
	}


}
