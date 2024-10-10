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

public class rightClick_local {
	

	private WebDriver driver;
	private String Status = "passed";
	Tunnel t;

	@Test
	public void setup(Method m, ITestContext ctx) throws MalformedURLException, Exception {
		
		
		   System.setProperty("webdriver.chrome.driver", "/Users/rahulkumar/Downloads/chromedriver");

	        // Initialize the WebDriver
	         WebDriver driver = new ChromeDriver();
	         
	         
	         //This is for deepanshu's customer and Prakhar's customer
	         
//	         driver.get("https://WebUser:9v3n4rA8+N@preprod.medimerck.sk/sk/login/splash-page.html");
//	         Thread.sleep(5000);
//
//	         driver.findElement(By.xpath("//*[@id=\"signInName\"]")).click();
//	         driver.findElement(By.xpath("//*[@id=\"signInName\"]")).sendKeys("joaquin.86@falkcia.com");
//	         
//	         driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
//	         driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Merck@1234");
////	         driver.findElement(By.cssSelector(".fc-footer-buttons button p")).click();
////	         Thread.sleep(30000);
//	         
//	         driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
//	         
//	         Thread.sleep(8000);
//	         
//	         driver.findElement(By.xpath("//*[@class='cmp-adv-cookie--disclaimer__controls']/div[1]/a[1]")).click();
//	         
//	         Thread.sleep(2000);
//	         
//	        driver.findElement(By.xpath("//*[@class='cmp-navigation__extralinks']/ul/li[2]")).click();
//	        
//	        Thread.sleep(1000);
//	        
//	        driver.findElement(By.xpath("//*[@class='text']/div/ul/li[2]/a")).click();
//	        
//	        Thread.sleep(15000);
	        
	        //https://preprod.medimerck.sk/services/oneciamLogoutRedirect?requestUri=https://preprod.medimerck.sk/sk/login/splash-page.html

	         driver.get("http://r4d4.info/form-button-label");
	         
	         Thread.sleep(1500);

	 		WebElement btn = driver.findElement(By.xpath("//*[@id='changer']"));
	 		
	 		//btn.click();
	 		
	 		Thread.sleep(3000);

	 		
	 		// Right click the button to launch right click menu options
	 		Actions action = new Actions(driver);

//	 		WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
	 		 action.contextClick(btn).build().perform();
	         Thread.sleep(2000);

	         // Use arrow keys to navigate to the desired option in the context menu
	         action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
	         Thread.sleep(2000);

	         // Perform Enter key press to select the option
	         action.sendKeys(Keys.ENTER).build().perform();
	         Thread.sleep(5000);

	 		
	 		driver.quit();
	}

}

