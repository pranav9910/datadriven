package com.shoppiing.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout 
{
    
	public WebDriver ldriver;
	public Logout(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath ="//a[text()='Log out']") WebElement logout;
	
	public void logout()
	{
		logout.click();
	}

}
