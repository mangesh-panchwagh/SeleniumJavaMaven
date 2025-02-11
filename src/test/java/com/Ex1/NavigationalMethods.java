package com.Ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationalMethods {

	public static void main(String[] args) throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("hyr tutorials");
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).submit();
		Thread.sleep(2000);
		System.out.println("Entered button");
		driver.navigate().to("https://github.com/");
		Thread.sleep(2000);
		System.out.println("Navigated to URL");
		driver.findElement(By.id("hero_user_email")).sendKeys("mangesh013");
		Thread.sleep(2000);
		System.out.println("Entered name");
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("Refresh performed");
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Navigated Back");
		driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println("Navigated forward");
	}
}
