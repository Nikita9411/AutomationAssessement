package com.Fitpeo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Fitpeo.Pages.BasePage;
import com.Fitpeo.Pages.RevnueCalcActions;

public class RevnueCalculatorTests extends BaseTest
{
	
  @Test
  public void TC01_scrollDownToSliderSection() 
  
  {
	  RevnueCalcActions rca = new RevnueCalcActions(driver);
	  
	  BasePage bp = new BasePage(driver);
	  
	  bp.navigateToRevnueCalculator();
	  
	  rca.scrollTillSlider();	  
  }
  
  @Test
  public void TC02_adjustTheSlider()
  {
	  RevnueCalcActions rca = new RevnueCalcActions(driver);
	  
	  BasePage bp = new BasePage(driver);
	  
	  bp.navigateToRevnueCalculator();
	  
	  String sliderValue = rca.updateSliderValue(820);
	  
	  Assert.assertEquals(sliderValue, 820);
  }
  
  @Test
  public void TC03_updateTheTextField() throws InterruptedException
  {
	  RevnueCalcActions rca = new RevnueCalcActions(driver);
	  
	  BasePage bp = new BasePage(driver);
	  
	  bp.navigateToRevnueCalculator();
	  
	  int textValue =  rca.updateTextField("560");
	 
	  Assert.assertEquals(textValue, "560");
  }
  
  @Test
  public void TC04_selectCPTCodes()
  {
	  RevnueCalcActions rca = new RevnueCalcActions(driver);
	  
	  BasePage bp = new BasePage(driver);
	  
	  bp.navigateToRevnueCalculator();
	  
	  rca.checkTheCPTBoxes();
  }
  
  @Test
  public void TC05_validateTotalRecurringReimbursement()
  {
	  RevnueCalcActions rca = new RevnueCalcActions(driver);
	  
	  rca.updateSliderValue(820);
	  
	  String header = rca.matchHeaderDetails();
	  
	  Assert.assertEquals(header, "Total Recurring Reimbursement for all Patients Per Month:");
	  
	  String hValue = rca.matchHeaderValue();
	  
	  Assert.assertEquals(hValue, "$110700");
  }
  
}
