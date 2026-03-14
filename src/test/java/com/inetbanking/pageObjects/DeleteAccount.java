package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.SeleniumUtilities;

public class DeleteAccount extends SeleniumUtilities {

	WebDriver driver;

	public DeleteAccount (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountno")
	private WebElement enterAccNo;
	
	@FindBy (name="AccSubmit")
	private WebElement submitBtn;
	
	
	
	public void deleteCustAccount(String accNo) {
		typeInput(enterAccNo, accNo);
		logger.info("Account number is provided");
		clickOnElement(submitBtn);
	}
		
	
}
