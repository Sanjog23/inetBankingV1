
//public class TC_LoginTest_001 extends BaseClass {
//
//	@Test
//	public void loginTest() {
//		driver.get(baseURl);
//
//		logger.info("URL is opened");
//	
//		LoginPage lp = new LoginPage(driver);
//		lp.setUserName(username);
//		logger.info("Entered Username");
//
//		lp.setPassword(password);
//		logger.info("Entered Password");
//
//		lp.clickSubmit();
//
//		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
//			Assert.assertTrue(true);
//			logger.info("Login test passed");
//		} else {
//			Assert.assertTrue(false);
//			logger.info("Login test faild");
//		}
//
//	}
//}
package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

@Listeners(com.inetbanking.utilities.TestListener.class)
public class TC_001_LoginTest extends BaseClass {

    @Test
    public void loginTest() {
        LoginPage lp = new LoginPage(driver);
    	lp.loginIntoInetBanking(username, password);
    	
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login test faild");
		}
    }
}