package uistore;

import org.openqa.selenium.By;

public class PurchasePlanFormUI {

	//Member Details
	public static By selfText = By.cssSelector("div[class='newGwrap'] div[class='nomanieeDetails1'] div div[class='inputGtitle']");
	public static By dob = By.cssSelector("label[for='dob-1-self']");
	public static By year = By.cssSelector("li[id='2002']");
	public static By month = By.xpath("//li[normalize-space()='Jul']");
	public static By day = By.xpath("//li[normalize-space()='29']");

	public static By heightInFeet = By.id("height_feet-1-self");
	public static By heightInInch = By.id("height_inch-1-self");
	public static By weight = By.id("weight-1-self");
	public static By occupation = By.id("occupation-1-self");
	//	public static By selfEmployed = By.xpath("//li[@data-name = 'Professional-doctor']");
	public static By selfEmployed = By.cssSelector(".gs_ta_choice[data-value='Self employed']");
	public static By panNumber = By.id("pan_number");
	public static By relation = By.id("relationship");
	public static By father = By.cssSelector(".gs_ta_choice[data-value='Father']");
	public static By Nomineename = By.id("name-1");
	public static By NomineeAge = By.id("age-1");

	public static By NomineeDob = By.cssSelector("label[for='customeDatePicker2']");
	public static By NomineeYear = By.cssSelector("li[id='2000']");
	public static By NomineeMonth = By.xpath("//li[normalize-space()='Jul']");
	public static By NomineeDay = By.xpath("//li[normalize-space()='20']");

	public static By Nomineeaddress = By.id("NomineeAddress");
	public static By continueToMedicalDetails = By.cssSelector("button[type='button']");
	public static By medicalDetailsText = By.xpath("//div[@class='proposetxt ']");

	public static By viewFeatures = By.xpath("//a[text() = 'View Features ']");
	public static By planFeatures = By.xpath("//div[text() = 'Plan Features']");
	public static By closePlanFeatures = By.xpath("//span[@class = 'v2_close']");
	public static By heightInFeetErrorText = By.xpath("//div[normalize-space()='The height feet (self) field is required.']");

}
