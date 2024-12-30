package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmailAddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement logbtn;
	
	public void setEmail(String email) { 
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		txtpassword.sendKeys(pass);
	}
	public void clickLogin() {
		logbtn.click();
	}

}
