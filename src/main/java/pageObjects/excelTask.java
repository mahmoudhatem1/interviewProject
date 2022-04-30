package pageObjects;
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
public class excelTask {
	
	private String path;
	private String nameOfSheet;
	private String nameOfColumnInRowHeader;
	private String nameOfcellToCountingAfter;
	
	public void testingExcel(String path,String nameOfSheet,String nameOfColumnInRowHeader,String nameOfcellToCountingAfter,int count) throws IOException{
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int noOfSheets=workbook.getNumberOfSheets();
		for(int i=0;i<noOfSheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase(nameOfSheet)) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				java.util.Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				java.util.Iterator<Cell> celll=firstRow.cellIterator();
				int columnHeaderNumber=0;
				int columnHeaderNumberMatching=0;
				while(celll.hasNext()) {
					Cell valueOfcell=celll.next();
					if(valueOfcell.getStringCellValue().equalsIgnoreCase(nameOfColumnInRowHeader)) {
						columnHeaderNumberMatching=columnHeaderNumber;
						System.out.println("hi");
						
					}
				
					columnHeaderNumber++;
					
					}
				System.out.println(columnHeaderNumberMatching);
				Row myRow;
				int counterofMatchingRow=2;
				while(rows.hasNext()) {
					myRow=rows.next();
					
				if(myRow.getCell(columnHeaderNumberMatching).getStringCellValue().equalsIgnoreCase(nameOfcellToCountingAfter)) {
					String checking= myRow.getCell(columnHeaderNumberMatching).getStringCellValue();
				System.out.println(checking);
					System.out.println(counterofMatchingRow);
					int noOfRows=-1;
					while(rows.hasNext()) {
						myRow=rows.next();
						noOfRows++;
						
					}
					System.out.println(noOfRows);
				
					Assert.assertEquals(noOfRows, count);
					
				}
				counterofMatchingRow++;
			
				
				}
			
				
				
			}
		}
	}
	

}
