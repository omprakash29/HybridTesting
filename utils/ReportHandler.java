package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportHandler {
	public static String path;
	// Private constructor to prevent instantiation of the utility class
	private ReportHandler() {
		throw new IllegalStateException("Reporter Util");
	}

	private static Properties prop = null; // Properties object to hold configuration settings

	private static ExtentReports extentReport = null; // ExtentReports object for managing report generation

	// Method to generate an ExtentReport without a specific report name
	public static ExtentReports generateExtentReport() {
		return generateExtentReport(null); // Calls the overloaded method with null report name
	}

	// Method to generate an ExtentReport with a specified report name
	public static ExtentReports generateExtentReport(String reportName) {
		// Check if the extentReport is already created
		if (extentReport == null) {
			extentReport = createExtentReport(reportName); // Create a new report if not already created
		}
		return extentReport; // Return the existing or newly created report
	}

	// Method to create a new ExtentReport
	private static ExtentReports createExtentReport(String reportName) {
		extentReport = new ExtentReports();

		// Load properties from browser.properties file
		String filepath = System.getProperty("user.dir") + "/config/browser.properties";
		try {
			FileInputStream file = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}

		String timestamp = getCurrentTimestamp(); 
		String reportFilePath = getReportFilePath(reportName, timestamp);

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(reportFilePath));

		configureReporter(sparkReporter); 
		extentReport.attachReporter(sparkReporter);

		setSystemInfo();

		return extentReport; 
	}

	// Method to get the current timestamp formatted as a string
	private static String getCurrentTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss"); 
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); 
		return dateFormat.format(new Date());
	}

	// Method to generate the report file path based on the report name and timestamp

	private static String getReportFilePath(String reportName, String timestamp) {
		// Default report name if none is provided
		if (reportName == null || reportName.isEmpty()) {
			reportName = "_Enter Name_Application Report"; // Default name
		}
		path = System.getProperty("user.dir") + "/reports/" + reportName + "_" + timestamp + ".html";
		// Construct the full file path for the report
		return System.getProperty("user.dir") + "/reports/" + reportName + "_" + timestamp + ".html";
	}

	// Method to configure the SparkReporter settings
	private static void configureReporter(ExtentSparkReporter sparkReporter) {
		sparkReporter.config().setTheme(Theme.STANDARD); // Set the theme of the report to dark
		sparkReporter.config().setReportName("Sports_Jam"); // Set the report name
		sparkReporter.config().setDocumentTitle("Sports_Jam_Reports"); // Set the document title
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss"); // Set the timestamp format
	}

	// Method to set system information in the report
	private static void setSystemInfo() {
		extentReport.setSystemInfo("Application URL", prop.getProperty("url")); // Set application URL
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browser")); // Set browser name
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name")); // Set OS name
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version")); // Set Java version
	}
}