package codewithharry.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement country = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
	
	//PageFactory
	
	@FindBy(css="input[placeholder='Select Country']")
	
	WebElement country;
	
	
	public void inputCountryName(String myCountry) {
		
		country.sendKeys(myCountry);
	}
	
	
	//List<WebElement> suggestive = driver.findElements(By.cssSelector(".ta-results button"));
	
	@FindBy(css=".ta-results button")
	List<WebElement> suggestive;
	
	public List<WebElement> getCountryList() {
		
		return suggestive;
	}
	
	public void getCountryByName(String countryName) {
	
	WebElement myCountryName = getCountryList().stream().filter(suggest->suggest.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
	
	myCountryName.click();

}
	
	//WebElement myPlaceOrder = driver.findElement(By.cssSelector(".btnn"));
	
	@FindBy(css=".btnn")
	WebElement myPlaceOrder;
	
	public OrderConfirmed orderPlaced() {
		
		myPlaceOrder.click();
		
		OrderConfirmed orderConfirmed = new OrderConfirmed(driver);
		
		return orderConfirmed;
	}
	
	
}
