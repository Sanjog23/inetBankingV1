package com.inetbanking.utilities;

import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetbanking.testCases.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class SeleniumUtilities {
//	public static WebDriver driver;
//	public static WebDriverWait wait;
//	protected Properties properties;
//	protected Actions action;
//	protected FileInputStream fis;
//	protected static String filePath;
//    public static Logger logger = LogManager.getLogger(BaseClass.class);
//
//	/**
//	 * using this method we can load our property and also open desired browser
//	 */
//	{
//		filePath = System.getProperty("user.dir") + "\\Configuration\\config.properties";
//	}
//
//	public WebDriver setUp(String browserName, String appUrl) {
//		properties = new Properties();
//		try {
//			fis = new FileInputStream(filePath);
//			properties.load(fis);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (browserName.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("ie")) {
//			driver = new InternetExplorerDriver();
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//		wait=new WebDriverWait(driver,Duration.ofSeconds(50));
//		driver.get(appUrl);
//		action = new Actions(driver);
//		return driver;
//	}
	
	protected Properties properties;
    protected FileInputStream fis;
    protected static String filePath = System.getProperty("user.dir")
            + "\\Configuration\\config.properties";

    public SeleniumUtilities() {
        properties = new Properties();
        try {
            fis = new FileInputStream(filePath);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Logger logger = LogManager.getLogger(BaseClass.class);

    public static WebDriver driver;
//    protected WebDriver driver;
    public static WebDriverWait wait;
    protected Actions action;

    public WebDriver setUp(String browserName, String appUrl) {

        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().clearDriverCache().setup();

            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless=new");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
        }

        else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if (browserName.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else {
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(appUrl);

        action = new Actions(driver);

        return driver;
    }
	
	public String getValueFromPropertyFile(String key) {
		return properties.getProperty(key);
	}


	public WebDriver getDriver() {
		return driver;
	}

	public void typeInput(WebElement element, String input) {
		waitForElementDisplayed(element);
		element.clear();
		element.sendKeys(input);
	}
	
	public WebElement getActiveElementFromUI() {
		return driver.switchTo().activeElement();
	}

	public void clickOnElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}
	public String getRequiredAttributeValue(WebElement element,String attribute) {
		waitForElementDisplayed(element);
		setSleepTime(2000);
		return element.getAttribute(attribute);
	}

	public void performMouseOverOperation(WebElement element) {
		action.moveToElement(element).perform();
	}

	public void performRightClickOperation(WebElement element) {
		action.moveToElement(element).contextClick().build().perform();
	}

	public void performDragAndDrop(WebElement source, WebElement target) {
		action.dragAndDrop(source, target).build().perform();
	}

//	public void takeScreenShotOfThePage(String location) {
//		// downcast the driver to access TakesScreenshot method
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		// capture screenshot as output type FILE
//		File file = ts.getScreenshotAs(OutputType.FILE);
//		try {
//			// save the screenshot taken in destination path
//			FileUtils.copyFile(file, new File(location));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	

	public String takeScreenShot(String testName) {

	    String folderPath = System.getProperty("user.dir") + "/Screenshots";

	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdir();
	        System.out.println("📁 Screenshots folder created at: " + folderPath);
	    }

	    String timestamp = String.valueOf(System.currentTimeMillis());
	    String screenshotPath = folderPath + "/" + testName + "_" + timestamp + ".png";

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    try {
	        FileUtils.copyFile(source, new File(screenshotPath));
	        System.out.println("📸 Screenshot captured successfully at: " + screenshotPath);
	    } catch (IOException e) {
	        System.out.println("❌ Screenshot capture failed!");
	        e.printStackTrace();
	    }

	    return screenshotPath;
	}
	
	public String getTextFromElement(WebElement element) {
		waitForElementDisplayed(element);
		return element.getText();
	}

	/**
	 * Method to get the title of current page
	 */
	public String getCurrentTitleOfApplication(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	/**
	 * Method to get the title of current page
	 */
	public String getCurrentTitleOfApplication() {
		return driver.getTitle();
	}

	/**
	 * Method to get the current url of the application
	 */
	public String getCurrentUrlOfApplication() {
		return driver.getCurrentUrl();
	}

	public boolean isElementExist(WebElement element) {
		waitForElementDisplayed(element);
		return element.isDisplayed();
	}

	public boolean isCheckBoxSelected(WebElement element) {
		waitForElementDisplayed(element);
		return element.isSelected();
	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	protected void handleHtmlDropdownListWithVisibleText(WebElement element, String visibileText) {
		waitForElementDisplayed(element);
		Select select = new Select(element);
		select.selectByVisibleText(visibileText);
	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	protected void handleHtmlDropdownListWithIndex(WebElement element, int index) {
		waitForElementDisplayed(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	protected List<WebElement> getHtmlDropdownListSize(WebElement element) {
		waitForElementDisplayed(element);
		Select select = new Select(element);
		return select.getOptions();
	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	protected WebElement getFirstSelectedOptionFromHtmlDropdownList(WebElement element) {
		waitForElementDisplayed(element);
		Select select = new Select(element);
		return select.getFirstSelectedOption();
	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	protected List<WebElement> getAllSelectedOptionFromMultiSelectDropdownList(WebElement element) {
		waitForElementDisplayed(element);
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}

	/**
	 * Utility to handle iframes
	 */
	protected void switchToIFrameWithWebElement(WebElement element) {
		waitForElementDisplayed(element);
		driver.switchTo().frame(element);
	}

	/**
	 * Utility to handle iframes
	 */
	protected void switchToIFrameWithIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * Utility to handle iframes
	 */
	protected void switchFromIFrameToMainPage() {

		driver.switchTo().defaultContent();
	}

	/**
	 * This is sleep method from java only use it when uttermost required
	 * 
	 * @param millis time in mili seconds
	 */
	protected void setSleepTime(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {

		}
	}

	/**
	 * Method to refresh Page
	 */
	protected void refreshPage() {

		driver.navigate().refresh();

	}

	/**
	 * Method to wait for an element till it's not display .
	 * 
	 * @param by
	 */
	public void waitForElementDisplayed(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Method to wait for an element till it's not clickable.
	 * 
	 * @param by
	 */
	public void waitForElementToBeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void tearDown() {
	    if (driver != null) {
	        driver.close();
	        driver.quit();
	    }
	}

}
