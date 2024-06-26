package codewithharry.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codewithharry.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
	}

	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail")); // When the locator is starting from driver then we can use PageFactory.
	
	//PageFactory
	
	@FindBy(css="#userEmail")
	WebElement userEmail;
	
	//WebElement password = driver.findElement(By.cssSelector("#userPassword"));
	
	@FindBy(css="#userPassword")
	WebElement password;
	
	//WebElement submit = driver.findElement(By.cssSelector("#login"));
	
	@FindBy(css="#login")
	WebElement submit;
	
	//WebElement errorMessage = driver.findElement(By.cssSelector(".ng-trigger-flyInOut"));
	
	//PageFactory
	
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement errorMessage;
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public ProductCatalogue loginApplication(String myEmail , String myPassword) {
		
		userEmail.sendKeys(myEmail);
		
		password.sendKeys(myPassword);
		
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
	}

	
	}
	

