//package com.inetbanking.testCases;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//
//import com.inetbanking.utilities.ReadConfig;
//
//public class Base extends ReadConfig {
//
//	public String baseURL;
//	public String username;
//	public String password;
//	public static WebDriver driver;
//	public static Logger logger;
//
//	@BeforeClass
//	public void setup() {
//		 baseURL = pro.getProperty("url").trim();
//	     username = pro.getProperty("username").trim();
//	     password = pro.getProperty("password").trim();
//	        
//		System.setProperty("webdriver.chrome.driver", getChromePath());
//		driver = new ChromeDriver();
//
//		logger = Logger.getLogger("ebanking");
//		PropertyConfigurator.configure("Log4j.properties");
//	}
//}
