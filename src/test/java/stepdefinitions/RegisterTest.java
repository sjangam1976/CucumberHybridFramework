package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class RegisterTest 
{
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("user navigates to Register page")
	public void user_navigates_to_register_page() {
	    
		 driver= DriverFactory.getDriver();
		 HomePage homePage = new HomePage(driver);
		 homePage.clickOnMyAccount();
		 registerPage=  homePage.selectRegisterOption();
		 //driver.findElement(By.xpath("//span[text()='Account']")).click();
		// driver.findElement(By.linkText("Register")).click();
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
	  Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	  registerPage.enterFirstName(dataMap.get("firstName"));
	  registerPage.enterLastName(dataMap.get("lastName"));
	  commonUtils=new CommonUtils();
	  registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
	  registerPage.enterTelephone(dataMap.get("telephone"));
	  registerPage.enterPassword(dataMap.get("password"));
	  registerPage.enterPasswordConfirmation(dataMap.get("password"));
	  
	}

	@When("user selects privacy policy")
	public void user_selects_privacy_policy() 
	{	   
		registerPage.selectPrivacyPolicyOption();		
	}

	@When("user clicks continue button")
	public void user_clicks_continue_button() 
	{
	   
		accountSuccessPage=registerPage.clickContinueButton();
	}

	@Then("user account should get created successfully")
	public void user_account_should_get_created_successfully() 
	{
	
		
	    Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeadning());
	}

	@When("user selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
	  
		 registerPage.selectNewsLetterAsYes();
		
	}

	@Then("user should get proper warning about duplicate email")
	public void user_should_get_proper_warning_about_duplicate_email() 
	{
	    Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("user does not enter any details into fields")
	public void user_does_not_enter_any_details_into_fields() 
	{
		//intentionally left blank
	}

	@Then("user should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() 
	{
		
	    Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarningMessageText());

	}


}
