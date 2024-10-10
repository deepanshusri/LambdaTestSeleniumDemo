
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

public class AutoHealDemo {

	private RemoteWebDriver driver;
	private String Status = "passed";
	Tunnel t;

	@BeforeMethod
	public void setup(Method m, ITestContext ctx) throws MalformedURLException, Exception {
		String username = "rahulkumarlambdatest";
		String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
		String hub = "@hub.lambdatest.com/wd/hub";

		System.getenv("LT_BUILD_NAME");
		DesiredCapabilities caps = new DesiredCapabilities();

		ChromeOptions browserOptions = new ChromeOptions();
		// browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "124");

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("driver_version", "127.0");
		ltOptions.put("accessKey", authkey);
		ltOptions.put("build", "AutoHeal_TestIntelligence3");
		ltOptions.put("platformName", "Windows 11");
		ltOptions.put("selenium_version", "4.0.0");

		ltOptions.put("w3c", true);

		ltOptions.put("accessibility", true);
		ltOptions.put("seCdp", true);
		ltOptions.put("accessibility.wcagVersion", "wcag22aa");
		ltOptions.put("autoHeal", true);
//		ltOptions.put("network", true);
//		ltOptions.put("network.har", true);
//		ltOptions.put("network.full.har", true);
		// ltOptions.put("tunnel", true);
		// ltOptions.put("tunnelName", "MavenSingle");
		// ltOptions.put("smartUI.project", "SmarttUIProject-21-08-2024");
//		ltOptions.put("smartUI.build", "Sample-2");
//		ltOptions.put("smartUI.baseline", true);

		browserOptions.setCapability("lt:options", ltOptions);

		caps.setCapability(ChromeOptions.CAPABILITY, browserOptions);

		// create tunnel instance
//		t = new Tunnel();
//		HashMap<String, String> options1 = new HashMap<String, String>();
//		options1.put("username", username);
//		options1.put("accessKey", authkey);
		// options1.put("tunnelName", "MavenSingle");

//        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
//        caps.setCapability("tags", Tags);

		// start tunnel

		driver = new RemoteWebDriver(new URL(
				"https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@hub.lambdatest.com/wd/hub"),
				caps);

		// t.start(options1);
	}

	@Test
	public void basicTest() throws InterruptedException {

		System.out.println("Loading Url");

		driver.get("https://www.lambdatest.com/selenium-playground/auto-healing");
		
		driver.findElement(By.xpath("//*[text()='Change DOM ID']")).click(); //uncomment this in second run
		
		Thread.sleep(2000);

		driver.findElement(By.id("username")).click();

		driver.findElement(By.id("username")).sendKeys("test@gmail.com");

		Thread.sleep(2000);

		driver.findElement(By.id("password")).click();

		driver.findElement(By.id("password")).sendKeys("test@gmail.com");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Submit']")).click();

		// ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=pic1");
		// // Lambda SmartUI

		Thread.sleep(3000);

		System.out.println("Test Finished");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.executeScript("lambda-status=" + Status);
		driver.quit();
		// t.stop();
	}

	// ltOptions.put("project", "AutoHeal_TestIntelligence_LambdaTest");
	// ltOptions.put("selenium_version", "3.141.0");
}