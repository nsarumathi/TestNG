package Salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Opportunities extends CommonClass {

	@Test
	public void Create_NewOpportunity() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//div[@role='combobox']//button")).click();
	   System.out.println("New screen url =="+driver.getCurrentUrl());
		Thread.sleep(3000);
		
		WebElement App=driver.findElement(By.xpath("//span/p[text()='Sales']"));
		driver.executeScript("arguments[0].click();",App);
		WebElement Opp=driver.findElement(By.xpath("//a/span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();",Opp);
		driver.findElement(By.xpath("//a/div[text()='New']")).click();
		
		WebElement A=driver.findElement(By.xpath("//input[@name='Name']"));
		driver.executeScript("arguments[0].value='Salesforce Automation by Saru';", A);
		String title=A.getAttribute("value");
		System.out.println("Oppurtinity name entered(title)=="+title);
		
		WebElement Calendar=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		Calendar.sendKeys("12/14/2022");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div//button[@role='combobox']")).click();
		driver.findElement(By.xpath("(//span[@class='slds-media__body'])[4]/span")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("title=="+driver.getTitle());
		WebElement check = driver.findElement(By.xpath("//div[@class='slds-media__body']//lightning-formatted-text"));
		String final1=check.getText();
		System.out.println("Oppurtinity name saved(final1)="+final1);
		
	   if(title.equals(final1)) {System.out.println("Opp name is saved is same as entered is confirmed");}
	   else {System.out.println("opp name saved is not same as entered");}
	   
	}
}
