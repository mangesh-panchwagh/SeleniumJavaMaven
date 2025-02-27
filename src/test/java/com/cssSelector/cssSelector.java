package com.cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

// For id attribute we use # symbol
// For class attribute we use . symbol
public class cssSelector {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Mangesh");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Panchwagh");
		driver.findElement(By.cssSelector(".city")).sendKeys("Pune");
		driver.findElement(By.cssSelector(".gender")).sendKeys("Male");
	}
}
