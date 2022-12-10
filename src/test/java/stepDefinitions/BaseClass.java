package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;

	public LoginPage lp;
	public Properties configprop;

	// public static logger logger;

	// Created for generating random string for unique email
	/*
	 * public static String ramdomestring() {
	 * 
	 * String generatedString1 = StringUtils.randomStringUtils.randomALphabetic(5);
	 * return (generatedString1);
	 * 
	 * }
	 */

}
