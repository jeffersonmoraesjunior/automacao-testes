package dev.jeff.automation.pratice.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/login");
	}

	@AfterEach
	void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	void test() {
		WebElement emailAddressLocator = driver
				.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
		emailAddressLocator.sendKeys("falejin299@visignal.com");

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys("123456");

		WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
		submitBtnElement.click();

		WebElement classMyAccount = driver
				.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
		String textClassUser = classMyAccount.getText();

		Assertions.assertTrue(textClassUser.contains("Logged in as"));

	}

}
