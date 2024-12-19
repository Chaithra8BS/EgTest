package EGIndia.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import EGIndia.AbstractComponents.utilitycomponent;

public class BasketPage extends utilitycomponent{
	WebDriver driver;
	
	public BasketPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="shopping_cart_container") WebElement cartPage;	
	@FindBy(className="cart_item")List<WebElement> cart;	
	By itemName= By.cssSelector("div.cart_item_label a div.inventory_item_name");
	
	public void gotCart()
	{
		cartPage.click();
	}
	
	public List<WebElement> CartItems()
	{
		return cart;
	}

	public boolean VerifyProdAdded(String productInput)
	{
		for(WebElement option: cart)
        {	
        	if(option.findElement(itemName).getText().contains(productInput))
        	{
        		System.out.println("The given product"+productInput+" is present in the cart");
        		return true;
        	}
        }
		return false;
	}




}
