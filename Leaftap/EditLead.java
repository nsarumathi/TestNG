package Leaftap;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import readdata.Leaftap.EditdataExcel;

public class EditLead extends ParanetrizedCommonClass {
	@Test(dataProvider="fetchdata" )
	public  void Edit(String cname) {

		driver.findElement(By.linkText("Edit")).click();
		System.out.println("Title page=="+ driver.getTitle());
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.name("submitButton")).click();
	}
	@DataProvider(name="fetchdata")
	public String[][] senddata() throws IOException {
		return EditdataExcel.readdata();}
}
