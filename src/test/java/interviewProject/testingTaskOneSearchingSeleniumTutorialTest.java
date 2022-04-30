package interviewProject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.taskOneSearchingSeleniumTutorial;
import resources.base;

public class testingTaskOneSearchingSeleniumTutorialTest extends base {
	public WebDriver driver;
	public WebDriverWait w;
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 w=new WebDriverWait(driver,Duration.ofSeconds(5));

	}
	
	@Test(dataProvider="getData")
	public void testTaskOneGoogleSearching(String name,String expectedUrl) throws InterruptedException {
		driver.get(prop.getProperty("googleUrlTask1"));
		taskOneSearchingSeleniumTutorial t1=new taskOneSearchingSeleniumTutorial(driver);
		t1.getSearchingElement().sendKeys("Selenium Tutorial");
		List<WebElement>options=t1.getAllSearchingElements();
		t1.achieving(name,expectedUrl);
		//System.out.println(t1.getCurrentUrl());
		//System.out.println(t1.getActualUrl());
		
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Selenium Tutorial - javatpoint";
		data[0][1]="https://www.javatpoint.com/selenium-tutorial";
		data[1][0]="Selenium Tutorial - Tutorialspoint";
		data[1][1]="https://www.tutorialspoint.com/selenium/index.htm";
		return data;
		
	}
	

	
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.close();
	
	
	}


	}
