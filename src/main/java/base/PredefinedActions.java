package base;



import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import contant.ConstantPath;
import customExceptions.ElementNotEnabledException;

public class PredefinedActions {
	

	static WebDriver driver;
	//static WebDriverWait wait;

	static public void initialization(String url) {
		System.setProperty("webdriver.chrome.driver", ConstantPath.CHROMEEXEPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	static public void closeBrower()
	{
		driver.close();
	}

	// [id]:-mngid
	private WebElement getElement(String locator) {
		String locatorType = getLocatorType(locator).toUpperCase(); // id
		String locatorValue = getLocatorValue(locator);// mngid
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locatorType) {
		case "ID":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		case "NAME":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
		case "XPATH":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		case "CSSSELECTOR":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
		default:
			return null;
		}

	}

	private List<WebElement> getElements(String locator) {
		String locatorType = getLocatorType(locator).toUpperCase(); // id
		String locatorValue = getLocatorValue(locator);// mngid
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locatorType) {
		case "ID":
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));
		case "NAME":
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorValue)));
		case "XPATH":
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
		case "CSSSELECTOR":
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locatorValue)));
		default:
			return null;
		}

	}
	private void setBorderVisibility(WebElement element, boolean flag) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (flag)
			js.executeScript("arguments[0].style.border='3px red solid'", element);
		else
			js.executeScript("arguments[0].style.border='0px red solid'", element);
	}

	// private void hideBorder(WebElement element)
	// {
	// JavascriptExecutor js = (JavascriptExecutor)driver;
	// js.executeScript("arguments[0].style.border='0px red solid'", element);
	// }

	protected void click(String locator) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
		
	
	}

	private String getLocatorType(String locator) {
		return locator.split(":-")[0].replace("[", "").replace("]", "");
	}

	private String getLocatorValue(String locator) {
		return locator.split(":-")[1];
	}

	protected void setText(String locator, String value, boolean ignoredExpected) {
		WebElement element = getElement(locator);
		if (element.isEnabled()) {
			element.clear();
			element.sendKeys(value);
			// return;
		} else {
			throw new ElementNotEnabledException(locator + " is not enabled, expected to be enabled");
		}
	}
	
	protected String getText(String locator) {
		WebElement element = getElement(locator);
		if (element.isEnabled()) {
			
			return element.getText();
			// return;
		} else {
			throw new ElementNotEnabledException(locator + " is not enabled, expected to be enabled");
		}
	}
	
	protected String getAttributeValue(String locator, String attribute)
	{
		WebElement element = getElement(locator);
		return element.getAttribute(attribute);
		
	}
	
	protected String getPageTitle()
	{
		return driver.getTitle();
	}
	
	protected String getPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	protected boolean visiblilityOfElement(String locator)
	{
		WebElement element = null;
		try{
			element = getElement(locator);
			return element.isDisplayed();
		}catch(NoSuchElementException ne)
		{
			return false;
		}
	}
	
	protected boolean isElementClickable(String locator)
	{
		WebElement element = null;
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try{
			element = getElement(locator);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			return true;
		}catch(TimeoutException ne)
		{
			return false;
		}
	}
	
	protected boolean verifyAlertPresent()
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(TimeoutException e)
		{
			return false;
		}
	}
		
	protected String handleAccept()
	{
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	
	
	protected int getTotalRowCount(String locator)
	{
		return getElements(locator).size();
	}
	
	protected String navigateToBack() {
		driver.navigate().back();
		return getPageURL();
	}
	
}
