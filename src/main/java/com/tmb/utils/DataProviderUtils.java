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
		
		List<Map<String, String>> alldatalist = getExcelContent();
		List<Map<String,String>> testcaselist = new ArrayList<>();
		
		for(int i=0; i< alldatalist.size();i++) {
			if(isConditionsMatching(method, alldatalist, i)) {
				testcaselist.add(alldatalist.get(i));
			}
		}
		return testcaselist.toArray();
		
	}
	
	
	
	

	private static boolean isConditionsMatching(Method method, List<Map<String, String>> alldatalist, int i) {
		return isTestCaseNameMatching(method, alldatalist, i) && isRunnable(alldatalist, i);
	}

	private static boolean isRunnable(List<Map<String, String>> alldatalist, int i) {
		return alldatalist.get(i).get("execute").equalsIgnoreCase("yes");
	}

	private static boolean isTestCaseNameMatching(Method m, List<Map<String, String>> alldatalist, int i) {
		return alldatalist.get(i).get("testname").equalsIgnoreCase(m.getName());
	}

	private static List<Map<String, String>> getExcelContent() throws FileNotFoundException, IOException {
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+
				"/src/test/resources/excel/testdata.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fip);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		int lastRowNum = sheet.getLastRowNum();
		short lastColNum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastRowNum);
		
		List<Map<String,String>> list =  new ArrayList<>();
		
		//Object[] data = new Object[lastRowNum];
		
		Map<String,String> map = null;
		
		for (int i = 1; i < lastRowNum+1; i++) {
			
			map = new HashMap<>();
			
			for (int j = 0; j < lastColNum; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue(); 
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			list.add(map);
			
		}
		return list;
	}

}
