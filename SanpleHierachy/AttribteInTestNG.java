package SanpleHierachy;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AttribteInTestNG {
	
	@Test(dependsOnMethods={"duplicate"},alwaysRun =false)
	public void m1() {
		System.out.println("m1 method will not run(skipped) if it depends on a method(duplicate) is failed");}
	
	@Test(priority=1,invocationCount=4,threadPoolSize=3)
	public void catgry() {
		System.out.println("method(categry)is executed with priority-1 for 4 times inbtw 3 fields");}
	
	@Ignore
	@Test
	public void merge() {
		System.out.println("merge method will totally skipped itself");}
	
	@Test(enabled=true)//if it is false,this method will skipped
	public void duplicate() {
		throw new RuntimeException();} //throw exception to understand concept 
	
	@Test(priority=0)
	public void fruit()  {
		System.out.println("method(fruits)is executed with priority-0 ");}
	
	@Test(dependsOnMethods={"duplicate"},alwaysRun =true)
	public void veg() {
		System.out.println("method(veg) will always run even if it depends on method(duplicate) failed");}
	
	@Test
	public void name() {
		System.out.println("method(name) is executed without priority");}
	
	@Test(invocationCount=2,threadPoolSize=1,invocationTimeOut=200)
	public void type() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("method(type)is executed for 2 times in 1 field within timeseconds 200" );}
	
	@Test(priority=-3)
	public void vegcatgry()  {
		System.out.println(" veg catgry method is executed with priority-(-3)");}
	
	@Test(priority=-5)
	public void foodcatgry()  {
		System.out.println("foodcatgry method is executed with priority-(-5) ");}

}
