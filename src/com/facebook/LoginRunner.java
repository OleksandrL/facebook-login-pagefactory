package com.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginRunner {

	public static void main(String[] args) throws Exception{
		WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.facebook.com/");
        User user = new User();
        
        /*Success Login from StartPage*/
        user = user.createValidUser();
        StartPage facebookStart = PageFactory.initElements(driver, StartPage.class);
        HomePage homePage = facebookStart.successLogin(user);
        System.out.println(homePage.isReallyHomePage());
        facebookStart = homePage.quit();
      
        /*Error Login from StartPage*/
        user = user.createInvalidUser();
        LoginPage loginPage = facebookStart.errorLogin(user);
        loginPage.errorMessageVerify("Facebook");
        
        /*Error Login from LoginPage*/
        loginPage = loginPage.errorLogin(user);
        loginPage.errorMessageVerify("Facebook");
        
        /*Success Login from LoginPage*/
        user = user.createValidUser();
        homePage = loginPage.successLogin(user);
        System.out.println(homePage.isReallyHomePage());
        facebookStart = homePage.quit();
        driver.close();
	}

}
