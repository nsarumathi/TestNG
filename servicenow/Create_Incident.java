package servicenow;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Create_Incident extends CommonClass{
	@Test
	public  void incident() throws IOException, InterruptedException {
	
		
		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		
		WebElement all=dom.findElementByXPath("//div[text()='All']");
        all.click();
	
		Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		dom2.findElementByXPath("//mark[@class='filter-match']").click();
		
		
		WebElement iframe = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		WebElement create=driver.findElement(By.xpath("//button[text()='New']"));
		driver.executeScript("arguments[0].click();", create);
		
		driver.findElement(By.xpath("//input[@name='incident.short_description']")).sendKeys("Dell Printers Display");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		 Thread.sleep(5000);
		    //take screenshot
		    File Source=driver.getScreenshotAs(OutputType.FILE);
		    File Dest=new File(".//screenshots/incidentcreation.png");
		    FileUtils.copyFile(Source, Dest);
		
		
}}

