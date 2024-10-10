
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import com.lambdatest.tunnel.Tunnel;

public class varunCustomerZoho {

	private RemoteWebDriver driver;
	private String Status = "passed";


	@BeforeMethod
	public void setup(Method m, ITestContext ctx) throws MalformedURLException, Exception {
		String username = "";
		String authkey = "";
		String hub = "@hub.lambdatest.com/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();

		ChromeOptions browserOptions = new ChromeOptions();
		//browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "124");

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("driver_version", "127.0");
		ltOptions.put("accessKey", authkey);
		ltOptions.put("build", "AutoHeal_TestIntelligence3");
		ltOptions.put("platformName", "Windows 11");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("smartUI.project", "SmarttUIProject-23-08-2024");  
//		ltOptions.put("smartUI.build", "Sample-2");
//		ltOptions.put("smartUI.baseline", true);

		browserOptions.setCapability("lt:options", ltOptions);
	

		caps.setCapability(ChromeOptions.CAPABILITY, browserOptions);

		driver = new RemoteWebDriver(new URL("https://{LT_UserNamee}:{LT_Access_Key}@hub.lambdatest.com/wd/hub"), caps);

	}

	@Test
	public void basicTest() throws InterruptedException {
		System.out.println("Loading Url");
		
		driver.get("https://ruby-site-2106-dev-ed.scratch.lightning.force.com/lightning/r/zqci15__Quote__c/a0wEc000001zYtqIAE/view");
		
		Thread.sleep(3000);
		
		WebElement emailField = driver.findElement(By.id("username"));
		emailField.click();
		emailField.sendKeys("test-7o7nx3ck2lsm@example.com");
		
		Thread.sleep(3000);
		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.click();
		passwordField.sendKeys("v8chmepz");
		
		Thread.sleep(3000);
		
		WebElement loginBtn = driver.findElement(By.id("Login"));
		
		loginBtn.click();
		
		Thread.sleep(5000);
		
		WebElement nodFrameElement = driver.findElement(By.xpath("//*[@class='content iframe-parent']"));
		
		WebElement IFElement = nodFrameElement.findElement(By.xpath("//*[@class='content iframe-parent']//iframe"));
		
		IFElement.click();
		
		driver.switchTo().frame(IFElement);
		
		
		List<WebElement> iframeCount = driver.findElements(By.tagName("iframe"));
		
		System.out.println("couts are "+iframeCount.size());
		
		Thread.sleep(2000);
		
		WebElement opportunityText = driver.findElement(By.xpath("//*[@id=\"01IEc000002auZk.00NEc000008o0hg-_help\"]"));
		
		opportunityText.getText();
		
		System.out.println("text is "+opportunityText.getText());
		
		Thread.sleep(4000);

		//((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=pic1");  // Lambda SmartUI 
		
		((JavascriptExecutor)driver).executeScript("smartui.takeFullPageScreenshot=pic1");
		
		//((JavascriptExecutor)driver).executeScript("smartui.takeFullPageScreenshot,{\"screenshotName\":\"pic1\", \"smartScroll\":true }");


		
		
		
		System.out.println("Test Finished");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.executeScript("lambda-status=" + Status);
		driver.quit();
	}
}