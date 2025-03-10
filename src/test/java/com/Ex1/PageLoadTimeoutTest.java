package com.Ex1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Without page is actually loaded you cannot perform the actions on web page
// Time this application takes to load completely is called page load time.
// Some application takes less time some takes more time
// If application is not loaded in specified time, then selenium is going to through an exception
// the timeout exception.
// You have to always restrict page load time
// // 300 seconds is default value for pageLoadTimeout in selenium


public class PageLoadTimeoutTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// 300 seconds is default value for pageLoadTimeout in selenium
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
