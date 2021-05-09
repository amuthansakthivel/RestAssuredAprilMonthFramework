package com.tmb.tests;

import static com.tmb.constants.FrameworkConstants.STATUSCODE_200;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tmb.constants.FrameworkConstants;
import com.tmb.constants.FrameworkConstantsWithSingleton;
import com.tmb.reports.ExtentLogger;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class EmployeeGetTest extends BaseTest {

	//never hardcode
	//readable tests
	//keep right things at right place
	
	
	
	/*
	 * https://medium.com/codingthesmartway-com-blog/create-a-rest-api-with-json-server-36da8680136d
	 * Please use this article to start the json-server from your end.
	 * 
	 */
	
	/*
	 * There should be a test case matching this test name in RUNMANAGER and ITERATIONDATA sheet
	 * If there are multiple data lines in TESTDATA sheet, it will treated as iteration
	 * Mark Yes in RUNMANAGER and ITERATIONDATA to run this test case
	 * 
	 */

	


	@Test
	public void getEmployeeDetail(Map<String,String> data) {
		Response response = given()
				.filter(new RequestLoggingFilter(captor))
				.baseUri(FrameworkConstants.getBaseURI())
				.pathParam("id", data.get("id"))
				.get("/employees/{id}");
		
		ExtentLogger.logRequestAndResponseInReport(writer.toString(), response.prettyPrint());

		assertThat(response.getStatusCode()).isEqualTo(STATUSCODE_200);

	}


	


	/*
	 * @DataProvider private Object[][] getData() { return new Object[][] {
	 * {1,"sebastian@codingthesmartway.com"}, {2,"steve@codingthesmartway.com"},
	 * {3,"sebastian@codingthesmartway12.com"} }; }
	 */
}
