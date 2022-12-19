package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utility.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_PUT_Update_Employee extends TestBase{

	String empName = RestUtils.empName();
	
	RequestSpecification httpRequests;
	Response response;
	
	
	
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();

	@BeforeClass

	public void CreateEMP() throws InterruptedException   {
		logger.info("Starting TC004_PUT_UPDATE_Emp_Test");
		RestAssured.baseURI= baseURI;

		httpRequests = RestAssured.given();

		JSONObject  requestParams = new JSONObject ();
		requestParams.put("name", empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);


		httpRequests.header("Content-Type", "application/json");

		httpRequests.body(requestParams.toJSONString());

	response =	httpRequests.request(Method.PUT,"/update/" +empID);
		Thread.sleep(15000);
		
		}
	
	
	@Test(priority =1)
	public void checkingBody() {
		String responseBody = response.getBody().asPrettyString();
		logger.info("This is responseBody " + responseBody );
		Assert.assertTrue(responseBody.contains(empName));
		Assert.assertTrue(responseBody.contains(empSal));
		Assert.assertTrue(responseBody.contains(empAge));
		
	}
	
	@Test(priority =2)
	public void checkStatusCode() {
		logger.info("Checking Status code");
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode );
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority =3)
	public void checkStatusLine() {
		logger.info("Checking Status line");
		String statusLine = response.statusLine();
		logger.info("Status line is " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test (priority=4)
	public void checkContentType() {
		logger.info("Checking  content type");
		String cotentType = response.contentType();
		logger.info("Content type is " +cotentType );
		Assert.assertEquals(cotentType, "application/json");
		
	}
	
	@Test(priority =5)
	public void checkserverType() {
		logger.info("Checking server type");
		String serverType = response.header("Server");
		logger.info("Server type is " + serverType);
		Assert.assertEquals(serverType, "Apache");
	}
	
	
	
	
	@Test(priority =6)
	public void checkEncoding() {
		logger.info("Checking Encoding");
		String contentEncoding = response.header("Content-Encoding");
		logger.info( "This is  Encoding "+contentEncoding);
	}
	
	
	@Test(priority =7)
	public void contentLenght() {
		logger.info("Checking Content Lenght");
		String contentLenght = response.header("Content-Length");
		logger.info("Content lenght is " +contentLenght);
		
		
	}
	
	@Test(priority =8)
	public void cookies() {
		logger.info("Checking cookies");
		String cookies = response.getCookie("12344");
	}
	
	
	@AfterClass
	public void tearDown() {
		logger.info("Starting TC004_PUT_UPDATE_Emp_Test");
	}
	
	





























}



