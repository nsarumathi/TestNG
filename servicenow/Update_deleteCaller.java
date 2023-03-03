package servicenow;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Update_deleteCaller extends CommonClass{
	@Test
	public void  Update_delete() throws InterruptedException {

		
		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		WebElement all=dom.findElementByXPath("//div[text()='All']");
        all.click();
	
		Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);
		WebElement caller=dom.findElementByXPath("//input[@id='filter']");
		caller.sendKeys("Callers");
		
		dom2.findElementByXPath("//mark[text()='Callers']").click();
		Shadow dom3=new Shadow(driver); 
		dom3.setImplicitWait(10);
		
		WebElement frame =dom3.findElementByXPath("//iframe[@title='Main Content']");
	    driver.switchTo().frame(frame);
		
		
		//Update caller
		WebElement first_change = dom3.findElementByXPath("//a[@class='linked formlink']");	
		String phone_bfrUpd = driver.findElement(By.xpath("(//tr[@data-type='list2_row'])[1]/td[5]")).getText();
		first_change.click();
		
		Thread.sleep(3000);
	    driver.findElement(By.id("sys_user.phone")).sendKeys("+456 987654032");
		driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
		
		String phone_aftrUpd = driver.findElement(By.xpath("(//tr[@data-type='list2_row'])[1]/td[5]")).getText();
		if(phone_bfrUpd.contains(phone_aftrUpd)) {System.out.println(">>>>>user is not Updated");}
		else {System.out.println(">>>>>.user is Updated sucessfully");}
		
		//Delete caller
		WebElement first_delete = dom3.findElementByXPath("//a[@class='linked formlink']");
		String name1=first_delete.getText();
		System.out.println("name_bfrdeletion="+name1);
		first_delete.click();
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		WebElement aftr_delete = dom3.findElementByXPath("//a[@class='linked formlink']");
		String name2=aftr_delete.getText();
		System.out.println("name_aftr deletion="+name2);
		
		if(name1.contains(name2)) {System.out.println(">>>...user is not deleted");}
		else {System.out.println(">>>>>user is deleted  sucessfully");}

}}
