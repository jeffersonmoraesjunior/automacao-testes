package dev.jeff.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

	// Locators
	private By nameAddressLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
	private By emailAddressLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
	private By submitBtnSignin = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
	private By nameLocator = By.id("name");
	private By emailLocator = By.id("email");

	public void insertEmailToRegister() {
		if (super.isDisplayed(emailAddressLocator)) {
			type("jefferson", nameAddressLocator);
			type("jeffersonjunior@gmail.com", emailAddressLocator);
			click(submitBtnSignin);
		} else {
			System.out.println("email textbox was not present");
		}
	}

	public String getEmailNewAccount() {
		return super.getTextByAttribute(this.emailLocator, "value");
	}
}
