package codewithharry.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codewithharry.pageObjects.Checkout;
import codewithharry.pageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Since the locator is not starting with driver so we cannot use pageFactory , therefore we will use By locator .
	
	
	public void waitForWebElementToAppear(WebElement findBy) { // This wait is used as on inspecting Incorrect email or password the webElement 
		// comes and disappear quickly.
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	
	
	public void waitForTheElementToAppear(By findBy) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	
	}
	
	
	
	public void waitForTheElementToDisappear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	//WebElement clickCart = driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"));
	
		//PageFactory
		
		@FindBy(css="button[routerlink='/dashboard/cart']")
		WebElement clickCart;
		
		
		
		@FindBy(css="button[routerlink='/dashboard/myorders']")
		WebElement orderPage;
		
		
			public Checkout clickOnCart() {
				
				clickCart.click();
				Checkout checkout = new Checkout(driver);
				return checkout;
			}
			
			
			public OrdersPage clickOnOrders() {
				
				orderPage.click();
				
				OrdersPage ordersPage = new OrdersPage(driver);
				
				return ordersPage;
			}
		}
	


