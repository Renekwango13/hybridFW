package com.FWUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pr;
	
	public ReadConfig()
	{
	pr = new Properties();
	File fl = new File("./Configuration/conf.properties");
	
	try {
		FileInputStream fs = new FileInputStream(fl);
		pr.load(fs);
	}catch(Throwable t) {
		System.out.println("Throwable message is"+t.getMessage());
		}
	}
	public String getApplicationUrl() {
		String url=pr.getProperty("url");
		return url;
		}
	public String getBrowser() {
		String browser=pr.getProperty("browserName");
		return browser;
		}
	public String getValidUsernam() {
		String username=pr.getProperty("ValidEmail");
		return username;
		}
	public String getValidPassworld() {
		String password=pr.getProperty("validPass");
		return password;
		}
}