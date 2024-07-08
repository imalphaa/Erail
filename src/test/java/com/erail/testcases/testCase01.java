package com.erail.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.erail.base.baseClass;
import com.erail.pageobjects.*;
import com.erail.utility.extentManager;
import com.erail.testcases.*;

public class testCase01 extends baseClass {
	WebDriver driver;
	erailhomepage hp=new erailhomepage(driver);

	@Test(enabled = true)
	public void verifySourceStationName() throws InterruptedException {
		hp.clickOnFromButton();
//		hp.SetNameinFromTextField("DEL");
//		hp.selectSationName(4);
	}

	@Test(enabled = false)
	public void verifySuggetionNameWithActual() {
		hp.clickOnSortOnDateButton();
	}

	@Test(enabled = false)
	public void verifySourceOnDateField() {
		Reporter.log("Hello");
	}
}
