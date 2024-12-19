package EGIndia.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import EGIndia.AbstractComponents.utilitycomponent;

public class LoginPage extends utilitycomponent{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{	super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}	
	//pageFactory	
	@FindBy(id="user-name") WebElement userEmail;
	@FindBy(name="password") WebElement passWord;
	@FindBy(id="login-button") WebElement loginbutton;
	@FindBy(css=".error-message-container h3") WebElement errormsg;
	@FindBy(css=".header_label div.app_logo") WebElement swaglabs;

	public void loadurl()
	{		
		driver.get("https://www.saucedemo.com/");
	}
	
	public void logintask(String email,String password)
	{
		userEmail.sendKeys(email);
		passWord.sendKeys(password);
		loginbutton.click();
	}	

	public String geterrormsg()
	{
		waitForElementToAppear(errormsg);
		return errormsg.getText();
	}
	
	public String swagmsg()
	{
		waitForElementToAppear(swaglabs);
		return swaglabs.getText();
	}
}
