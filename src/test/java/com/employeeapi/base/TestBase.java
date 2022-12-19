package com.employeeapi.base;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequests;
	public static Response response;
	public String empID ="1";
	public String baseURI ="https://dummy.restapiexample.com/api/v1";
	
	
	public Logger logger;
	
	@BeforeClass
	
	public void setup () {
		logger =Logger.getLogger("EmployeeRestAPI");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
