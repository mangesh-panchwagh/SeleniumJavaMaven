package com.Ex1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// This is handling of windows using Iterator
public class WindowHandleDemo5 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window : " + parentWindowHandle);
		
		driver.findElement(By.id("newWindowBtn")).click();
		Thread.sleep(5000);
		Set<String> AllWindowHandles = driver.getWindowHandles(); 
		Iterator<String> i1 = AllWindowHandles.iterator();
		
		while(i1.hasNext()) {
			String childWindow = i1.next();
			if(!parentWindowHandle.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.id("firstName")).sendKeys("Mangesh");
				Thread.sleep(2000);
				driver.findElement(By.id("lastName")).sendKeys("Panchwagh");
				Thread.sleep(2000);
				driver.close();
				System.out.println("Child window closed");
			}
		}
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.id("name")).sendKeys("Reddy");
		
		Thread.sleep(3000);
	}
}
