package com.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Handling multiple tabs
//Here we will handle tabs and switch between two tabs
public class WindowHandleDemo3 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window handle : " + parentWindowHandle + "\n");
		
		// Click on button to open multiple tabs
		driver.findElement(By.id("newTabsBtn")).click();
		System.out.println("Landed on Parent Wwindow : " + driver.getTitle());
		Set<String> allWindowHandleTabs = driver.getWindowHandles();
		for (String handle : allWindowHandleTabs) {
			System.out.println("Handle" + handle);
		}
		
		System.out.println("");
		
		// convert to List collection interface 
		List<String> allTabString = new ArrayList<>(allWindowHandleTabs);
		String tab2 = allTabString.get(1);
		driver.switchTo().window(tab2);
		System.out.println("Swithced to : " + driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Mangesh");
		
		String tab3 = allTabString.get(2);
		driver.switchTo().window(tab3);
		System.out.println("Switched to : " + driver.getTitle());
		driver.findElement(By.id("confirmBox")).click();
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println("Confirmation Alert Text Message : " + confirmationAlert.getText());
		Thread.sleep(2000);
		confirmationAlert.accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("output")).getText());
		
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Switched to : " + driver.getTitle());
		driver.findElement(By.id("name")).sendKeys("Reddy");
		Thread.sleep(2000);
		
		driver.switchTo().window(tab2);
		System.out.println("Swithced to : " + driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("Panchwagh");
	}
}
