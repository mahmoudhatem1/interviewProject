package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class taskThreeTablesAsserting {
	public WebDriver driver;
	public  taskThreeTablesAsserting(WebDriver driver) {
		this.driver=driver;
	}
	By allRowsOfFirstColumn=By.xpath("//table[@id='customers'] /tbody /tr /td[1]");
	By allRowsOfLastColumn=By.xpath("//table[@id='customers'] /tbody /tr /td[3]");
	
	public List<WebElement> getAllRowsOfFirstColumnElements(){
		return driver.findElements(allRowsOfFirstColumn);
		
	}
	public List<WebElement> getAllRowsOfLastColumnElements(){
		return driver.findElements(allRowsOfLastColumn);
		
	}
	public WebElement getSpecififedCellFromRowsOfLastColumnElements(int index){
		
		return driver.findElement(By.xpath("//table[@id='customers'] /tbody /tr["+index+"] /td[3]")) ;
	}
	
	public void checking(String expectedSearchingName,String expectedResultName) throws InterruptedException {
		int i=1;
		int matchingIndex=1;
		
		for(WebElement myRow:getAllRowsOfFirstColumnElements()) {
			i++;
			if(myRow.getText().equalsIgnoreCase(expectedSearchingName)) {
				matchingIndex=i;
				Thread.sleep(3000);
				String ActualNameofSearchingIndex= myRow.getText();
				System.out.println(ActualNameofSearchingIndex);
				System.out.println(matchingIndex);
				Assert.assertEquals(ActualNameofSearchingIndex,expectedSearchingName);
				String actualCountry=getSpecififedCellFromRowsOfLastColumnElements(matchingIndex).getText();
				Thread.sleep(3000);
				System.out.println(actualCountry);
				Assert.assertEquals(actualCountry,expectedResultName);
				break;
			}
		}
	}

}
