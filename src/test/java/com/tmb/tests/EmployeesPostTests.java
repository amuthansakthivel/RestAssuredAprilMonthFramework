package com.tmb.tests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tmb.constants.FrameworkConstants;
import com.tmb.constants.StringConstants;
import com.tmb.reports.ExtentLogger;
import com.tmb.requestbuilder.RequestBuilder;
import com.tmb.utils.RandomUtils;
import com.tmb.utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeesPostTests {
	
	

	//5 solid principles --> follow these to create clean code
	// write a clean readable maintable code --> 5 solid principles will fall in place

	//String, hashmap, file, read file and replace certain values, pojo and pjo with builder

	//Unirest , rest assured, http client

	
	@Test(enabled=false)
	public void postRequestAsString() {

		Response response = given()
				.baseUri(FrameworkConstants.getBaseURI())
				.header(StringConstants.getAbcd(),"1234")
				.contentType(ContentType.JSON)
				.body(StringConstants.getReqBodyForPost())
				.post(FrameworkConstants.getEmployeesEndpoint());

		assertThat(response.getStatusCode())
		.isEqualTo(201);
	}

	@Test
	public void postRequestUsingMap(Map<String,String> data) {
		Map<String,Object> map = new HashMap<>();
		map.put("id",RandomUtils.generateRandomString(4));
		map.put("first_name",data.get("firstname"));
		map.put("lastname", data.get("lastname"));
		

		Response response = RequestBuilder.getBuilder()
				.body(map)
				.post(FrameworkConstants.getEmployeesEndpoint());

		logResponse(response);
		response.prettyPrint();

		assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(data.get("statuscode")));

	}
	

	private void logResponse(Response response) {
		ExtentLogger.info(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
	}

	@Test(enabled=false)
	public void postRequestByReadingJsonFile(String filename) throws IOException {

		String reqBody = 
				TestUtils.getJsonFileAsString(FrameworkConstants.getRequestBodyFolderpath()+filename);

		String reqBodyNew = prepareJsonForAddEmployee(reqBody);
		Response response = RequestBuilder.getBuilder()
				.body(reqBodyNew)
				.post(FrameworkConstants.getEmployeesEndpoint());

		response.prettyPrint();

		assertThat(response.getStatusCode()).isEqualTo(201);
	}

	private String prepareJsonForAddEmployee(String reqBody) {
		String reqBodyNew = reqBody.replace("999", RandomUtils.generateRandomNumericString(3))
				.replaceAll("fname", RandomUtils.generateRandomString(6));
		return reqBodyNew;
	}



	//Json library
	//pojo
	//builder


















}
