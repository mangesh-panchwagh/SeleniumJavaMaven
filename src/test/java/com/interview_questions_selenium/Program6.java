package com.interview_questions_selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
// What is the difference between driver.close() and driver.quit() in Selenium WebDriver?

public class Program6 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentWindowHandle = driver.getWindowHandle();
		
		System.out.println("Parent window : " + parentWindowHandle);
		
		driver.findElement(By.id("newWindowBtn")).click();	// Move to new window pop-up
		Thread.sleep(5000);
	 
		for (String handle : driver.getWindowHandles()) {
			System.out.println(handle);
			if(!handle.equals(parentWindowHandle)) {
				Thread.sleep(3000);
				driver.switchTo().window(handle);
			}	
		}
		Thread.sleep(3000);
		driver.findElement(By.id("firstName")).sendKeys("Mangesh");
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("Panchwagh");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		//Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
	}
}
