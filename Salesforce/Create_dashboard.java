package Salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Create_dashboard extends CommonClass {
	
	@Test
	public  void dashbaord() throws InterruptedException {
		
		
		WebElement dashboard= driver.findElement(By.xpath("//span[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();",dashboard);

		
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);
		
		WebElement name = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		name.sendKeys("Salesforce Automation by Saru");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='slds-button doneEditing']")).click();
		
     	 String title = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
		 System.out.println("Dasboard title="+ title);

		if(title.contains("Salesforce Automation by Saru")) {System.out.println("Dashboard is created successfully");}
		   else {System.out.println("Dashboard is not created");}
	   }}  
