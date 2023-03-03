package servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Create_Caller extends ParameterCommonClass {
	
	@BeforeTest
	public void setdata() {
		filename="Caller_SN";
	}
	
	@Test(dataProvider="data to fetch")
	public void Create_newcaller(String lname,String title,String phone,String bphone) throws InterruptedException {
		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		WebElement all=dom.findElementByXPath("//div[text()='All']");
        all.click();
        
        Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);

		WebElement caller=dom.findElementByXPath("//input[@id='filter']");
		caller.sendKeys("Callers");
		
		dom2.findElementByXPath("//mark[text()='Callers']").click();
		WebElement iframe = dom2.findElementByXPath("////iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		WebElement firstname=driver.findElement(By.xpath("//input[@id='sys_user.first_name']"));
		firstname.sendKeys("Abin");
		String create=firstname.getAttribute("value");
		System.out.println("Name to create=="+ create);
		
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys(title);
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys(phone);
		driver.findElement(By.id("sys_user.phone")).sendKeys(bphone);
	    driver.findElement(By.id("sys_user.email")).sendKeys("admin@example.com");
	    
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    WebElement select=driver.findElement(By.xpath("//select[@role='listbox']"));
	    Select s=new Select(select);
	    s.selectByVisibleText("First name");
	    
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("abin",Keys.ENTER);
	    String created = driver.findElement(By.xpath("//table//tr[1]/td[4]")).getText();
	    System.out.println("Name created=="+ created);
	    if(create.equals(created)) {
	    	System.out.println("New caller is sucessfully created");}
	    else {System.out.println("New caller is not created");}
	    
	}

}
