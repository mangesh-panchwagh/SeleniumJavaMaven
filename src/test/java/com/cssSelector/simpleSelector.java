package com.cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// CSS selector is a pattern to find web element in the web page
/*
// For id attribute we use # symbol
// For class attribute we use . symbol
CSS element Selector
CSS id Selector
CSS class Selector
CSS Universal Selector 
*/

public class simpleSelector {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.cssSelector("button")).getAttribute("id"));
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Mangesh");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Panchwagh");
		driver.findElement(By.cssSelector(".city")).sendKeys("Pune");
		driver.findElement(By.cssSelector(".gender")).sendKeys("Male");
		System.out.println(driver.findElements(By.cssSelector("*")).size());
		
	}
}
