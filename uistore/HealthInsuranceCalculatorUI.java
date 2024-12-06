package uistore;

import org.openqa.selenium.By;

public class HealthInsuranceCalculatorUI {
	public static By healthInsuranceCalculator = By.xpath("//h2[normalize-space()='Health Insurance Calculator']");

	public static By youOption = By.xpath("//div[contains(@class,'membersTag')][normalize-space()='You']");
	public static By coupleOption = By.xpath("//div[contains(@class,'membersTag')][normalize-space()='Couple']");
	public static By familyOption = By.xpath("//div[contains(@class,'membersTag')][normalize-space()='Family']");
	public static By fatherOption = By.xpath("//div[contains(@class,'membersTag')][normalize-space()='Father']");
	public static By motherOption = By.xpath("//div[contains(@class,'membersTag')][normalize-space()='Mother']");
	public static By ageInputbox = By.id("primary_age");
	public static By spouseAgeInputbox = By.id("age_spouse");
	public static By age = By.cssSelector(".gs_ta_choice[data-value='23']");
	public static By childGender = By.cssSelector("label[class='gs_control gs_radio ']");
	public static By childAgeInputBox = By.id("child_1_age");
	public static By childAge = By.cssSelector(".gs_ta_choice[data-value='1']");
	public static By fatherAgeInputbox = By.id("age_father");
	public static By fatherAge = By.cssSelector(".gs_ta_choice[data-value='54']");
	public static By motherAgeInputbox = By.id("age_mother");
	public static By motherAge = By.cssSelector(".gs_ta_choice[data-value='42']");

	public static By areaPincode = By.id("city");
	public static By coverage = By.xpath("//div[normalize-space()='10 Lac']");
	public static By coverageDropdown = By.id("coverage");
	public static By coverageAmount = By.cssSelector(".gs_ta_choice[data-value='700000']");
	public static By calculatePremiumButton = By.xpath("//div[contains(text(),'Calculate Premium')]");
	public static By verifyText = By.cssSelector("div[class='title']");

	//check error message
	public static By nameFieldError = By.xpath("//div[text() = 'The  age field is required.']");
}
