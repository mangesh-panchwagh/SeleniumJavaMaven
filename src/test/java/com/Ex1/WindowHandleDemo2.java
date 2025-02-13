package com.Ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Open Multiple Windows
// Handling multiple windows
// Here we will handle multiple window and switch between two windows
// First get the parent window handle
// then store all the window handles in the set collection.
// to iterate over the set window handles, convert it to List implemented class
public class WindowHandleDemo2 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle : " + parentWindowHandle);
		
		// Click on button to open multiple windows
		driver.findElement(By.id("newWindowsBtn")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> windowStrings = new ArrayList<>(allWindowHandles);
		
		String reqWindow2 = windowStrings.get(2);
		driver.switchTo().window(reqWindow2);
		System.out.println("Switched to : " + driver.getTitle());
		
		Thread.sleep(2000);
		//driver.findElement(By.id("ContactForm1_contact-form-email")).sendKeys("Mangesh");
		//Thread.sleep(5000);
		driver.close();
		
		String reqWindow1 = windowStrings.get(1);
		driver.switchTo().window(reqWindow1);
		System.out.println("Switched to : " + driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Mangesh");
		
		
		String reqWindow = windowStrings.get(0);
		driver.switchTo().window(reqWindow);
		System.out.println("Switched to : " + driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Reddy");
		Thread.sleep(2000);
		
		//String reqWindow1 = windowStrings.get(1);
		driver.switchTo().window(reqWindow1);
		System.out.println("Switched to : " + driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("Panchwagh");
		
	}
}
