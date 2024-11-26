package com.Fitpeo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RevnueCalcActions extends BasePage

{
	public RevnueCalcActions(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//span[starts-with(@class,'MuiSlider-thumb')]")
	WebElement slider;
	
	@FindBy(xpath = "//input[@type='number']")
	WebElement textField;
	
	@FindBy(xpath = "//p[text()='CPT-99091']//following-sibling::label/span/input")
	WebElement CPT_99091;
	
	@FindBy(xpath = "//p[text()='CPT-99453']//following-sibling::label/span/input")
	WebElement CPT_99453;
	
	@FindBy(xpath = "//p[text()='CPT-99454']//following-sibling::label/span/input")
	WebElement CPT_99454;
	
	@FindBy(xpath = "//p[text()='CPT-99474']//following-sibling::label/span/input")
	WebElement CPT_99474;
	
	@FindBy(xpath = "Total Recurring Reimbursement for all Patients Per Month")
	WebElement header;
	
	@FindBy(xpath = "//p[text()='110700']")
	WebElement headerValue;
	
	public void scrollTillSlider()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//here we are chaning the no. to scroll the page
		jse.executeScript("arguments[0].scrollIntoView()",slider);
					
	}
	
	public String updateSliderValue(int value)
	{
			
		//System.out.println("Default value is :- "+slider.getLocation().getX());
		
		Actions act = new Actions(driver);	
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", slider);
		
		act.moveToElement(slider).dragAndDropBy(slider, value, 622).build().perform();
		
		return textField.getText();
		
	}
	
	public int updateTextField(String value) 
	{
		
		textField.clear();
		
		textField.sendKeys("560");
		
		return slider.getLocation().x;
	}
	
	public void  checkTheCPTBoxes()
	{
		CPT_99091.click();
		CPT_99453.click();
		CPT_99454.click();
		CPT_99474.click();
	}
	
	public String matchHeaderDetails()
	{
		return header.getText();
	}
	
	public String matchHeaderValue()
	{
		return headerValue.getText();
	}
}
