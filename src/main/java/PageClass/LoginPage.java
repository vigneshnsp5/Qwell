package PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Helper.Base;

public class LoginPage extends Base{
	
	@FindBy(xpath="//input[@type=\"email\"]")
	WebElement userNameTextBox;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement loginButton;
	

	public WebElement getUserNameTextBox() {
		return userNameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	

}
