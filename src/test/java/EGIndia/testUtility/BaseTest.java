package EGIndia.testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public WebDriver initialzeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\EGIndia\\Resources\\Config.properties");		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chaithra B\\eclipse-workspace\\EGTaskframe\\geckodriver.exe");		
			driver = new FirefoxDriver();		
		}		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;		
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	 public String getScreenshotPath(String testCaseName, RemoteWebDriver driver) throws IOException{
		 	File sourceFile= driver.getScreenshotAs(OutputType.FILE);
		 	File destinationFile =new File(System.getProperty("user.dir")+"//Test_Reports//Screen Shots//"+testCaseName+".png");
		 	FileUtils.copyFile(sourceFile,destinationFile);
			return destinationFile.toString();		 	
	    }
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
	String jsondata =	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsondata, new TypeReference<List<HashMap<String, String>>>(){});
	return data;	
	}
}
