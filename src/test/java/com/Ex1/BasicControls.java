package com.Ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicControls {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		driver.manage().window().maximize();
		
		// Text box
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("HYR Tutorials");
		
		// Radio Button
		driver.findElement(By.id("femalerb")).click();
		
		// Check box
		driver.findElement(By.id("englishchbx")).click();
		driver.findElement(By.id("hindichbx")).click();
		
		// button
		driver.findElement(By.id("registerbtn")).click();
		Thread.sleep(2000);
		
		// hyperlink
		driver.findElement(By.linkText("Click here to navigate to the home page")).click();
		System.out.println("Done");
	}

}
