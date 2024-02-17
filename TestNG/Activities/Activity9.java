package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;


public class Activity9 {
    WebDriver driver;
    @BeforeTest
    public void BeforeTest(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("Browser is opened");
        Reporter.log("Page title is: " +driver.getTitle());
    }

    @Test(priority = 0)
    public void simpleAlertTestCase(){
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple alert is clicked");
        // Wait for the alert to display
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Reporter.log("Simple alert is displayed");
        Alert alert = driver.switchTo().alert();
        Reporter.log("Simple alert text: " +alert.getText());
        // Assertion
        Assert.assertEquals("This is a JavaScript Alert!", alert.getText());
        alert.accept();
        Reporter.log("Simple alert closed");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase() throws InterruptedException {
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm alert is clicked");
        // Wait for the alert to display
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Reporter.log("Confirm alert is displayed");
        // Switch the focus from the main window to the Alert box and print the text in it
        Alert alert = driver.switchTo().alert();
        Reporter.log("Confirm alert text: " +alert.getText());
        // Assertion
        Assert.assertEquals("This is a JavaScript Confirmation!", alert.getText());
        Thread.sleep(1000);
        // Close the alert with Ok
        alert.dismiss();
        Reporter.log("Confirm alert closed");
    }

    @Test(priority = 2)
    public void promptAlertTestCase() throws InterruptedException {
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt alert is clicked");
        // Switch the focus from the main window to the Alert box and print the text in it
        Alert alert = driver.switchTo().alert();
        Reporter.log("Prompt alert text: " +alert.getText());
        // Assertion
        Assert.assertEquals("This is a JavaScript Prompt!", alert.getText());
        // Type "Awesome!" into the prompt
        alert.sendKeys("Awesome!");
        Reporter.log("Text entered into alert");
        Thread.sleep(1000);
        // Close the alert with Ok
        alert.accept();
        Reporter.log("Prompt alert is closed");
    }

    @BeforeMethod
    public void BeforeMethod(){
        driver.switchTo().defaultContent();
        Reporter.log("In the main page");
    }

    @AfterTest
    public void AfterTest(){
        driver.close();
        Reporter.log("Browser is closed");
    }
}
