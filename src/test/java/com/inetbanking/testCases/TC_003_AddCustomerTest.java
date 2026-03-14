package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_003_AddCustomerTest extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		AddCustomerPage addcust = new AddCustomerPage(driver);

		lp.loginIntoInetBanking(username, password);

		Thread.sleep(3000);

		hp.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("Sanjog");
		addcust.custGender("male");
//		addcust.custDob("23-03-1998");
		addcust.custDob("23","03","1998");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("Pune");
		addcust.custState("MH");
		addcust.custPinno("442103");
		addcust.custMobileNumber("9754452582");
		String email = randomString() + "@gmail.com";
		addcust.custEmail(email);

		addcust.custPassword("abcdef");
		addcust.custSubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		} else {
			logger.info("test case failed");
			takeScreenShot("addNewCustomer");
			Assert.assertTrue(false);
		}
		
		String generatedCustomerId=addcust.captureCustomerId();
		BaseClass.customerId=generatedCustomerId;
		
		System.out.println("Generated Customer ID: " + BaseClass.customerId);
		
	}

}
