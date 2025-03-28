package com.interview_questions_selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// When you type cast, you are converting driver instance into JavascriptExecutor instance
// Converts WebDriver  instance into JavascriptExecutor instance so you can access the methods of JavascriptExecutor 

public class Program2_2 {

	static String browserName = "chrome";
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		String title = (String) jsExecutor.executeScript("return document.title");
		System.out.println(title);
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/Img1.png"));
		
		driver.quit();
	}
}
