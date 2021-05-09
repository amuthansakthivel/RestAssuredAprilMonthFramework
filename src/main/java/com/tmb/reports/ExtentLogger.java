package com.tmb.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

	private ExtentLogger() {}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}
	
	public static void logStackTraceInfoInExtentReport(String message) {
		String formattedText = "<pre>"+ message.replace(",", "<br>") + "</pre>";
		ExtentManager.getExtentTest().fail(formattedText);
	}
	
	public static void logRequestAndResponseInReport(String request, String response) {
		logPrettyRequestToReport(request);
		logPrettyResponseToReport(response);
	}

	private static void logPrettyResponseToReport(String response) {
		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
	}

	private static void logPrettyRequestToReport(String request) {
		ExtentManager.getExtentTest().info("<pre>"+ request.replace("\n", "<br>") + "</pre>");
	}


}
