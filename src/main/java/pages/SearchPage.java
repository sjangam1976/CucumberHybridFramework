package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search")
	private WebElement searchField;
	
	public void enterProductIntoSearchField(String ProductText) {
		searchField.sendKeys(ProductText);
	}
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	private WebElement searchButton;
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validSearchResult;
	
	public String getValidSearchResultText() {
		return validSearchResult.getText();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2")
	private WebElement noProductMessage;
	
	
	public String getNoProductMessageText() {
		return noProductMessage.getText();
	}
}
