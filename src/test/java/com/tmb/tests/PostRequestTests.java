package com.tmb.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.tmb.constants.FrameworkConstantsWithEagerLoading;
import com.tmb.enums.Constants;
import com.tmb.requestbuilder.RequestBuilder;
import com.tmb.requests.pojo.Data;
import com.tmb.requests.pojo.FavFood;

import io.restassured.response.Response;

public class PostRequestTests {

	@Test
	public void postRequestUsingPojo() {
		
		List<String> list = new ArrayList<>();
		list.add("tester");
		list.add("trainer");
		
		 
		Data data = new Data(15,"sadcs", list
				,new FavFood("salad","rice","meat"));
		
		Response response = RequestBuilder.getBuilder()
			.body(data)
			.post(FrameworkConstantsWithEagerLoading.getValue(Constants.GETEMPLOYEEENDPOINT));
		
		response.prettyPrint();
	}
	
}
