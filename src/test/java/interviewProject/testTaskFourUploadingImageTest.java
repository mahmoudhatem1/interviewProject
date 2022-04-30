package interviewProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.taskFourUploadingImage;
import pageObjects.taskThreeTablesAsserting;
import resources.base;

public class testTaskFourUploadingImageTest extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("googleUrlTask1"));
		 driver.navigate().to(prop.getProperty("uploadingImage"));
		

	}
	@Test
	
	public void testingUploadingImage() throws InterruptedException {
		taskFourUploadingImage t1=new taskFourUploadingImage(driver);
		
		t1.getChooseFileElement().sendKeys("C:\\\\Users\\\\ok\\\\eclipse-workspace\\\\interviewProject\\\\Image\\\\ONEjpg.jpg");
		t1.getuploadingButtonElement().click();
		t1.getfileUploadTextElement();
		t1.assertionImageIsUploaded("File Uploaded!");
		
		
		
		
		
	}
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	
		
	}

}
