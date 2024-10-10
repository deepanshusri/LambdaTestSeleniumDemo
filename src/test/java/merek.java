
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class merek {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, NoSuchAlgorithmException {

        String username = "";
        String authkey = "";

        String url = "https://" + username+ ":"+ authkey+ "@hub.lambdatest.com/wd/hub";

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "Windows 11");
//        caps.setCapability("browserName", "chrome");
//        caps.setCapability("browserVersion", "119");
//        caps.setCapability("name", "test 1");
//        caps.setCapability("build", "merek");
//        caps.setCapability("network", false);
//        caps.setCapability("acceptSslCerts", true);
//        caps.setCapability("acceptInsecureCerts",true);
//        caps.setCapability("idleTimeout", 300);
//        caps.setCapability("console", "true");

        String[] Tags = new String[] { "Prakhar", "UI", "Prod" };
        
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("--disable-blink-features=AutomationControlled");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("project", "merek");
        ltOptions.put("build", "with args");
        ltOptions.put("browserVersion", "124");
        ltOptions.put("w3c", true);//seTelemetryLogs
        ltOptions.put("seTelemetryLogs", true);//seTelemetryLogs
        ltOptions.put("Tags", "tags");
        ltOptions.put("network", true);
        ltOptions.put("network.har", true);
        ltOptions.put("network.full.har", true);
        capabilities.setCapability("LT:Options", ltOptions);
       
        
        driver = new RemoteWebDriver(new URL(url), capabilities);

    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;

        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.manage().window().maximize();

        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//*[@type='file']")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//*[@type='file']")).sendKeys("/Users/rahulkumar/Downloads/baseline-Allego.png");

//        driver.get("https://hcp.merckgroup.com/en/academe-ms/login.html\\");
//        driver.findElement(By.cssSelector(".cookie-disclaimer__accept")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.id("access-code-login__form-input")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.id("access-code-login__form-input")).sendKeys("ACADEME20");
//        Thread.sleep(5000);
//        driver.findElement(By.id("button")).click();
//        Thread.sleep(15000);
//
//        driver.executeScript("lambda:network");
//		driver.executeScript("lambda:network=all");

        System.out.println("TestFinished");

    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("*********quit test ***********");
            driver.executeScript("lambda-status=" + "failed");
        }
        else
        {
            driver.executeScript("lambda-status=" + "passed");
        }
        driver.quit();
    }


}