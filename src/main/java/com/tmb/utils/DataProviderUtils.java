package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public final class DataProviderUtils {
	
	private DataProviderUtils() {}
	
	//For all test case I am using single data provider
	
	@DataProvider
	public static Object[] getData(Method method) throws IOException {
		
		List<Map<String, String>> alldatalist = ExcelUtils.getExcelContent("iterationdata");
		List<Map<String,String>> testcaselist = new ArrayList<>();
		
		for(int i=0; i< alldatalist.size();i++) {
			if(ExcelUtils.isConditionsMatching(method, alldatalist, i)) {
				testcaselist.add(alldatalist.get(i));
			}
		}
		return testcaselist.toArray();
		
	}
	
	
	


}
