package com.Ex1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// How to perform click operation in java script

// 1) FindElement(Java script) + click (Java script)
// we find element in java script and we perform operation in java script

// 2) FindElement(WebDriver) + Text (Java script)
//we find the element in web driver and we perform click operation in java script

// document.getElementById("femalerb")
// document.getElementById("femalerb")[1]

// In selenium webdriver we start with driver but in the java script we start with document, because we
// are performing operations on dom

// document.getElementById : return single element
// document.getElementsByClassName, getElementsByName, getElementsByTagName, getElementsByTagNameNS return list of elements


public class JsExecutorDemo3 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('femalerb').click()");
		List checkBoxes = (List) js.executeScript("return document.getElementsByName('language')");
		
		for (Object object : checkBoxes) {
			js.executeScript("arguments[0].click()", object);
		}
		
		js.executeScript("document.getElementById('registerbtn').click()");
		Thread.sleep(5000);
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Click here to navigate to the home page']"));
		
		js.executeScript("arguments[0].click()", link);
		
	}
}
