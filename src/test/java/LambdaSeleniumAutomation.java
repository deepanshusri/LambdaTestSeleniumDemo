
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LambdaSeleniumAutomation {

	@Test
    public void testBrowser() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();        
        driver.get("https://lambdatest.com");
        String title = driver.getTitle();
        System.out.println(title);      
            
    }
}
