package com.Ex1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		
		// Simple Alert
		driver.findElement(By.id("alertBox")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println("Simple Alert Text Message : " + simpleAlert.getText());
		Thread.sleep(2000);
		simpleAlert.accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("output")).getText());
		
		// Confirmation Alert
		driver.findElement(By.id("confirmBox")).click();
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println("Confirmation Alert Text Message : " + confirmationAlert.getText());
		Thread.sleep(2000);
		//confirmationAlert.accept();
		confirmationAlert.dismiss();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("output")).getText());
		
		// Prompt Alert
		driver.findElement(By.id("promptBox")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("Prompt Alert Text Message : " + promptAlert.getText());
		promptAlert.sendKeys("Panchwagh");
		confirmationAlert.accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("output")).getText());
		
		driver.quit();
		
		
		
	}
}
