package com.Ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeAutomationMessage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
//		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
//		options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
//		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		List<String> eSwitches = new ArrayList<>();
		eSwitches.add("enable-automation");
		options.setExperimentalOption("excludeSwitches", eSwitches);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		
	}
}
