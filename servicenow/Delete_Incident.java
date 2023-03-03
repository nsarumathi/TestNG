package servicenow;


import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Delete_Incident extends CommonClass {
	@Test
	public void Delete() throws IOException, InterruptedException {
		
		
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
		
		WebElement incident1 = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		String bfrid = incident1.getText();
	    System.out.println("ID bfr deletion =>"+ bfrid);

		incident1.click();
	    
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();

		WebElement incident = driver.findElement(By.xpath("//a[@class='linked formlink']"));
	    String aftrid = incident.getText();
	    System.out.println("ID aftr deletion =>"+ aftrid);
	    
	    if(bfrid.contains(aftrid)) {System.out.println(">>Incident is not deleted");}
	    else {System.out.println(">>Incident is deleted");}

		
		
}}

