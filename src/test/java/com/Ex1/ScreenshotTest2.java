package com.Ex1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTest2 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/");
		Utils2.captureScreenshot(driver, "w3s1.png");
		driver.findElement(By.xpath("//a[@id='navbtn_exercises']")).click();
		Utils2.captureScreenshot(driver, "w3s2.png");
		
		
	}

}
