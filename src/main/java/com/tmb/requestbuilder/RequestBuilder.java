package com.tmb.requestbuilder;

import static io.restassured.RestAssured.given;

import com.tmb.constants.FrameworkConstants;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {
	
	public static RequestSpecification getBuilder() {
	
		return given()
			.log()
			.all()
			.baseUri(FrameworkConstants.getBaseURI())
			.contentType(ContentType.JSON);
	}

}
