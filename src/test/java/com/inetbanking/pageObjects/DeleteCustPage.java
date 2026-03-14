package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.SeleniumUtilities;

public class DeleteCustPage extends SeleniumUtilities{

	WebDriver driver;
	
	public DeleteCustPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="cusid")
	private WebElement searchCustId;
	
	@FindBy(name="AccSubmit")
	private WebElement submitBtn;
	
	
	public void enterCustomerId(String custID) {
		typeInput(searchCustId, custID);
	}
	
	public void clickOnSubmit() {
		clickOnElement(submitBtn);
	}
	
}
