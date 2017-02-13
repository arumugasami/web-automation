package com.testdata;

import java.util.HashMap;
import java.util.Map;

public class RegisterTestData {
	
	public static Map<String,String> registerData = new HashMap<String,String>();
	
	public static Object[][] registerData() {

		Object[][] data = new Object[1][1];
		registerData.put("firstName", "John");
		registerData.put("lastName", "Doe");
		registerData.put("email", "hellofresh@seleniumchallenge.com");
		registerData.put("password", "logmein");
		registerData.put("Day", "1");
		registerData.put("Month", "1");
		registerData.put("year", "1985");
		data[0][0] = registerData;
	   	return data;
	}

}
