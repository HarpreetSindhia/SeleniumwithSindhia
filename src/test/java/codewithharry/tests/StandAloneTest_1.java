package codewithharry.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import codewithharry.pageObjects.LandingPage;

public class StandAloneTest_1
{
	public static void main(String[] args) {
		
		String productName = "IPHONE 13 PRO";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("harrysindhia@gmail.com");
		
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("harry@Code5");
		
		driver.findElement(By.cssSelector("#login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product->product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-1")));
		
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match = cartProduct.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
		
		//driver.findElement(By.cssSelector(".ta-results button:nth-of-type(2)")).click();
		
		List<WebElement> suggestive = driver.findElements(By.cssSelector(".ta-results button"));
		
		WebElement countryName = suggestive.stream().filter(suggest->suggest.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		
		countryName.click();
		
		driver.findElement(By.cssSelector(".btnn")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();

// Hello everyone


//We should change our efforts not the goal 

		
		
		
		
		
		
		
		
		
	
		
		
		
	}

}
