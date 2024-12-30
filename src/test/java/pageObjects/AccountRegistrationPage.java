package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement mobilenumber;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement retypepass;
	@FindBy(xpath="//input[@name='agree']") WebElement policy;
	@FindBy(xpath="//input[@value='Continue']") WebElement ctnbutton;
 	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgconf;
	
	
	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastname.sendKeys(lname);
	}
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	public void setMobileNumber(String number) {
		mobilenumber.sendKeys(number);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	public void setRepass(String pass) {
		retypepass.sendKeys(pass);
	}
	public void clickPolicy() {
		policy.click();
	}
	public void clickCtn() {
		ctnbutton.click();
	}
	
	public String getConfirmmsg() {
		try {
			return (msgconf.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
}
