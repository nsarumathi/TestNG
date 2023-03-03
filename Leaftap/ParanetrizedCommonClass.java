package Leaftap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ParanetrizedCommonClass {
	
	RemoteWebDriver driver;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void precondtn( String browser,String url,String username,String password  ) throws InterruptedException  {
		
		if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();}
		else if(browser.equalsIgnoreCase("edge")){
		driver=new EdgeDriver();	}
		//System.out.println(driver);
		//System.out.println(Thread.currentThread().getId());
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
 @AfterMethod
   public void postcondtn() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.close();
	}
}


