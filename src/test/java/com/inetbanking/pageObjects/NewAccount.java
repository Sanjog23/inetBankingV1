package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.inetbanking.utilities.SeleniumUtilities;

public class NewAccount extends SeleniumUtilities {

	WebDriver driver;
	
	public NewAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[normalize-space()='Add new account form']")
	private WebElement vefiryNewAccountForm;
	
	@FindBy(name="cusid")
	private WebElement custId;
	
	@FindBy(name="selaccount")
	private WebElement accountType;
	
	@FindBy(name="inideposit")
	private WebElement iniDeposit;
	
	@FindBy(name="button2")
	private WebElement submitBtn;
	
	public void enterCustomerID(String id) {
		typeInput(custId, id);
	}
	
	public void selectAccountType(String type) {
		Select select =new Select(accountType);
		select.selectByVisibleText(type);
	}
	
	public void enterInitialDeposit(String amount) {
		typeInput(iniDeposit, amount);
	}
	
	public void createNewAccount(String custId,String accType,String deposit) {
		enterCustomerID(custId);
		selectAccountType(accType);
		enterInitialDeposit(deposit);
		clickOnElement(submitBtn);
	}
	
	
}
