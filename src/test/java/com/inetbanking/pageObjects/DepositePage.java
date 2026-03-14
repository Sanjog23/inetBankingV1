package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.SeleniumUtilities;

public class DepositePage extends SeleniumUtilities{

	WebDriver driver;
	
	public DepositePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountno")
	private WebElement txtAccountNo;
	
	@FindBy(name="ammount")
	private WebElement txtAmmount;
	
	@FindBy(name="desc")
	private WebElement txtDescription;
	
	@FindBy(name="AccSubmit")
	private WebElement submitBtn;
	
	public void enterAccountNumber(String accNum) {
		typeInput(txtAccountNo, accNum);
	}
	
	public void depositAmmount(String amt,String desc) {
		typeInput(txtAmmount, amt);
		typeInput(txtDescription, desc);
		clickOnElement(submitBtn);
	}
}
