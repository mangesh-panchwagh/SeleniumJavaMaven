package com.Ex1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Enter text into textbox using javascript executor

/*
driver.findElement(By.id("username")).sendKeys("abcd");
1) FindElement(Javascript) + Text (Javascript)
2) FindElement(WebDriver) + Text (Javascript)
*/


// document.evaluate("//textarea[@name='q']",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;
// document.getElementsByName("q")[0]
// document.getElementById("APjFqb");

// document.evaluate("//a[text()='Click here to navigate to the home page']",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).
// singleNodeValue
// document.getElementById("APjFqb").value="HYR Tutorials"

// to find the element using xpath we need to use evaluate method


public class JsExecutorDemo2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.co.in/");
		
		WebElement element = driver.findElement(By.id("APjFqb"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// 1) FindElement(Javascript) + Text (Javascript)
		// js.executeScript("document.getElementById('APjFqb').value='HYR Tutorials'");
		//js.executeScript("document.getElementsByName('q')[0].value='HYR Tutorials'");
		js.executeScript("document.evaluate(\"//textarea[@name='q']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.value='HYR Totorials'");
		
		// 2) FindElement(WebDriver) + Text (Javascript)
		// js.executeScript("arguments[0].value='HYR Tutorials'", element);
		//String text = (String)js.executeScript("return document.getElementById('APjFqb').value");
		//System.out.println(text);
	}
}
