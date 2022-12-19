package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GET_AllEmployees extends TestBase {
	
	@BeforeClass
	
	public void getAllemployees() throws InterruptedException {
		logger.info("Starting TC001_GET_AllEmployee");
		RestAssured.baseURI= baseURI;
		
		httpRequests = RestAssured.given();
		
		response = httpRequests.request(Method.GET,"/employees");
		Thread.sleep(3000);
		}
	
	@Test
	public void checkResponseBody() {
		logger.info("Checking Response Body");
	String responseBody =	response.getBody().asPrettyString();
		logger.info("Response Body is " + responseBody);
		Assert.assertTrue(responseBody != null);
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("Checking Status code");
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode );
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@Test
	public void checkResponseTime() {
		logger.info("Checking Response Time");
		long respondTime = response.getTime();
		logger.info("Response Time is " + respondTime);
		
		
		if(respondTime> 3000) 
			logger.warn("Respond time is greater han 3000");
		Assert.assertTrue(respondTime<3000);
		
	}
	
	@Test
	public void checkStatusLine() {
		logger.info("Checking Status line");
		String statusLine = response.statusLine();
		logger.info("Status line is " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void checkContentType() {
		logger.info("Checking  content type");
		String cotentType = response.contentType();
		logger.info("Content type is " +cotentType );
		Assert.assertEquals(cotentType, "application/json");
		
	}
	
	@Test
	public void checkserverType() {
		logger.info("Checking server type");
		String serverType = response.header("Server");
		logger.info("Server type is " + serverType);
		Assert.assertEquals(serverType, "nginx/1.21.6");
	}
	
	
	
	
	@Test
	public void checkEncoding() {
		logger.info("Checking Encoding");
		String contentEncoding = response.header("Content-Encoding");
		logger.info( "This is  Encoding "+contentEncoding);
	}
	
	
	@Test
	public void contentLenght() {
		logger.info("Checking Content Lenght");
		String contentLenght = response.header("Content-Length");
		logger.info("Content lenght is " +contentLenght);
		
		
	}
	
	@Test
	public void cookies() {
		logger.info("Checking cookies");
		String cookies = response.getCookie("12344");
	}
	
	
	@AfterClass
	public void tearDown() {
		logger.info("Finished TC001_Get_All Emp Test");
	}
	
	

}
