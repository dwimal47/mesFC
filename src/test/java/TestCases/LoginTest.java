package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectClasses.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginTest {

		WebDriver driver;
		LoginPage lp;		
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
		void testLogo()
		{
			lp=new LoginPage(driver);	
			lp.checkLogoPresence();
			Assert.assertEquals(lp.checkLogoPresence(), true);
		}
		
		@Test(priority=2)
		void testLogin() throws InterruptedException
		{
			lp.setUserName("anant");
			lp.setPassword("123");
			lp.clickLogin();
			Thread.sleep(4000); 
			Assert.assertEquals(driver.getTitle(), "Main Master Page");
		}
		
		@AfterClass
		void closeBrowser()
		{
			driver.close();
		}
			
}
