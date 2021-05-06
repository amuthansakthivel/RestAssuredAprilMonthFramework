package com.tmb.constants;

import java.util.HashMap;
import java.util.Map;

import com.tmb.enums.Constants;

public final class FrameworkConstantsWithEagerLoading {

	private FrameworkConstantsWithEagerLoading() {}

	private static final Map<Constants,String> CONSTANTS = new HashMap<>();

	//executed the class file is loaded in the memory

	static {
		CONSTANTS.put(Constants.BASEURI, "http://localhost:3000");
		CONSTANTS.put(Constants.GETEMPLOYEEENDPOINT, "/employees"); 
	}

	public static String getValue(Constants key) {
		return CONSTANTS.get(key);
	}



}
