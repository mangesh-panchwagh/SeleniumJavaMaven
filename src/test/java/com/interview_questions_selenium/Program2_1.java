package com.interview_questions_selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * @author Mangesh Panchwagh
 * How to find broken links from Selenium WebDriver
 * */

/*
WebDriver -interface
driver - local variable
new - keyword (new keyword to create object)
ChromeDriver - this is a constructor
If you are invoking this ChromeDriver() constructor means this constructor is coming from chromeDriver class


So we are creating object for chrome driver class by calling driver constructor(default constructor)
This will open the chrome browser. After opening browser we want to perform some actions on browser.
So To perform some operations on browser, we should have that instance, browser instance stored in some variable, then
you can use that variable and perform actions. That is the reason we are storing chromeDriver instance in one driver
variable
*/
// Why we need to type cast WebDriver instance in order to use javaScriptExecutor and takeScreenshotAs interfaces
//  When we are working with javaScriptExecutor or takeScreenshotAs, we type cast the web driver 
// Why this type casting is needed.?

//When you type cast, you are converting driver instance into JavascriptExecutor instance
//Converts WebDriver instance into JavascriptExecutor instance so you can access the methods of JavascriptExecutor 


public class Program2_1 {

	public static void main(String[] args) throws IOException {
		/*
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		//System.out.println(driver.getTitle());
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		String title = (String) jsExecutor.executeScript("return document.title");
		System.out.println(title);
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(	file, new File("./Screenshots/Img1.png"));
		
		driver.quit();
		*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		//System.out.println(driver.getTitle());
		
		JavascriptExecutor jsExecutor = driver;
		String title = (String) jsExecutor.executeScript("return document.title");
		System.out.println(title);
		
		TakesScreenshot takeScreenshot = driver;
		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(	file, new File("./Screenshots/Img1.png"));
		
		driver.quit();
	}
}
