package com.tmb.reports;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.tmb.enums.LogMethods;

public final class ExtentLoggerWithJava8 {
	
	private ExtentLoggerWithJava8() {}
	
	private static Map<LogMethods,Consumer<String>> MAP = new HashMap<>();
	 
	
	private static Consumer<String> PASS = (message)-> ExtentManager.getExtentTest().pass(message);
	private static Consumer<String> FAIL = (message)-> ExtentManager.getExtentTest().fail(message);
	private static Consumer<String> SKIP = (message)-> ExtentManager.getExtentTest().skip(message);
	private static Consumer<String> INFO = (message)-> ExtentManager.getExtentTest().info(message);
	
	static {
		MAP.put(LogMethods.PASS, PASS);
		MAP.put(LogMethods.FAIL, FAIL);
		MAP.put(LogMethods.SKIP, SKIP);
		MAP.put(LogMethods.INFO, INFO);
	}
	
	public static void writeToReport(LogMethods method,String message) {
		MAP.get(method).accept(message);
	}
	
	
	//If you know Java 8 use this way 
	/*
	 * ExtentLogger.writeToReport(LogMethods.PASS, "testcase is started");
	 */

}
