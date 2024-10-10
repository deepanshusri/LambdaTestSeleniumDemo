

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lambdatest.tunnel.Tunnel;

import java.net.URL;
import java.util.HashMap;

public class tunnelLambda {
	Tunnel t;

	WebDriver driver = null;
	public static String status = "passed";

	String username = "";
	String access_key = "";

	@BeforeTest
	public void setUp() throws Exception {
		System.out.println("Capabilities started");
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "latest");

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();

		ltOptions.put("build", "AutoHeal_TestIntelligence2");
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("w3c", true);
		ltOptions.put("tunnel",true);
		ltOptions.put("network",true);
		ltOptions.put("w3c",true);
		ltOptions.put("console",true);
		ltOptions.put("visual",true);

		browserOptions.setCapability("lt:options", ltOptions);

		//create tunnel instance
		t = new Tunnel();
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("user", username);
		options.put("key", access_key);
		options.put("tunnelName", "rahul");

		//start tunnel
		t.start(options);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), browserOptions);
		System.out.println("Started session");
	}

	@Test()
	public void testTunnel() throws Exception {
		//Check LocalHost on XAMPP
		driver.get("http://localhost:8080/login?from=%2F");
		// Let's check that the item we added is added in the list.
		driver.get("https://google.com");
	}

	@AfterTest
	public void tearDown() throws Exception {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
	}
	@AfterSuite
	public void setTearDown() throws Exception {
		t.stop();
	}
}