
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;

public class basicAuthDesktop {

    public static void main(String[] args) {
        try {
        	DesiredCapabilities caps = new DesiredCapabilities();
        	
        	ChromeOptions browserOptions = new ChromeOptions();
        	browserOptions.setPlatformName("Windows 10");
        	browserOptions.setBrowserVersion("beta");
        	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        	ltOptions.put("username", "");
        	ltOptions.put("version", "beta");
        	ltOptions.put("accessKey", "");
        	ltOptions.put("project", "Untitled");
        	ltOptions.put("selenium_version", "4.15.0");
//        	ltOptions.put("region", "eu");
//        	ltOptions.put("geoLocation", "IT");
        	ltOptions.put("w3c", true);
//         	ltOptions.put("network", true);
//          	ltOptions.put("network.har", true);
//          	ltOptions.put("network.full.har", true);
        	browserOptions.setCapability("LT:Options", ltOptions);
        	
            caps.setCapability(ChromeOptions.CAPABILITY, browserOptions);
        	
//        	DesiredCapabilities capabilities = new DesiredCapabilities();
//        	capabilities.setCapability("browserName", "Chrome");
//        	capabilities.setCapability("browserVersion", "beta");
//        	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        	ltOptions.put("username", "rahulkumarlambdatest");
//        	ltOptions.put("accessKey", "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6");
//        	ltOptions.put("platformName", "Windows 11");
//        	//ltOptions.put("selenium_version", "4.0.0");
////        	ltOptions.put("w3c", true);
//        	ltOptions.put("project", "Untitled");
//        	capabilities.setCapability("LT:Options", ltOptions);

        	
        	 
            WebDriver driver = new RemoteWebDriver(new URL("https://{LT_UserNamee}:{LT_Access_Key}@hub.lambdatest.com/wd/hub"), caps);

            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
           Thread.sleep(5000);
           
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
