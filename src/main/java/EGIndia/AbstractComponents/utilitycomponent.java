package EGIndia.AbstractComponents;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilitycomponent {
	public WebDriver driver;
	
	public utilitycomponent(WebDriver driver) {
		this.driver = driver;
		}

	WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
	
	public void waitForElementToAppear(List<WebElement> findBy)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated((By) findBy));		
	}

	public void waitForElementToAppear(By findBy)
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));		
	}
	
	public void waitForElementToAppear(WebElement findBy)
	{
		w.until(ExpectedConditions.visibilityOf(findBy));		
	}
	
	public void handlepopup()
	{
		// Handle unexpected pop-up (if it appears)
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Change your password appeared. Message: " + alert.getText());
            alert.accept(); 
        } catch (Exception e) {
            // No pop-up appeared, continue execution
            System.out.println("No pop-up appeared.");
        }        
        System.out.println("Login successful or continuing to the next steps.");
	}	
}
