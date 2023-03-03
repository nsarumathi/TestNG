package servicenow;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Change_Proposal extends CommonClass {
	@Test
	public void Proposal() throws IOException, InterruptedException {
		
		
		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		Thread.sleep(2000);
		WebElement all = dom.findElementByXPath("//div[text()='All']");
		all.click();
	
		Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("My Proposal");
		dom2.findElementByXPath("//mark[@class='filter-match']").click();
		
		WebElement iframe = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement template = driver.findElement(By.xpath("//input[@aria-label='Template description']"));
		template.sendKeys("Sample-TestNG");
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();

		Thread.sleep(5000);
		    //take screenshot
		    File Source=driver.getScreenshotAs(OutputType.FILE);
		    File Dest=new File(".//screenshots/changeproposal.png");
		    FileUtils.copyFile(Source, Dest);
			
}}

