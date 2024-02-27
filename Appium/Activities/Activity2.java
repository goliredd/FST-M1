package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    // Test method
    @Test
    public void browserTest() throws InterruptedException {
        // Open the browser with the URL
        driver.get("https://v1.training-support.net/");
        // Locate the heading on the page and print it to console
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement Heading = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//android.view.View[@text='Training Support']"))));
        String pageHeading = Heading.getText();
        System.out.println("Heading of the page is: " +pageHeading);
        // Locate the About Us button and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='about-link']"))).click();
        // Print the heading on the About Us page to the console
        WebElement nextPageHeading = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//android.view.View[@text='About Us']"))));
        String aboutUsHeading = nextPageHeading.getText();
        System.out.println("Heading of the About Us page is: " +aboutUsHeading);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }


}
