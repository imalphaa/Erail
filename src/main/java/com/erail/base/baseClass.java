package com.erail.base;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.erail.utility.extentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass extends extentManager{

	public static WebDriver driver;
//	public SearchContext searchContext;

//	@BeforeSuite()
//	public void extent() {
//		extentManager.configureReport();
//	}
//	
//	@AfterSuite()
//	public void afterSuite() {
//		extentManager.endReport();
//	}

	@BeforeClass
	public static void launchBrowser() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		String excelFilePath = ".\\testData\\TestData.xlsx";
//		FileInputStream input = new FileInputStream(excelFilePath);
//		XSSFWorkbook workbook = new XSSFWorkbook(input);
//		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		int rows = sheet.getLastRowNum();
//		int cols = sheet.getRow(2).getLastCellNum();
//		for (int r = 0; r <= rows; r++) {
//			XSSFRow row = sheet.getRow(r);
//			for (int c = 0; c <= cols; c++) {
//				XSSFCell cell = row.getCell(c);
//				String vealu=cell.getStringCellValue();
//			}
//		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
