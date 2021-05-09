package com.tmb.listeners;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{
	
	//methods -->It is having all the test cases to be executed\
	//PostReqquestusingmap , getEmployeeDetails

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		
		 List<IMethodInstance> newmethods = new ArrayList<>();
		 // newmethods.add(methods.get(1));
		 List<Map<String, String>> runmanagercontent = null ;
		
		try {
			runmanagercontent = ExcelUtils.getExcelContent("runmanager");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j< runmanagercontent.size(); j++) {
				if(isTestNameMatching(methods, runmanagercontent, i, j)) {
					if(isTestRunnable(runmanagercontent, j)) {
						setDescription(methods, runmanagercontent, i, j);
						newmethods.add(methods.get(i));
					}
				}
			}
		}
		
		
		return newmethods;
	}

	private void setDescription(List<IMethodInstance> methods, List<Map<String, String>> runmanagercontent, int i, int j) {
		methods.get(i).getMethod().setDescription(runmanagercontent.get(j).get("description"));
	}

	private boolean isTestRunnable(List<Map<String, String>> runmanagercontent, int j) {
		return runmanagercontent.get(j).get("execute").equalsIgnoreCase("yes");
	}

	private boolean isTestNameMatching(List<IMethodInstance> methods, List<Map<String, String>> runmanagercontent, int i,
			int j) {
		return methods.get(i).getMethod().getMethodName().equalsIgnoreCase(runmanagercontent.get(j).get("testname"));
	}

}
