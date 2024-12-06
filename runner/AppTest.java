package runner;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HealthInsuraceCalculatorPage;
import pages.HealthInsuranceBestPlansPage;
import pages.HealthInsurancePage;
import pages.Homepage;
import pages.WrapperPage;
import utils.Base;
import utils.ReportHandler;

public class AppTest extends Base
{
	ExtentReports InsuranceDekhoReports;
	ExtentTest test;

	//Page Objects
	Homepage homepage;
	HealthInsurancePage healthpage;
	HealthInsuraceCalculatorPage insuranceCalculatorPage;
	HealthInsuranceBestPlansPage planpage;
	WrapperPage wrapperpage;

	@BeforeTest
	public void generateReports(){
		InsuranceDekhoReports = ReportHandler.generateExtentReport("Om's report");
	}

	@BeforeMethod
	public void getDriver() {
		openBrowser();
	}

	@Test(priority = 1 ,enabled = true)
	public void checkForHealthInsuranceCompany() throws InterruptedException, AddressException, MessagingException 
	{
		test = InsuranceDekhoReports.createTest("checkout the comapany list").assignAuthor("Om");
		wrapperpage = new WrapperPage(driver, test);
		wrapperpage.checkingForHealthInsuranceCompanies();
	}

	@Test(priority = 2, enabled = true)
	public void checkingPlanForFemale() throws IOException, InterruptedException 
	{
		test = InsuranceDekhoReports.createTest("checkout the insurance plans").assignAuthor("Om");
		wrapperpage = new WrapperPage(driver, test);
		wrapperpage.checkInsuranceForFemale();
	}

	@Test(priority = 3 , enabled = true)
	public void calculateInsurance() throws InterruptedException 
	{
		test = InsuranceDekhoReports.createTest("calculate the health insurance").assignAuthor("Om");
		wrapperpage = new WrapperPage(driver, test);
		wrapperpage.calculateHealthInsurance();
	}

	@Test(priority = 4 , enabled = false)
	public void validErrorMessageForBuyingPlan() {
		test = InsuranceDekhoReports.createTest("checkout the insurance plans").assignAuthor("Om");
		wrapperpage = new WrapperPage(driver, test);
		wrapperpage.checkForErrorMessageInInsuranceBuying();
	}

	@Test(priority = 5, enabled = false)
	public void checkForHealthInsurancePlans() throws IOException, InterruptedException 
	{
		test = InsuranceDekhoReports.createTest("checkout the insurance plans").assignAuthor("Om");
		wrapperpage = new WrapperPage(driver, test);
		wrapperpage.checkForHealthInsurancePlan();
	}

	@Test(priority = 6, enabled = false)
	public void checkHospitalsInDifferentCities() throws InterruptedException 
	{
		test = InsuranceDekhoReports.createTest("Checking hospitals").assignAuthor("Om");
		wrapperpage = new WrapperPage(driver, test);
		wrapperpage.checkHospitals();
	}

	@Test(priority = 7, enabled = true)
	public void checkBikeInsurance() throws InterruptedException 
	{
		test = InsuranceDekhoReports.createTest("Checking Bike Insurance").assignAuthor("Om");
		wrapperpage = new WrapperPage(driver, test);
		wrapperpage.checkBikeInsurance();
	}

	@AfterMethod
	public void closeDriver() 
	{
		driver.quit();
	}

	@AfterTest
	public void flushReports() throws AddressException, MessagingException 
	{
		String mailTo = "omprakashaf3003@gmail.com"; 
		String subject = "Selenium Test Report"; 
		String message = "Please find the attached Selenium test report."; 
		InsuranceDekhoReports.flush();

		//		EmailSender.sendEmailWithAttachment(mailTo, subject, message);
	}
}
