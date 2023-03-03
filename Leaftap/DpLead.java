package Leaftap;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import readdata.Leaftap.DplicateDataExcel;

public class DpLead extends CommonClass {
	@Test(dataProvider="fetchdata" )
	public  void dp(String cname,String fname) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();	
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		System.out.println("Title page=="+ driver.getTitle());
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);

		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);

		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

		System.out.println(driver.getTitle());

	}

	@DataProvider(name="fetchdata")
	public String[][] senddata() throws IOException {
		return DplicateDataExcel.readdata();}
}
