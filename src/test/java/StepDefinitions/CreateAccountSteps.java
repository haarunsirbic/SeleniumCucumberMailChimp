package StepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.*;

import io.cucumber.java.en.*;

public class CreateAccountSteps {
	
	
	Random unique = new Random();
	int number = unique.nextInt(10000000);
	
	String hundredLetters = "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest";
	

	WebDriver driver = null;

	@Given("Browser is open")
	public void browser_is_open() {

		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

	}

	@And("user is on account creation page")
	public void user_is_on_account_creation_page() throws InterruptedException {
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://login.mailchimp.com/signup/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	}

	@When("^user is typing (.*) (.*) password$")
	public void user_is_typing_email_username_password(String email, String username) {
		
		if (email.isEmpty()) {
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("new_username")).sendKeys(username +number);
			driver.findElement(By.id("new_password")).sendKeys("Testare123!");
			
			driver.findElement(By.id("create-account")).click();
			
			WebElement SpanError = driver.findElement(By.xpath("//span[text()='Please enter a value']"));
			Assert.assertEquals(true, SpanError.isDisplayed());
			
		}
		
		else if (username.contains("z")) {
			driver.findElement(By.id("email")).sendKeys(number+ email);
			driver.findElement(By.id("new_username")).sendKeys(username);
			driver.findElement(By.id("new_password")).sendKeys("Testare123!");
			
			driver.findElement(By.id("create-account")).click();
			
			WebElement SpanErrorThree = driver.findElement(By.className("invalid-error"));
			Assert.assertEquals(true, SpanErrorThree.isDisplayed());
			
		}
		
		else if (username.contains("123")) {
			
			driver.findElement(By.id("email")).sendKeys(number+ email);
			driver.findElement(By.id("new_username")).sendKeys(hundredLetters);
			driver.findElement(By.id("new_password")).sendKeys("Testare123!");
			
			driver.findElement(By.id("create-account")).click();
			
			WebElement SpanErrorTwo = driver.findElement(By.xpath("//span[text()='Enter a value less than 100 characters long']"));
			Assert.assertEquals(true, SpanErrorTwo.isDisplayed());
			
		}
		
		else {
			
			driver.findElement(By.id("email")).sendKeys(number+ email);
			driver.findElement(By.id("new_username")).sendKeys(username +number);
			driver.findElement(By.id("new_password")).sendKeys("Testare123!");
			
			driver.findElement(By.id("create-account")).click();
			
			WebElement Success = driver.findElement(By.id("signup-content"));
			Assert.assertEquals(true, Success.isDisplayed());
			
		}
		
		
		
	}

	@Then("closes browser and session")
	public void closes_browser_and_session() throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

	

}
