package com.interview_questions_selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Broken links : Broken link is a link on web site that is no longer accessible or that is no longer exists
// Get all the links, iterate over each link and verify link is valid or broken


public class Program3 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.eddymens.com/blog/page-with-broken-pages-for-testing-53049e870421/");
		Thread.sleep(2000);
		
		Set<String> brokenLinkUrls = new HashSet<String>();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total link count : " + links.size());
		
		// Check each link
		for (WebElement link : links) {
			String linkURL = link.getAttribute("href");
			// validate url
			URL url = new URL(linkURL);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection; 
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			
			// if response code is 200 then it is a valid url, other than 200 it is a invalid url
			if(httpURLConnection.getResponseCode() != 200)	
			{
				brokenLinkUrls.add(linkURL);
			}
//				System.out.println(linkURL + " - " + " - " + httpURLConnection.getResponseMessage());
//			else
//				System.err.println(linkURL + " - " + " - " + httpURLConnection.getResponseMessage());
			
			httpURLConnection.disconnect();
		}
		
		driver.quit();
		for (String brokenLinkURL : brokenLinkUrls) {
			System.err.println(brokenLinkURL);
		}
	}
}
