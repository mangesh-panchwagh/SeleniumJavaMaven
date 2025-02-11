package com.Ex1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownsMultiSelect {

public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		WebElement courseNameElement = driver.findElement(By.id("course"));
		Select select = new Select(courseNameElement);
		
		select.selectByIndex(1);
		// Multiple selection
		
		WebElement multiSelectDropdown = driver.findElement(By.id("ide"));
		//System.out.println(multiSelectDropdown.getText());
		Select multiSelect = new Select(multiSelectDropdown);
		
		multiSelect.selectByIndex(0);
		Thread.sleep(2000);
		
		multiSelect.selectByValue("ij");
		Thread.sleep(2000);
		
		multiSelect.selectByVisibleText("NetBeans");
		Thread.sleep(2000);
		
		// de-select
//		multiSelect.deselectByIndex(0);
//		Thread.sleep(2000);
//		
//		multiSelect.deselectByValue("ij");
//		Thread.sleep(2000);
//		
//		multiSelect.deselectByVisibleText("NetBeans");
//		Thread.sleep(2000);
		List<WebElement> coursesAvailable = select.getOptions();
		System.out.println("Courses availabl");
		for (WebElement webElement : coursesAvailable) {
			System.out.println(webElement.getText());
		}
		
		System.out.println();
		
		List<WebElement> multiSelectdd = multiSelect.getAllSelectedOptions();
		System.out.println("multiSelectdd");
		for (WebElement webElement : multiSelectdd) {
			System.out.println(webElement.getText());
		}
		
		System.out.println();
		System.out.println("SelectedOption");
		System.out.println(select.getFirstSelectedOption().getText());
		
	}
}
