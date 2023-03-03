package servicenow;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import readdata.Sericenow.ServiceNow_data;


public class ParameterCommonClass {
	
	public 	ChromeOptions options;
	public ChromeDriver driver;
	String filename;
	
	
	@BeforeMethod
	public void precondtn()  {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://dev37469.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("ZffB4^Q/2Opz");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		
	}
	@DataProvider(name="data to fetch")
	public String[][] data() throws IOException{
		return ServiceNow_data.senddata(filename);
	}
	

	@AfterMethod
	public void postcndtn() {
		driver.close();
	}
}
