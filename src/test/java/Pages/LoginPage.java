package Pages;

import Base.screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class LoginPage  extends screenshot {
    WebDriver driver;
   // Logger log = Logger.getLogger(LoginPage.class);
    @BeforeMethod
    public void BrowserSetUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php?");
        //log.info("browser opened");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    @Test(enabled=true)
    public void Signbutton() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        Thread.sleep(5000);
        //log.info("sign in button clicked");
        // TO CLICK BUTTON USING JAVASCRIPT EXECUTOR
        WebElement lgnbutton =  driver.findElement(By.xpath("//input[@name='email_create']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click;",lgnbutton);
        System.out.println(" Email button clicked");
        lgnbutton.sendKeys("kavitha_abburi@yahoo.com");
        //Assert.assertFalse(true);
        //log.error("Error occured");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
        System.out.println(" create account button clicked");
        // ENTERING DETAILS
        driver.findElement(By.xpath("//form[@id='account-creation_form']//div//div//label//div//span//input[@id='id_gender1']")).click();
        System.out.println("radio button clicked");
}
@AfterMethod
public void teardown(){
        driver.close();
    System.out.println("browser closed");
    }
}
