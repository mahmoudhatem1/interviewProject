package interviewProject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.taskOneSearchingSeleniumTutorial;
import resources.base;


	public class testingTaskOneSearchingSeleniumTutorial1 extends base {
		public WebDriver driver;
		@BeforeTest
		public void initialize() throws IOException
		{
		
			 driver =initializeDriver();

		}
		
		@Test(dataProvider="getData")
		public void testTaskOneGoogleSearching1(String name,String expectedUrl) throws InterruptedException {
			driver.get(prop.getProperty("googleUrlTask1"));
			taskOneSearchingSeleniumTutorial t1=new taskOneSearchingSeleniumTutorial(driver);
			t1.getSearchingElement().sendKeys("Selenium Tutorial");
			List<WebElement>options=t1.getAllSearchingElements();
			List<WebElement>choosingFromResults=t1.getAllResultedOptionSearching();
			//t1.achieving(name,expectedUrl);
			for(int i=0;i<t1.getAllSearchingElements().size();i++) {
				if(i==0) {
					t1.getAllSearchingElements().get(i).click();
					t1.getAllResultedOptionSearching();
					for(WebElement option:t1.getAllResultedOptionSearching()) {
						Thread.sleep(5000);
						if(option.getText().equalsIgnoreCase(name)) {
							Thread.sleep(5000);
							option.click();
							Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
							
							break;
						}
					}
					break;
					
				}
				
			}
			
			
			
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
	

		
		
		

	
	
