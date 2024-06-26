package codewithharry.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import codewithharry.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-1")));
	
	
	By toastMessage = By.cssSelector("#toast-container");
	
	By invisibilityMessage = By.cssSelector(".ng-tns-c31-1");
	
	
	
	
	
	//PageFactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	public List<WebElement> getProductList() 
	{
		
		return products;
	}
	
	
	public WebElement getProductByName(String productName)
	{
		
		WebElement prod = getProductList().stream()
				.filter(product->product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
		
	}
	
	
	public void addToCart(String productName){
		
		WebElement prod = getProductByName(productName);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		waitForTheElementToAppear(toastMessage);
		
		waitForTheElementToDisappear(invisibilityMessage);
		
		
		
	}

}	
	
	
	
	
	


