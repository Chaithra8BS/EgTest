package EGIndia.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EGIndia.AbstractComponents.utilitycomponent;

public class HomePage extends utilitycomponent {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}	
	        
	@FindBy(css=".inventory_item_description")List<WebElement> prod;
	By addcart = By.cssSelector(".inventory_item_description button");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(prod);
		return prod;
	}
		
	public WebElement getProductBYName(String productInput)
	{		 
		for(WebElement option:prod)        
        {    	
        	String name = option.findElement(By.cssSelector(".inventory_item_label a .inventory_item_name")).getText();             	
        	if(name.contains(productInput))
        		{
        		System.out.println(name);
        		return option;
        		}          	
        }
		return null;
	}
	
	public void addProducttoCart(String prodin)
	{
		WebElement prod = getProductBYName(prodin);
		prod.findElement(addcart).click();
	}
}