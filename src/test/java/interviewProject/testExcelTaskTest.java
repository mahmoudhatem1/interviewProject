package interviewProject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.excelTask;
import pageObjects.taskOneSearchingSeleniumTutorial;
public class testExcelTaskTest {
	
	@Test(dataProvider="getData")
	public void testTaskExcelIntegration(String path,String nameOfSheet,String nameOfColumnInRowHeader,String nameOfcellToCountingAfter,int count) throws InterruptedException, IOException {
		
		excelTask t1=new excelTask();
		t1.testingExcel(path, nameOfSheet, nameOfColumnInRowHeader, nameOfcellToCountingAfter, count);
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][5];
		data[0][0]=".\\Excel\\gantt-chart_L.xlsx";
		data[0][1]="GanttChart";
		data[0][2]="[Project Name] Project Schedule";
		data[0][3]="WBS";
		data[0][4]=36;
		
		return data;
		
	}
	
}
