package Leaftap;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class CreateContact extends CommonClass {
	
	@Test
	public  void create_contact() {
	
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
	
	WebElement Name=driver.findElement(By.xpath("//input[@id='firstNameField']"));
	Name.sendKeys("saru");
	System.out.println(Name.getAttribute("value"));
	
	driver.findElement(By.xpath("(//input[contains(@name,'last')])[3]")).sendKeys("mathi");
	driver.findElement(By.name("submitButton")).click();
	
	System.out.println(driver);
	driver.close();

}}
