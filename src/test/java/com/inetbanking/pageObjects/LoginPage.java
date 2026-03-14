package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetbanking.utilities.SeleniumUtilities;

import java.time.Duration;

public class LoginPage extends SeleniumUtilities{

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	private WebElement txtUserName;

	@FindBy(name = "password")
	private WebElement txtPassword;

	@FindBy(name = "btnLogin")
	private WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	private WebElement lnkLogOut;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	
	public void clickLogOut() throws InterruptedException {

		 WebElement logoutBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(By.linkText("Log out"))
	        );
	        JavascriptExecutor js = (JavascriptExecutor) SeleniumUtilities.driver;

	        // Scroll to center (very important)
	        js.executeScript(
	                "arguments[0].scrollIntoView({block: 'center'});",
	                logoutBtn);

	        // Small pause to stabilize layout
	        Thread.sleep(800);

	        // JS click (bypasses overlap)
	        js.executeScript("arguments[0].click();", logoutBtn);


//	        wait.until(ExpectedConditions.alertIsPresent());
//	        driver.switchTo().alert().accept();

		}
	
	public void loginIntoInetBanking(String username,String password) {
		typeInput(txtUserName, username);
		logger.info("User name is provided");
		typeInput(txtPassword, password);
		logger.info("Password is provided");
		clickOnElement(btnLogin);

	}
}

/*
 * mngr654821 
 * dYretEg
 * 180533
 * github repo link 
 * https://github.com/Sanjog23/inetBankingV1.git
 */