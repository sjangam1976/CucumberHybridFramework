package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage 

{
	WebDriver driver;
	private ElementUtils elementUtils;
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='Account']")
	private WebElement myAccountDropDownMenu;
	
	public void clickOnMyAccount() {
		
		//myAccountDropDownMenu.click();
		
		elementUtils.clickOnElement(myAccountDropDownMenu, 15 );
	}
	
	@FindBy(linkText="Login")
	private WebElement selectLogin;
	
	public LoginPage selecLoginOption() 
	{
		selectLogin.click();
		return new LoginPage(driver);
	}
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public RegisterPage selectRegisterOption()
	{
		registerOption.click();
		return new RegisterPage(driver);
	}
	
}
