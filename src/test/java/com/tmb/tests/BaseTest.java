package com.tmb.tests;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeMethod;

import com.tmb.reports.ExtentLogger;

public class BaseTest {


	protected StringWriter writer;
	protected PrintStream captor;

	@BeforeMethod
	public void setUp() {
		writer = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writer), true);
	}
	
	


}
