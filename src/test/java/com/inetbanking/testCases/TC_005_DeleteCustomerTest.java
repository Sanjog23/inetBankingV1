package com.inetbanking.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteCustPage;
import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_005_DeleteCustomerTest extends BaseClass {

	@Test(dependsOnMethods="editCustomer")
	public void deleteCustomer() {
		LoginPage lp=new LoginPage(driver);
		HomePage hp= new HomePage(driver);
		DeleteCustPage dCust=new DeleteCustPage(driver);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		lp.loginIntoInetBanking(username, password);
		
		hp.clickDeleteCustomer();
		
		dCust.enterCustomerId(BaseClass.customerId);
		dCust.clickOnSubmit();
		
		 // First alert
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    alert.accept();
	    
//		driver.switchTo().alert().accept();
		
		relogin();
		
		hp.clickDeleteCustomer();
		dCust.enterCustomerId(customerId);
		dCust.clickOnSubmit();
				
		// Second alert
	    alert = wait.until(ExpectedConditions.alertIsPresent());
	    alert.accept();

	    // Final verification alert
	    alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertMsg = alert.getText();
		
		if(alertMsg.equals("Customer does not exist!!")) {
			Assert.assertTrue(true);
			logger.info("Customer sucessfully deleted");
		}else {
			takeScreenShot("deleteCustomer");
			Assert.assertTrue(false);
			logger.info("Customer delete failed");
		}
		
		alert.accept();
		
	}
}
