package com.qa.auto.testHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigSettings {
	public static String getWebUrl() {
		return webUrl;
	}

	public static void setWebUrl(String webUrl) {
		ConfigSettings.webUrl = webUrl;
	}

	public static String getWebBrowser() {
		return webBrowser;
	}

	public static void setWebBrowser(String webBrowser) {
		ConfigSettings.webBrowser = webBrowser;
	}

	private static String webUrl;
	private static String webBrowser;
	private static String email;
	private static String password;
	private static String reviewContent;

	public void getConfigSettings() throws IOException {

		Properties property = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		property.load(inputStream);

		setWebUrl(property.getProperty("webUrl"));
		setWebBrowser(property.getProperty("webBrowser"));
		setEmailId(property.getProperty("Email"));
		setPassword(property.getProperty("Password"));
		setReviewContent(property.getProperty("ReviewContent"));

		IoLibrary.writeLine("Test Config Settings");
		System.out.println(String.format("WebUrl: %s", getWebUrl()));
		System.out.println(String.format("WebBrowser: %s", getWebBrowser()));
		System.out.println(String.format("Email: %s", getEmailId()));
		System.out.println(String.format("Password: %s", "SECRET"));
		System.out.println(String.format("Review Content: %s", getReviewContent()));
		IoLibrary.writelineEnd();
	}

	public static String getEmailId() {
		return ConfigSettings.email;
	}

	public static void setEmailId(String emailId) {
		ConfigSettings.email = emailId;
	}

	public static String getPassword() {
		return ConfigSettings.password;
	}

	public static void setPassword(String pwd) {
		ConfigSettings.password = pwd;
	}

	public static String getReviewContent() {
		return ConfigSettings.reviewContent;
	}

	public static void setReviewContent(String content) {
		ConfigSettings.reviewContent = content;
	}
}
