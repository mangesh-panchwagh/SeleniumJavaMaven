package com.Ex1;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopups {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentsetting = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		
		
		contentsetting.put("notification", 0);
		profile.put("managed_defaul_content_setting", contentsetting);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriverManager.chromedriver().setup();
		
		options.addArguments("disable-notifications");
//		options.addArguments("disable-geolocation");
//		options.addArguments("disable-media-stream");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.cleartrip.com/");

	}

}
