package EGIndia.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import EGIndia.PageObjects.LoginPage;
import EGIndia.testUtility.BaseTest;

public class InvalidLogins extends BaseTest{
	
	@Test //"TestCase1" Invalid Login
	public void InvalidLogin() throws IOException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loadurl();
		loginpage.logintask("standard_user", "secret_sauce1");
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginpage.geterrormsg());
	}
	
	@Test //"TestCase2" Invalid Login
	public void InvalidLogin2() throws IOException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loadurl();
		loginpage.logintask("locked_out_user", "secret_sauce");
		Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginpage.geterrormsg());
	}

}
