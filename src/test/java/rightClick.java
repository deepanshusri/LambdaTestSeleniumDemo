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
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import com.lambdatest.tunnel.Tunnel;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class rightClick {
	

	private RemoteWebDriver driver;
	private String Status = "passed";
	Tunnel t;

	@BeforeMethod
	public void setup(Method m, ITestContext ctx) throws MalformedURLException, Exception {
		String username = "";
		String authkey = "";
		String hub = "@hub.lambdatest.com/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities();

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 10");
		browserOptions.setCapability("browserVersion", "114.0");

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", authkey);
		ltOptions.put("build", "AutoHeal_TestIntelligence1");

		ltOptions.put("w3c", false);
		ltOptions.put("autoHeal", true);
		//ltOptions.put("tunnel", true);
//		ltOptions.put("tunnelName", "MavenSingle");
		ltOptions.put("smartUI.project", "SamrtUIProject-06-09-2023");
		ltOptions.put("smartUI.build", "SmartUIBuildAutoHeal");
		ltOptions.put("smartUI.baseline", true);

		browserOptions.setCapability("lt:options", ltOptions);

		caps.setCapability(ChromeOptions.CAPABILITY, browserOptions);
		caps.setCapability("browserName", "chrome");

		// create tunnel instance
		t = new Tunnel();
		HashMap<String, String> options1 = new HashMap<String, String>();
		options1.put("username", username);
		options1.put("accessKey", authkey);
		//options1.put("tunnelName", "MavenSingle");

//        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
//        caps.setCapability("tags", Tags);

		// start tunnel

		driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

		//t.start(options1);
	}

	@Test
	public void basicTest() throws InterruptedException {
		String spanText;
		System.out.println("Loading Url");

		driver.get("https://turquoise-laurette-51.tiiny.site/");

		Thread.sleep(1500);

		WebElement btn = driver.findElement(By.xpath("/html/body/div[2]/button"));
		
		btn.click();

		
		// Right click the button to launch right click menu options
		Actions action = new Actions(driver);

//		WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
		Action act = action.contextClick(btn).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build();
		
		act.perform();
		

	//	action.sendKeys("I").perform(); 
		
//		   Actions builder = new Actions(driver);
//		          Action mouseOverHome = builder
//		                  .contextClick(btn)
//		                  .sendKeys(Keys.ARROW_DOWN)
//		                  .sendKeys(Keys.ARROW_UP)
//		                  .sendKeys(Keys.RETURN)
//		                  .build();
//		          mouseOverHome.perform();
		
		
	
	
		
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

