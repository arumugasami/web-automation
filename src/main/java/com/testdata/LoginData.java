package com.testdata;

import java.util.HashMap;
import java.util.Map;

public class LoginData {
	
	public static Map<String,String> ukLogin = new HashMap<String,String>();
	public static Map<String,String> usLogin = new HashMap<String,String>();
	static String country = System.getProperty("country");

	public static Object[][] loginTestData() {

		Object[][] data = new Object[1][1];
		ukLogin.put("login", "qwe@asd.com");
		ukLogin.put("password", "123456");
		
		usLogin.put("login", "testimg@testrockersss.com");
		usLogin.put("password", "loginpass");
		
	    if(country.equalsIgnoreCase("uk")){
	    	data[0][0] = ukLogin;
	    }
		
	    else{
	    	data[0][0] = usLogin;
	    }
		
		return data;
	}

}
