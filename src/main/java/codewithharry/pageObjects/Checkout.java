package codewithharry.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codewithharry.AbstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;


public class Checkout extends AbstractComponents {
	
	WebDriver driver;
	
	public Checkout(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
	
	//PageFactory
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	
	public List<WebElement> getCartList() {
		
		return cartProduct;
	}
	
	public Boolean getProductByName(String productName) {
	
	Boolean match = getCartList().stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(productName));
	
	return match;
	


	
}
	
	//WebElement clickCheckOut = driver.findElement(By.cssSelector(".totalRow button"));
	
	//PageFactory
	
	@FindBy(css=".totalRow button")
	
	WebElement clickCheckOut;
	
	
	public ConfirmationPage onCheckOut() {
		
		clickCheckOut.click();
		
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		
		return confirmationPage;
	}
	
}
