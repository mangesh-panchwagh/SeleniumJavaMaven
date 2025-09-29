package com.listeners;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerClass.class)
public class TestClass1 {

	@Test
	public void testMethod1() {
		System.out.println("I m inside test method 1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("I m inside test method 2");
		Assert.assertTrue(false);
	}
	
	@Test(timeOut = 1000)
	public void testMethod3() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("I m inside test method 3");
		
	}
	
	@Test(dependsOnMethods = "testMethod3")
	public void testMethod4() {
		//int a = 50;
		System.out.println("I m inside test method 4");
		//assertTrue (a<=10 , "The value of a is grater than 10");
	}
}
