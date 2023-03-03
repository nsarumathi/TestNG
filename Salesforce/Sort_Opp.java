package Salesforce;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Sort_Opp extends CommonClass {
	@Test
	public  void sorting() throws InterruptedException, IOException {
		
		WebElement Opp=driver.findElement(By.xpath("//a/span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();",Opp);
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--reset')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search lists...']")).sendKeys("All Opportunities");
		driver.findElement(By.xpath("//mark[text()='All Opportunities']")).click();
		
		Thread.sleep(5000);
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dest1=new File(".//snap/assignment/bfrascendingorder.png");
		FileUtils.copyFile(src1, dest1);
		
		
		WebElement sort = driver.findElement(By.xpath("//a[@class='toggle slds-th__action slds-text-link--reset ']"));
		driver.executeScript("arguments[0].click();",sort);
		
		Thread.sleep(5000);
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File(".//snap/assignment/ascendingorder.png");
		FileUtils.copyFile(src, dest);
		
	   }}  
