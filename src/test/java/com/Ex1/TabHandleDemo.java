package com.Ex1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// getWindowHandle() will return one window handle
// getWindowHandles() will returns the set of unique string value
// Set will allow only unique string values as it does not allows duplicates unlike Lists
// If you forgot to store parent window handles and you want to move to parent window, you can always
// get the first value of set (i.e. zeroth index value of set which is always a parent window handle value)
public class TabHandleDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window : " + parentWindowHandle);
		
		driver.findElement(By.id("newTabBtn")).click();
		Thread.sleep(5000);
		Set<String> AllWindowHandles = driver.getWindowHandles();
		
		for (String handle : AllWindowHandles) {
			System.out.println(handle);
			if(!handle.equals(parentWindowHandle)) {
				Thread.sleep(3000);
				driver.switchTo().window(handle);
				driver.findElement(By.id("alertBox")).click();
				Alert simpleAlert = driver.switchTo().alert();
				System.out.println("Simple Alert Text Message : " + simpleAlert.getText());
				Thread.sleep(2000);
				simpleAlert.accept();
				Thread.sleep(2000);
				System.out.println(driver.findElement(By.id("output")).getText());
			}	
		}
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.id("name")).sendKeys("Reddy");
		
		Thread.sleep(3000);
		
		
		
	}
}
