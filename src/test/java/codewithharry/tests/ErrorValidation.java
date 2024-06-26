package codewithharry.tests;

	import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.sun.net.httpserver.Authenticator.Retry;

import codewithharry.TestComponents.BaseTest;
import codewithharry.pageObjects.Checkout;
import codewithharry.pageObjects.ProductCatalogue;
//import codewithharry.TestComponents.Retry;
import codewithharry.TestComponents.Retry;

	public class ErrorValidation extends BaseTest
	{
		
		@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
		public void LoginErrorValidation() throws IOException {
			
			//String productName = "IPHONE 13 PRO";
			
			//String countryName = "India";
			
			landingPage.loginApplication("harrysindhia@gmail.com", "hary@Code5");
			
				
			Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email password.");
			
			
			
		}
		
		@Test
		public void ProductErrorValidation() throws IOException {
			
			String productName = "IPHONE 13 PRO";
			
			//String countryName = "India";
			
			ProductCatalogue productCatalogue = landingPage.loginApplication("harrysindhia@gmail.com", "harry@Code5");
			
			productCatalogue.getProductList();
			
			productCatalogue.addToCart(productName);
			
			Checkout checkout = productCatalogue.clickOnCart();
			
			checkout.getCartList();
			Boolean match = checkout.getProductByName("ADIDAS ORIGINAL");
			
			Assert.assertFalse(match);
			
			
		
		}

	}

		

	


