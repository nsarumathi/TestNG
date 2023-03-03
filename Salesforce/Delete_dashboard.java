package Salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Delete_dashboard extends CommonClass{
	
	@Test
	public void DeleteEdit(String dashboardtitle) throws InterruptedException {

		WebElement dashboard= driver.findElement(By.xpath("//span[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();",dashboard);
		
		WebElement label=driver.findElement(By.xpath("//div[@class='slds-hyphenate']//a"));
		String namebfrdeletion = label.getText();

		
		WebElement icon = driver.findElement(By.xpath("//button[contains(@class,'icon-border slds-button_icon-x-small')]"));
		driver.executeScript("arguments[0].click();",icon);
		driver.findElement(By.xpath("(//lightning-menu-item[@role='presentation']//a)[4]")).click();
		
		driver.findElement(By.xpath("//button/span[text()='Delete']")).click();

		WebElement aftrlabel=driver.findElement(By.xpath("//div[@class='slds-hyphenate']//a"));
		String nameaftrdeletion = aftrlabel.getText();
		if(namebfrdeletion.contains(nameaftrdeletion)) {System.out.println("---------->>Dashboard is not deleted successfully<<");}
		else {System.out.println("---------->>Dashboard is deleted successfully");}



	}}  
