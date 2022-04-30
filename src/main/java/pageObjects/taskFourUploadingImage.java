package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class taskFourUploadingImage {
	public WebDriver driver;
	public  taskFourUploadingImage(WebDriver driver) {
		this.driver=driver;
	}
	//.\\Image\\ONEjpg.jpg
	By chooseFile=By.xpath("//input[@id='file-upload']");
	By uploadingButton=By.id("file-submit");
	By fileUploadTextElement=By.xpath("//h3[text()='File Uploaded!']");
	public WebElement getChooseFileElement() {
		return driver.findElement(chooseFile);
	}
	
	public WebElement getuploadingButtonElement() {
		return driver.findElement(uploadingButton);
	}
	public void uploading(String bath,String expectedTextReturned) {
		driver.findElement(chooseFile).sendKeys(bath);
		
		
	}
	public void assertionImageIsUploaded(String expectedResult) {
		Assert.assertEquals(getfileUploadTextElement(), expectedResult);
	}
	
	
	public WebElement getfileUploadTextElementModified() {
		return driver.findElement(fileUploadTextElement);
		
	}
	public String getfileUploadTextElement() {
		System.out.println(driver.findElement(fileUploadTextElement).getText());
		return driver.findElement(fileUploadTextElement).getText();
		
	}

}
