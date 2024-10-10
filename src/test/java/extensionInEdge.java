
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class extensionInEdge {
	
    public static RemoteWebDriver driver = null;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        
    	String extensionPath = "/Users/rahulkumar/Downloads/jifpbeccnghkjeaalbbjmodiffmgedin.crx";

    	
        EdgeOptions edgeOptions = new EdgeOptions();
       // edgeOptions.addArguments("--inprivate");
        
        File extensionFile = new File(extensionPath);
        if (extensionFile.exists()) {
        	edgeOptions.addExtensions(extensionFile);
        } else {
            System.out.println("Extension file does not exist: " + extensionPath);
        }

     // edgeOptions.addExtensions(new File("/Users/rahulkumar/Downloads/jifpbeccnghkjeaalbbjmodiffmgedin.crx"));


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "MicrosoftEdge");
        capabilities.setCapability("browserVersion", "119.0");
        capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "");
        ltOptions.put("accessKey", "");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("build", "EdgeExtension");
        capabilities.setCapability("LT:Options", ltOptions);


        // Create a Remote WebDriver instance on LambdaTest
        driver = new RemoteWebDriver(new URL("https://{LT_UserNamee}:{LT_Access_Key}@hub.lambdatest.com/wd/hub"), capabilities);

        driver.get("edge://extensions");

        Thread.sleep(5000);

        driver.quit();
    }
}

