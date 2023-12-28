package PageObjectClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HourlyEnergyReport {
	
	public WebDriver driver;
	
	//Constructor
	public HourlyEnergyReport(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Locator
	@FindBy(xpath="//a[@data-bs-target='#energyReportCollapseLayouts']")
	WebElement energy_loc;
	
	@FindBy(id="HourlyReports_Energy")
	WebElement hourly_energy_loc;
	
	@FindBy(id="DailyReports_Energy")
	WebElement daily_energy_loc;
	
	@FindBy(id="ProjectContent_energyMeterId")
	WebElement select_metername_textbox;
	
	@FindBy(id="reportrange")
	WebElement select_period;
	
	@FindBy(xpath="//input[@value='Apply']")
	WebElement apply_btn;
	
	@FindBy(xpath="//input[@ id='ProjectContent_ViewButton']")
	WebElement view_btn;

	@FindBy(id="ProjectContent_cmdAction")
	WebElement download_excel;
	
	@FindBy(xpath="//input[@ id='ProjectContent_exportBtn']")
	WebElement export_excel;
	
	@FindBy(xpath="//li[@data-range-key='Today']")
	WebElement today_btn;
	
	@FindBy(xpath="//option[@value=2]")
	WebElement main_meter_option;
	
	//Action method
	public void hourlyEnergyReport() throws InterruptedException
	{   
    	energy_loc.click();
    	Thread.sleep(3000); 
		hourly_energy_loc.click();
		Thread.sleep(3000); 
		select_metername_textbox.click(); 
		Thread.sleep(3000);  
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", select_period);
		Thread.sleep(3000); 
		today_btn.click();
		Thread.sleep(3000); 
		apply_btn.click(); 
		Thread.sleep(3000); 
		download_excel.click(); 
		Thread.sleep(6000); 
	}
	
	public void dailyEnergyReport() throws InterruptedException
	{   
    	energy_loc.click();
    	Thread.sleep(3000); 
    	daily_energy_loc.click();
		Thread.sleep(3000); 
		select_metername_textbox.click(); 
		Thread.sleep(3000);  
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", select_period);
		Thread.sleep(3000); 
		today_btn.click();
		Thread.sleep(3000);
		view_btn.click();
		Thread.sleep(3000); 
		export_excel.click(); 
		Thread.sleep(6000); 
	}
}
