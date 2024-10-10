import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PullFileSelenium {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    String status = "passed";

    @BeforeTest
    public void setUp() throws Exception {

        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("version", "123.0");
        ltOptions.put("platform", "MacOS Monterey");
        ltOptions.put("build", "Download functionality test");
        ltOptions.put("name", "LT Test");
        ltOptions.put("network", true); // To enable network logs
        ltOptions.put("visual", true);
        ltOptions.put("video", true); // To enable video recording`
        ltOptions.put("console", true); // To capture console logs
        options.setCapability("lt:Options", ltOptions);

        try {

            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), options);

        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test()
    public void fileDownload() throws Exception {
        try {

            driver.get("https://file-examples.com/wp-content/storage/2017/02/file_example_XLSX_10.xlsx");

            Thread.sleep(4000);

            Assert.assertEquals(
                    ((JavascriptExecutor) driver).executeScript("lambda-file-exists=file_example_XLSX_10.xlsx"),
                    true); // file exist check

            System.out.println(
                    ((JavascriptExecutor) driver).executeScript("lambda-file-stats=file_example_XLSX_10.xlsx")); // retrieve
      

            String base64EncodedFile = ((JavascriptExecutor) driver)
                    .executeScript("lambda-file-content=file_example_XLSX_10.xlsx").toString(); // file content download
            System.out.println(base64EncodedFile);

            byte[] data = Base64.getDecoder().decode(base64EncodedFile.getBytes());
          FileOutputStream fileOutStream;
          File file=new File("/Users/rahulkumar/Downloads/file_example_XLSX_10.xlsx"); //destination path where you file which you downloaded in your 
          // LambdaTest test machine would get saved in your local machine in the above path
          fileOutStream = new FileOutputStream(file);

          fileOutStream.write(data);

          fileOutStream.close();
        	


        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());

            SessionId id = driver.getSessionId();
            System.out.println("Failed test session id: " + id.toString());
        }

    }

    @AfterTest
    public void tearDown() throws Exception {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}