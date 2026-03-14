package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewAccount;

public class TC_006_AddNewAccount extends BaseClass {

	@Test
	public void addNewAccount() {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		NewAccount addAcc = new NewAccount(driver);

		lp.loginIntoInetBanking(username, password);

		setSleepTime(3000);

		hp.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("Sanjog");
		addcust.custGender("male");
//		addcust.custDob("23-03-1998");
		addcust.custDob("23","03","1998");
		setSleepTime(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("Pune");
		addcust.custState("MH");
		addcust.custPinno("442103");
		addcust.custMobileNumber("9754452582");
		String email = randomString() + "@gmail.com";
		addcust.custEmail(email);

		addcust.custPassword("abcdef");
		addcust.custSubmit();

		setSleepTime(3000);

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
		
		String generatedCustID=addcust.captureCustomerId();
		BaseClass.customerId=generatedCustID;
		
		hp.clickNewAccount();
		
		addAcc.createNewAccount(BaseClass.customerId, "Savings", "10000");

	}
}
