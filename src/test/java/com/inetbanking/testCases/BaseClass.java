package com.inetbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.SeleniumUtilities;

public class BaseClass extends SeleniumUtilities {

    public static Logger logger = LogManager.getLogger(BaseClass.class);

    public String browserName;
    public String appUrl;
    public String username;
    public String password;
    public static String customerId;
    public boolean skipLogout = false;

    
    LoginPage lp;
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public void relogin() {

	    driver.get(appUrl);

	    lp = new LoginPage(driver);
	    lp.loginIntoInetBanking(username, password);
	}
    
    @BeforeClass
    @Parameters("browser")    
    public void setup(@Optional("chrome")String browser) {
    	
    	browserName = browser;   // <-- THIS is important
        appUrl = properties.getProperty("url").trim();
        username = properties.getProperty("username").trim();
        password = properties.getProperty("password").trim();
        
        // Launch browser using SeleniumUtilities
        driver = setUp(browserName, appUrl);
        logger.info(browserName + " browser launched and navigated to " + appUrl);
    }
        
    @AfterMethod
    public void logout() throws InterruptedException {
    	if(skipLogout) {
            return;
        }
    	lp=new LoginPage(driver);
    	lp.clickLogOut();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
    
    public String randomString() {
		String generatedString = RandomStringUtils.secure().nextAlphabetic(8);
		return generatedString;
	}
	
	public static String randomNum() {
		String generatedString2=RandomStringUtils.secure().nextNumeric(4);
		return (generatedString2);
	}
	
	
    
}
