package servicenow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Create_article extends CommonClass {
	
	@Test
	public void Knowledge_fields() throws InterruptedException, IOException {
		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		WebElement all=dom.findElementByXPath("//div[text()='All']");
        all.click();
        
        Shadow dom2=new Shadow(driver); 
		dom2.setImplicitWait(10);
	
		Thread.sleep(2000);
		WebElement caller=dom.findElementByXPath("//input[@id='filter']");
		caller.sendKeys("Knowledge");
		dom2.findElementByXPath("//mark[text()='Knowledge']").click();
		
		String bfr = driver.getTitle();
		System.out.println("Before creating article Title==" + bfr);
		
		WebElement iframe = dom2.findElementByXPath("////iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		WebElement create=driver.findElement(By.xpath("//button[@type='button']"));
		driver.executeScript("arguments[0].click();", create);
		
		System.out.println("Before Title==" +driver.getTitle());
		driver.findElement(By.xpath("//button[@data-type='ac_reference_input']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(1));
		System.out.println("After Knowledge base==" +driver.getTitle());
		driver.findElement(By.xpath("//table/tbody//tr/td[3]/a")).click();
		driver.switchTo().window(list.get(0));
		driver.switchTo().frame(iframe);
		WebElement catgry=driver.findElement(By.xpath("(//span[@class='input-group-btn']/button)[2]"));
		driver.executeScript("arguments[0].click();", catgry);
		driver.findElement(By.xpath("//div[@class='top column']/div[4]")).click();
		driver.findElement(By.xpath("//div[@class='column']/div[4]")).click();
		
		driver.findElement(By.id("ok_button")).click();
		WebElement description = driver.findElement(By.id("kb_knowledge.short_description"));
		description.sendKeys("Java is a Case-Sensitive lang");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String aftr = driver.getTitle();
		System.out.println("After creating article Title==" + aftr);
		
		driver.switchTo().defaultContent();
		
	    dom.findElementByXPath("//div[text()='All']").click();
	    dom.findElementByXPath("//input[@id='filter']").clear();
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge Articles");
		dom2.findElementByXPath("//mark[text()='Knowledge Articles']").click();
		

	    Thread.sleep(5000);
	    //take screenshot
	    File Source=driver.getScreenshotAs(OutputType.FILE);
	    File Dest=new File(".//screenshots/article.png");
	    FileUtils.copyFile(Source, Dest);
		
	}}
