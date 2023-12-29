package dev.jeff.automation.pratice.selenium.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.jeff.automation.pratice.selenium.pages.RegisterPage;

class RegisterPageTest {
	private RegisterPage registerPage;
	private final String URL = "https://automationexercise.com/login";

	@BeforeEach
	void setUp() throws Exception {
		this.registerPage = new RegisterPage();
		this.registerPage.visit(this.URL);
	}

	@AfterEach
	void tearDown() throws Exception {
//		this.registerPage.quitWebDriver();
	}

	@Test
	void test() {
		// when
		this.registerPage.insertEmailToRegister();

		// then
		String expected = "jeffersonjunior@gmail.com";
		String actual = this.registerPage.getEmailNewAccount();
		Assertions.assertEquals(expected, actual);
	}

}
