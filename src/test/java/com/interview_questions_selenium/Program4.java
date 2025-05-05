package com.interview_questions_selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		verifyBrokenImagesUsingSelenium();
		
	}
	
	public static void verifyBrokenImagesUsingSelenium() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		
		for (WebElement image : images) {
			@SuppressWarnings("deprecation")
			String imgSrc = image.getAttribute("src");
			try {
				
				URL url = new URL(imgSrc);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.connect();
				
				if(httpURLConnection.getResponseCode() == 200)
					System.out.println(imgSrc + " - " + httpURLConnection.getResponseMessage() + " - " +httpURLConnection.getResponseMessage());
				else
					System.err.println(imgSrc + " - " + httpURLConnection.getResponseMessage()+ " - " +httpURLConnection.getResponseMessage());
				
			
				httpURLConnection.disconnect();
			} catch (Exception e) {
				System.err.println(imgSrc);
			}
		}
		
	}

}
