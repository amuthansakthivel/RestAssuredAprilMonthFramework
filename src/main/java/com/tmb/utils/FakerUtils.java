package com.tmb.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {
	
	private FakerUtils() {}
	
	public static String getFirstName() {
		return new Faker().name().firstName();
	}

}
