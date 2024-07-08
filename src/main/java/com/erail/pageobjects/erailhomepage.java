package com.erail.pageobjects;

import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erail.base.baseClass;

public class erailhomepage extends baseClass {
	
	@FindBy(xpath = "//input[@id='txtStationFrom']")
	public WebElement fromTextField;

	@FindBy(xpath = "//td[@id='tdDateFromTo']/input")
	public WebElement sortOnDate;

	@FindBy(xpath = "(//div[@class='autocomplete-w1'])[1]/div/div")
	public List<WebElement> listOfStation;
	
	@FindBy(xpath = "(//div[@class='autocomplete-w1'])[1]/div/div")
	public WebElement selectDate;

	WebDriver ldriver;
	public erailhomepage(WebDriver ldriver) {
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnFromButton() {
		fromTextField.click();
	}
	
	public void selectSationName(int a) {
		listOfStation.get(a).toString();
	}
	
	public void clearFromTextField() {
		sortOnDate.clear();
	}
	
	public String SetNameinFromTextField(String name) {
		fromTextField.sendKeys(name);
		return name;
	}

	public void clickOnSortOnDateButton() {
		sortOnDate.click();
	}

	public void getListOfStation() throws IOException {
		String excelFilePath = ".\\testData\\TestData.xlsx";
		FileInputStream input = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		for (int i = 0; i <= listOfStation.size()-1; i++) {
			String suggestion = listOfStation.get(i).toString();
			XSSFRow row = sheet.createRow(i);
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(suggestion);
		}
//		for(int i=1;i<=listOfStation.size()-2;i++) {
//			String value1 = sheet.getRow(i).getCell(0).getStringCellValue();
//			String value2 = sheet.getRow(i).getCell(1).getStringCellValue();
//			Assert.assertEquals(value1, value2);
//		}

	}
}
