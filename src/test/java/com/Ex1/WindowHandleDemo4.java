package com.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Open multiple Tabs and Windows
// This is pending : 13 Feb 2025 Thursday
public class WindowHandleDemo4 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle : " + parentWindowHandle + "\n");
		
		// Click on button to open multiple windows and tab
		driver.findElement(By.id("newTabsWindowsBtn")).click();
		Set<String> allWindowAndTabHandles = driver.getWindowHandles();
		for (String handles : allWindowAndTabHandles) {
			System.out.println("handle : " + handles + " Title : " + driver.getTitle());
		}
		
		List<String> allWindowAndTabHandlesList = new ArrayList<>(allWindowAndTabHandles);
		String handle1 = allWindowAndTabHandlesList.get(0);
		driver.switchTo().window(handle1);
		System.out.println("Switched to : " + driver.getTitle());
		
		String handle2 = allWindowAndTabHandlesList.get(1);
		driver.switchTo().window(handle2);
		System.out.println("Switched to : " + driver.getTitle());
		
		String handle3 = allWindowAndTabHandlesList.get(2);
		driver.switchTo().window(handle3);
		System.out.println("Switched to : " + driver.getTitle() );
		
		String handle4 = allWindowAndTabHandlesList.get(3);
		driver.switchTo().window(handle4);
		System.out.println("Switched to : " + driver.getTitle() );
		
		String handle5 = allWindowAndTabHandlesList.get(4);
		driver.switchTo().window(handle5);
		System.out.println("Switched to : " + driver.getTitle() );
	}
}
