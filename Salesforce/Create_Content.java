package Salesforce;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Create_Content extends Parameter_CommonClass {
	@BeforeTest
	public void setData() {
		filename="Content_SF";}

	@Test(dataProvider="fetchdata")
	public void Content(String qn,String details) throws InterruptedException {


		WebElement all = driver.findElement(By.xpath("//input[@class='slds-input']"));
		driver.executeScript("arguments[0].value='Content';",all);
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

		WebElement chatter = driver.findElement(By.xpath("//a[@title='Chatter']"));
		driver.executeScript("arguments[0].click();",chatter);
		driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();

		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(qn);

		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(details);

		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();

		List<WebElement> fulldetails = driver.findElements(By.xpath("//span[@class='uiOutputText']"));
		System.out.println(">>Questioner details<<");
		for(WebElement d2:fulldetails) {
			String check=d2.getText();
			System.out.println(check);}

		String Qn_posted = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		if (Qn_posted.contains(qn)) {System.out.println(">>>>>>>>>>>>Check::question is succesfully is posted");}
		else {System.out.println("question is not posted"); }}
	}
