package interviewProject;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pageObjects.taskTwoCheckBoxes;
import resources.base;

public class testApiTest extends base {
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("ApiTest"));
		
		

	}
	
	@Test
	public void testingAPI() {
		
		String expectedName="Ahmed";
		int expectedAge=33;
		int expectedCount=133489;
		RestAssured.baseURI="https://api.agify.io";
		String response=
		given().log().all().queryParam("name", "Ahmed").when().get()
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String actualName=js.getString("name");
		int actualAge=js.getInt("age");
		int actualCount=js.getInt("count");
		
		
		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(actualAge, expectedAge);
		Assert.assertEquals(actualCount, expectedCount);
		
		

	}
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	
		
	}
		
		
	}


