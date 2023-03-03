package Leaftap;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import readdata.Leaftap.DynamicDatafromExcel;


public class TestNG_Common {

	public  ChromeDriver driver;
	String filename;
	
	@BeforeMethod
	public void precondtn()  {
		driver=new ChromeDriver();
		System.out.println(driver);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();	
	}
	
	@DataProvider(name="fetchdata")
	public String[][] senddata() throws IOException {
		return DynamicDatafromExcel.readdata(filename);}
		
		
		
   @AfterMethod
   public void postcondtn() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.close();
	}
}
