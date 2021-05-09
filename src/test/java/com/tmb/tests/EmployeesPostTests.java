package com.tmb.tests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.tmb.constants.FrameworkConstants;
import com.tmb.constants.StringConstants;
import com.tmb.reports.ExtentLogger;
import com.tmb.requestbuilder.RequestBuilder;
import com.tmb.utils.RandomUtils;
import com.tmb.utils.TestUtils;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeesPostTests extends  BaseTest {
	
	

	//5 solid principles --> follow these to create clean code
	// write a clean readable maintable code --> 5 solid principles will fall in place
	//String, hashmap, file, read file and replace certain values, pojo and pojo with builder
	//Unirest , rest assured, http client

	//This is just to demonstrate how to pass request as string
	//This test is disabled and will not be ran
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
				.filter(new RequestLoggingFilter(captor)) //to log the request component to extent report
				.body(map)
				.post(FrameworkConstants.getEmployeesEndpoint());

		
		ExtentLogger.logRequestAndResponseInReport(writer.toString(), response.prettyPrint());

		assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(data.get("statuscode")));

	}
	

	
	//This test is to demonstrate how to read a file and convert to string to construct req body
	@Test(enabled=false)
	public void postRequestByReadingJsonFile(String filename) throws IOException {

		String reqBody = 
				TestUtils.getJsonFileAsString(FrameworkConstants.getRequestBodyFolderpath()+filename);

		String reqBodyNew = prepareJsonForAddEmployee(reqBody);
		Response response = RequestBuilder.getBuilder()
				.body(reqBodyNew)
				.post(FrameworkConstants.getEmployeesEndpoint());

		response.prettyPrint();

		assertThat(response.getStatusCode()).isEqualTo(FrameworkConstants.STATUSCODE_201);
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
