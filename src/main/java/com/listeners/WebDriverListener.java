package com.listeners;

import org.testng.IExecutionListener;
import org.testng.Reporter;


public class WebDriverListener implements IExecutionListener {

	public void onExecutionFinish() {
		// TODO Auto-generated method stub

	}

	//set the Firefox drivers before execution starts
	public void onExecutionStart() {
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		String path = classLoader.getResource("geckodriver.exe").getPath();
		System.setProperty("webdriver.gecko.driver", path);
		Reporter.log(" Firefox Successfully set in system property");

	}

}