package com.Ex1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
We have three types of scrolls
Scroll/ScrollTo
	- Specific position
	- Bottom of the page
	- To element location
ScrollBy : Move from Current web site position
ScrollIntoView : 
*/

// Scroll to is starting from initial position where as scrollBy is starting from current position
public class JsExecutorDemo4Scroll {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollTo(0,1000)");
		//js.executeScript("window.scrollTo(0,1000)");
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}