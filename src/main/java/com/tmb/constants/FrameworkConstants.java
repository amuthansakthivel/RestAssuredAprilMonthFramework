package com.tmb.constants;

import lombok.Getter;


public final class FrameworkConstants {
	
	//Lombak on class level is for non static fields
	//covered three different ways of storing constants --> using static fields and exposing getters
	//using Lombak plugin
	
	private FrameworkConstants() {}
	
	private @Getter static final String baseURI = "http://localhost:3000";
	private @Getter static final String employeesEndpoint = "/employees";
	private @Getter static final String requestBodyFolderpath= 
			System.getProperty("user.dir")+"/src/test/resources/requestbody/";

	public  static final int STATUSCODE_200 = 200;
	public  static final int STATUSCODE_201 = 201;
	
	
	

}
