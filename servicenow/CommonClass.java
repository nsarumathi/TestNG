package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class CommonClass {
	
	public 	ChromeOptions options;
	public ChromeDriver driver;
	
	
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

	@AfterMethod
	public void postcndtn() {
		driver.close();
	}
}
