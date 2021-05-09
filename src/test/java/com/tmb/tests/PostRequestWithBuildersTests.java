package com.tmb.tests;

import java.util.Arrays;
import java.util.Map;


import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import com.tmb.constants.FrameworkConstantsWithSingleton;
import com.tmb.enums.LogMethods;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentLoggerWithJava8;
import com.tmb.requestbuilder.RequestBuilder;
import com.tmb.requests.pojo.Data;
import com.tmb.requests.pojo.FavFood;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class PostRequestWithBuildersTests extends BaseTest{

	@Test
	public void postRequestUsingPojoAndBuilders(Map<String,String> data) {
		
		

		//using our custom builder
		/*
		 * FavFood favfood =new FavFoodBuilder() .given() .setBreakfast("chicken")
		 * .and() .setLunch("rice") .and() .setDinner("dosa") .when() .build() .then()
		 * .perform();
		 */

		//using lombok builder
		FavFood favFood = FavFood.builder().setBreakfast("sdfsf")
				.setLunch("sffsd").build();

		Data datapojo = new Data(234,"sdfsf",Arrays.asList(data.get("job").split(",")),favFood);

		Response response = RequestBuilder
				.getBuilder()
				.filter(new RequestLoggingFilter(captor))
				.body(datapojo)
				.post(FrameworkConstantsWithSingleton.getInstance().getGetemployeeendpoint());
		
			
		ExtentLogger.logRequestAndResponseInReport(writer.toString(), response.asPrettyString());
		
		assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(data.get("statuscode")));
	}

}
