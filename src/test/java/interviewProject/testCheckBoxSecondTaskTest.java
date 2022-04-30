package interviewProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.taskTwoCheckBoxes;
import resources.base;

public class testCheckBoxSecondTaskTest extends base{

	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("googleUrlTask1"));
		 driver.navigate().to(prop.getProperty("checkBoxesUrl"));
		

	}
	@Test
	public void testingCheckBox() {
		
		
		 taskTwoCheckBoxes t1=new taskTwoCheckBoxes(driver);
		 t1.getFirstCheckBoxElement().click();
		 t1.loopingToChecking();
		
	}
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	
		
	}
}
