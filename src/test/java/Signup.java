
import java.net.URL;
import java.util.HashMap;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Signup {
//    public static String userName = "abidk";
//    public static String accessKey = "";//prod


    public static String status = "passed";



    public static void main(String args[]) throws MalformedURLException
    {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("build", "Sign up failure");
//        capabilities.setCapability("test", "IOS");
//
//        capabilities.setCapability("isRealMobile", true);
//
//        capabilities.setCapability("platformName", "ios");
//        capabilities.setCapability("deviceName", "iPad .*");
//        capabilities.setCapability("platformVersion","16");
//        capabilities.setCapability("w3c", true);
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("w3c", true);
    	ltOptions.put("platformName", "macos sonoma");
    	ltOptions.put("browserName", "chrome");
    	ltOptions.put("browserVersion", "latest");
//    	ltOptions.put("isRealMobile", true);
//    	ltOptions.put("nativeWebTap", true);
    //	ltOptions.put("region", "us");
    	capabilities.setCapability("lt:options", ltOptions);
        
        
        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://{LT_UserNamee}:{LT_Access_Key}@hub.lambdatest.com/wd/hub"), capabilities);

        try {

            driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//*[@type='file']")).click();
            
            Thread.sleep(20000);
      
            
//            ////*[@id="email"]
//            
//            driver.findElement(By.xpath("//*[@title='SIGN IN']")).click();
//            
//  
//
//            //driver.fi("/html/body/app-root/app-header/div/div/div[2]/div/div/a").click();
//
//            Thread.sleep(5000);
//            
//            driver.findElement(By.id("email")).sendKeys("nitinagarwal.525@gmail.com");
//
//           //driver.findElementById("email").sendKeys("nitinagarwal.525@gmail.com");
//
//            Thread.sleep(5000);
//            
//            driver.findElement(By.xpath("/html/body/p-dynamicdialog/div/div/div[2]/app-login-modal/app-login-process/div/div[1]/div/div/app-email/div/form/div[1]/button")).click();
//
//         //   driver.findElementByXPath("/html/body/p-dynamicdialog/div/div/div[2]/app-login-modal/app-login-process/div/div[1]/div/div/app-email/div/form/div[1]/button").click();
//
//            Thread.sleep(10000);
//            
//            driver.findElement(By.xpath("/html/body/p-dynamicdialog/div/div/div[2]/app-login-modal/app-login-process/div/div[1]/div/div/app-email/div/form/div[1]/button")).click();
//
//         //   driver.findElementByXPath("/html/body/p-dynamicdialog/div/div/div[2]/app-login-modal/app-login-process/div/div[1]/div/div/app-email/div/form/div[1]/button").click();
//
//            
//            
//            Thread.sleep(15000);
//            
//            driver.findElement(By.id("company_name")).click();
//            
//            driver.findElement(By.id("company_name")).sendKeys("QSP");
//          String companyNameText =   driver.findElement(By.id("company_name")).getText();
//
//          System.out.println(companyNameText);
//           // driver.executeScript("document.getElementById('contact_number').setAttribute('value', 1234567891)");
//
//            Thread.sleep(5000);
//            ////*[@class='phone-group']/input
//            ////*[@role='dialog']/div[2]/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input
//            ////*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input
//            
//            ////*[@role='dialog']/div[2]/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/p-dropdown
//            
//          //*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input
//            
//          String tagName =  driver.findElement(By.xpath("//*[@role='dialog']/div[2]/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/p-dropdown")).getTagName();
//
//          System.out.println("Tag is "+tagName);
//          
//        driver.findElement(By.xpath("//*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input")).click();
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input")).clear();
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input")).sendKeys("9934634567");
//         
//      
////         Actions actions = new Actions(driver);
////         
////         actions.moveToElement( driver.findElement(By.xpath("//*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input"))).click().sendKeys("1234567890").perform();
//    
//       //  driver.findElement(By.xpath("//*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "12345");
//         
//       String enteredText =   driver.findElement(By.xpath("//*[@class='p-dialog-content ng-tns-c47-2']/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/input")).getText();
//            
//       System.out.println("Text is "+enteredText);
//       Thread.sleep(2000);
//          // driver.findElement(By.xpath("//*[@role='dialog']/div[2]/app-login-modal/app-login-process/div/div/div/div/app-sign-up/div/form/span[5]/div/p-dropdown"));
//            
//          //  Thread.sleep(3000);
//            
//           String textName = driver.findElement(By.xpath("//*[@class='label-select ng-star-inserted']")).getText();
//            
//            System.out.println("Text is "+textName);
//          //  driver.findElementById("contact_number").sendKeys("1");
//
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("/html/body/p-dynamicdialog/div/div/div[2]/app-login-modal/app-login-process/div/div[1]/div/div/app-sign-up/div/form/div/button")).click();
//          //  driver.findElementByXPath("/html/body/p-dynamicdialog/div/div/div[2]/app-login-modal/app-login-process/div/div[1]/div/div/app-sign-up/div/form/div/button").click();
//
//            Thread.sleep(10000);



            status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
        }
        driver.executeScript("lambda-status=" + status);
        driver.quit();
    }
}