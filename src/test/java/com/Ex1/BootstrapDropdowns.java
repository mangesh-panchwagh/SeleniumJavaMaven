package com.Ex1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
Single selection dropdown link : https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1
Multi-selection dropdown link : https://www.jquery-az.com/boots/demo.php?ex=63.0_2 
*/
public class BootstrapDropdowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		// We have Select tag for traditional drop-downs, i.e. for normal drop-downs
		// Bootstrap is a toolkit which consists of CSS, javascript and HTML 
		// Bootstrap is used for responsive designing web pages
		// You can change the appearance of the control
		
//		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
//		driver.findElement(By.id("btnDropdownDemo")).click();
//		List<WebElement> optins = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu show')]/a"));
//		
//		for (WebElement option : optins) {
//			String optionText = option.getText();
////			if(optionText.equals("CSS")) {
////				option.click();
////				break;
////			}
//			System.out.println(optionText);
//			
//		}
//		driver.quit();
		
		// Multiselect drop down
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("https://www.jquery-az.com/boots/demo.php?ex=63.0_2"));
		
		
	}
}
