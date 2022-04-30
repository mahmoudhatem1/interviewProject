package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class taskTwoCheckBoxes {
	
	public WebDriver driver;
	private WebElement elementSelectedByIndex;
	
	public  taskTwoCheckBoxes(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By firstCheckBoxElement=By.xpath("//input[@type='checkbox'][1]");
	By secondCheckBoxElement=By.xpath("//input[@type='checkbox'][2]");
	By AllCheckBoxesElement=By.xpath("//input[@type='checkbox']");
	
	
	public WebElement getFirstCheckBoxElement() {
		
		return driver.findElement(firstCheckBoxElement);
	}
	
	
	
	public WebElement getSecondCheckBoxElement() {
		return driver.findElement(secondCheckBoxElement);
	}
	
	
	
	public List<WebElement> getAllCheckBoxesElement() {
		return driver.findElements(AllCheckBoxesElement);
		
	}
	
	
	
	public void loopingToChecking() {
	
		
		for(WebElement option:getAllCheckBoxesElement()) {
			
			Assert.assertTrue(option.isSelected());
			
		}
	}
	
	
	/*
	public WebElement getElementByYourInsertedIndex(int x) {
	
		return driver.findElement(By.xpath("//input[@type='checkbox']["+x+"]"));
	}
	*/
	
	public void setElementSelectedByIndex(int x) {
		this.elementSelectedByIndex=driver.findElement(By.xpath("//input[@type='checkbox']["+x+"]"));
		
	}
	public WebElement getElementSelectedByIndex() {
		return this.elementSelectedByIndex;
	}
	
}
