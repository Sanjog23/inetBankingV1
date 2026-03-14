package com.inetbanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import java.io.IOException;
import java.time.Duration;

public class TC_002_LoginDDT extends BaseClass {

	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		skipLogout = true;
		LoginPage lp = new LoginPage(driver);

		lp.loginIntoInetBanking(user, pwd);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

		    // Wait for either alert OR manager id
		    wait.until(ExpectedConditions.or(
		            ExpectedConditions.alertIsPresent(),
		            ExpectedConditions.presenceOfElementLocated(
		                    By.xpath("//td[contains(text(),'Manger Id')]"))
		    ));

		    Thread.sleep(3000);
		    if (isAlertPresent()) {

		        // ❌ Invalid login
		        driver.switchTo().alert().accept();
		        logger.warn("Login failed as expected");
		        Assert.fail("Invalid credential");
//		        
		        Assert.assertTrue(true);  // Test PASSED (expected failure)

		    } else {
		        logger.info("Login successful");

		        lp.clickLogOut();
		        Thread.sleep(3000);
		        wait.until(ExpectedConditions.alertIsPresent());
		        driver.switchTo().alert().accept();
		        // Back to login page
		        driver.switchTo().defaultContent();
		        wait.until(ExpectedConditions.titleContains("Guru99 Bank"));

		        logger.info("Logout successful");

		        Assert.assertTrue(true);
		    }

		} catch (Exception e) {
		    logger.error("Unexpected error: " + e.getMessage());
		    Assert.fail("Test failed due to unexpected error");
		}
		}
	
	

	public boolean isAlertPresent() { // user define created to check alert is not present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}
		
	

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1,0
			}
		}
		return logindata;

	}


}
