package servicenow;


import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Update_Resolve_Incident extends CommonClass {
	@Test
	public void Update_Resolve() throws IOException, InterruptedException {
	

		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(50);
		WebElement all=dom.findElementByXPath("//div[text()='All']");
		all.click();

		Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		dom2.findElementByXPath("//mark[@class='filter-match']").click();


		WebElement iframe = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);

		//Update incident
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String no_actv = driver.findElement(By.xpath("//div[@class='activity-stream-label-counter']")).getText();
		System.out.println("No of activities==>"+no_actv);
		List<WebElement> activities = driver.findElements(By.xpath("//span[@class='sn-widget-list-table-cell']"));
		System.out.println(">>>>>>Activities bfr Updation<<<<<");
		for(WebElement activity:activities) {
			String info=activity.getText();
			System.out.println(info);
		}

		Select option1=new Select(driver.findElement(By.id("incident.urgency")));
		option1.selectByVisibleText("1 - High");

		Select option2=new Select(driver.findElement(By.id("incident.state")));
		option2.selectByVisibleText("Resolved");

		driver.findElement(By.xpath("//button[text()='Update']")).click();

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		String no_actv1 = driver.findElement(By.xpath("//div[@class='activity-stream-label-counter']")).getText();
		System.out.println("No of activities==>"+no_actv1);
		List<WebElement> activities2 = driver.findElements(By.xpath("//span[@class='sn-widget-list-table-cell']"));
		System.out.println(">>>>>Activities aftr Updation<<<<<<<<<");
		for(WebElement activity:activities2) {
			String info=activity.getText();
			System.out.println(info);
		}

		driver.findElement(By.xpath("//button[text()='Update']")).click();

		//resolve incident
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[2]")).click();


		List<WebElement> activities_1 = driver.findElements(By.xpath("//span[@class='sn-widget-list-table-cell']"));
		System.out.println(">>>>>>>Activities bfr  Resolve Updation<<<<<<");
		for(WebElement activity:activities_1) {
			String info=activity.getText();
			System.out.println(info);
		}

		Select dd=new Select(driver.findElement(By.id("incident.state")));
		dd.selectByVisibleText("Resolved");

		driver.findElement(By.xpath("//button[text()='Update']")).click();

		driver.findElement(By.xpath("(//a[@class='linked formlink'])[2]")).click();


		List<WebElement> activities_2 = driver.findElements(By.xpath("//span[@class='sn-widget-list-table-cell']"));
		System.out.println(">>>>>>Activities aftr Resolve Updation<<<<<<<");
		for(WebElement activity:activities_2) {
			String info=activity.getText();
			System.out.println(info);}



	}}

