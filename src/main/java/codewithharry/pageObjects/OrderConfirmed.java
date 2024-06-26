package codewithharry.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codewithharry.AbstractComponents.AbstractComponents;

public class OrderConfirmed extends AbstractComponents {
	
	WebDriver driver;
	
	public OrderConfirmed(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	//WebElement confirmMessage = driver.findElement(By.cssSelector(".hero-primary"));
	
		@FindBy(css=".hero-primary")
		WebElement confirmMessage;
		
		public String getConfirmationMessage() {
			
			return confirmMessage.getText();
			
			
		}

}
