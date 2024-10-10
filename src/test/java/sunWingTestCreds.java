
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sunWingTestCreds {
	
	public String username = "";
	public String accesskey = "";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
 
	@BeforeTest
	public void setUp() {

		ChromeOptions browserOptions = new ChromeOptions();
		// browserOptions.addArguments("--headless");
//		browserOptions.addArguments("--incognito");
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("114.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", accesskey);
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
//		ltOptions.put("accessibility.bestPractice", true);
//		ltOptions.put("accessibility.needsReview", true);
//		ltOptions.put("accessibility.wcagVersion", "wcag21a");

		ltOptions.put("build", "SunWing");
		ltOptions.put("name", "SunWing-Test");

		ltOptions.put("w3c", true);

		browserOptions.setCapability("LT:Options", ltOptions);

		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void visualRegression1() throws InterruptedException {

	//	driver.get("https://www.sunwing.ca/en/");
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		driver.get("https://www.sunwing.ca/en/user-account/login");
		Thread.sleep(5000);
	
		driver.findElement(By.id("idp-discovery-username")).click();
		
		driver.findElement(By.id("idp-discovery-username")).sendKeys("Testingsunwing@gmail.com");
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("idp-discovery-submit")).click();
		
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//*[@id=\"accountSignin\"]")).click();
		
		driver.findElement(By.id("okta-signin-password")).click();
		
		driver.findElement(By.id("okta-signin-password")).sendKeys("Sunwing123!");
		Thread.sleep(1000);
		driver.findElement(By.id("okta-signin-submit")).click();
		
		Thread.sleep(15000);
		
		System.out.println("title is "+driver.getTitle());
		System.out.println("URL is "+driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//*[text()='Flights']")).click();


	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
