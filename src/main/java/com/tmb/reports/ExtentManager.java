package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();
	
	static ExtentTest getExtentTest() {
		return exTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}
}
