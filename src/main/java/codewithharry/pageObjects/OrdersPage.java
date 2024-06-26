package codewithharry.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codewithharry.AbstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents {
	
	WebDriver driver;
	
	
	public OrdersPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Page Factory
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderList;
	
	public Boolean verifyOrderByName(String productName) {
		
		Boolean match = orderList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		
		return match;
	}

}
