package com.Fitpeo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigateToRC extends BasePage
{
	public WebDriver driver;
	
	public NavigateToRC(WebDriver driver) 
	{
			super(driver);
			
	}
	
	//Locators
		@FindBy(xpath ="//div[contains(text(),'Revenue Calculator')]")
		WebElement RC;
		
		public void naviagteToRevnueCollector()
		{
			RC.click();
		}
}