package Salesforce;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import readdata.Salesforce.Dashbaord_SF;

public class DeleteEdit_dashboard extends CommonClass{
	
	@Test(dataProvider="readdata")
	public void DeleteEdit(String dashboardtitle) throws InterruptedException {

		WebElement dashboard= driver.findElement(By.xpath("//span[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();",dashboard);

		//Edit_dashboard
		WebElement editicon = driver.findElement(By.xpath("//button[contains(@class,'icon-border slds-button_icon-x-small')]"));
		driver.executeScript("arguments[0].click();",editicon);
		driver.findElement(By.xpath("(//lightning-menu-item[@role='presentation']//a)[2]")).click();

		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);

		WebElement label=driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-has-divider_bottom']"));
		label.click();

		WebElement edit= driver.findElement(By.xpath("//input[@id='edit-dashboard-title']"));
		Thread.sleep(3000);
		edit.clear();
		edit.sendKeys(dashboardtitle);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral save']")).click();
		//driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[@class='slds-button doneEditing']")).click();

		String title = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
		System.out.println("Dasboard title="+ title);

		if(title.contains("Automation by mathi")) {System.out.println(">>>>>>>>>>Dashboard is edited successfully");}
		else {System.out.println(">>>>>>>>>>Dashboard is not edited");}

		Thread.sleep(3000);
		
		
		//Delete dashboard
		WebElement deleteicon = driver.findElement(By.xpath("//button[contains(@class,'icon-border-filled ignore-click')]"));
		driver.executeScript("arguments[0].click();",deleteicon);
		driver.findElement(By.xpath("(//ul//a[@role='menuitem'])[4]")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		
		driver.switchTo().defaultContent();
		String title1=driver.findElement(By.xpath("//div[@class='slds-hyphenate']//a")).getText();
		if(title1.contains(dashboardtitle)) {System.out.println("---------->>Dashboard is not deleted successfully<<");}
		else {System.out.println("---------->>Dashboard is deleted successfully");}
}
	@DataProvider(name="readdata")
	public String[][] data() throws IOException{
		return Dashbaord_SF.senddata_SF();
		
	}









}  
