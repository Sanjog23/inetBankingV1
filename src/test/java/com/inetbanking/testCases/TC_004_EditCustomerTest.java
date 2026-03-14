package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.EditCustPage;
import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_004_EditCustomerTest extends BaseClass{

	@Test(dependsOnMethods="addNewCustomer")
	public void editCustomer() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		AddCustomerPage addCust=new AddCustomerPage(driver);
		EditCustPage editCust=new EditCustPage(driver);
		
		lp.loginIntoInetBanking(username, password);
		
		hp.clickEditCustomer();
		
		editCust.enterCustomerId(BaseClass.customerId);
		editCust.clickOnSubmit();
		
		logger.info("Editing customer details");
		
		addCust.custCity("Bangalore");
		addCust.custState("Karnataka");
		addCust.custPinno("412515");
		addCust.custMobileNumber("9858224223");
		addCust.custSubmit();
		
		logger.info("Relogin to verify cust details are updated");

		relogin();   

	    hp.clickEditCustomer();

	    editCust.enterCustomerId(BaseClass.customerId);
	    editCust.clickOnSubmit();

	    String city = editCust.getCityValue();

	    if(city.equals("Bangalore")) {
	    	Assert.assertTrue(true);
	    	logger.info("Customer details sucessfully updated");
	    }else {
	    	takeScreenShot("editCustomer");
	    	logger.info("Customer update failed");
	    	Assert.assertTrue(false);
	    }
//	    Assert.assertEquals(city, "Bangalore","Customer details are sucessfully updated");
		
		
	}
	
}
