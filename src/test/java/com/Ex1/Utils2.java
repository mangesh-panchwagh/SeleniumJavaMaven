package com.Ex1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils2 {

	public static void captureScreenshot(WebDriver driver, String fileName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/" + " " + fileName));
	}
}
