package com.erail.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utils {

	public void getExcelVealu() throws IOException {
		String excelFilePath = ".\\testData\\TestData.xlsx";
		FileInputStream input = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(2).getLastCellNum();
		for (int r = 0; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c <= cols; c++) {
				XSSFCell cell = row.getCell(c);
				String vealu = cell.getStringCellValue();
			}
		}
	}

	public void getDate() {
		Date t = new Date(1715884200000L);

		// Create a Calendar instance and set it to the Date object's time
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(t);

		// Add 30 days to the date
		calendar.add(Calendar.DATE, 30);

		// Get the resulting date
		Date resultDate = calendar.getTime();

		// Output the resulting date
		System.out.println(resultDate);
	}
	
	@SuppressWarnings("deprecation")
	public void dateIntoTimestamp() throws ParseException {
		String dateString = "16-Jun-24"; // Date string to convert
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        
//        try {
            // Parse the date string into a Date object
            Date date = dateFormat.parse(dateString);
            
            // Set the year to 2024
            date.setYear(124); // Note: Years are specified as the number of years since 1900
            
            // Convert the Date object to a Unix timestamp (milliseconds since January 1, 1970)
            long timestamp = date.getTime();
            
            Date t = new Date(timestamp);
            Calendar calendar = Calendar.getInstance();
    		calendar.setTime(t);

    		// Add 30 days to the date
    		calendar.add(Calendar.DATE, 30);

    		// Get the resulting date
    		Date resultDate = calendar.getTime();

    		// Output the resulting date
    		System.out.println(resultDate);

            
            // Output the timestamp
//            System.out.println("Timestamp: " + timestamp);
//        } catch (ParseException e) {
//            System.out.println("Error parsing date: " + e.getMessage());
//        }
	}
}
