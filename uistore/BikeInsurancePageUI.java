package uistore;

import org.openqa.selenium.By;

public class BikeInsurancePageUI {
	public static By startNewSearch = By.xpath("//a[normalize-space()='Start a new search']");

	public static By bikeNumber = By.name("registrationNumber");
	public static By checkPriceButton = By.xpath("//span[normalize-space()='Check Prices']");
	//	public static By yesItsMyBikeButton = By.xpath("//button[normalize-space()='Yes, its my Bike']");
	//	public static By confirmDetails = By.cssSelector("button[name='submitBtn'] div");
	public static By yamahaOption = By.cssSelector("a[title='Yamaha']");
	public static By searchBikeModel = By.cssSelector("input[placeholder='Search Bike model e.g. Splender']");
	public static By mt15Bike = By.cssSelector("div[title='MT 15 V2.0']");
	public static By motoGpEdition = By.xpath("//li[contains(text(),'MotoGP Edition')]");
	public static By registerYear = By.xpath("//li[normalize-space()='2020']");
	public static By registerCity = By.xpath("//span[text()='Mumbai']");
	public static By cityNo = By.xpath("//span[text() = 'MH02']");
	public static By confirmDetails = By.cssSelector(".title.bold");
	public static By previousOwnDamage = By.xpath("//label[text()='Previous Own Damage Policy End Date']");
	public static By ownDamageYear = By.id("2024");
	public static By ownDamageMonth = By.xpath("//li[text() = 'Jul']");
	public static By ownDamageDay = By.xpath("//li[text() = '20']");
	public static By confirmDetailsButton = By.xpath("text() = 'Confirm Details']");
	public static By zeroDepreciation =  By.cssSelector(".gs_control gs_checkbox");
	public static By addons = By.cssSelector(".bunchval addontext");
	public static By engineProtectionCover = By.xpath("//label[normalize-space()='Engine Protection Cover']");
	public static By tyreProtection = By.xpath("//label[normalize-space()='Tyre Protection']");
	public static By applyButton = By.cssSelector("button[class='button-primary small']");
	public static By resetFilteresButton = By.cssSelector("button[class='button-primary small secondary']");
	public static By firstCompany = By.xpath("(//div[@class = 'QuoteSection']/descendant::button[@class = 'button'])[1]");
	public static By verifyTextProposalForm = By.xpath("//h1[normalize-space()='Proposal Form']");

}
