package com.Ex1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// select all option from drop-down
public class BootstrapDropdowns3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Print total options available in the drop-down and its number
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		WebElement dropDownBtn = driver.findElement(By.xpath("//button[contains(@class,'multiselect ')]"));
		dropDownBtn.click();
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li[not(@class='multiselect-item multiselect-group')]/a/label"));
		
		// Select all options
		for(WebElement option:options) {
			WebElement optionClick = driver.findElement(By.tagName("input"));
			String optionsText = option.getText();
			
			option.click();
			
			/*
			if(optionsText.equals("jQuery")) {
				option.click();
				AllSelectedOption++;
			}if(optionsText.equals("Bootstrap")) {
				option.click();
				AllSelectedOption++;
			}
			if(optionsText.equals("Python")) {
				option.click();
				AllSelectedOption++;
			}if(optionsText.equals("MySQL")) {
				option.click();
				AllSelectedOption++;
			}
			if(optionsText.equals("Oracle")) {
				option.click();
				AllSelectedOption++;
			}if(optionsText.equals("MS SQL Server")) {
				option.click();
				AllSelectedOption++;
			}
			if(optionsText.equals("C#")) {
				option.click();
				AllSelectedOption++;
			}if(optionsText.equals("Java")) {
				option.click();
				AllSelectedOption++;
			}
			if(optionsText.equals("Angular")) {
				option.click();
				AllSelectedOption++;
			}if(optionsText.equals("CSS")) {
				option.click();
				AllSelectedOption++;
			}
			if(optionsText.equals("HTML")) {
				option.click();
				AllSelectedOption++;
			}
			*/
		}
		
		// De-select all options
		for(WebElement option:options) {
			WebElement optionClick = driver.findElement(By.tagName("input"));
			option.click();
		}
		
	}
}
