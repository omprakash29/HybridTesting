package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import uistore.HomepageUI;
import utils.WebDriverHelper;

public class Homepage {

	WebDriver driver;
	WebDriverHelper helper;
	public Homepage(WebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		helper = new WebDriverHelper(driver,test);
	}

	public void checkTheHealthInsuranceComapany() 
	{
		helper.hoverOverElement(HomepageUI.insurance,  HomepageUI.class);
		helper.hoverOverElement(HomepageUI.healthInsurance,  HomepageUI.class);
		helper.hoverOverElement(HomepageUI.healthInsuranceComapanies,  HomepageUI.class);
		helper.clickOnElement(HomepageUI.healthInsuranceFirstCompany,  HomepageUI.class);
	}

	public void verifyInsuranceCompanyText() 
	{
		helper.verifyText(HomepageUI.companyNameVerify ,"HDFC ERGO Health Insurance" ,  HomepageUI.class);
	}

	public void hoverOnInsuracne() 
	{
		helper.hoverOverElement(HomepageUI.insurance,  HomepageUI.class);
	}
	public void clickHealthInsurance() 
	{
		helper.clickOnElement(HomepageUI.healthInsurance,  HomepageUI.class);
	}
	public void clickBikeInsurance()
	{
		helper.clickOnElement(HomepageUI.bikeInsurance,  HomepageUI.class);
	}
}

