package com.Ex1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemoNested {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.id("name")).sendKeys("Hello");	// main web page
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("frm3")));

		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		
		Select coursedropdown = new Select(driver.findElement(By.id("course")));
		coursedropdown.selectByVisibleText("Java");
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("frame3");	// Frame 3
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("main webpage");	// main web page
	}
}
