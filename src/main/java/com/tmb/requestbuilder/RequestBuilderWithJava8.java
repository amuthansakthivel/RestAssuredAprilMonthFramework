package com.tmb.requestbuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import static io.restassured.RestAssured.*;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.HttpMethods;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilderWithJava8 {
	
	private RequestBuilderWithJava8() {}
	//For people who know how to use Java8 can use this class instead of RequestBuilder

	
	private static Map<HttpMethods,Supplier<RequestSpecification>> MAP = new HashMap<>();
	
	private static Supplier<RequestSpecification> GET = ()-> given();
	private static Supplier<RequestSpecification> POST = ()-> given()
			.log()
			.all()
			.baseUri(FrameworkConstants.getBaseURI())
			.contentType(ContentType.JSON); 
	static {
		MAP.put(HttpMethods.GET, GET);
		MAP.put(HttpMethods.POST, POST);
	}
	
	

	
	  public static RequestSpecification getRequest(HttpMethods method) { 
		  return  MAP.get(method).get();
		  
	  }
	 

}
