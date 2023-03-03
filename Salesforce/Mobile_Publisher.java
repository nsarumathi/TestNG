package Salesforce;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Mobile_Publisher {
	
	@Test
	public void window_Learn() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("saru.mathi@dell.com");
		driver.findElement(By.id("password")).sendKeys("Mathi@4321");
		driver.findElement(By.name("Login")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(handles);
		System.out.println("total windows opened=="+ list.size());
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("Title is==="+ driver.getTitle());
		driver.switchTo().window(list.get(0));
		
		
	}

}
