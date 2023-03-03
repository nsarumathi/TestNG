package servicenow;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Order_Mobile extends CommonClass{
	
	@Test
	public  void Order_mobile() throws IOException, InterruptedException {
		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		WebElement all=dom.findElementByXPath("//div[text()='All']");
        all.click();
        
        Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);

		dom.findElementByXPath("//input[@id='filter']").sendKeys("Service catalog");
		dom2.findElementByXPath("//mark[@class='filter-match']").click();
		
		WebElement iframe = dom.findElementByXPath("////iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		
		driver.findElement(By.xpath("//table[@role='presentation']//div/a")).click();
		driver.findElement(By.xpath("((//td[@class='iotd'])[4]//label)[2]")).click();
		driver.findElement(By.xpath("((//td[@class='iotd'])[5]//label)[3]")).click();
		
		driver.findElement(By.xpath("(//div[@class='sc-radio']//label)[2]")).click();
		WebElement allowance = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select s=new Select(allowance);
		s.selectByValue("Unlimited");
		
		driver.findElement(By.id("oi_order_now_button")).click();
		
		String title=driver.getTitle();
		System.out.println("Title="+title);
		
		 Thread.sleep(5000);
		    //take screenshot
		    File Source=driver.getScreenshotAs(OutputType.FILE);
		    File Dest=new File(".//screenshots/mobile.png");
		    FileUtils.copyFile(Source, Dest);
			
}}


/*
4. Click on  mobiles
5.Select Apple iphone6s
6.Update color field to rose gold and storage field to 128GB
7.Select  Order now option
8.Verify order is placed and copy the request number"*/
