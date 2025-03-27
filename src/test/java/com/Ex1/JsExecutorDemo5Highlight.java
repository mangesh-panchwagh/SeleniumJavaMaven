package com.Ex1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// We can Highlight the element
// 1) FindElement (JavaScript) + Highlight (Javascript)
// 2) FindElement (WebDriver) + Highlight (Javascript)

// highlight 2 ways
// 1) Draw border only : document.getElementById("APjFqb").style.border='2px solid red';
// 2) Draw border and background : document.getElementById("APjFqb").style.background='yellow'
// document.getElementById("APjFqb").setAttribute('style','border:2px solid red; background:yellow')

public class JsExecutorDemo5Highlight {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com");
		//Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('APjFqb').style.border='2px solid red'");
		//js.executeScript("document.getElementById('APjFqb').style.background='yellow'");
		//js.executeScript("document.getElementById('APjFqb').setAttribute('style','border:2px solid red; background:yellow')");
		
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:yellow')",searchBox);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style','border:; background:')",searchBox);
	}
}
