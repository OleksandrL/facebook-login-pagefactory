package com.facebook;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

	private WebElement email;
	private WebElement pass;
	private WebElement u_0_2;
	
	@FindBy(css = ".uiHeaderTitle")
	private WebElement header;
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	private void loginUser(User user) {
		email.clear();
		email.sendKeys(user.login);
		pass.clear();
		pass.sendKeys(user.password);
		u_0_2.click();
	}
	
	public LoginPage errorMessageVerify(String title){
		Assert.assertTrue("Required header should be present", header.isDisplayed());
		Assert.assertTrue("Required header should contains " + title, 
				header.getText().contains(title));
		return this;
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
