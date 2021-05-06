package com.tmb.tests;

import static com.tmb.constants.FrameworkConstants.STATUSCODE_200;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tmb.constants.FrameworkConstants;
import com.tmb.constants.FrameworkConstantsWithSingleton;
import com.tmb.reports.ExtentLogger;
import com.tmb.utils.DataProviderUtils;

import io.restassured.response.Response;

public class EmployeeGetTest extends BaseTest {

	//never hardcode
	//readable tests
	//keep right things at right place
	
	@Test(enabled=false)
	public void getEmployeesTest() {

		Response response = given()
				.baseUri(FrameworkConstantsWithSingleton.getInstance().getBaseuri())
				.get(FrameworkConstantsWithSingleton.getInstance().getGetemployeeendpoint());

		logResponse(response);

		assertThat(response.getStatusCode())
		.isEqualTo(STATUSCODE_200);

	}


	@Test
	public void getEmployeeDetail(Map<String,String> data) {
		Response response = given()
				.baseUri(FrameworkConstants.getBaseURI())
				.pathParam("id", data.get("id"))
				.get("/employees/{id}");

		logResponse(response);
		assertingResponse(data.get("email"), response);

	}


	private void logResponse(Response response) {
		ExtentLogger.info(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
	}


	private void assertingResponse(String email, Response response) {
		assertThat(response.getStatusCode()).isEqualTo(STATUSCODE_200);
		assertThat(response.jsonPath().get("email")).isEqualTo(email);
	}


	/*
	 * @DataProvider private Object[][] getData() { return new Object[][] {
	 * {1,"sebastian@codingthesmartway.com"}, {2,"steve@codingthesmartway.com"},
	 * {3,"sebastian@codingthesmartway12.com"} }; }
	 */
}
