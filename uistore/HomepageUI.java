package uistore;

import org.openqa.selenium.By;

public class HomepageUI {
	public static By insurance = By.xpath("//a[normalize-space()='Insurance']");
	public static By healthInsurance = By.xpath("//a[contains(@href,'/health-insurance')]//span[contains(@class,'subMicon')]");
	public static By healthInsuranceComapanies = By.cssSelector("div[class='subMenu2_wrap'] a[title='Health Insurance Companies']");
	public static By healthInsuranceFirstCompany = By.cssSelector("div[class='subMenu3_wrap'] a[title='HDFC ERGO Health Insurance']");
	public static By companyNameVerify = By.cssSelector("h1[content='HDFC ERGO Health Insurance']");

	public static By bikeInsurance = By.cssSelector("div[class='subMenu false'] a[title='Bike Insurance']");
}
