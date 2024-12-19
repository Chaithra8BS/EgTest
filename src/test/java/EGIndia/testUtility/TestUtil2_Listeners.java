package EGIndia.testUtility;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestUtil2_Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = TestUtil1_ExtentReports.getReporterObject();
	RemoteWebDriver driver;
	

	@Override
	public void onTestStart(ITestResult result) {
		 test= extent.createTest(result.getMethod().getMethodName());
		 test.info("<span style='color:green; font-weight:bold;'>Test execution started</span>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "\"<span style='color:green; font-weight:bold;'>This test is passed!</span>\"");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		test.log(Status.FAIL, "<span style='color:red; font-weight:bold;'>This test is failed!</span>");
		try {
				driver = (RemoteWebDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());	
			} catch (Exception e1) {
			e1.printStackTrace();
			} 
		  
		try {
			if (driver != null) {	
			//	//screenshot code
				test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			}else {
		           System.out.println("Driver is not initialized. Cannot capture screenshot.");
		        }} catch (Exception e) {
			e.printStackTrace();
			}
	}	

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"<span style='color:blue; font-weight:bold;'>This test is skipped</span>");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}	
}
