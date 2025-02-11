package com.Ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdowns {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		WebElement courseNameElement = driver.findElement(By.id("course"));
		Select select = new Select(courseNameElement);
		
		// Select by index
		select.selectByIndex(1);
		Thread.sleep(2000);
		System.out.println(select.getFirstSelectedOption().getText());
		
		// Select by value
		select.selectByValue("net");
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		
		// Select by visible text
		select.selectByVisibleText("Python");
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		
		select.selectByValue("js");
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		
		
		
		
	}
}
