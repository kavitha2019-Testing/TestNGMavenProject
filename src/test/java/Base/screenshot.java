package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class screenshot {
 public static  WebDriver driver;

    public static void browseropen() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();

        System.out.println("Url opened");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public void captureScreen(String methodname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
       // File target = new File(System.getProperty("user.dir") + "/Screenshots/" + methodname + ".png");
          File target = new File(System.getProperty("user.dir") + "/Screenshots/" +"Testfail_this.getclass().getname()/"+
               "-"+".jpg");

        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}