package com.tmb.constants;

import lombok.Getter;

@Getter
public final class FrameworkConstantsWithSingleton {
	
	//single instance of a class
	//Eager initialisation
	//simple way using singleton
	// multiple threads
	//reflection to create an instance
	//Awaitility
	
	private FrameworkConstantsWithSingleton() {} //creating object from other files //Eager
	
	private static FrameworkConstantsWithSingleton INSTANCE = null;
	
	public static synchronized FrameworkConstantsWithSingleton getInstance() {
		if(INSTANCE==null) {
			return new FrameworkConstantsWithSingleton();
		}
		return INSTANCE;
	}
	
	private String baseuri = "http://localhost:3000";
	private String getemployeeendpoint = "/employees";
	
	
	
}
