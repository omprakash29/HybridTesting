package utils;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class WebDriverHelper {
	private WebDriver driver;
	public ExtentTest test;
	public WebDriverHelper(WebDriver driver , ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	private String getLocatorName(By locator, Class<?> uiStoreClass) {
		for (Field field : uiStoreClass.getDeclaredFields()) {
			try {
				if (field.get(null).equals(locator)) {
					return field.getName();
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return "Unknown Locator";
	}

	public void waitForElementToBeVisible(By locator, int timeoutInSeconds) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
			.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeClickable(By locator, int timeoutInSeconds) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
			.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebElement waitForElement(WebDriver driver, By locator) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		return wait.until(webDriver -> webDriver.findElement(locator));
	}

	public void verifyText(By locator, String expectedText, Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(getText(locator, uiStoreClass).contains(expectedText));
			LoggerHandler.info("verified the text: " + locatorName);
			test.log(Status.PASS,"verified the text: ");
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to verify the text: " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}

	public void verifyUrl(String expectedText,Class<?> uiStoreClass) {
		try {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(driver.getCurrentUrl().contains(expectedText));
			LoggerHandler.info("verified the URL");
			test.log(Status.PASS,"verified the URL");
		} catch (Exception e) {
			LoggerHandler.error("Not verify the URL");
			test.fail("Failed to verify the URL:", MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}

	public void verifyTitle(String expectedText, Class<?> uiStoreClass) {
		try {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(driver.getTitle().contains(expectedText));
			LoggerHandler.info("verified the Title");
			test.log(Status.PASS,"verified the Title");
		} catch (Exception e) {
			LoggerHandler.error("Not verify the Title");
			test.fail("Failed Not verify the title", MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}

	public void clickOnElement(By locator,Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			waitForElementToBeClickable(locator, 10);
			WebElement webElement = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid black'", webElement);
			webElement.click();
			LoggerHandler.info("Clicked on the selected element: " + locatorName);
			test.log(Status.PASS,"Clicked on the selected element: " + locatorName);
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to click on element " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}


	public void sendKeys(By locator,String data, Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			waitForElementToBeClickable(locator, 5);
			WebElement webElement = driver.findElement(locator);
			webElement.sendKeys(data);
			LoggerHandler.info("send keys to the : " + locatorName);
			test.log(Status.PASS, "send keys to the : " + locatorName);
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to send keys to the : " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}

	public String getText(By locator, Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			waitForElementToBeClickable(locator, 5);
			WebElement webElement = driver.findElement(locator);
			String text = webElement.getText();
			LoggerHandler.info("Got the text : " + locatorName);
			test.log(Status.PASS, "Got the text : " + locatorName);
			return text;
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to get the text : " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
			return "";
		}
	}

	public void jsClick(By locator, Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			waitForElementToBeClickable(locator, 5);
			WebElement element = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			js.executeScript("arguments[0].click();", element);
			LoggerHandler.info("Clicked on the selected element: " + locatorName);
			test.log(Status.PASS, "Clicked on the selected element: " + locatorName);
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to click on element " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}

	public void javascriptScroll(By locator, Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			waitForElementToBeClickable(locator, 5);
			WebElement element = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			LoggerHandler.info("Scroll to the: " + locatorName);
			test.log(Status.PASS, "Scroll to the: " + locatorName);
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to scroll to the: " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}

	public void switchToNewWindow() {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			for (String windowHandle : windowHandles) {
				if (!windowHandle.isEmpty()) {
					driver.switchTo().window(windowHandle);
				} else {
					throw new Exception("New window could not be retrieved");
				}
			}
			LoggerHandler.info("Window switched sucessfully.");
			test.log(Status.PASS , "Window switched sucessfully.");
		} catch (Exception e) {
			String errorMessage = "Not switched to new window";
			LoggerHandler.error(errorMessage);
			test.fail("Failed to switch window: " + errorMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
			e.printStackTrace();
		}
	}

	public void enterAction(By locator, Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			waitForElementToBeClickable(locator, 5);
			WebElement webElement = driver.findElement(locator);
			webElement.sendKeys(Keys.ENTER);
			LoggerHandler.info("Enter action performed: " + locatorName);
			test.log(Status.PASS, "Enter action performed: " + locatorName);
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to perform enter action: " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}

	public void hoverOverElement(By locator , Class<?> uiStoreClass) {
		String locatorName = getLocatorName(locator, uiStoreClass);
		try {
			waitForElementToBeClickable(locator, 5);
			WebElement webElement = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).perform();
			LoggerHandler.info("Hover on the: " + locatorName);
			test.log(Status.PASS, "Hover on the: " + locatorName);
		} catch (Exception e) {
			LoggerHandler.error(locatorName);
			test.fail("Failed to hover on the: " + locatorName, MediaEntityBuilder.createScreenCaptureFromBase64String(
					Screenshot.captureScreenshotAsBase64("failSnap")).build());
		}
	}
}