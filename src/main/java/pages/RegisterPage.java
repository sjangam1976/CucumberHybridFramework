package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	WebDriver driver;
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	
	@FindBy(id="input-lastname")
	private WebElement lasttNameField;
	
	public void enterLastName(String lasttNameText) {
		lasttNameField.sendKeys(lasttNameText);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	public void enterPasswordConfirmation(String passwordText) {
		passwordConfirmField.sendKeys(passwordText);
	}
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	public void selectPrivacyPolicyOption() {
		privacyPolicyField.click();
	}
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public AccountSuccessPage clickContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement YesNewsLetterOption;
	
	public void selectNewsLetterAsYes() {
		YesNewsLetterOption.click();
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public String getWarningMessageText() {
		return warningMessage.getText();
	}
	
	@FindBy(xpath="//*[@id=\"account\"]/div[2]/div/div")
	private WebElement firstNameWarning;
	
	public String getFirstNameWarningMessageText() {
		
		return firstNameWarning.getText();
	}
	
}
