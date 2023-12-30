package dev.jeff.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

	// Locators
	private By nameAddressLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
	private By emailAddressLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
	private By submitBtnSignin = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
	private By emailLocator = By.id("email");
	private By alertAdditionalInformationLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/p[4]/label/span");
	private By accountCreated = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
	// Locators Personal information
	private By title = By.id("id_gender1");
	private By name = By.id("name");
	private By password = By.id("password");
	private By days = By.id("days");
	private By months = By.id("months");
	private By years = By.id("years");
	private By newsletter = By.id("newsletter");
	private By optin = By.id("optin");
	// Locators ADDRESS INFORMATION
	private By first_name = By.id("first_name");
	private By last_name = By.id("last_name");
	private By company = By.id("company");
	private By address1 = By.id("address1");
	private By address2 = By.id("address2");
	private By country = By.id("country");
	private By state = By.id("state");
	private By city = By.id("city");
	private By zipcode = By.id("zipcode");
	private By mobile_number = By.id("mobile_number");
	private By btnCreateAccount = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");

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
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		return super.getTextByAttribute(this.emailLocator, "value");
	}

	public void fillOutForm() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		if (super.isDisplayed(title)) {
			super.click(title);
			super.clear(name);
			super.type("Jefferson Junior", name);
			super.type("123456", password);
			selectByValue(days, "18");
			selectByValue(months, "3");
			selectByValue(years, "1999");
			super.click(newsletter);
			super.click(optin);
			super.type("Jefferson", first_name);
			super.type("Moraes", last_name);
			super.type("company", company);
			super.type("address1", address1);
			super.type("address2", address2);
			selectByValue(country, "United States");
			super.type("state", state);
			super.type("city", city);
			super.type("25960360", zipcode);
			super.type("21993629731", mobile_number);
			super.click(btnCreateAccount);
		} else {
			System.out.println("Erro no cadastramento");
		}
	}
	
	public String getWelcomemessage() {
		super.waitVisibilityOfElementLocated(accountCreated);
		return super.getText(accountCreated);
	}
}
