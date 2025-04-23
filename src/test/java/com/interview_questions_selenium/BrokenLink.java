package com.interview_questions_selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Broken link is a link that is not accessible on website.
// Those links shows error pages 
// Page might be removed from web site or moved the location.
// href attribute stores the link address where you have to navigate

public class BrokenLink {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com");
		Thread.sleep(2000);
		
		Set<String> brokenLinkUrls = new HashSet<String>();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (WebElement link : links) {
			String linkURL = link.getAttribute("href");
			URL url = new URL(linkURL);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
		
			if(httpURLConnection.getResponseCode() != 200 ) {
				
				brokenLinkUrls.add(linkURL);
			}

			
			httpURLConnection.disconnect();
			
		}
		driver.quit();
		for (String brokenLinkUrl : brokenLinkUrls) {
			System.out.println(brokenLinkUrl);
		}
	}
	
}
