package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	    public WebDriver driver;
		
		//Constructor
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
		//Locator
		@FindBy(xpath="//div[@class='col-lg-6 d-none d-lg-block bg-login-image']")
		WebElement loginpage_logo_loc;
		
		@FindBy(xpath="//input[@name='exampleInputEmail']")
		WebElement txt_username_loc;
		
		@FindBy(xpath="//input[@name='exampleInputPassword']")
		WebElement txt_password_loc;
		
		@FindBy(xpath="//input[@name='LoginButton']")
		WebElement btn_login_loc;
		
		//Action method
		
		public void setUserName(String username)
		{
			txt_username_loc.sendKeys(username);
		}
		
		public void setPassword(String password)
		{
			txt_password_loc.sendKeys(password);
		}
		public void clickLogin()
		{
			btn_login_loc.click();
		}
		public boolean checkLogoPresence() 
		{
			return loginpage_logo_loc.isDisplayed();
		}
			
}
