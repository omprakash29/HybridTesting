package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import uistore.PurchasePlanFormUI;
import utils.WebDriverHelper;

public class PurchasePlanForm {
	WebDriver driver;
	WebDriverHelper helper;
	public PurchasePlanForm(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		helper = new WebDriverHelper(driver, test);
	}

	public void verifySelfText() 
	{
		helper.verifyText(PurchasePlanFormUI.selfText, "Self", PurchasePlanFormUI.class);
	}
	public void selfDob() 
	{
		helper.clickOnElement(PurchasePlanFormUI.dob,PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.year,PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.month,PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.day,PurchasePlanFormUI.class);
	}
	public void sendHeight(String feet, String inch) 
	{
		helper.sendKeys(PurchasePlanFormUI.heightInFeet, feet,PurchasePlanFormUI.class);
		helper.sendKeys(PurchasePlanFormUI.heightInInch, inch,PurchasePlanFormUI.class);
	}
	public void sendWeight(String weight)
	{
		helper.sendKeys(PurchasePlanFormUI.weight, weight,PurchasePlanFormUI.class);
	}
	public void selectOccupation()
	{
		helper.clickOnElement(PurchasePlanFormUI.occupation, PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.selfEmployed,PurchasePlanFormUI.class);
	}
	public void sendPanNumber(String panNumber) {
		helper.sendKeys(PurchasePlanFormUI.panNumber, panNumber ,PurchasePlanFormUI.class);
	}
	public void NomineeDetails() {
		helper.clickOnElement(PurchasePlanFormUI.relation,PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.father,PurchasePlanFormUI.class);
	}
	public void NomineeName(String name) {
		helper.clickOnElement(PurchasePlanFormUI.Nomineename,PurchasePlanFormUI.class);
		helper.sendKeys(PurchasePlanFormUI.Nomineename,name,PurchasePlanFormUI.class);
	}
	public void NomineeAge(String age) {
		helper.clickOnElement(PurchasePlanFormUI.NomineeAge,PurchasePlanFormUI.class);
		helper.sendKeys(PurchasePlanFormUI.NomineeAge,age,PurchasePlanFormUI.class);
	}
	public void NomineeDob() {
		helper.clickOnElement(PurchasePlanFormUI.NomineeDob,PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.NomineeYear,PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.NomineeMonth,PurchasePlanFormUI.class);
		helper.clickOnElement(PurchasePlanFormUI.NomineeDay,PurchasePlanFormUI.class);
	}
	public void NomineeAdress(String address) {
		helper.clickOnElement(PurchasePlanFormUI.Nomineeaddress,PurchasePlanFormUI.class);
		helper.sendKeys(PurchasePlanFormUI.Nomineeaddress,address,PurchasePlanFormUI.class);
	}
	public void clickCalucalteMedicalDetails() {
		helper.clickOnElement(PurchasePlanFormUI.continueToMedicalDetails , PurchasePlanFormUI.class);
	}
	public void verifyTheMedicalForm(String expectedTitle) {
		helper.verifyText(PurchasePlanFormUI.medicalDetailsText,expectedTitle , PurchasePlanFormUI.class);

	}
	public void viewFeature() {
		helper.clickOnElement(PurchasePlanFormUI.viewFeatures , PurchasePlanFormUI.class);
	}
	public void verifyPlanFeature(String verifyString) {
		helper.verifyText(PurchasePlanFormUI.planFeatures ,verifyString ,PurchasePlanFormUI.class);
	}
	public void closeViewFeatures() {
		helper.clickOnElement(PurchasePlanFormUI.closePlanFeatures , PurchasePlanFormUI.class);
	}

	//	public void incomeSource() {
	//		helper.clickOnElement(PurchasePlanFormUI.incomeSource , PurchasePlanFormUI.class);
	//		helper.clickOnElement(PurchasePlanFormUI.business , PurchasePlanFormUI.class);
	//	}
	//	public void isPoliticianExposedPerson() {
	//		helper.sendKeys(PurchasePlanFormUI.isPoliticallyExposedPerson, "No" ,PurchasePlanFormUI.class);
	//	}
	//	public void occupationInCommunicationDetails() {
	//		helper.clickOnElement(PurchasePlanFormUI.occupationInCommunicationForm , PurchasePlanFormUI.class);
	//	}
	//	public void polticallyExposedRemarks() {
	//		helper.sendKeys(PurchasePlanFormUI.isPoliticallyExposedPerson, "No" ,PurchasePlanFormUI.class);
	//	}
	//	public void clickOnVerifyButton() {
	//		helper.clickOnElement(PurchasePlanFormUI.verifyButton , PurchasePlanFormUI.class);
	//		helper.verifyText(PurchasePlanFormUI.enterValidPanNumberMessage, "valid" , PurchasePlanFormUI.class);
	//	}
	//	public void selectDL() {
	//		helper.clickOnElement(PurchasePlanFormUI.othersOption , PurchasePlanFormUI.class);
	//		helper.clickOnElement(PurchasePlanFormUI.drivingLicense , PurchasePlanFormUI.class);
	//		helper.sendKeys(PurchasePlanFormUI.DlInputBox, "DL14 20110012342" ,PurchasePlanFormUI.class);
	//	}

}
