package interviewProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.taskThreeTablesAsserting;
import pageObjects.taskTwoCheckBoxes;
import resources.base;

public class testingtaskThreeTablesAssertingTest extends base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("googleUrlTask1"));
		 driver.navigate().to(prop.getProperty("TableUrl"));
		

	}
	@Test(dataProvider="getData")
	public void testingCheckBox(String expectedSearchingName,String expectedResultName) throws InterruptedException {
		
		
		taskThreeTablesAsserting t1=new taskThreeTablesAsserting(driver);
		t1.checking(expectedSearchingName,expectedResultName);
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][1];
		data[0][0]="Ernst Handel";
		data[0][1]="Austria";
		
		return data;
		
	}
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	
		
	}

}
