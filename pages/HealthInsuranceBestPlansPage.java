package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import uistore.HealthInsuranceBestPlansPageUI;
import utils.WebDriverHelper;

public class HealthInsuranceBestPlansPage {
	WebDriver driver;
	WebDriverHelper helper;
	public HealthInsuranceBestPlansPage(WebDriver driver , ExtentTest test)
	{
		this.driver = driver;
		helper = new WebDriverHelper(driver,test);
	}

	//ValidatingBase function
	public void BaseDropdown() throws InterruptedException 
	{
		Thread.sleep(3000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.baseDropdown,HealthInsuranceBestPlansPageUI.class);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.oneCrOption,HealthInsuranceBestPlansPageUI.class);
	}
	//Validating Coverage functions
	public void CoverageDropdown() throws InterruptedException 
	{
		//		driver.get("https://www.insurancedekho.com/health-insurance/quotes?request=673a18c1cc46d4805e335f06");
		Thread.sleep(3000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.coverage,HealthInsuranceBestPlansPageUI.class);
	}
	public void CoverageTenLakh() throws InterruptedException 
	{
		Thread.sleep(3000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.tenLakhOption,HealthInsuranceBestPlansPageUI.class);
	}
	public void CoverageFiftyLakh() throws InterruptedException 
	{
		Thread.sleep(3000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.fiftyLakh,HealthInsuranceBestPlansPageUI.class);
	}
	public void dynamicCoverage() 
	{
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.dynamicCoverage,HealthInsuranceBestPlansPageUI.class);
	}
	public void	CoverageFiftenLakh() throws InterruptedException 
	{
		Thread.sleep(2000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.fiftyLakh,HealthInsuranceBestPlansPageUI.class);
	}
	public void CoverageUpdateButton() {
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.updateButton,HealthInsuranceBestPlansPageUI.class);
	}


	//Validating Feature functions
	public void FeatureDropdown() throws InterruptedException 
	{
		Thread.sleep(3000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.featureDropdown,HealthInsuranceBestPlansPageUI.class);
	}
	public void FeatureReset() throws InterruptedException 
	{
		Thread.sleep(3000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.resetButton,HealthInsuranceBestPlansPageUI.class);
	}
	public void FeatureMaternityCover() throws InterruptedException 
	{
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.maternityCover,HealthInsuranceBestPlansPageUI.class);
	}
	public void FeatureRestorationBenefits() throws InterruptedException 
	{
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.restorationBenefits,HealthInsuranceBestPlansPageUI.class);
		Thread.sleep(2000);
	}
	public void FeaturePreHospitalization() throws InterruptedException {
		Thread.sleep(2000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.preHospitalization,HealthInsuranceBestPlansPageUI.class);
	}
	public void FeaturePostHospitalization() throws InterruptedException {
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.postHospitalization,HealthInsuranceBestPlansPageUI.class);
	}
	public void FeatureOpdBenefits() throws InterruptedException {
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.OpdBenifit,HealthInsuranceBestPlansPageUI.class);
	}
	public void FeaturePedTime() throws InterruptedException 
	{
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.pedTime,HealthInsuranceBestPlansPageUI.class);
		Thread.sleep(2000);
	}
	public void FeatureNoRoomCapping() throws InterruptedException 
	{
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.NoRoomRentCapping,HealthInsuranceBestPlansPageUI.class);
	}
	public void FeatureApplyNow() throws InterruptedException 
	{
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.applyNow,HealthInsuranceBestPlansPageUI.class);
	}

	//Choose Tenture functions
	public void TentureDropdown() throws InterruptedException {
		Thread.sleep(2000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.tentureDropdown,HealthInsuranceBestPlansPageUI.class);
	}
	public void TentureTwoYear() throws InterruptedException 
	{
		Thread.sleep(2000);
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.twoYear,HealthInsuranceBestPlansPageUI.class);
	}
	public void TentureThreeYear() throws InterruptedException 
	{
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.threeYear,HealthInsuranceBestPlansPageUI.class);
	}

	//Validating the Sort filter
	public void applyFilterSorting(String type) throws InterruptedException {
		if(type.equalsIgnoreCase("hightolow")) {
			Thread.sleep(3000);
			helper.clickOnElement(HealthInsuranceBestPlansPageUI.relevence,HealthInsuranceBestPlansPageUI.class);
			helper.clickOnElement(HealthInsuranceBestPlansPageUI.highToLow,HealthInsuranceBestPlansPageUI.class);

		}else if(type.equalsIgnoreCase("lowtohigh")) {
			Thread.sleep(3000);
			helper.clickOnElement(HealthInsuranceBestPlansPageUI.relevence,HealthInsuranceBestPlansPageUI.class);
			helper.clickOnElement(HealthInsuranceBestPlansPageUI.lowToHigh,HealthInsuranceBestPlansPageUI.class);
		}
	}

	public void applyForCompanyInsurance() {
		helper.clickOnElement(HealthInsuranceBestPlansPageUI.firstCompany,HealthInsuranceBestPlansPageUI.class);
	}
}
