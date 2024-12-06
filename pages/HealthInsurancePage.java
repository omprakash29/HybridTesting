package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import uistore.HealthInsurancePageUI;
import utils.WebDriverHelper;

public class HealthInsurancePage {
	WebDriver driver;
	WebDriverHelper helper;
	public HealthInsurancePage(WebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		helper = new WebDriverHelper(driver,test);
	}

	public void viewPlans(String gender) throws IOException, InterruptedException
	{
		if(gender.equalsIgnoreCase("male")) {
			helper.clickOnElement(HealthInsurancePageUI.male,  HealthInsurancePageUI.class);
		}else if(gender.equalsIgnoreCase("female")) {
			helper.clickOnElement(HealthInsurancePageUI.female,  HealthInsurancePageUI.class);
		}

		helper.clickOnElement(HealthInsurancePageUI.nameInput,  HealthInsurancePageUI.class);
		helper.sendKeys(HealthInsurancePageUI.nameInput, "ram" ,  HealthInsurancePageUI.class);
		helper.clickOnElement(HealthInsurancePageUI.phoneNumberInput,  HealthInsurancePageUI.class);
		helper.sendKeys(HealthInsurancePageUI.phoneNumberInput, "9078684573",  HealthInsurancePageUI.class);
		Thread.sleep(3000);
		helper.clickOnElement(HealthInsurancePageUI.viewPlanButton,  HealthInsurancePageUI.class);

		helper.clickOnElement(HealthInsurancePageUI.selectAdults,  HealthInsurancePageUI.class);
		helper.clickOnElement(HealthInsurancePageUI.age,  HealthInsurancePageUI.class);
		helper.clickOnElement(HealthInsurancePageUI.pincodeInputBox, HealthInsurancePageUI.class);

		helper.sendKeys(HealthInsurancePageUI.pincodeInputBox, "751020",  HealthInsurancePageUI.class);
		Thread.sleep(2000);
		helper.clickOnElement(HealthInsurancePageUI.continueButton,  HealthInsurancePageUI.class);
		Thread.sleep(2000);
		helper.clickOnElement(HealthInsurancePageUI.viewPlanButtonInPopup,  HealthInsurancePageUI.class);
	}

	public void invalidCheckForPlans() 
	{
		helper.clickOnElement(HealthInsurancePageUI.viewPlanButton,  HealthInsurancePageUI.class);
		helper.verifyText(HealthInsurancePageUI.nameErrorText, "The name field is required." ,  HealthInsurancePageUI.class);
		helper.verifyText(HealthInsurancePageUI.phoneNumberErrorText, "The mobile field is required.",  HealthInsurancePageUI.class);
	}

	public void clickOnChooseCity() {
		helper.javascriptScroll(HealthInsurancePageUI.networkHospital, HealthInsurancePageUI.class);
		//		helper.javascriptScroll(HealthInsurancePageUI.chooseCity, HealthInsurancePageUI.class);
		helper.clickOnElement(HealthInsurancePageUI.chooseCity, HealthInsurancePageUI.class);
	}

	public void enterCity(String cityName) {
		helper.sendKeys(HealthInsurancePageUI.chooseCity, cityName, HealthInsurancePageUI.class);
		helper.enterAction(HealthInsurancePageUI.chooseCity, HealthInsurancePageUI.class);
	}

	public void verifyCityText(String expectedString) throws InterruptedException
	{
		helper.verifyText(HealthInsurancePageUI.verifyText,expectedString,HealthInsurancePageUI.class);
	}
}
