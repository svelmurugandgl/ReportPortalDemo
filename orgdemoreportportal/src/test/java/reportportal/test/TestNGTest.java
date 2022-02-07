package reportportal.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reportportal.test.Utils.LoggingUtils;

import java.io.File;

public class TestNGTest extends BaseTest
{

       @Test(priority = 0)  //Success Test
        public void CloseBrowser() {
            driver.close();
            System.out.println("Close Browser");
            LoggingUtils.logBase64("DEMO","Browser Closed");
        }

        @Test(priority = -1) //Failed Test
        public void OpenBrowser() {
            System.out.println("Open Browser");
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            String expectedTitle = "Google Website";
            String originalTitle = driver.getTitle();
            LoggingUtils.log(originalTitle.getBytes(),"Actual Title is wrong");
            TakesScreenshot ts= ((TakesScreenshot) driver);
            File screenshotSRC= ts.getScreenshotAs(OutputType.FILE);
            LoggingUtils.log(screenshotSRC,"Failure Screen Shot taken");
            Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
        }

        @Test(priority = 1)  // Skip Test
        public void SkipTest() {
            System.out.println("Skip Test");
            throw new SkipException("Skipping The Test Method ");
        }
    }

