package uistore;

import org.openqa.selenium.By;

public class HealthInsuranceBestPlansPageUI {
	public static By baseDropdown = By.xpath("//strong[normalize-space()='Base']");
	public static By oneCrOption = By.cssSelector("label[title='1 Cr Cover']");

	public static By coverage = By.xpath("//li[@class='plantypedropdown']//span[contains(@class,'fbutton')]");
	public static By tenLakhOption = By.cssSelector("label[title='10 Lac']");
	public static By dynamicCoverage = By.id("coverage");
	public static By fiftyLakh = By.cssSelector(".gs_ta_choice[data-value='5000000']");
	public static By fifteenLakh = By.cssSelector(".gs_ta_choice[data-value='1500000']");
	public static By updateButton = By.cssSelector("button[title='Update']");

	public static By featureDropdown = By.xpath("//li[contains(@class,'mobihide newquote_mobiaddcoverAddon')]//span[contains(@class,'fbutton')]");
	public static By maternityCover = By.cssSelector("label[title='Maternity cover']");
	public static By restorationBenefits = By.cssSelector("label[title='Restoration Benefits']");
	public static By OpdBenifit = By.cssSelector("label[title='OPD Benefit']");
	public static By NoRoomRentCapping = By.cssSelector("label[title='No Room Rent Capping']");
	public static By preHospitalization = By.cssSelector("label[title='Pre Hospitalization']");
	public static By postHospitalization = By.cssSelector("label[title='Post Hospitalization']");
	public static By pedTime = By.cssSelector("label[title='4 years']");
	public static By applyNow = By.cssSelector("button[title='Apply Now']");
	public static By resetButton = By.xpath("//span[text() = 'RESET']");

	public static By tentureDropdown = By.xpath("//li[contains(@class,'mobihide newquote_tenure')]//span[contains(@class,'fbutton')]");
	public static By twoYear = By.cssSelector("label[title='2 Years']");
	public static By threeYear = By.cssSelector("label[title='3 Years']");

	public static By relevence = By.xpath("//li[@class='mobihide tenureSorting']//span[contains(@class,'fbutton')]");
	public static By lowToHigh = By.cssSelector("label[title='Premium: Low to High']");
	public static By highToLow = By.cssSelector("label[title='Hospitals: High to Low']");

	public static By firstCompany = By.xpath("(//div[@class='gsc_row']/descendant::button[@class=' Hquotesbtn'])[1]");

	public static By confirmDetails = By.xpath("//button[text() = 'Confirm Details ']");
	public static By yesRadioBox = By.xpath("//input[name = 'is_indian_resident']");
}