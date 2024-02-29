package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class PActivity2 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    // Test method
    @Test
    public void googleKeep() {
        // Perform the Google Keep actions
        // Click the Create New Note button to add a new Note
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Add a title for the note and add a small description
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title"))).sendKeys("New note");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("edit_note_text"))).sendKeys("This is a new note");
        // Press the back button
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        // Assertion
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("index_note_title"))).getText();
        Assert.assertEquals(title, "New note");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
