package SanpleHierachy;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Test1 {
  @Test
  public void TestA() {
	  System.out.println("          >>Executing Hiearchy of Annotation-Test1<<          ");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(" >>Test1--Before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(" >>Test1--After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(" >>Test1--Before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(" >>Test1--After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println(" >>Test1--Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(" >>Test1--After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println(" >>Test1--Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println(" >>Test1--After Suite");
  }
  
  @DataProvider
  public void data() {
	  System.out.println(" >>Test1--Providing data");
  }

}
