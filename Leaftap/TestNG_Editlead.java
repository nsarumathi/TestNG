package Leaftap;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Editlead extends TestNG_Common {
	@BeforeTest
	public void setData() {
		filename="EditLead";}
	
@Test(dataProvider="fetchdata" )
	public  void Edit(String cname) throws InterruptedException {
	
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Edit")).click();
	System.out.println("Title page=="+ driver.getTitle());
	driver.findElement(By.id("updateLeadForm_companyName")).clear();
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
	driver.findElement(By.name("submitButton")).click();
		
}}


