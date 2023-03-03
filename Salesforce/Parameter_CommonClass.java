package Salesforce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import readdata.Salesforce.Readdata_SF;


public class Parameter_CommonClass {
	
	public 	ChromeOptions options;
	public ChromeDriver driver;
	String filename;
	
	
	@BeforeMethod
	public void precondtn() throws InterruptedException  {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
	    driver = new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("saru.mathi@dell.com");
		driver.findElement(By.id("password")).sendKeys("Mathi@4321");
		driver.findElement(By.name("Login")).click();
		
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//div[@role='combobox']//button")).click();
	   System.out.println("New screen url =="+driver.getCurrentUrl());
		Thread.sleep(3000);
		
	}
	@DataProvider(name="fetchdata")
	public String[][] senddata() throws IOException {
		return Readdata_SF.senddata_SF(filename);}
	
	@AfterMethod
	public void postcndtn() {
		driver.close();
	}
}
