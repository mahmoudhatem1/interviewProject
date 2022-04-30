package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class taskOneSearchingSeleniumTutorial {
	public WebDriver driver;
	private String actualUrl;
	
	
	public taskOneSearchingSeleniumTutorial (WebDriver driver) {
		this.driver=driver;
	}
	By searchingElement=By.name("q");
	By allElements=By.xpath("//ul[@role='listbox']//li/descendant::div[@class='pcTkSc']");
	By resultedOptionSearching=By.xpath("//div[@class='yuRUbf'] /a  /h3[@class='LC20lb MBeuO DKV0Md']");
	public WebElement getSearchingElement() {
		return driver.findElement(searchingElement);
	}
	public List<WebElement> getAllSearchingElements(){
		return driver.findElements(allElements);
	}
	public List<WebElement> getAllResultedOptionSearching(){
		return driver.findElements(resultedOptionSearching);
	}
	//,String expectedUrl
	public void achieving(String name,String expectedUrl) throws InterruptedException {
		for(int i=0;i<getAllSearchingElements().size();i++) {
			if(i==0) {
				getAllSearchingElements().get(i).click();
				getAllResultedOptionSearching();
				for(WebElement option:getAllResultedOptionSearching()) {
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
	}/*
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		
		
	}
	public void setActualUrl() {
		this.actualUrl=getCurrentUrl();
	}
	public String getActualUrl() {
		return this.actualUrl;
		
	}
	public void AssertExpectedUrlWithCurrentUrl(String expectedUrl) {
		
		Assert.assertEquals(expectedUrl,getCurrentUrl() );
	}*/
	
	
	
	

}
