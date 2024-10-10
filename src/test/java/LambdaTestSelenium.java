import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lambdatest.tunnel.Tunnel;

import java.util.HashMap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeOptions;

public class LambdaTestSelenium{
	Tunnel t;
	
	public String username = "";
    public String accesskey = "";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
   
    
    
	@BeforeTest
    public void setUp() throws Exception {
//       DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("version", "112.0");
//        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
//        capabilities.setCapability("build", "RahulBuild");
//        capabilities.setCapability("name", "MyNewRahulTestBuild");
//        capabilities.setCapability("visual", true);
//        capabilities.setCapability("network", true);
//        capabilities.setCapability("video", true);
//        capabilities.setCapability("console", true);
    	//WebDriverManager.chromedriver().setup();
    	
    	ChromeOptions browserOptions = new ChromeOptions();
    	
    	//browserOptions.addExtensions(new File("/Users/rahulkumar/Downloads/tFU6g0crbGJ85WKCGu4WVS6rrPlX9wQtc5SoJxmk40oiSVcAcU.crx"));
    	//browserOptions.addArguments("--headless");
    	browserOptions.setPlatformName("Windows 10");
    	browserOptions.setBrowserVersion("123.0");
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "");
    	ltOptions.put("accessKey", "");
    	ltOptions.put("visual", true);
    	ltOptions.put("video", true);
    	ltOptions.put("network", true);
    	ltOptions.put("tunnel", false);
    	ltOptions.put("mitm", "true");
    	ltOptions.put("build", "MyNewBuildOne");
    	ltOptions.put("project", "TestingAutomationProject");
    	ltOptions.put("name", "MyNewAutomationTestingBuildOne");
    	ltOptions.put("w3c", true);
    	browserOptions.setCapability("LT:Options", ltOptions);
    	
    	
        
        try {
        	
        	t = new Tunnel();
    		HashMap<String, String> options = new HashMap<String, String>();
    		options.put("user", username);
    		options.put("key", accesskey);
    		 options.put("tunnelName", "sample");
    	      options.put("mitm", "true");
    	      options.put("verbose", "true");

    		//start tunnel
    		t.start(options);
    		
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
            System.out.println("Started session");
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testSimple() throws Exception {
       try {//Change it to production page
    	   //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
            driver.get("https://sha512.badssl.com/");
            
            
              //Let's mark done first two items in the list.
//            driver.findElement(By.name("li1")).click();
//            driver.findElement(By.name("li2")).click();
           
             // Let's add an item in the list.
//              driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
//            driver.findElement(By.id("addbutton")).click();
            
              // Let's check that the item we added is added in the list.
//            String enteredText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
//            if (enteredText.equals("Yey, Let's add it to list")) {
//                status = true;
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @AfterTest
    public void tearDown() throws Exception {
       if (driver != null) {
    	
    	      
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
      
            driver.quit();
            System.out.println("closing session");
            t.stop();
        }
    }
}
