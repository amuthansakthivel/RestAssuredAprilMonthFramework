package com.tmb.constants;

public final class StringConstants {
	
	private StringConstants() {}
	
	private static String reqBodyForPost = "{\r\n"
			+ "    \"id\": 1521,\r\n"
			+ "    \"first_name\": \"testing\",\r\n"
			+ "    \"last_name\": \"Sakthivel1\",\r\n"
			+ "    \"email\": \"checking@gmail.com\",\r\n"
			+ "    \"job\":[\"tester\",\"trainer\"],\r\n"
			+ "	\"empid\":14,\r\n"
			+ "    \"favfood\":{\r\n"
			+ "        \"breakfast\":\"dosa\",\r\n"
			+ "        \"lunch\":\"rice\",\r\n"
			+ "		\"dinner\":[\"chapathi\",\"chicken\"]\r\n"
			+ "    }\r\n"
			+ "}";
	
	private static String abcd ="abcd";
	

	public static String getAbcd() {
		return abcd;
	}

	public static String getReqBodyForPost() {
		return reqBodyForPost;
	}
	

}
