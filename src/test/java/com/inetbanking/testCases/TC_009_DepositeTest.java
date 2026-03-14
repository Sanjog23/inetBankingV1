package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DepositePage;
import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_009_DepositeTest extends BaseClass{

	@Test
	public void deposit() {
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		DepositePage dp=new DepositePage(driver);
		
		
		lp.loginIntoInetBanking(username, password);
		
		hp.clickDeposit();
		
		dp.enterAccountNumber(BaseClass.customerId);
		dp.depositAmmount("10,000", "Deposit");
		
		
		
		
	}
}
