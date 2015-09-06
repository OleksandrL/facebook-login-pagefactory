package com.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Page {
	private WebElement email;
	private WebElement pass;
	private WebElement u_0_l;
	
	public StartPage(WebDriver driver){
		super(driver);
	}

	private void loginUser(User user) {
		email.clear();
		email.sendKeys(user.login);
		pass.clear();
		pass.sendKeys(user.password);
		u_0_l.click();
	}
	
	public HomePage successLogin(User user){
		loginUser(user);
		return PageFactory.initElements(driver, HomePage.class);
	}

	
	public LoginPage errorLogin(User user){
		loginUser(user);
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
