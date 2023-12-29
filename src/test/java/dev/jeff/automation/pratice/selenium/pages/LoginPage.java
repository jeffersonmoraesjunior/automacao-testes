package dev.jeff.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	// Locators
	private By emailAddressLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
	private By passwordElement = By.name("password");
	private By submitBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
	private By verificationAccountLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");

	public void signin() {
		if (super.isDisplayed(emailAddressLocator)) {
			super.type("falejin299@visignal.com", emailAddressLocator);
			super.type("123456", passwordElement);
			super.click(submitBtnLocator);
		} else {
			System.out.println("Email textbox was not present");
		}
	}
	
	public String getMyAccountMessage() {
		return super.getText(verificationAccountLocator);
	}

}
