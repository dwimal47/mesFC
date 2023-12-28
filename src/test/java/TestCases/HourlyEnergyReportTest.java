package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectClasses.HourlyEnergyReport;
import PageObjectClasses.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
 
public class HourlyEnergyReportTest {
	WebDriver driver;
	LoginPage lp;
	HourlyEnergyReport her;		
	@BeforeClass
	void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://brmfactoryconnect.pre-scient.com/SteelMES-BRM/Furnace/UI/Heat1_report.aspx");
		driver.manage().window().maximize();
		Thread.sleep(4000); 
	}
	
	@Test(priority=1)
	void testLogin() throws InterruptedException
	{   
		lp= new LoginPage(driver);
		lp.setUserName("anant");
		lp.setPassword("123");
		lp.clickLogin();
		Thread.sleep(4000); 
		Assert.assertEquals(driver.getTitle(), "Main Master Page");
	}
	
	@Test(priority=2)
	void downloadEnergyReport() throws InterruptedException
	{
		her=new HourlyEnergyReport(driver);
		her.hourlyEnergyReport();
		Thread.sleep(5000); 
	}
	
	@AfterClass
	void closeBrowser()
	{
		driver.close();
	}	
}
