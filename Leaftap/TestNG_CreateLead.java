package Leaftap;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_CreateLead extends TestNG_Common{
	
	@BeforeTest
	public void setData() {
		filename="CreateLead";}
	
	
	@Test(dataProvider="fetchdata" )
	public void create( String cname, String fname,String lname)  {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();
	}

}
