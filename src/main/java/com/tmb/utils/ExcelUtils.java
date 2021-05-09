package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {
	
	private ExcelUtils() {}
	
	public static List<Map<String, String>> getExcelContent(String sheetname) throws FileNotFoundException, IOException {
		XSSFSheet sheet = getExcelSheet(sheetname);
		int lastRowNum = getLastRowNum(sheet);
		short lastColNum = getLastColNum(sheet);
		
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
			//data[i-1] = map;
		}
		return list;
	}

	private static XSSFSheet getExcelSheet(String sheetname) throws FileNotFoundException, IOException {
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+
				"/src/test/resources/excel/testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fip);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		return sheet;
	}
	
	

	static boolean isConditionsMatching(Method method, List<Map<String, String>> alldatalist, int i) {
		return isTestCaseNameMatching(method, alldatalist, i) && isRunnable(alldatalist, i);
	}

	private static boolean isRunnable(List<Map<String, String>> alldatalist, int i) {
		return alldatalist.get(i).get("execute").equalsIgnoreCase("yes");
	}

	private static boolean isTestCaseNameMatching(Method m, List<Map<String, String>> alldatalist, int i) {
		return alldatalist.get(i).get("testname").equalsIgnoreCase(m.getName());
	}
	
	private static short getLastColNum(XSSFSheet sheet) {
		return sheet.getRow(0).getLastCellNum();
	}
	
	private static int getLastRowNum(XSSFSheet sheet) {
		return sheet.getLastRowNum();
	}


}
