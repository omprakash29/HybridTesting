package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class WrapperPage {

	//page objects
	Homepage homepage;
	HealthInsurancePage healthpage;
	HealthInsuraceCalculatorPage insuranceCalculatorPage;
	HealthInsuranceBestPlansPage planpage;
	PurchasePlanForm purchaseplanpage;
	BikeInsurancePage bikepage;

	WebDriver driver;
	ExtentTest test;
	public WrapperPage(WebDriver driver ,ExtentTest test )
	{
		this.driver = driver;
		this.test = test;
	}

	public void checkingForHealthInsuranceCompanies() {
		homepage = new Homepage(driver,test);
		homepage.checkTheHealthInsuranceComapany();
		homepage.verifyInsuranceCompanyText();

	}
	public void checkInsuranceForFemale() throws IOException, InterruptedException {
		homepage = new Homepage(driver,test);
		homepage.hoverOnInsuracne();
		homepage.clickHealthInsurance();
		healthpage = new HealthInsurancePage(driver,test);
		healthpage.viewPlans("female");
	}

	public void checkForErrorMessageInInsuranceBuying() {
		homepage = new Homepage(driver,test);
		homepage.hoverOnInsuracne();
		homepage.clickHealthInsurance();
		healthpage = new HealthInsurancePage(driver,test);
		healthpage.invalidCheckForPlans();
	}

	public void checkForHealthInsurancePlan() throws IOException, InterruptedException 
	{
		homepage = new Homepage(driver,test);
		homepage.hoverOnInsuracne();
		homepage.clickHealthInsurance();
		healthpage = new HealthInsurancePage(driver,test);
		healthpage.viewPlans("male");
		checkingHealthInsurancePlansWithDifferentFilters();
		purchasePlansForm();
	}

	public void checkHospitals() throws InterruptedException 
	{
		homepage = new Homepage(driver,test);
		homepage.checkTheHealthInsuranceComapany();
		healthpage = new HealthInsurancePage(driver,test);
		healthpage.clickOnChooseCity();
		healthpage.enterCity("Mumbai");
		healthpage.verifyCityText("HDFC ERGO Network Hospitals in Mumbai");
	}

	public void calculateHealthInsurance() throws InterruptedException 
	{
		homepage = new Homepage(driver,test);
		homepage.hoverOnInsuracne();
		homepage.clickHealthInsurance();
		insuranceCalculatorPage = new HealthInsuraceCalculatorPage(driver,test);

		insuranceCalculatorPage.scrollToHealthInsuranceCalculator();

		insuranceCalculatorPage.selectYouOption();
		insuranceCalculatorPage.calculateInsurance("10");
		driver.navigate().refresh();
		Thread.sleep(3000);

		insuranceCalculatorPage.selectCoupleOption();
		insuranceCalculatorPage.calculateInsurance("10");
		driver.navigate().refresh();
		Thread.sleep(3000);

		insuranceCalculatorPage.selectFamilyOption();
		insuranceCalculatorPage.calculateInsurance("10");
		driver.navigate().refresh();
		Thread.sleep(3000);

		insuranceCalculatorPage.selectMotherOption();
		insuranceCalculatorPage.calculateInsurance("15");
		driver.navigate().refresh();
		Thread.sleep(3000);
		insuranceCalculatorPage.invalidErrorCheck();
	}

	public void checkingHealthInsurancePlansWithDifferentFilters() throws InterruptedException
	{
		planpage = new HealthInsuranceBestPlansPage(driver, test);
		//Filter1
		planpage.CoverageDropdown();
		planpage.CoverageTenLakh();
		planpage.FeatureDropdown();
		planpage.FeatureReset();
		planpage.FeatureDropdown();
		planpage.FeatureMaternityCover();
		planpage.FeatureRestorationBenefits();
		planpage.FeatureApplyNow();
		planpage.TentureDropdown();
		planpage.TentureTwoYear();

		//Filter2
		planpage.CoverageDropdown();
		planpage.dynamicCoverage();
		planpage.CoverageFiftyLakh();
		planpage.CoverageUpdateButton();
		planpage.FeatureDropdown();
		planpage.FeatureReset();
		planpage.FeatureDropdown();
		planpage.FeatureOpdBenefits();
		planpage.FeaturePreHospitalization();
		planpage.FeaturePostHospitalization();
		planpage.FeatureApplyNow();
		planpage.TentureDropdown();
		planpage.TentureThreeYear();

		//Filter3
		planpage.CoverageDropdown();
		planpage.dynamicCoverage();
		planpage.CoverageFiftenLakh();
		planpage.CoverageUpdateButton();
		planpage.FeatureDropdown();
		planpage.FeatureReset();
		planpage.FeatureDropdown();
		planpage.FeatureOpdBenefits();
		planpage.FeaturePreHospitalization();
		planpage.FeaturePostHospitalization();
		planpage.FeaturePedTime();
		planpage.FeatureApplyNow();

		//Filter4
		planpage.BaseDropdown();
		planpage.FeatureDropdown();
		planpage.FeatureReset();
		planpage.FeatureDropdown();
		planpage.FeatureMaternityCover();
		planpage.FeatureOpdBenefits();
		planpage.FeatureNoRoomCapping();
		planpage.FeaturePedTime();
		planpage.FeatureApplyNow();
		planpage.applyFilterSorting("hightolow");

		//filter5
		//		planpage.BaseDropdown();
		planpage.FeatureDropdown();
		planpage.FeatureReset();
		planpage.FeatureDropdown();
		planpage.FeatureMaternityCover();
		planpage.FeatureOpdBenefits();
		planpage.FeatureNoRoomCapping();
		planpage.FeatureApplyNow();
		planpage.TentureDropdown();
		planpage.TentureTwoYear();
		planpage.applyFilterSorting("lowtohigh");

		planpage.applyForCompanyInsurance();
	}

	public void purchasePlansForm() throws InterruptedException 
	{
		purchaseplanpage = new PurchasePlanForm(driver, test);
		purchaseplanpage.verifySelfText();
		purchaseplanpage.selfDob();
		purchaseplanpage.sendHeight("5" , "10");
		purchaseplanpage.sendWeight("80");
		purchaseplanpage.selectOccupation();
		purchaseplanpage.sendPanNumber("ABCDE1234F");
		purchaseplanpage.NomineeDetails();
		purchaseplanpage.NomineeName("om");
		//		purchaseplanpage.NomineeAge("55");
		purchaseplanpage.NomineeDob();
		purchaseplanpage.NomineeAdress("Hydrabad");
		purchaseplanpage.clickCalucalteMedicalDetails();
		purchaseplanpage.verifyTheMedicalForm("Medical Details");
	}

	public void checkBikeInsurance() throws InterruptedException{
		homepage = new Homepage(driver,test);
		homepage.hoverOnInsuracne();
		homepage.clickBikeInsurance();
		bikepage = new BikeInsurancePage(driver, test);
		bikepage.sendBikeNumber();
		bikepage.selectBikeCompany();
		bikepage.searchBikeModel();
		bikepage.selectBikeModel();
		bikepage.selectBikeEdition();
		bikepage.selectRegistrationYear();
		bikepage.clickOnRegisterCity();
		bikepage.clickOnCityNo();
		bikepage.clickOnPreviousOwnDamage();
		bikepage.clickOnOwnDamageDate();
		bikepage.clickOnConfirmDetailsButton();
		bikepage.clickOnZeroDepreciation();
		bikepage.clickOnAddons();
		bikepage.clickOnEngineProtectionCover();
		bikepage.clickOnTyreProtection();
		bikepage.clickOnApplyButton();
		bikepage.clickOnFirstCompany();
		bikepage.verifyProposalFormText("Proposal Form");
	}

	public void validatingInvalid() {
		bikepage = new BikeInsurancePage(driver, test);
		homepage = new Homepage(driver,test);
		homepage.hoverOnInsuracne();
		homepage.clickBikeInsurance();
		bikepage.validatingInvalidBikeDetails();
	}
}
