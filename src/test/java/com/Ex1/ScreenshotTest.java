package com.Ex1;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTest {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://www.w3schools.com/");
		Utils.captureScreenshot(driver, "Image1.png");
		driver.findElement(By.xpath("//a[@id='navbtn_exercises']")).click();
		Utils.captureScreenshot(driver, "Image2.png");
		/*
		 For capturing screenshot selenium is providing one interface namely TakeScreenshot
		 But we cannot create instance for interface. We can create instance for class but not for interface.
		 We are capturing screenshot of browser .
		 Browser instance is stored inside the driver. So driver is having browser instance. So we need to take help of
		 driver and TakeScreenshot combinelly. Then only we can capture the screenshot.
		 So to do so, we need to cast driver into TakeScreenshot 
		 */
		
	    //TakesScreenshot ts = (TakesScreenshot)driver;
		// OutputType has three types(FILE, BASE64 and BYTES)
		// This is capturing the screen shot and storing in temporary memory.
		// 1)
//		File file = ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File ("./Screenshots/Image1.png"));
		
		// 2) 
//		String base64Code = ts.getScreenshotAs(OutputType.BASE64); // This will return string value
		// Now we have image in the format of String. We need to convert this string into image For that use
		//FileOutputStream
		// convert BASE64 into Byte Array
//		byte[] byteArr = Base64.getDecoder().decode(base64Code);
//		FileOutputStream fos = new FileOutputStream(new File("./Screenshots/Image2.jpg"));
//		fos.write(byteArr);
//		fos.close();
		
//		byte[] byteArr = ts.getScreenshotAs(OutputType.BYTES);
//		FileOutputStream fos = new FileOutputStream(new File("./Screenshots/Image3.jpeg"));
//		fos.write(byteArr);
//		fos.close();
		
		driver.quit();
	}

}
