package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@title='My Account']") WebElement lnkmyacc;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkregister;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement lnklogin;

	public void clickMyAccount() {
		lnkmyacc.click();
	}
	
	public void clickRegister() {
		lnkregister.click();
	}
	public void clickLogin() {
		lnklogin.click();
	}
}
