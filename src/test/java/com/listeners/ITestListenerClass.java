package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener {

	// Run from testng.xml file. It will have result of Test runs : 4, Passes : 1, Failure : 2, Skips : 1
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}
}
