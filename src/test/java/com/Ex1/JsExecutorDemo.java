package com.Ex1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
It is an interface which provides a way to execute the java script from selenium web driver.
Why we need to perform operations using java script executor. We can perform operations using selenium web driver.
Why we need to perform operation using java script. Because in some applications on some web elements actual 
selenium web driver commands will not work.

*/
public class JsExecutorDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://www.google.co.in/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("alert('hello')");
	}

}
