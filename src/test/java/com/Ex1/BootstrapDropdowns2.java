package com.Ex1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdowns2 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Print total options available in the drop-down and its number
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		WebElement dropDownBtn = driver.findElement(By.xpath("//button[contains(@class,'multiselect ')]"));
		dropDownBtn.click();
		int totalOptions =0;
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li[not(@class='multiselect-item multiselect-group')]/a/label"));
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			totalOptions ++;
			
		}
		
		System.out.println("Total number of options available = " + totalOptions);
		dropDownBtn.click();
		Thread.sleep(2000);
		
		// Select any three drop down option and count number of options selected
		System.out.println("==============");
		dropDownBtn.click();
		int SelectedCount = 0;
		for(WebElement option : options) {
			WebElement optionCheck = driver.findElement(By.tagName("input"));
			String optionsText = option.getText();
			if(optionsText.equals("HTML")) {
				option.click();
				SelectedCount ++;
			}
			if(optionsText.equals("Java")) {
				option.click();
				SelectedCount ++;
			}
			if(optionsText.equals("Angular")) {
				option.click();
				SelectedCount ++;
			}
		}
		System.out.println("Selected option count : " + SelectedCount);
		//dropDownBtn.click();
		Thread.sleep(2000);
		
		// Print selected options
		int selectedCount = 0;
		for(WebElement option : options) {
			WebElement optionClick = driver.findElement(By.tagName("input"));
			String optionsText = option.getText();
			if(optionsText.equals("C#")) {
				option.click();
			}if(optionsText.equals("HTML")) {
				option.click();
			}
			if(option.findElement(By.tagName("input")).isSelected()) {
				selectedCount++;
			}
		}
		System.out.println("Total number of selected items are : " + selectedCount);
		dropDownBtn.click();
		Thread.sleep(2000);
		
		System.out.println("=========================");
		// Select all drop-down option
		
		
	}
}
