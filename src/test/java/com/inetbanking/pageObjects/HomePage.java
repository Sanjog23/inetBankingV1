package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	private WebElement newCustomer;
	
	@FindBy(xpath="//a[normalize-space()='Edit Customer']")
	private WebElement editCustomer;
	
	@FindBy(xpath="//a[normalize-space()='Delete Customer']")
	private WebElement deleteCustomer;
	
	@FindBy(xpath="//a[normalize-space()='New Account']")
	private WebElement newAccount;
	
	@FindBy(xpath="//a[normalize-space()='Edit Account']")
	private WebElement editAccount;
	
	@FindBy (xpath="//a[normalize-space()='Delete Account']")
	private WebElement deleteAccount;
	
	@FindBy (xpath="//a[normalize-space()='Deposit']")
	private WebElement deposit;
	
	@FindBy (xpath="//a[normalize-space()='Withdrawal']")
	private WebElement withdrawal;
	
	@FindBy (xpath="//a[normalize-space()='Fund Transfer']")
	private WebElement fundTransfer;
	
	@FindBy (xpath="//a[normalize-space()='Change Password']")
	private WebElement changePassword;
	
	@FindBy (xpath="//a[normalize-space()='Balance Enquiry']")
	private WebElement balanceEnquiry;
	
	@FindBy (xpath="//a[normalize-space()='Mini Statement']")
	private WebElement miniStatement;
	
	@FindBy (xpath="//a[normalize-space()='Customised Statement']")
	private WebElement custStatement;
	
	
	
	
	public void clickAddNewCustomer() {
		clickOnElement(newCustomer);
	}
	
	public void clickEditCustomer() {
		clickOnElement(editCustomer);
	}
	
	public void clickDeleteCustomer() {
		 clickOnElement(deleteCustomer);
	}
	
	public void clickNewAccount() {
		clickOnElement(newAccount);
	}
	
	public void clickEditAccount() {
		clickOnElement(editAccount);
	}
	
	public void clickDeleteAccount() {
		clickOnElement(deleteAccount);
	}
	
	public void clickDeposit() {
		clickOnElement(deposit);
	}
	
	public void clickWithdrawal() {
		clickOnElement(withdrawal);
	}
	
	public void clickfundTransfer() {
		clickOnElement(fundTransfer);
	}
	
	public void clickchangePassword() {
		clickOnElement(changePassword);
	}
	
	public void clickBalanceEnquiry() {
		 clickOnElement(balanceEnquiry);
	}
	
	public void clickMiniStatement() {
		clickOnElement(miniStatement);
	}
	
	public void clickCustStatement() {
		clickOnElement(custStatement);
	}
	
	
}
