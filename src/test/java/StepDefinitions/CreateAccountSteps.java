package StepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class CreateAccountSteps {


	Random unique = new Random();
	int number = unique.nextInt(10000000);


	WebDriver driver = null;

	@Given("Browser is open")
	public void browser_is_open() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@And("user is on account creation page")
	public void user_is_on_account_creation_page() {

		driver.navigate().to("https://login.mailchimp.com/signup/");

	}

	@And("^user is typing (.*) (.*) password$")
	public void user_is_typing_email_username_password(String email, String username) {


		if (email.isEmpty()) {
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("new_username")).sendKeys(username +number);
			driver.findElement(By.id("new_password")).sendKeys("Testare123!");
		}

		else if (username.contains("z")) {
			driver.findElement(By.id("email")).sendKeys(number+ email);
			driver.findElement(By.id("new_username")).sendKeys(username);
			driver.findElement(By.id("new_password")).sendKeys("Testare123!");
		}

		else {

			driver.findElement(By.id("email")).sendKeys(number+ email);
			driver.findElement(By.id("new_username")).sendKeys(username +number);
			driver.findElement(By.id("new_password")).sendKeys("Testare123!");

		}

	}

	@When("presses sign up")
	public void presses_sign_up() {


		driver.findElement(By.id("create-account")).click();
	}


	@Then("user is navigated to check your email page")
	public void user_is_navigated_to_check_your_email_page() {


		driver.findElement(By.id("signup-content"));

	}
}
