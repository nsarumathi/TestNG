package Salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Create_Individual extends Parameter_CommonClass {
	
	@BeforeTest
	public void setData() {
		filename="Indiv_SF";}
	
	@Test(dataProvider="fetchdata")
	public void Individual(String name) throws InterruptedException {
		
		
	   WebElement all = driver.findElement(By.xpath("//input[@class='slds-input']"));
	   driver.executeScript("arguments[0].value='individual';",all);
	   driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
	   
	   driver.findElement(By.xpath("//div[@title='New']")).click();
	   driver.findElement(By.xpath("//div[@class='uiPopupTrigger']")).click();
	   driver.findElement(By.xpath("(//a[@role='menuitemradio'])[3]")).click();
	   
	   driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(name);
	   driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	   
	   String title = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
	   System.out.println("individ title="+title);
	   if(title.contains(name)) {System.out.println("Individual is created successfully");}
	   else {System.out.println("Individual is not created");}
	   }
	   

	   }
