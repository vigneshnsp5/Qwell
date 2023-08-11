package Utility;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import Helper.Base;
import PageClass.LoginPage;

public class Utility extends Base {
	
	
	public static void adminLogin() throws IOException, Exception {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getUserNameTextBox().sendKeys(testData("form", 1, 0));
		Thread.sleep(3000);
		lp.getPasswordTextBox().sendKeys(testData("form", 1, 1));
		Thread.sleep(5000);
		lp.getLoginButton().click();
	}
	
	public static void adminLogout() throws IOException, Exception {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getLoginButton().click();
	}
	
	
	
	public static void admininvalidlogin() throws IOException, Exception {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getUserNameTextBox().sendKeys(testData("form", 2, 0));
		lp.getPasswordTextBox().sendKeys(testData("form", 2, 1));
		lp.getLoginButton().click();
		
	}

}
