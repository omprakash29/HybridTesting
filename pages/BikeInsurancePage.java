package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import uistore.BikeInsurancePageUI;
import utils.WebDriverHelper;

public class BikeInsurancePage {
	WebDriver driver;
	WebDriverHelper helper;
	public BikeInsurancePage(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		helper = new WebDriverHelper(driver, test);
	}
	public void startNewSearch() {
		helper.clickOnElement(BikeInsurancePageUI.startNewSearch, BikeInsurancePageUI.class);
	}
	public void sendBikeNumber() {
		helper.sendKeys(BikeInsurancePageUI.bikeNumber, "DL-02-AF-3103", BikeInsurancePageUI.class);
	}
	public void selectBikeCompany() {
		helper.clickOnElement(BikeInsurancePageUI.yamahaOption , BikeInsurancePageUI.class);
	}
	public void searchBikeModel() {
		helper.sendKeys(BikeInsurancePageUI.searchBikeModel, "mt15", BikeInsurancePageUI.class);
	}
	public void selectBikeModel() throws InterruptedException {
		helper.clickOnElement(BikeInsurancePageUI.mt15Bike, BikeInsurancePageUI.class);
	}
	public void selectBikeEdition() throws InterruptedException{
		helper.clickOnElement(BikeInsurancePageUI.motoGpEdition, BikeInsurancePageUI.class);
	}
	public void selectRegistrationYear() throws InterruptedException{
		helper.clickOnElement(BikeInsurancePageUI.registerYear, BikeInsurancePageUI.class);
	}
	public void verifyConfirmDetails(String expectedString) {
		helper.verifyText(BikeInsurancePageUI.confirmDetails,expectedString, BikeInsurancePageUI.class);
	}
	public void validatingInvalidBikeDetails() {
		helper.clickOnElement(BikeInsurancePageUI.checkPriceButton, BikeInsurancePageUI.class);
	}

	public void clickOnRegisterCity() {
		helper.clickOnElement(BikeInsurancePageUI.registerCity, BikeInsurancePageUI.class);
	}

	public void clickOnCityNo() {
		helper.clickOnElement(BikeInsurancePageUI.cityNo, BikeInsurancePageUI.class);
	}

	public void clickOnPreviousOwnDamage() {
		helper.clickOnElement(BikeInsurancePageUI.previousOwnDamage, BikeInsurancePageUI.class);
	}

	public void clickOnOwnDamageDate() {
		helper.clickOnElement(BikeInsurancePageUI.ownDamageYear, BikeInsurancePageUI.class);
		helper.clickOnElement(BikeInsurancePageUI.ownDamageMonth, BikeInsurancePageUI.class);
		helper.clickOnElement(BikeInsurancePageUI.ownDamageDay, BikeInsurancePageUI.class);
	}

	public void clickOnConfirmDetailsButton() {
		helper.clickOnElement(BikeInsurancePageUI.confirmDetailsButton, BikeInsurancePageUI.class);
	}

	public void clickOnZeroDepreciation() {
		helper.clickOnElement(BikeInsurancePageUI.zeroDepreciation, BikeInsurancePageUI.class);
	}

	public void clickOnAddons() {
		helper.clickOnElement(BikeInsurancePageUI.addons, BikeInsurancePageUI.class);
	}

	public void clickOnEngineProtectionCover() {
		helper.clickOnElement(BikeInsurancePageUI.engineProtectionCover, BikeInsurancePageUI.class);
	}

	public void clickOnTyreProtection() {
		helper.clickOnElement(BikeInsurancePageUI.tyreProtection, BikeInsurancePageUI.class);
	}

	public void clickOnApplyButton() {
		helper.clickOnElement(BikeInsurancePageUI.applyButton, BikeInsurancePageUI.class);
	}

	public void clickOnFirstCompany() {
		helper.clickOnElement(BikeInsurancePageUI.firstCompany, BikeInsurancePageUI.class);
	}

	public void verifyProposalFormText(String expectedText) {
		helper.verifyText(BikeInsurancePageUI.verifyTextProposalForm, expectedText, BikeInsurancePageUI.class);
	}
}

