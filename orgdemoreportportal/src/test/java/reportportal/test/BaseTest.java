package reportportal.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void initDriver()
    {
        WebDriverManager.chromedriver().cachePath("D:\\VEL-Training\\Software").avoidOutputTree().setup();
        driver=new ChromeDriver();
    }
}
