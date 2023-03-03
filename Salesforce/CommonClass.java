package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class CommonClass {
	
	public 	ChromeOptions options;
	public ChromeDriver driver;
	
	
	@BeforeMethod
	public void precondtn()  {
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
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
	   System.out.println("New screen url =="+driver.getCurrentUrl());
	   
	   WebElement App=driver.findElement(By.xpath("//span/p[text()='Sales']"));
		driver.executeScript("arguments[0].click();",App);
		
	}

	@AfterMethod
	public void postcndtn() {
		driver.close();
	}
}
