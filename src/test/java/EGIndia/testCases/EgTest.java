package EGIndia.testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import EGIndia.PageObjects.BasketPage;
import EGIndia.PageObjects.HomePage;
import EGIndia.PageObjects.LoginPage;
import EGIndia.testUtility.BaseTest;

public class EgTest extends BaseTest{

	//"TestCase1" Valid Login
	@Test (dataProvider="getData")
	public void validLogin(HashMap<String,String> input) throws IOException
	{
		LoginPage loginpage = new LoginPage(driver);		
		loginpage.loadurl();
		loginpage.logintask(input.get("username"), input.get("password"));
		loginpage.handlepopup();
		Assert.assertEquals("Swag Labs", loginpage.swagmsg());
	}	
	
	//"TestCase2" Add the given product to cart and verify its presence
	@Test (dataProvider="getData")
	public void addProducttoBasket(HashMap<String,String> input) throws IOException
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		BasketPage basketpage = new BasketPage(driver);
		String prodinput = "Sauce Labs Bolt T-Shirt";
		loginpage.loadurl();
		loginpage.logintask(input.get("username"), input.get("password"));
		loginpage.handlepopup();

		// select the product and add to cart		
		homepage.getProductBYName(prodinput);
		homepage.addProducttoCart(prodinput);

		// verify the cart page		
		basketpage.gotCart();
		basketpage.CartItems();
		Assert.assertTrue(basketpage.VerifyProdAdded(prodinput));		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\EGIndia\\Resources\\InputData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}
