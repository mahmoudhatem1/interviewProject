package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public   WebDriver initializeDriver() throws IOException {
		prop=new Properties();
		
		String path=".\\Myfile\\myData.properties";
		FileInputStream fis=new FileInputStream(path);
		
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		 if(browserName.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Mychrome/chromedriver.exe" );
			 driver=new ChromeDriver();
			 
		 }
		 else
			 if(browserName.equalsIgnoreCase("fireFox")) {
				 
			 }
			 else
				 if(browserName.equalsIgnoreCase("IE")) {
					 
				 }
	
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 return driver;
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
	
}
