package com.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
	private WebElement q;
	
	@FindBy (id = "pageLoginAnchor")
	private WebElement button;
	@FindBy (css= "a[data-gt*='menu_logout']>span>span")
	private WebElement exit;
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	public StartPage quit() throws Exception{
		this.button.click();
		// Warning: waitForElementPresent may require manual changes
		for (int second = 0;; second++) {
	    	if (second >= 60) {throw new Exception(); }
	    	try { if (exit.isDisplayed()) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
		this.exit.click();
		return PageFactory.initElements(driver, StartPage.class);
	}
	
	public String isReallyHomePage(){
		if(q.isDisplayed()){
			return "It is the Home Page.";
		}else{
			return "It is a wrong page.";
		}
			
	}
}
