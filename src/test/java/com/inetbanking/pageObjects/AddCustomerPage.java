	package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.SeleniumUtilities;

public class AddCustomerPage extends SeleniumUtilities{

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="name")
	private WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	private WebElement rdGender;
//	List<WebElement> rdGender;
	
	@FindBy(id="dob")
	private WebElement txtdob;
	
	@FindBy(name="addr")
	private WebElement txtaddress;
	
	@FindBy (name="city")
	private WebElement txtCity;
	
	@FindBy(name="state")
	private WebElement txtState;
	
	@FindBy (name="pinno")
	private WebElement txtPin;
	
	@FindBy (name="telephoneno")
	private WebElement txtMobile;
	
	@FindBy(name="emailid")
	private WebElement txtEmailId;
	
	@FindBy (name="password")
	private WebElement txtPassword;
	
	@FindBy(name="sub")
	private WebElement btnSubmit;
	
	@FindBy(xpath="//td[contains(text(),'Customer ID')]/following-sibling::td")
	private WebElement customerId;
	
	


	
	public void custName(String cname) {
		typeInput(txtCustomerName, cname);
	}
	
	public void custGender(String cgender) {
		clickOnElement(rdGender);
	}
	
//	public void custDob(String dob) {
//	    typeInput(txtdob, dob);
//	}
	
	public void custDob(String dd, String mm, String yy) {
	    txtdob.sendKeys(dd);
	    txtdob.sendKeys(mm);
	    txtdob.sendKeys(yy);
	}
	
	public void custAddress(String cAddress) {
		typeInput(txtaddress, cAddress);
	}
	
	public void custCity(String cCity) {
		typeInput(txtCity, cCity);
	}
	
	public void custState(String csState) {
		typeInput(txtState, csState);
	}
	
	public void custPinno(String cpinno) {
		typeInput(txtPin, String.valueOf(cpinno));
	}
	
	public void custMobileNumber(String cMobile) {
		typeInput(txtMobile, cMobile);
	}
	
	public void custEmail(String cEmail) {
		typeInput(txtEmailId, cEmail);
	}
	
	public void custPassword(String cPassword) {
		typeInput(txtPassword, cPassword);
	}
	
	public void custSubmit() {
		clickOnElement(btnSubmit);
	}
	
	public String captureCustomerId() {
		return getTextFromElement(customerId);
	}
	
	
	
	
}
