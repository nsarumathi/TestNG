package Salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Key_deal extends CommonClass {
	
	@Test
	public void Deal() throws InterruptedException {
		
		
		//driver.executeScript("window.scrollBy(0,document.body.scrollHeight)");->bottom
		//executeScript("window.scrollBy(0,-350)", "");->scroll up
		//executeScript("window.scrollBy(0,350)", "");->scroll down
		
		WebElement deals = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
	    driver.executeScript("arguments[0].scrollIntoView();", deals);
		deals.click();

		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--reset')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search lists...']")).sendKeys("All Opportunities");
		driver.findElement(By.xpath("//mark[text()='All Opportunities']")).click();
		
		Thread.sleep(3000);
		WebElement newopp = driver.findElement(By.xpath("//div[@title='New']"));
        newopp.click();
        
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("New Opp");
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Type')]")).click();
		driver.findElement(By.xpath("//span[@title='New Customer']")).click();
		
		WebElement leadsrc = driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Source')]"));
		driver.executeScript("arguments[0].scrollIntoView();",leadsrc);
		leadsrc.click();	
		driver.findElement(By.xpath("(//button[@role='combobox']//span)[3]")).click();
	
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75000");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		driver.findElement(By.xpath("//button[@title='Next Month']//lightning-primitive-icon[1]")).click();
		driver.findElement(By.xpath("//span[text()='20']")).click();
	
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]")).click();
		driver.findElement(By.xpath("//span[text()='Needs Analysis']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		String pageSource = driver.getPageSource();
		if(pageSource.contains("view")) {System.out.println("New Opp is created successfully");}
		   else {System.out.println("new Opp is not created");}
	 
		
		
		
	   }}  
