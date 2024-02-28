package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class PActivity1 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    // Test method
    @Test
    public void GoogleTasks() {
        // Perform the Google Tasks actions
        // Click the button to add a new task1
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Tasks");
        // Save the task
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        // Click the button to add a new task2
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Keep");
        // Save the task
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        // Click the button to add a new task3
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete the second Activity Google Keep");
        // Save the task
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        List<WebElement> taskList = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id,'com.google.android.apps.tasks:id/task_name']"));
        System.out.println("Size: " +taskList.size());
        // Assertion
        Assert.assertEquals(taskList.size(), 3);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
