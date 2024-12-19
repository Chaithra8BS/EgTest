package EGIndia.testUtility;
import java.time.LocalDateTime;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestUtil1_ExtentReports {
	
	public static ExtentReports getReporterObject()
	{		
		String path =System.getProperty("user.dir")+"//Test_Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("EGTEST Report");
		reporter.config().setDocumentTitle("Automation Test Results");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		reporter.config().isTimelineEnabled();
		ExtentReports extent =new ExtentReports();
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Chaithra");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Operating System", "Windows 11");
		extent.setSystemInfo("Test Framework Version", "TestNG");
		extent.setSystemInfo("Execution Date and Time", LocalDateTime.now().toString());
		return extent;		
	}	
}
