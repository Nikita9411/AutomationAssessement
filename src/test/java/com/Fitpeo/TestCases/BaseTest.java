package com.Fitpeo.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Fitpeo.Pages.BasePage;
import com.Fitpeo.Pages.NavigateToRC;

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
	  
	 /* @Test
	  public void naviagteToRevnueCollector()
	  {
		  NavigateToRC bp= new NavigateToRC(driver);
		  String title = bp.naviagteToRevnueCollector();
		  
		  Assert.assertEquals("https://fitpeo.com/revenue-calculator",title);
		  		   
	  }*/
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
