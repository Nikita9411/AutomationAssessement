package com.Fitpeo.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Fitpeo.Pages.BasePage;

public class BaseTest 
{
 public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	 public void naviagteToHomePage() 
	  {
		  Assert.assertEquals(driver.getTitle(), "Remote Patient Monitoring (RPM) - fitpeo.com");
		  
	  }
	  
	  @Test
	  public void naviagteToRevnueCollector()
	  {
		  BasePage bp= new BasePage(driver);
		  String title = bp.navigateToRevnueCalculator();
		  
		  Assert.assertEquals("https://fitpeo.com/revenue-calculator",title);
		  		   
	  }
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
