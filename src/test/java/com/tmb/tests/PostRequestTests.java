package com.tmb.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.tmb.constants.FrameworkConstants;
import com.tmb.constants.FrameworkConstantsWithEagerLoading;
import com.tmb.enums.Constants;
import com.tmb.reports.ExtentLogger;
import com.tmb.requestbuilder.RequestBuilder;
import com.tmb.requests.pojo.Data;
import com.tmb.requests.pojo.FavFood;
import com.tmb.utils.RandomUtils;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class PostRequestTests extends BaseTest {

	@Test
	public void postRequestUsingPojo(Map<String,String> data) {
	 
		List<String> listOfJobs = Arrays.asList(data.get("job").split(","));
		
		//Usage of pojo without builder patterns 
		 
		Data data1 = new Data(Integer.parseInt(RandomUtils.generateRandomNumericString(3)),data.get("firstname"),listOfJobs
				,new FavFood(data.get("breakfast"),data.get("lunch"),"meat"));
		
		Response response = RequestBuilder.getBuilder()
			.filter(new RequestLoggingFilter(captor))
			.body(data1)
			.post(FrameworkConstantsWithEagerLoading.getValue(Constants.GETEMPLOYEEENDPOINT));
		
		//Using awaitility library to wait for max of 5 sec
		await().atMost(Duration.ofSeconds(5)).until(()->response.getStatusCode()==201);
		
		ExtentLogger.logRequestAndResponseInReport(writer.toString(), response.asPrettyString());
		
		assertThat(response.getStatusCode()).isEqualTo(FrameworkConstants.STATUSCODE_201);
		
	}
	
}
