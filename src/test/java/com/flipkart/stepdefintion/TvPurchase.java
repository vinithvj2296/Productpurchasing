package com.flipkart.stepdefintion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TvPurchase {
	public static  WebDriver driver;

	@BeforeClass
	
	public static void  openBrow() throws InterruptedException{
		System.out.println("launch");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinit\\workspace\\Junit-maven\\driver\\chromedriver.exe");
		
		   driver=new ChromeDriver();
		 driver.navigate().to("https://www.flipkart.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		
	}
	 @AfterClass
	   public static void closebrow(){
		   System.out.println("closing brow");
		   
		  
	   }
	 
	   @Before
	   public void starttime(){
		    long start= System.currentTimeMillis();
		    System.out.println(start);
	   }
	   @After
	   public void endtime(){
		   long end=  System.currentTimeMillis();
		   System.out.println(end);
		  
	   }
	   @Test
     public void method1() throws InterruptedException 
	   {
		   System.out.println("login");
		   
			  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7904264799");
			 
			WebElement pass=  driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
			  pass.sendKeys("Vin846484");
		     driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
		  // WebElement out=   driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			//out.click();

     }
	   	@Test
	   public void method2() 
			   throws InterruptedException, IOException{
		   System.out.println("search");
		   
		   driver.findElement(By.name("q")).sendKeys("sony tv");
		   driver.findElement(By.xpath("//*[@type='submit']")).click();
		   Thread.sleep(2000);
		    
           File s= new File("C:\\Users\\vinit\\OneDrive\\Documents\\sampleexl.xlsx");
     	  
         	  FileOutputStream m = new FileOutputStream(s);
     	  Workbook F= new XSSFWorkbook();
     	  Sheet r= F.createSheet("TV LIST");
     	List<WebElement> tdata=  driver.findElements(By.xpath("//*[contains(text(),'SONY')]"));
         
        for(int i=1; i<tdata.size();i++){
       WebElement adata=  tdata.get(i);
       String print=adata.getText();
     	  Row t= r.createRow(i);
     	  Cell y= t.createCell(0);
     	  y.setCellValue(print);}
    
     	  F.write(m);
         F.close();  
           
			
			
	   }
	    
	   @Test
	   public void method3()throws InterruptedException{
		   System.out.println("windowhandle");
		   driver.findElement(By.xpath("//*[contains(text(),'SONY Bravia 80 cm (32 inch) HD Ready LED Smart Google TV TV with Google TV')]")).click();
		   Thread.sleep(2000);
		   String parent=  driver.getWindowHandle();
		     
    		Set<String>child=driver.getWindowHandles();
    		
    		for(String v:child){
    			if(!parent.equals(v)){
    				driver.switchTo().window(v);
    			}
    		}
   
    	
	   }
	   @Test
	   public void method4() throws IOException{
		   
   
        WebElement name=driver.findElement(By.xpath("(//*[contains(text(),'SONY Bravia 80 cm (32 inch) HD Ready LED Smart Google TV TV with Google TV')])[3] ") );
         String ab= name.getText();
         
         
         File s= new File("C:\\Users\\vinit\\OneDrive\\Documents\\sampleexl.xlsx");
          FileInputStream f1= new FileInputStream(s);
          Workbook F= new XSSFWorkbook(f1);
          Sheet P= F.getSheet("TV LIST");
          
        
        	  Row u=P.getRow(2);
        	  
        	  for (int j = 0; j < u.getPhysicalNumberOfCells(); j++) {
        		  Cell n= u.getCell(j);
				Assert.assertEquals(ab, n);
			}
        	          
        
	   }
	   @Test
	 public void method5() throws IOException{
		 System.out.println("Screenshot");
		  JavascriptExecutor j= (JavascriptExecutor)driver;
		   j.executeScript("window.scrollBy(0,1800)","");
		   TakesScreenshot t= (TakesScreenshot)driver;
	         File src=  t.getScreenshotAs(OutputType.FILE);
	        File des= new File("C:\\Users\\vinit\\workspace\\Junit-maven\\Screenshot2\\photo.png");
	        FileUtils.copyFile(src, des);
	 }
	  

}
