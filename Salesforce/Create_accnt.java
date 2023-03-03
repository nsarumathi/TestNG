package Salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Create_accnt extends CommonClass {
	
	@Test
	public  void accnt() throws InterruptedException {
		
		
		WebElement acc = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",acc);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Mathi");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String acctitle = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		
		System.out.println("Accnt title is="+acctitle);
		if(acctitle.contains("Mathi")) {System.out.println("Accnt is created successfully");}
		   else {System.out.println("Accnt is not created");}
		
		String pageSource = driver.getPageSource();
		if(pageSource.contains("view")) {System.out.println("Accnt is created successfully");}
		   else {System.out.println("Accnt is not created");}
		
		
	   }}  
