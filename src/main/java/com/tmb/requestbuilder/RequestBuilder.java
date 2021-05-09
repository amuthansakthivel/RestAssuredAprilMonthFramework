package com.tmb.requestbuilder;

import static io.restassured.RestAssured.given;

import com.tmb.constants.FrameworkConstants;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {
	
	public static RequestSpecification getBuilder() {
		
		//if you need to provide diff implementations
		
		/*
		 * if(httpmethod == "get"){
		 * return given();
		 * }
		 * else if(httpmethod=="post"){
		 * return given().auth().basic("","").baseURI("").post("");
		 * }
		 * 
		 */
	
		return given()
			.log()
			.all()
			.baseUri(FrameworkConstants.getBaseURI())
			.contentType(ContentType.JSON);
	}

}
