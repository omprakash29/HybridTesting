package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import uistore.HealthInsuranceCalculatorUI;
import utils.WebDriverHelper;

public class HealthInsuraceCalculatorPage {
	WebDriver driver;
	WebDriverHelper helper;
	public HealthInsuraceCalculatorPage(WebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		helper = new WebDriverHelper(driver,test);
	}

	public void scrollToHealthInsuranceCalculator()
	{
		helper.javascriptScroll(HealthInsuranceCalculatorUI.healthInsuranceCalculator, HealthInsuranceCalculatorUI.class);
	}

	public void selectYouOption() 
	{

		helper.clickOnElement(HealthInsuranceCalculatorUI.ageInputbox, HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.age, HealthInsuranceCalculatorUI.class);
	}
	public void selectCoupleOption() 
	{
		helper.clickOnElement(HealthInsuranceCalculatorUI.coupleOption, HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.ageInputbox, HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.age, HealthInsuranceCalculatorUI.class); 
		helper.clickOnElement(HealthInsuranceCalculatorUI.spouseAgeInputbox, HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.age, HealthInsuranceCalculatorUI.class); 

	}
	public void selectFamilyOption()
	{
		helper.clickOnElement(HealthInsuranceCalculatorUI.familyOption, HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.ageInputbox,  HealthInsuranceCalculatorUI.class);

		helper.clickOnElement(HealthInsuranceCalculatorUI.age, HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.spouseAgeInputbox, HealthInsuranceCalculatorUI.class);

		helper.clickOnElement(HealthInsuranceCalculatorUI.age,HealthInsuranceCalculatorUI.class); 
		helper.clickOnElement(HealthInsuranceCalculatorUI.childGender, HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.childAgeInputBox ,HealthInsuranceCalculatorUI.class);
		helper.clickOnElement(HealthInsuranceCalculatorUI.childAge, HealthInsuranceCalculatorUI.class);
	}
	public void selectFatherOption() 
	{
		helper.clickOnElement(HealthInsuranceCalculatorUI.fatherOption, HealthInsuranceCalculatorUI.class);

	}
	public void selectMotherOption()
	{
		helper.clickOnElement(HealthInsuranceCalculatorUI.motherOption, HealthInsuranceCalculatorUI.class);
	}

	public void calculateInsurance(String amount) 
	{
		helper.sendKeys(HealthInsuranceCalculatorUI.areaPincode, "751020", HealthInsuranceCalculatorUI.class);
		if(amount.equalsIgnoreCase("10")) {
			helper.clickOnElement(HealthInsuranceCalculatorUI.coverage, HealthInsuranceCalculatorUI.class);
		}else {
			helper.clickOnElement(HealthInsuranceCalculatorUI.coverageDropdown, HealthInsuranceCalculatorUI.class);
			helper.clickOnElement(HealthInsuranceCalculatorUI.coverageAmount,  HealthInsuranceCalculatorUI.class);
		}

		helper.clickOnElement(HealthInsuranceCalculatorUI.calculatePremiumButton,HealthInsuranceCalculatorUI.class);
		String actualText = helper.getText(HealthInsuranceCalculatorUI.verifyText, HealthInsuranceCalculatorUI.class);
		String expectedText = "Fill your personal details";
		Assert.assertTrue(actualText.contains(expectedText));
	}

	public void invalidErrorCheck() 
	{
		helper.clickOnElement(HealthInsuranceCalculatorUI.calculatePremiumButton, HealthInsuranceCalculatorUI.class);
		helper.verifyText(HealthInsuranceCalculatorUI.nameFieldError, "The  age field is required.",HealthInsuranceCalculatorUI.class) ;
	}
}
