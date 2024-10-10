
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import com.lambdatest.tunnel.Tunnel;

public class AutoHeal {

	private RemoteWebDriver driver;
	private String Status = "passed";
	Tunnel t;

	@BeforeMethod
	public void setup(Method m, ITestContext ctx) throws MalformedURLException, Exception {

		String hub = "@hub.lambdatest.com/wd/hub";
		

		System.getenv("LT_BUILD_NAME");
		DesiredCapabilities caps = new DesiredCapabilities();

		ChromeOptions browserOptions = new ChromeOptions();
		//browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "latest");

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//		ltOptions.put("username", username);
//		ltOptions.put("driver_version", "127.0");
//		ltOptions.put("accessKey", authkey);
		ltOptions.put("build", "Test姓氏");
		ltOptions.put("platformName", "Windows 10");
//		ltOptions.put("selenium_version", "4.25.0");
		
//		ltOptions.put("w3c", true);
		ltOptions.put("name", "SampleTest");
//		ltOptions.put("tunnel", true);
		ltOptions.put("accessibility", true);
//		ltOptions.put("seCdp", true);
		ltOptions.put("accessibility.wcagVersion", "wcag21aaa");
		ltOptions.put("network", true);
		ltOptions.put("console", true);
//		ltOptions.put("network.har", true);
//		ltOptions.put("network.full.har", true);
//		ltOptions.put("network.full.har", true);
//		ltOptions.put("tunnel", true);
		//ltOptions.put("tunnelName", "MavenSingle");
//		ltOptions.put("smartUI.project", "SmarttUIProject-04-10-2024");  
//		ltOptions.put("smartUI.build", "Sample-2");
//		ltOptions.put("smartUI.baseline", true);

//		caps.setCapability("accessibility", true);
//		caps.setCapability("accessibility.wcagVersion", "wcag21aaa");
		browserOptions.setCapability("lt:options", ltOptions);
	

		caps.setCapability(ChromeOptions.CAPABILITY, browserOptions);
//		caps.setCapability("accessibility", true);
//		caps.setCapability("accessibility.wcagVersion", "wcag21aaa");
		
		
		
		

		// create tunnel instance
//		t = new Tunnel();
//		HashMap<String, String> options1 = new HashMap<String, String>();
//		options1.put("username", username);
//		options1.put("accessKey", authkey);
		//options1.put("tunnelName", "MavenSingle");

//        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
//        caps.setCapability("tags", Tags);

		// start tunnel

		driver = new RemoteWebDriver(new URL("https://{LT_UserNamee}:{LT_Access_Key}@hub.lambdatest.com/wd/hub"), caps);

		//t.start(options1);
	}

	@Test
	public void basicTest() throws InterruptedException {
		String spanText;
		System.out.println("Loading Url");
//		Thread.sleep(2000);

//		driver.get("https://www.amazon.com");

//		driver.get("https://the-internet.herokuapp.com/login");
//		Thread.sleep(1500);
//		
		driver.get("https://www.baidu.com");
		
	Thread.sleep(3000);
//	
	driver.findElement(By.id("kw")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("kw")).sendKeys("rahul");
//		
		//driver.executeScript("lambda:network"); 
		

		//((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=pic1");  // Lambda SmartUI 
		
		

//		Thread.sleep(90000);
		
		
		
		

//		System.out.println("Checking Box");
//		
//		 driver.executeScript("lambda:network=all");
////		driver.findElement(By.id("nav-search-submit-button")).click();
////
////		driver.executeScript("document.getElementById('nav-search-submit-button').id='test'");
////		System.out.println("Autoheal search box");
////		driver.findElement(By.id("nav-search-submit-button"));
//
//		driver.findElement(By.className("username")).click();
//		
//		driver.findElement(By.className("username")).sendKeys("Rahul");
//		
//		driver.executeScript("document.getElementsByClassName('username').class='ratetet'");  //document.getElementsByName('username').name='test1'
//		
//		System.out.println("Autoheal search box");
//		
//		driver.findElement(By.className("username")).sendKeys("Kumar");
		
//		Thread.sleep(1500);

		//((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=pic2");

		// Other actions...
//		 driver.executeScript("lambda:network=all");

		System.out.println("Test Finished");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.executeScript("lambda-status=" + Status);
		driver.quit();
		//t.stop();
	}

	// ltOptions.put("project", "AutoHeal_TestIntelligence_LambdaTest");
	// ltOptions.put("selenium_version", "3.141.0");
}