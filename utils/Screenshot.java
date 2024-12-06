package utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class Screenshot extends Base {

	public static TakesScreenshot takess;

	public static void captureScreenShot(String filename) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String name = filename + timestamp + ".png";
		takess = (TakesScreenshot) driver;
		File file = takess.getScreenshotAs(OutputType.FILE);

		File path = new File(System.getProperty("user.dir") + "/screenshots");
		if (!path.exists()) {
			path.mkdirs();
		}

		File target = new File(path, name);
		try {
			Files.copy(file, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String captureScreenshotAsBase64(String screenshotName) {
		String timestamp = getCurrentTimestamp();
		byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
		saveScreenshotToFile(screenshotBytes, screenshotName + "_" + timestamp + ".png");
		return base64Screenshot;
	}

	private static String getCurrentTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		return dateFormat.format(new Date());
	}

	private static void saveScreenshotToFile(byte[] screenshotBytes, String fileName) {
		try {
			File screenshotsDir = new File(System.getProperty("user.dir") + "/reports/ErrorScreenshots/");
			if (!screenshotsDir.exists()) {
				screenshotsDir.mkdirs();
			}
			try (FileOutputStream outputStream = new FileOutputStream(new File(screenshotsDir, fileName))) {
				outputStream.write(screenshotBytes);
			}
		} catch (IOException e) {
			LoggerHandler.debug(e.getMessage());
		}
	}
}