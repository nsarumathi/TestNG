package Leaftap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead_Data extends CommonClass  {
	@Test(dataProvider="data to fetch", priority=1 )
	public void create( String cname, String fname,String lname,String phno)  {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();	
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
	}
	@DataProvider(name="data to fetch")
		
	public String[][] data(){
		String[][] a=new String[3][4];
		a[0][0]="Tcs";
		a[0][1]="abi";
		a[0][2]="r";
		a[0][3]="99";
		
		a[1][0]="cts";
		a[1][1]="bala";
		a[1][2]="r";
		a[1][3]="01";
		
		a[2][0]="Dell";
		a[2][1]="Rose";
		a[2][2]="r";
		a[2][3]="044";
		 
		return a;}
	
	@Test(priority=0)
	public void m() {
		System.out.println("method is printed");
	}

}
