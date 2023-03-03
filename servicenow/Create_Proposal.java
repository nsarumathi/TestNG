package servicenow;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Create_Proposal extends ParameterCommonClass{
	
	@BeforeTest
	public void setdata() {
		filename="Proposal_SN";
	}
	
	
	@Test(dataProvider="data to fetch")
	public void Crete_Newproposal(String description) throws IOException, InterruptedException {

		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		WebElement all=dom.findElementByXPath("//div[text()='All']");
        all.click();
        
        Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);
	
		dom.findElementByXPath("//input[@id='filter']").sendKeys("My Proposal");
		dom2.findElementByXPath("//mark[@class='filter-match']").click();
		
		WebElement iframe = dom.findElementByXPath("////iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		WebElement create=driver.findElement(By.xpath("//button[text()='New']"));
		driver.executeScript("arguments[0].click();", create);
		
		WebElement template = driver.findElement(By.xpath("//input[@aria-label='Template description']"));
		template.sendKeys(description);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		 Thread.sleep(5000);
		    //take screenshot
		    File Source=driver.getScreenshotAs(OutputType.FILE);
		    File Dest=new File(".//screenshots/proposal.png");
		    FileUtils.copyFile(Source, Dest);
			
}}

