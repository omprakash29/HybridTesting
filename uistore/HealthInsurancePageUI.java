package uistore;

import org.openqa.selenium.By;

public class HealthInsurancePageUI {

	public static By male = By.cssSelector("label[for='Male']");
	public static By female = By.cssSelector("label[for='Female']");
	public static By nameInput = By.name("name");
	public static By phoneNumberInput = By.name("mobile");
	public static By viewPlanButton = By.xpath("//div[normalize-space()='View Plans']");
	public static By selectAdults = By.xpath("//div[contains(@class,'rowlist')]/div[1]");
	public static By age = By.cssSelector("div[class='searhres'] div:nth-child(6)");
	public static By pincodeInputBox = By.id("pincode");
	public static By continueButton = By.cssSelector("button[title='Continue']");
	public static By viewPlanButtonInPopup = By.cssSelector("button[title='View Plans']");
	public static By planResultPageText = By.xpath("//span[contains(text, ' Plans found ')]");
	public static By nameErrorText = By.xpath("//div[normalize-space()='The name field is required.']");
	public static By phoneNumberErrorText = By.xpath("//div[normalize-space()='The mobile field is required.']");

	//checking the hospitals list
	public static By premiumCalculator = By.cssSelector("a[title='HDFC ERGO Premium Calculator']");
	public static By networkHospital = By.cssSelector("h2[content='Network Hospital in Popular Cities']");
	public static By chooseCity = By.xpath("//label[normalize-space()='Choose your city']");
	public static By verifyText = By.cssSelector("div[class='pageTitleSec'] h1");
}
