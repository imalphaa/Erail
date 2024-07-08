package com.erail.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.erail.base.baseClass;
import com.erail.pageobjects.erailhomepage;

public class testCase02 extends baseClass {
	WebDriver driver;
	erailhomepage hp=new erailhomepage(driver);
	@Test(enabled=true)
	public void verifySourceStationName() throws InterruptedException, IOException {
//		hp.clickOnFrom();
//		hp.getListOfStation();
	}
}
