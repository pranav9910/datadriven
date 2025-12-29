package com.shoppiing.testcase;

import org.testng.annotations.Test;

import com.shoppiing.pageobject.Login;
import com.shoppiing.pageobject.Logout;

public class LoginTestCase extends BaseClass
{
	@Test
	void login()
	{
		driver.get(url);
		Login l=new Login(driver);
		l.getUsername("student");
		l.getPassword("Password123");
		l.clickSubmit();
		
	}
	@Test
	void logout()
	{
		Logout lo=new Logout(driver);
		lo.logout();
		
	}

}
