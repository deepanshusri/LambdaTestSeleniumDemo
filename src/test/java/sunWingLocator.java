import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import com.lambdatest.tunnel.Tunnel;
import org.openqa.selenium.interactions.Actions;

public class sunWingLocator {
	

	private WebDriver driver;
	private String Status = "passed";
	Tunnel t;

	@Test
	public void setup() throws MalformedURLException, Exception {
		
		
		   System.setProperty("webdriver.chrome.driver", "/Users/rahulkumar/Downloads/chromedriver");

	        // Initialize the WebDriver
	         WebDriver driver = new ChromeDriver();
	         
	         
	        

//	         driver.get("https://www.sunwing.ca/en/");
//	         
//	         Thread.sleep(1500);
//
//	         driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/header/section[1]/div/div/div[2]/nav/ul/li[2]/a")).click();
//	         
//	         Thread.sleep(10000);
//	         
//	         WebElement shadowElement = (WebElement) driver.findElement(By.xpath("//div[@id='booking-search-box-wrapper']"))
//	 				.getShadowRoot().findElement(By
//	 						.cssSelector("#booking-search-box-app > form > div > label:nth-child(3) > span:nth-child(2)"));
//
//	 		shadowElement.click();
//	         
//	         driver.findElement(By.cssSelector("#booking-search-box-app > form > div > label:nth-child(3) > span:nth-child(2)")).click();
//	         
//	         Thread.sleep(5000);
	         
	         driver.get("https://www.sunwing.ca/en/user-account/login");
	 		Thread.sleep(5000);
	 	
	 		driver.findElement(By.id("idp-discovery-username")).click();
	 		
	 		driver.findElement(By.id("idp-discovery-username")).sendKeys("Testingsunwing@gmail.com");
	 		
	 		Thread.sleep(1000);
	 		
	 		driver.findElement(By.id("idp-discovery-submit")).click();
	 		
	 		Thread.sleep(2000);
	 		
//	 		driver.findElement(By.xpath("//*[@id=\"accountSignin\"]")).click();
	 		
	 		driver.findElement(By.id("okta-signin-password")).click();
	 		
	 		driver.findElement(By.id("okta-signin-password")).sendKeys("Sunwing123!");
	 		Thread.sleep(1000);
	 		driver.findElement(By.id("okta-signin-submit")).click();
	 		
	 		Thread.sleep(15000);
	 		
	 		driver.quit();
	}

}

