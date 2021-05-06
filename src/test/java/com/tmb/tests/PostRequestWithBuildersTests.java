package com.tmb.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.tmb.constants.FrameworkConstantsWithSingleton;
import com.tmb.requestbuilder.RequestBuilder;
import com.tmb.requests.builders.FavFoodBuilder;
import com.tmb.requests.pojo.Data;
import com.tmb.requests.pojo.FavFood;

public class PostRequestWithBuildersTests {

	@Test
	public void postRequestUsingPojoAndBuilders() {
		List<String> list = new ArrayList<>();
		list.add("tester");
		list.add("trainer");
		/*
		 * FavFood favfood =new FavFoodBuilder() .given() .setBreakfast("chicken")
		 * .and() .setLunch("rice") .and() .setDinner("dosa") .when() .build() .then()
		 * .perform();
		 */
		
		FavFood favFood = FavFood.builder().setBreakfast("sdfsf")
		.setLunch("sffsd").build();

		Data data = new Data(234,"sdfsf",list,favFood);

		RequestBuilder
		.getBuilder()
		.body(data)
		.post(FrameworkConstantsWithSingleton.getInstance().getGetemployeeendpoint())
		.prettyPrint();		
	}

}
