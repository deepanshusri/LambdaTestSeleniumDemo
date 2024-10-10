
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.HashMap;

public class geoLocationTestAmit {

	public static void main(String[] args) {
		try {
	

//			FirefoxOptions browserOptions = new FirefoxOptions();
//			// Create a new Firefox profile
//			FirefoxProfile profile = new FirefoxProfile();
//
//			// Set preferences for handling permissions
//			profile.setPreference("permissions.default.geo", 1); // 1: Allow, 2: Block
//			profile.setPreference("permissions.default.desktop-notification", 1); // 1: Allow, 2: Block
//			profile.setPreference("permissions.default.microphone", 1); // 1: Allow, 2: Block
//			profile.setPreference("permissions.default.camera", 1); // 1: Allow, 2: Block
//
//
//			browserOptions.setProfile(profile);
//
//			browserOptions.setPlatformName("Windows 10");
//			browserOptions.setBrowserVersion("118");
//			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//			ltOptions.put("username", "rahulkumarlambdatest");
//			ltOptions.put("accessKey", "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6");
//			ltOptions.put("project", "GeoLocationTest");
//			ltOptions.put("w3c", true);
//			browserOptions.setCapability("LT:Options", ltOptions);
			
			ChromeOptions browserOptions = new ChromeOptions();

            // Set preferences for handling permissions
            HashMap<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.geolocation", 2); // 1: Allow, 2: Block
            prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Block
            prefs.put("profile.default_content_setting_values.media_stream_mic", 1); // 1: Allow, 2: Block
            prefs.put("profile.default_content_setting_values.media_stream_camera", 1); // 1: Allow, 2: Block
            browserOptions.setExperimentalOption("prefs", prefs);

            // Set additional capabilities
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("121");

            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "");
            ltOptions.put("accessKey", "");
            ltOptions.put("project", "GeoLocationTest");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);


			WebDriver driver = new RemoteWebDriver(new URL(
					"https://{LT_UserNamee}:{LT_Access_Key}@hub.lambdatest.com/wd/hub"),
					browserOptions);

			driver.get("https://the-internet.herokuapp.com/geolocation");
			Thread.sleep(10000);

			driver.findElement(By.xpath("//*[text()='Where am I?']")).click();

			Thread.sleep(5000);

			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
