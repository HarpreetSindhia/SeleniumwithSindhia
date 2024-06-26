package codewithharry.tests;

	import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import codewithharry.TestComponents.BaseTest;
import codewithharry.pageObjects.Checkout;
import codewithharry.pageObjects.ConfirmationPage;
import codewithharry.pageObjects.LandingPage;
import codewithharry.pageObjects.OrderConfirmed;
import codewithharry.pageObjects.OrdersPage;
import codewithharry.pageObjects.ProductCatalogue;

	public class SubmitCartTest extends BaseTest
	{
		
		String productName = "IPHONE 13 PRO";


		
		@Test(dataProvider="getData",groups= {"Purchase Product"})
		public void submitCart(HashMap<String,String> input) throws IOException {
			
			
			
			String countryName = "India";
			
			//LandingPage landingPage = launchApplication();
			
			
			//WebDriverManager.chromedriver().setup();
			
			//WebDriver driver = new ChromeDriver();
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//driver.manage().window().maximize();
			
			//driver.get("https://rahulshettyacademy.com/client/");
			
			//LandingPage landingPage = new LandingPage(driver);
			
			//landingPage.goTo();
			
			ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
			
			//driver.findElement(By.cssSelector("#userEmail")).sendKeys("harrysindhia@gmail.com");
			
			//driver.findElement(By.cssSelector("#userPassword")).sendKeys("harry@Code5");
			
			//driver.findElement(By.cssSelector("#login")).click();
			
			//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			
			productCatalogue.getProductList();
			
			productCatalogue.addToCart(input.get("product"));
			
			//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
			
			//WebElement prod = products.stream().filter(product->product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
			
			//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-1")));
			
			Checkout checkout = productCatalogue.clickOnCart();
			
			//driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
			
			//Checkout checkout = new Checkout(driver);
			
			checkout.getCartList();
			Boolean match = checkout.getProductByName(input.get("product"));
			
			
			
			//List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
			
			//Boolean match = cartProduct.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(productName));
			
			Assert.assertTrue(match);
			
			ConfirmationPage confirmationPage = checkout.onCheckOut();
			
			//driver.findElement(By.cssSelector(".totalRow button")).click();
			
			//ConfirmationPage confirmationPage = new ConfirmationPage(driver);
			
			confirmationPage.inputCountryName("ind");
			
			confirmationPage.getCountryList();
			
			confirmationPage.getCountryByName(countryName);
			
			//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
			
			
			
			//List<WebElement> suggestive = driver.findElements(By.cssSelector(".ta-results button"));
			
			//WebElement myCountryName = suggestive.stream().filter(suggest->suggest.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
			
			//myCountryName.click();
			
			OrderConfirmed orderConfirmed = confirmationPage.orderPlaced();
			
			//driver.findElement(By.cssSelector(".btnn")).click();
			
			//OrderConfirmed orderConfirmed = new OrderConfirmed(driver);
			
			String confirmMessage = orderConfirmed.getConfirmationMessage();
			
			
			
			//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
			
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
			
			//driver.close();
			
		}

		

	@Test(dependsOnMethods={"submitCart"})
	
	public void OrderConfirmed() {
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("harrysindhia@gmail.com", "harry@Code5");
		landingPage.clickOnOrders();
		OrdersPage ordersPage = new OrdersPage(driver);
		Boolean match = ordersPage.verifyOrderByName(productName);
		Assert.assertTrue(match);
		
		
		
	}

	
	//For multiple parameter values HashMap is recommended .
	
	/*@DataProvider
	public Object[][] getData(){
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("email", "harrysindhia@gmail.com");
		map.put("password", "harry@Code5");
		map.put("product", "IPHONE 13 PRO");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		
		map1.put("email", "harrycoder@gmail.com");
		map1.put("password", "harryCode@5");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
		
	}*/
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\codewithharry\\Data\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}



	
	
	
	
	
	
	
	//System.getProperty("user.dir")+"src\\test\\java\\codewithharry\\Data\\PurchaseOrder.json"
	
	
	
	

	}
	
	/*@DataProvider
	public Object[][] getData() {
		
		return new Object[][]  {{"harrysindhia@gmail.com","harry@Code5","IPHONE 13 PRO"},{"harrycoder@gmail.com","harryCode@5","ADIDAS ORIGINAL"}};
	}*/
