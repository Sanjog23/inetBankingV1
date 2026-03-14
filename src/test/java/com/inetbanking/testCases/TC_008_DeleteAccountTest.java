package com.inetbanking.testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteAccount;
import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_008_DeleteAccountTest extends BaseClass {

	@Test(dependsOnMethods="addNewAccount")
	
	public void deleteAccount() {
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		DeleteAccount delAcc=new DeleteAccount(driver);
		
		lp.loginIntoInetBanking(username, password);
		
		hp.clickDeleteAccount();
		
		delAcc.deleteCustAccount(BaseClass.customerId);
		
		driver.switchTo().alert().accept();
		
		relogin();
		logger.info("Customer relogin");
		
		hp.clickDeleteAccount();
		
		delAcc.deleteCustAccount(BaseClass.customerId);
		
		driver.switchTo().alert().accept();
		
		Alert alert= driver.switchTo().alert();
		
		String alertMsg=alert.getText();
		
		if(alertMsg.equals("Account does not exist!!")) {
			Assert.assertTrue(true);
			logger.info("Account sucessfully deleted");
		}else {
			takeScreenShot("deleteAccount");
			Assert.assertTrue(false);
			logger.info("Account delete failed");
		}
		
		
		
		
		
	}
}
