package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class LoginTest 

{
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() 
	{
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selecLoginOption();
	    
	}

	@When("user enters a valid email (.+) in the email field")
	public void user_enters_a_valid_email_in_the_email_field(String emailText) 
	{
	    loginPage.enterEmailAddress(emailText);
	}

	@And("user enters a valid password (.+) in the password field")
	public void user_enters_a_valid_password_in_the_password_field(String passwordText) {
	    
		loginPage.enterPassword(passwordText);
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	}

	@And("user clicks the login button")
	public void user_clicks_the_login_button() 
	{
	    
		accountPage =loginPage.clickLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user should successfully log in")
	public void user_should_successfully_log_in() 
	{
		
	    Assert.assertTrue(accountPage.displayStatusOfDownloadOption());
	}

	@When("user enters a invalid email in the email field")
	public void user_enters_a_invalid_email_in_the_email_field() 
	{
		commonUtils=new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	}

	@And("user enters a invalid password {string} in the password field")
	public void user_enters_a_invalid_password_in_the_password_field(String invalidPassword) {
	    
		loginPage.enterPassword(invalidPassword);
	}

	@Then("user should get a warning message")
	public void user_should_get_a_warning_message() 
	{
		
		
	   
	   Assert.assertTrue(loginPage.validateWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user does not enter email in the email field")
	public void user_does_not_enter_email_in_the_email_field() 
	{
		loginPage.enterEmailAddress("");
		
	}

	@When("user does not enter password in the password field")
	public void user_does_not_enter_password_in_the_password_field() 
	{
		loginPage.enterPassword(" ");
	}
	
	
	
}
