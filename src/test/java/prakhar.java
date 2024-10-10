import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class prakhar {

	public String username = "";
	public String accesskey = "";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() {

//		ChromeOptions browserOptions = new ChromeOptions();
//		browserOptions.setPlatformName("Windows 11");
//		browserOptions.setBrowserVersion("dev");
//		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//		ltOptions.put("username", username);
//		ltOptions.put("accessKey", accesskey);
//		ltOptions.put("build", "Locator");
//		ltOptions.put("name", "SmartUI-ProjectSampleName");
//
//		ltOptions.put("w3c", true);
//
//		browserOptions.setCapability("LT:Options", ltOptions);
		
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("w3c", true);

        // ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "Private cloud FitnessSyncer");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platform", "ios");
        ltOptions.put("deviceName", "iPhone 14");
        ltOptions.put("platformVersion", "16.0");  //autoDismissAlerts
        ltOptions.put("autoDismissAlerts", true);
        ltOptions.put("autoAcceptAlerts", true);
        ltOptions.put("autoGrantPermissions", true);
        ltOptions.put("deviceOrientation", "portrait");
       
         capabilities.setCapability("lt:options", ltOptions);

		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void visualRegression1() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/upload");
		Thread.sleep(3000);
	//	driver.findElement(By.cssSelector("[id='file-upload']")).click();

		// Thread.sleep(5000);
		
		WebElement shadowElement = (WebElement) driver.findElement(By.xpath("//*[@id='file-upload']"))
 				.getShadowRoot().findElement(By
 						.cssSelector("//input[value='Choose File']"));

 		shadowElement.click();


	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
